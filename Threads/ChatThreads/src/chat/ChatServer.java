package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

	static int port = 7777;
	public static void main(String[] args) throws IOException {
        System.out.println("\t\t Simple Socker Server");
		System.out.println("\t\t=====================\n\n");
        
        ServerSocket serversocket = new ServerSocket(port);
        int  current_clients = 1;
		
		
		try {
			while (true) {
			Socket socket = serversocket.accept();
			System.out.println("Client "+current_clients +"  is connected.....\n\n");
            // System.out.println();
            ServerThread ct = new ServerThread(socket,current_clients);
            current_clients++;                
            ct.start();
        }
			
		}finally {
			serversocket.close();
		}
	}

}




