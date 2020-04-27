package primary.Thread.ProducerAndComsumer;

public class Consumer extends Thread {
    private Stock stock;
    private int consume;

    public Consumer(Stock stock, int consume) {
        this.stock = stock;
        this.consume = consume;
    }

    @Override
    public void run() {
        stock.consume(this.consume);
    }
}
