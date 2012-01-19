package moura.luizfelipe.tools.eximphotomanager.photoImport;

import java.io.File;
import java.io.FileFilter;

public class JpgFilter implements FileFilter {

    private static final String EXTENSION = ".jpg";
    
    //from FileFilter
    public boolean accept(File file) {
        
        if (file == null)
            return false;
        
        if (!file.canRead())
            return false;
        
        if (file.isDirectory() && !file.getName().startsWith("."))
            return true;
        
        if (file.isFile() && file.getName().toLowerCase().endsWith(EXTENSION))
            return true;
        
        return false;
    }
}
