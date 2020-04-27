package primary.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws SocketException {
        String strSend = "HELLO UDP CLIENT";
        byte[] buf = new byte[1024];

        DatagramSocket ds = new DatagramSocket(8888);

        DatagramPacket dpReceive = new DatagramPacket(buf, 1024);
        System.out.println("server is on, wait for client to send data");
        while (true) {
            try {
                ds.receive(dpReceive);
                System.out.println("receive data from client:");
                String str_receive = new String(dpReceive.getData(), 0, dpReceive.getLength()) +
                        " from " + dpReceive.getAddress().getHostAddress() + ":" + dpReceive.getPort();
                System.out.println(str_receive);

                DatagramPacket dpSend = new DatagramPacket(strSend.getBytes(),strSend.length(), dpReceive.getAddress(),dpReceive.getPort());
                ds.send(dpSend);
                dpReceive.setLength(1024);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
