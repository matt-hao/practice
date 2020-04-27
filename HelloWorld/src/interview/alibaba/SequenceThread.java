package interview.alibaba;


public class SequenceThread {
    public static volatile int flag = 1;
    public final static Object LOCK = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

/**
 * 请改写这些线程，让这三个线程在同时启动的情况下，永远得到 123123...的结果。
 */
class Thread1 extends Thread {
    public void run() {
        while (true) {
            synchronized (SequenceThread.LOCK){
                if(SequenceThread.flag == 1){
                    System.out.println(1);
                    SequenceThread.flag = 2;
                    SequenceThread.LOCK.notifyAll();
                }else{
                    try {
                        SequenceThread.LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        while (true) {
            synchronized (SequenceThread.LOCK){
                if(SequenceThread.flag == 2){
                    System.out.println(2);
                    SequenceThread.flag = 3;
                    SequenceThread.LOCK.notifyAll();
                }else{
                    try {
                        SequenceThread.LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Thread3 extends Thread {
    public void run() {
        while (true) {
            synchronized (SequenceThread.LOCK){
                if(SequenceThread.flag == 3){
                    System.out.println(3);
                    SequenceThread.flag = 1;
                    SequenceThread.LOCK.notifyAll();
                }else{
                    try {
                        SequenceThread.LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}