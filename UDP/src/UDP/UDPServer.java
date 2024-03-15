package UDP;

import java.io.IOException;
import java.net.*;

public class UDPServer {

    public static void main(String[] args) throws
            IOException

    {
        DatagramSocket client = new DatagramSocket();

        InetAddress ipAddress = InetAddress.getLocalHost();

        String str = "Hello World";

        byte[] encodeByteArray = str.getBytes();

        DatagramPacket packet = new DatagramPacket(encodeByteArray,encodeByteArray.length,ipAddress,4222);

        client.send(packet);

        client.close();



    }

}
