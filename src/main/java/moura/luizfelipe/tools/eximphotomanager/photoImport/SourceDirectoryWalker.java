package moura.luizfelipe.tools.eximphotomanager.photoImport;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.DirectoryWalker;

public class SourceDirectoryWalker extends DirectoryWalker {
    
    private static final JpgFilter JPGFILTER = new JpgFilter();
    
    private PhotoImporter photoImporter;
    
    public SourceDirectoryWalker(PhotoImporter photoImporter) {
        
        super(JPGFILTER, 0);
        this.photoImporter = photoImporter;
    }
    
    public void walk(File srcDirectory, List<PhotoImportRegisgry> importReport) {
        
        walk(srcDirectory, importReport);
    }

    //from DirectoryWalker superclass
    @Override
    protected void handleFile(File file, int depth, Collection importReport) throws IOException {
        
        File dest = processFile(file);
        importReport.add(new PhotoImportRegisgry(file, dest));
    }
    
    private File processFile(File file) {
        
        File dest = this.photoImporter.processPhoto(file);
        return this.photoImporter.copyToRepository(file, dest);
    }
}
