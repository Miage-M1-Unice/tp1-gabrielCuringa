package tp2.ex2;

import java.awt.*;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args){
        try {
            //System.out.println(new GenericToString().toString(new Point(12,24)));
            Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);
            pol.getBounds();
            System.out.println(new GenericToString().toString(pol, 2));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
