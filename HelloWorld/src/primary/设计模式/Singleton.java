package primary.设计模式;

/**
 * 饿汉，线程安全
 */
public class Singleton {
    private static Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    private static Singleton getInstance() {
        return INSTANCE;
    }
}

/**
 * 懒汉，非线程安全
 */
class Singleton1 {
    private static Singleton1 INSTANCE;

    private Singleton1() {
    }

    private static Singleton1 getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Singleton1();
        return INSTANCE;
    }
}

/**
 * 懒汉，线程安全，read-read, read-write阻塞，效率不高
 */
class Singleton2 {
    private static Singleton2 INSTANCE;

    private Singleton2() {
    }

    public synchronized static Singleton2 getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Singleton2();
        return INSTANCE;
    }
}

/**
 * 双重检验锁
 */
class Singleton3 {
    //volatile防止指令重排
    private static volatile Singleton3 INSTANCE;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton3();
                }
            }
        }
        return INSTANCE;
    }
}

/**
 * 内部类
 */
class Singleton4 {
    private static class SingletonHolder {
        private static Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

/**
 * 枚举，恶汉模式，但可以解决序列化的问题
 */
enum Singleton5 {
    INSTANCE;

    public void doSomething() {
        System.out.println("Hello Matthew");
    }
}
