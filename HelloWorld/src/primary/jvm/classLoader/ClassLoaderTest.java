package primary.jvm.classLoader;

import java.util.Objects;

public class ClassLoaderTest {
    public static void main(String[] args) {
        MyFileClassLoader myFileClassLoader = new MyFileClassLoader("/Users/mario/IdeaProjects/HelloWorld/out/production/HelloWorld");
        Class<?> c = null;
        try {
             c = myFileClassLoader.findClass("Main");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c);
        System.out.println(Objects.requireNonNull(c).getClassLoader());
    }
}
