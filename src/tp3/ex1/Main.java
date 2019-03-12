package tp3.ex1;

import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        // Chargement de la classe Test avec l'URL class loader
        URL[] classLoaderUrls;
        try {
            classLoaderUrls = new URL[]{new URL("file:///Users/gab/Documents/M1_MIAGE/S2/Prog_avancee/tp3-classLoadTest/out/production/tp3-classLoadTest/")};

            // Create a new URLClassLoader
            URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);

            Class testClass = urlClassLoader.loadClass("m1.miage.Test");

            // Test du class loader custom

            String className = "m1.miage.Test";
            ArrayList<File> al = new ArrayList<File>();
            al.add(new File("/paslebon"));
            al.add(new File("/toujours/Pas"));
            al.add(new File("/Users/gab/Documents/M1_MIAGE/S2/Prog_avancee/tp3-classLoadTest/out/production/tp3-classLoadTest/"));
            MyClassLoader myCL = new MyClassLoader(al);
            try {
                Class classLoaded = myCL.loadClass(className);
                System.out.println("----- AFFICHAGE DES CHAMPS DE LA CLASSE "+className+"  -----");
                for (Field declaredField : classLoaded.getDeclaredFields()) {
                    System.out.println(declaredField.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
