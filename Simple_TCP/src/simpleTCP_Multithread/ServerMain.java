package simpleTCP_Multithread;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public ServerMain() throws Exception {
		
		int socket_port = 2021;
		ServerSocket server_socket = new ServerSocket(socket_port);
		System.out.println("Socket " + socket_port + " is open. I'm at multithread");
		
		boolean waiting_connection = true;
		while(waiting_connection) {
	/*		
			Socket socket = server_socket.accept();
			System.out.println("Successful connection");
			
			BufferedReader in_socket = new BufferedReader(new InputStreamReader (socket.getInputStream()));
			
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter (socket.getOutputStream()),true);
			
			out_socket.println("Welcome! Say something!");
			//as soon as the socket is connected, created a thread and run a thread
			String message_fromClient = in_socket.readLine();
			System.out.println("Client said: " + message_fromClient);
		
			System.out.println("Well I'm stuck here");
			
	*/
			
			Socket socket = server_socket.accept();
			
			ServerThread server_thread = new ServerThread(socket, this);
			Thread thread = new Thread(server_thread);
			thread.start();
				
		}	
	}
	
	private int clientNumber = 1;
	
	public int getClientNumber() {
		return clientNumber++;
	}
	
	
	public static void main(String[] args) {
		
		try {
			new ServerMain();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
