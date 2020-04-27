package primary.Thread.ProducerAndComsumer;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock(100);
        new Producer(stock, 10).start();
        new Producer(stock, 10).start();
        new Producer(stock, 10).start();
        new Producer(stock, 10).start();
        new Producer(stock, 20).start();
        new Producer(stock, 50).start();
        new Producer(stock, 101).start();
        new Producer(stock, 10).start();
        new Producer(stock, 30).start();
        new Producer(stock, 10).start();
        new Producer(stock, 10).start();

        new Consumer(stock, 20).start();
        new Consumer(stock, 30).start();
        new Consumer(stock, 10).start();
        new Consumer(stock, 10).start();
        new Consumer(stock, 10).start();
        new Consumer(stock, 10).start();
        new Consumer(stock, 10).start();
        new Consumer(stock, 10).start();
        new Consumer(stock, 10).start();
        new Consumer(stock, 10).start();
//        new Consumer(stock, 50).start();

    }
}
