import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.util.Scanner;

public class ClientChat {
    static int port = 7777;
    public static void main(String[] args) throws IOException {
        System.out.println("\\t\\t Simple Chat Client");
        System.out.println("\\t\\t =================== \n\n");
        Scanner scannerInput = new Scanner(System.in);
        String input,output;
        InetAddress ipAddress = InetAddress.getLocalHost(); // get the ip address of the local host

        Socket socket = new Socket(
                ipAddress,
                port
        ); // create a new socket

        System.out.println("Server is connected........\n\n");


        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        try{
            out.println("Welcome to the Chat Application");

            while(true){
                input = in.readLine();
                if(input == null || input.equals(".")){
                    break;
                }
                System.out.println("Server says: "+input);
                System.out.println("Me: ");
                output = scannerInput.nextLine();
                out.println(output);
            }
        }finally {
            socket.close();
            out.close();
            in.close();
        }

       System.exit(0);
    }
}
