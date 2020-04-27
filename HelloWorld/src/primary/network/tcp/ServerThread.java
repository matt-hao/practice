package primary.network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket client = null;

    public ServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            PrintStream out = new PrintStream(client.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while (true) {
                String str = in.readLine();
                if (str.equals("bye")){
                    System.out.println("客户端请求关闭连接");
                    break;
                }
                out.println("echo-->" + str);
                System.out.println("客户端信息--->" + str);
            }

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
