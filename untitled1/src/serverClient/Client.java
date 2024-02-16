package serverClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

public class Client {
    static int port = 6600;
    public static void main(String[] args) throws IOException {
        System.out.println("\\t\\t Simple Socket Client");
        System.out.println("\\t\\t =================== \n\n");

        InetAddress ipAddress = InetAddress.getLocalHost();

        Socket socket = new Socket(
                ipAddress,
                port
        );

        System.out.println("Server is connected........\n\n");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        String message = in.readLine();

        System.out.println("Server says:"+ message);

        System.out.println("Closing the connection");

        socket.close();

        in.close();

        System.exit(0);
    }
}
