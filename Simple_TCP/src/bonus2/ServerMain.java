/*
 * whatever text client sent to server, server return it with all CAPS
 * 
 */

package bonus2;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	
	//field
	private int clientNumber = 1;
	
	ServerMain() throws Exception{
		
		
		ServerSocket server_socket = new ServerSocket(2020);
		System.out.println("Socket 2020 port open");
		
		
		//open loop to continute receive client
		while(true) {	
			Socket socket = server_socket.accept();	
			ServerThread server_thread = new ServerThread(socket,this);
			Thread thread = new Thread(server_thread);
			thread.start();
		}
		
	}
	
public int getClient() {
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
