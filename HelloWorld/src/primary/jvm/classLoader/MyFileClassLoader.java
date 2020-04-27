package primary.jvm.classLoader;

import java.io.*;

public class MyFileClassLoader extends ClassLoader {
    private String root;

    public MyFileClassLoader(String root) {
        this.root = root;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //first check whether the class has already existed
        Class<?> c = findLoadedClass(name);
        if (c != null)
            return c;

        //check the class through parent classloader
//        ClassLoader parent = this.getParent();
//        c = parent.loadClass(name);
//        if (c != null)
//            return c;

        byte[] data = loadCLassData(name);
        if (data == null) {
            throw new ClassNotFoundException();
        }

        c = defineClass(name, data, 0, data.length);
        return c;
    }


    private byte[] loadCLassData(String name) {
        String path = root + File.separatorChar + name.replace(".", String.valueOf(File.separatorChar)) + ".class";
        InputStream is = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            is = new FileInputStream(path);
            byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int len = 0;

            while ((len = is.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
