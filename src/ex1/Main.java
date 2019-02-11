package ex1;

import java.io.File;

public class Main {

    private static String DEFAULT_PATH = ".";

    public static void main(String[] args){

        Main main = new Main();

        main.printDirectories(DEFAULT_PATH);

        System.out.println("------- --------");

        main.printDirectoriesAndFiles(DEFAULT_PATH);

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

}
