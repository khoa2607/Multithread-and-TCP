package simpleTCP_Multithread;

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
	public ServerThread(Socket socket, ServerMain server_main)  {
		this.socket = socket;
		this.server_main = server_main;
		
	}
	
	@Override
	public void run() {	
	try {
		
		int clientNumber = server_main.getClientNumber();
		
		System.out.println("Client " +clientNumber+ ". has connected!");
		
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		out_socket.println("Hello! Say somthing");
		
		String message = in_socket.readLine();
		System.out.println("Client"+ clientNumber+ " Say: " + message);
		
		socket.close();
		System.out.println("client" + clientNumber +". has disconnected");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}

	}
	
}
