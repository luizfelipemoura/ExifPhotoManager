package moura.luizfelipe.tools.eximphotomanager.photoImport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import moura.luizfelipe.tools.eximphotomanager.PhotoRepository;

public class PhotoImporter {
    
    private PhotoRepository repository;
    
    public PhotoImporter(PhotoRepository repository) {
        
        this.repository = repository;
    }
    
    public List<PhotoImportRegisgry> importPhotos(File ... sourceDirectories){
     
        List<PhotoImportRegisgry> importReport = new ArrayList<PhotoImportRegisgry>();
        
        SourceDirectoryWalker walker = new SourceDirectoryWalker(this);
        
        for (File sourceDirectory : sourceDirectories) 
            walker.walk(sourceDirectory, importReport);
        
        return importReport;
    }
    
    protected File copyToRepository(File source, File dest) {
        
        return repository.copyInto(source, dest);
    }
    
    protected File processPhoto(File file) {
        
        return repository.getPhotoProcessor().processPhoto(file);
    }
}