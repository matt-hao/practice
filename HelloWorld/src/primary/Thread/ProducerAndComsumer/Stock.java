package primary.Thread.ProducerAndComsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Stock {
    private int stockNum;
    private int maxSize;
    private Lock lock;
    private Condition produce;
    private Condition consume;

    public Stock(int maxSize) {
        this.maxSize = maxSize;
        stockNum = 0;
        lock = new ReentrantLock();
        produce = lock.newCondition();
        consume = lock.newCondition();
    }

    public void produce(int produceNum) {
        lock.lock();
        try {
            while (this.stockNum + produceNum > maxSize) {
                System.out.println("要生产的商品数量" + produceNum + "大于可生产的数量" + (maxSize - stockNum) + ",暂时停止生产");
                produce.await();
            }
            stockNum += produceNum;
            System.out.println("生产了" + produceNum + "个商品,现在库存为" + stockNum);
            Thread.sleep(1000);
            consume.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume(int consumeNum) {
        lock.lock();
        try {
            while (consumeNum > stockNum) {
                System.out.println("要消费的产品数量" + consumeNum + "大于现有库存" + stockNum + ",暂时不能消费");
                consume.await();
            }
            stockNum -= consumeNum;
            System.out.println("已消费了" + consumeNum + "个库存,消费后剩余库存为" + stockNum);
            Thread.sleep(1000);
            produce.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
