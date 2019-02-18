package tp1.ex1;

import java.io.FilenameFilter;

public class Main {

    private static String DEFAULT_PATH = ".";

    public static void main(String[] args){

        FileExample fileExample = new FileExample();

        fileExample.printDirectories(DEFAULT_PATH);

        System.out.println("------- FIN Q1 --------");

        fileExample.printDirectoriesAndFiles(DEFAULT_PATH);

        System.out.println("------- FIN Q2 --------");

        // CLASSE EXTERNE
        FilenameFilter externalFilter = new FilenameFilterExternal(".java");
        //main.printDirectoriesAndFilesFiltered(DEFAULT_PATH, externalFilter);

        // CLASSE ANONYME
        /*main.printDirectoriesAndFilesFiltered(DEFAULT_PATH, new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir.getPath()+"/"+name);
                return name.endsWith(".java") || file.isDirectory();
            }
        });*/

        // CLASSE INTERNE NOMMÉE
        fileExample.printDirectoriesAndFilesFilteredInternal(DEFAULT_PATH, ".java");

        System.out.println("------- FIN Q3 --------");
    }
}
