package tp1.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterExternal implements FilenameFilter {

    private String pattern;

    public FilenameFilterExternal(String pattern){
        this.pattern = pattern;
    }

    @Override
    public boolean accept(File dir, String name) {
        File file = new File(dir.getPath()+"/"+name);
        return name.endsWith(pattern) || file.isDirectory();
    }
}
