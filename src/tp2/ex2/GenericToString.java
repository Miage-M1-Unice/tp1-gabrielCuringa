package tp2.ex2;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class GenericToString {

    public String toString(Object o, int profondeur) throws IllegalAccessException {
        Class aClass = o.getClass();
        String s = aClass.getName() + "[";
        ArrayList<Field> fields = getAllFields(aClass);

        for (int i = 0; i < fields.size(); i++) {

            if(profondeur <= 0)
                return "";

            fields.get(i).setAccessible(true); //on rend le champ accessible

            s += fields.get(i).getName() +"="; //name

            if(fields.get(i).getType().isPrimitive()){
                s += fields.get(i).get(o);//value
                //fin de champ
                s += "; ";


            }else if(fields.get(i).getType().isArray()){

                s += fields.get(i).getName();
                s += "={";
                for (int j = 0; j < Array.getLength(fields.get(i).get(o)); j++) {

                    s += Array.get(fields.get(i).get(o), j);
                    if(j != Array.getLength(fields.get(i).get(o))-1)
                        s += ",";
                }
                s += "}; ";
            }else{
                s += toString(fields.get(i).get(o), profondeur-1)+"\n";

            }

        }

        return s+"]";
    }

    private ArrayList<Field> getAllFields(Class aClass){

        ArrayList<Field> fields = new ArrayList<>(Arrays.asList(aClass.getFields()));

        for (Field field : aClass.getDeclaredFields()) {
            if(!fields.contains(field))
                fields.add(field);
        }
        return fields;
    }
}
