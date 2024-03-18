package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread{

    Socket socket;
    int current_clients;
    private PrintWriter out;
    private BufferedReader in;
    private Scanner ScannerInput;

    public ServerThread(Socket socket, int current_clients) {
        this.current_clients = current_clients;
        this.socket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        ScannerInput = new Scanner(System.in);
    }

    @Override
    public void run(){
		String input, output;
        try {
			
			try {
				out.println("Welcome to Chat Application");
                out.println(current_clients);
				while(true) {
					input = in.readLine();
					System.out.println("Client "+current_clients+" Says: "+ input);
					
					System.out.println("Server: ");
					output = ScannerInput.nextLine();
					out.println(output);
                }
			
			} finally {
				socket.close();
				out.close();
				in.close();
			}
            
        } catch (IOException e) {
            // TODO: handle exception
        }    
        
        
         
		}
    }


    

