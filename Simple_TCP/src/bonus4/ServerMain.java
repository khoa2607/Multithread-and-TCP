/*
 * whatever text client sent to server, server return it with all CAPS
 * 
 */

package bonus4;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	
	//field
	private int clientNumber = 1;
	private int rand =(int)(Math.random()*10+1);
	private String name;
	private boolean guessed = false;
	
	ServerMain() throws Exception{
		ServerSocket server_socket = new ServerSocket(2020);
		System.out.println("Socket 2020 port open");
		
		System.out.println("Randon Number is: " + rand);
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
	
	public int getRand() {
		return this.rand;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGuessed(boolean guessed) {
		this.guessed = guessed;
	}
	
	public boolean getGuessed() {
		return this.guessed;
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
