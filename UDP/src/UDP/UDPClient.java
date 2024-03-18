package UDP;
//test
//est
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

    public static void main(String[] args) throws
            IOException
    {
//
        DatagramSocket server = new DatagramSocket(
                4222
        );

        byte[] recievingBytes = new byte[256];

        DatagramPacket packet = new DatagramPacket(recievingBytes,recievingBytes.length);

        server.receive(packet);

        
        String message = new String(packet.getData());

        System.out.println(message.trim());


    }
}
