package ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Main {

    private static String DEFAULT_PATH = ".";

    public static void main(String[] args){

        Main main = new Main();

        main.printDirectories(DEFAULT_PATH);

        System.out.println("------- FIN Q1 --------");

        main.printDirectoriesAndFiles(DEFAULT_PATH);

        System.out.println("------- FIN Q2 --------");

        FilenameFilter filter = new FilenameFilterExternal(".java");
        main.printDirectoriesAndFilesFiltered(DEFAULT_PATH, filter);

        System.out.println("------- FIN Q3 --------");
    }

    /**
     * Test méthode list
     * @param path
     */
    private void printDirectories(String path){

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
    private void printDirectoriesAndFiles(String path){
        File file = new File(path);
        for (File f: file.listFiles()) {
            if(f.isDirectory())
                printDirectoriesAndFiles(f.getPath());
            System.out.println(f);
        }
    }

    private void printDirectoriesAndFilesFiltered(String path, FilenameFilter filter){
        File file = new File(path);
        for (File f: file.listFiles(filter)) {
            if(f.isDirectory())
                printDirectoriesAndFilesFiltered(f.getPath(), filter);
            System.out.println(f);
        }
    }

}
