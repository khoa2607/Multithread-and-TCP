package bonus3;

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
			
			int rand = (int)(Math.random()*10+1); // create a random Number
			System.out.println("random number is: "+rand);
			String message;
			boolean wrong = true;

			while(wrong) {
				out_socket.println("Please guess again!");
				message = in_socket.readLine();
				if(Integer.parseInt(message)==rand){
					wrong = false;
					out_socket.println("Bye");
				}
			}
			socket.close();
			System.out.println("Client "+client + ". Disconnect!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
		
	}

}
