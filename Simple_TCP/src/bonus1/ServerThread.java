package bonus1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{
	
	//field
	private Socket socket;
	private ServerMain server_main;
	
	//constructor
	public ServerThread(Socket socket, ServerMain server_main) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.server_main = server_main;
	}

	public void run() {
		try {
			
			int client = server_main.getClient();
			
			System.out.println("Client " +client+ ". has join. ");
			
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			
			
	/*
	 * exit when client said exit		
	 */
			
			String message = "a";

			while(!message.equalsIgnoreCase("exit")) {
				
				message = in_socket.readLine();
				System.out.println("Client says: " + message);
				String message1 = message.toUpperCase();
				out_socket.println(message1); //resend the meesage with upper case
				
			}
			
			socket.close();
			System.out.println("Socket "+client + ". close!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
		
	}

}
