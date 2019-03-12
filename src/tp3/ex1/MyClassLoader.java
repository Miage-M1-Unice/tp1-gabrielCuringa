package tp3.ex1;

import java.io.*;
import java.security.SecureClassLoader;
import java.util.ArrayList;

public class MyClassLoader extends SecureClassLoader {

    private ArrayList<File> path;

    public MyClassLoader(ArrayList<File> p) {
        this.path = p;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] b = loadClassData(name);

        return super.defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) throws ClassNotFoundException {

        File f = null;

        for (File file : path) {
            if(file.exists()){
                f = new File(file.getPath()+""+File.separatorChar+""+name.replace('.', File.separatorChar)+".class");
            }
        }

        if(f == null)
            return null;

        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            InputStream inputStream = new FileInputStream(f);

            while ( (nextValue = inputStream.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            return null;
        }
        buffer = byteStream.toByteArray();

        return buffer;
    }
}
