package primary.network.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(20000);
        Socket client;
        while (true) {
            client = serverSocket.accept();
            System.out.println("客户端建立成功");
            new Thread(new ServerThread(client)).start();
        }
    }
}
