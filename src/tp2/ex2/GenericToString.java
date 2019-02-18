package tp2.ex2;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class GenericToString {

    public String toString(Object o, int profondeur) throws IllegalAccessException {
        Class aClass = o.getClass();
        String s = aClass.getName() + "[";
        for (int i = 0; i < aClass.getDeclaredFields().length; i++) {

            if(profondeur <= 0)
                return "";

            Field field = aClass.getDeclaredFields()[i];
            field.setAccessible(true); //on rend le champ accessible

            if(!field.getType().isPrimitive()){

                if(field.getType().isArray()){
                    s += field.getName();
                    s += "={";
                    for (int j = 0; j < Array.getLength(field.get(o)); j++) {

                        s += Array.get(field.get(o), j);
                        s += ",";
                    }
                    s += "}";
                }else
                    s += toString(field.get(o), profondeur-1);

            }else{
                s += field.getName() +"="; //name
                s += field.get(o);//value
                //fin de champ
                s += "; ";
            }

        }

        return s+"]";
    }
}
