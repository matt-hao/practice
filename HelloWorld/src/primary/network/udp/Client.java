package primary.network.udp;

import java.io.IOException;
import java.net.*;

public class Client {
    private static final int TIME_OUT = 5000;
    private static final int MAX_TRY = 5;

    public static void main(String[] args) throws IOException {
        String strSend = "Hello Udp Server";
        byte[] recei = new byte[1024];

        DatagramSocket ds = new DatagramSocket(9000);
        InetAddress loc = InetAddress.getLocalHost();

        DatagramPacket dpSend = new DatagramPacket(strSend.getBytes(), strSend.length(), loc, 8888);
        DatagramPacket dpReceive = new DatagramPacket(recei, recei.length);

        ds.setSoTimeout(TIME_OUT);

        int tries = 0;
        boolean receiveRes = false;

        while (!receiveRes && tries < MAX_TRY) {
            ds.send(dpSend);

            try {
                ds.receive(dpReceive);

                if (!dpReceive.getAddress().equals(loc))
                    throw new IOException("unknown resource");

                receiveRes = true;
            } catch (IOException e) {
                tries++;
                System.out.println("Time out, " + (MAX_TRY - tries) + " more tries..");
            }
        }

        if (receiveRes) {
            System.out.println("client receive data from server");
            String str_receive = new String(dpReceive.getData(), 0, dpReceive.getLength()) +
                    " from " + dpReceive.getAddress().getHostAddress() + ":" + dpReceive.getPort();
            System.out.println(str_receive);
            dpReceive.setLength(1024);
        } else {
            System.out.println("server no response -- give up");
        }
        ds.close();
    }
}
