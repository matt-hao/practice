package primary.Thread.ProducerAndComsumer;

public class Producer extends Thread {
    private Stock stock;
    private int produce;

    public Producer(Stock stock, int produce) {
        this.stock = stock;
        this.produce = produce;
    }

    @Override
    public void run() {
        stock.produce(this.produce);
    }
}
