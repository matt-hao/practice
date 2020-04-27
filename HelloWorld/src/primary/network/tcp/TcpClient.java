package primary.network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 20000);
        client.setSoTimeout(10000);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        PrintStream out = new PrintStream(client.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        while (true) {
            System.out.println("输入信息");
            String str = input.readLine();

            out.println(str);
            if (str.equals("bye"))
                break;

            String echo = in.readLine();
            System.out.println(echo);
        }

        input.close();
        client.close();
    }
}
