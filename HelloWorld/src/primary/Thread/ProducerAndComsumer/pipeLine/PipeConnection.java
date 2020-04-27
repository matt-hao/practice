package primary.Thread.ProducerAndComsumer.pipeLine;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeConnection {

    public static void main(String[] args) {
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream();

        try {
            out.connect(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Producer producer = new Producer(out);
        Consumer consumer = new Consumer(in);

        new Thread(producer).start();
        consumer.start();
    }
}

class Producer implements Runnable {
    private PipedOutputStream outputStream;

    public Producer(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
                outputStream.write(i);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer extends Thread {
    private PipedInputStream in;

    public Consumer(PipedInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(in.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}