package primary.Thread.ThreadPool;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool {
    private ArrayList<MyThread> myThreads;
    private ArrayBlockingQueue<Runnable> task;

    private Lock lock;

    private int maxSize;
    private int curSize;

    public ThreadPool(int initPool) {
        this.maxSize = initPool;
        this.curSize = 0;
        lock = new ReentrantLock();
        myThreads = new ArrayList<>(initPool);
        task = new ArrayBlockingQueue<>(initPool * 4);
    }

    public void execute(Runnable runnable) {
        lock.lock();
        try {
            if (curSize < maxSize) {
                MyThread thread = new MyThread(runnable);
                thread.start();
                curSize++;
                myThreads.add(thread);
            } else {
                if (!task.offer(runnable))
                    System.out.println("任务队列已满");
            }
        } finally {
            lock.unlock();
        }
    }


    class MyThread extends Thread {
        private Runnable runnable;

        MyThread(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            while (true) {
                if (runnable != null) {
                    runnable.run();
                    runnable = null;
                } else {
                    Runnable nTask = task.poll();
                    if (nTask != null)
                        nTask.run();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(10);
        Runnable task = () -> System.out.println(Thread.currentThread().getName() + "执行中");
        for (int i = 0; i < 100; i++) {
            threadPool.execute(task);
        }
    }
}


