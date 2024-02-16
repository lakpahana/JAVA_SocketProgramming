import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat {
    static int port = 7777;
    public static void main (String[] args) throws IOException {

        System.out.println("\t\t Simple Socket Server");
        System.out.println("\t\t =================== \n\n");


        ServerSocket serverSocket =  new ServerSocket(port);
        Scanner scannerInput = new Scanner(System.in);
        String input,output;
        try {
            while(true){

                Socket socket = serverSocket.accept();



                System.out.println("Client is connected........\n\n\n");

                try{

                    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()
                            )
                    );



                    try{
                        out.println("Welcome to the Chat Application");

                        while(true){
                            input = in.readLine();
                            if(input == null || input.equals(".")){
                                break;
                            }
                            System.out.println("Client says: "+input);
                            System.out.println("Me: ");
                            output = scannerInput.nextLine();
                            out.println(output);
                        }
                    }finally {
                        socket.close();
                        out.close();
                        in.close();
                    }


                }finally {
                    socket.close();

                }



            }
        }finally {
            serverSocket.close();
        }






    }
}
