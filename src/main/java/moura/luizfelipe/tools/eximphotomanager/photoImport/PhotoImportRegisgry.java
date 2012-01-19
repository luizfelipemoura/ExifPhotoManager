package moura.luizfelipe.tools.eximphotomanager.photoImport;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class PhotoImportRegisgry {
    
    private Date time;
    private File sourceFile;
    private File destinationFile;
    
    public PhotoImportRegisgry(File sourceFile, File destinationFile) {
        
        this.sourceFile = sourceFile;
        this.destinationFile = destinationFile;
        this.time = Calendar.getInstance().getTime();
    }

    public File getDestinationFile() {
        return destinationFile;
    }

    public File getSourceFile() {
        return sourceFile;
    }
    
    public Date getTime() {
        return time;
    }
}
