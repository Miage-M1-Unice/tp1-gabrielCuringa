package tp2.ex1;
/**
 * @version 1.00 23 Mars 2001
 * @author Michel Buffa
 * Inspiré par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publiée dans le livre Core Java, Sun Press
 */

import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {

  public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
    // Récupération d'un objet de type Class correspondant au nom passé en paramètres
    Class cl = getClasse(nomClasse);

    afficheEnTeteClasse(cl);

    System.out.println();
    afficheAttributs(cl);

    System.out.println();
    afficheConstructeurs(cl);

    System.out.println();
    afficheMethodes(cl);

    // L'accolade fermante de fin de classe !
    System.out.println("}");
  }


  /** Retourne la classe dont le nom est passé en paramètre */
  public static Class getClasse(String nomClasse) throws ClassNotFoundException {
    return Class.forName(nomClasse);
  }

  /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
  public static void afficheEnTeteClasse(Class cl) {
    //  Affichage du modifier et du nom de la classe
    System.out.print(Modifier.toString(cl.getModifiers()) +" "+cl.getName());

   // Récupération de la superclasse si elle existe (null si cl est le type Object)
    if(cl.getSuperclass() != null) {
      Class supercl = cl.getSuperclass();

      // On ecrit le "extends " que si la superclasse est non nulle et
      System.out.print(" extends "+supercl.getName());

    }
    // différente de Object
    // CODE A ECRIRE

    // Affichage des interfaces que la classe implemente
    if(cl.getInterfaces().length > 0) {
      Class[] interfaces = cl.getInterfaces();
      System.out.print(" implements ");
      for (Class anInterface : interfaces) {
        System.out.print(anInterface);
      }
    }

    // Enfin, l'accolade ouvrante !
    System.out.print(" {\n");
  }

  public static void afficheAttributs(Class cl) {
    System.out.println("// Champs");
    Field[] fields = cl.getFields();
    for (Field field : fields) {
      //System.out.println(Modifier.toString(field.getModifiers()));
      System.out.println(field);
    }
  }

  public static void afficheConstructeurs(Class cl) {
    System.out.println("// Constructeurs");
    for (Constructor constructor : cl.getConstructors()) {
      System.out.println(constructor);
    }
  }


  public static void afficheMethodes(Class cl) {

    System.out.println("// Méthodes");
    for (Method method : cl.getMethods()) {
      System.out.println(method);
    }
  }

  public static String litChaineAuClavier() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      return br.readLine();
  }

  public static void main(String[] args) {
    boolean ok = false;

    while(!ok) {
      try {
        System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
        String nomClasse = litChaineAuClavier();

        analyseClasse(nomClasse);

        ok = true;
      } catch(ClassNotFoundException e) {
        System.out.println("Classe non trouvée.");
      }catch(IOException e) {
        System.out.println("Erreur d'E/S!");
      }
    }
  }
}
