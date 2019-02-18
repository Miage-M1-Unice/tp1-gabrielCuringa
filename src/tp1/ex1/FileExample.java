package tp1.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class FileExample {

    /**
     * Test méthode list
     * @param path
     */
    public void printDirectories(String path){

        File file = new File(path);
        for (String s: file.list()) {

            System.out.println(s);
        }
    }

    /**
     * Test méthode listFiles
     * Affiche les répertoires et le contenu
     * @param path
     */
    public void printDirectoriesAndFiles(String path){
        File file = new File(path);
        for (File f: file.listFiles()) {
            if(f.isDirectory())
                printDirectoriesAndFiles(f.getPath());
            System.out.println(f);
        }
    }

    /**
     * Test méthode listFiles avec filtre
     * @param path
     * @param filter
     */
    public void printDirectoriesAndFilesFiltered(String path, FilenameFilter filter){
        File file = new File(path);
        for (File f: file.listFiles(filter)) {
            if(f.isDirectory())
                printDirectoriesAndFilesFiltered(f.getPath(), filter);
            System.out.println(f);
        }
    }

    /**
     * Test méthode listFiles avec filtre
     * UTILISATION CLASSE INTERNE
     * @param path
     * @param pattern
     */
    public void printDirectoriesAndFilesFilteredInternal(String path, String pattern){
        File file = new File(path);
        FilenameFilterInternal filter = new FilenameFilterInternal(pattern);
        for (File f: file.listFiles(filter)) {
            if(f.isDirectory())
                printDirectoriesAndFilesFiltered(f.getPath(), filter);
            System.out.println(f);
        }
    }

    public class FilenameFilterInternal implements FilenameFilter {

        private String pattern;

        public FilenameFilterInternal(String pattern){
            this.pattern = pattern;
        }

        @Override
        public boolean accept(File dir, String name) {
            File file = new File(dir.getPath()+"/"+name);
            return name.endsWith(pattern) || file.isDirectory();
        }
    }

}
