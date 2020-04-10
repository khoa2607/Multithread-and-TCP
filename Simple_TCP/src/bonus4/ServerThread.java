package bonus4;

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
			int rand = server_main.getRand();

			System.out.println("Client " +client+ ". has join. ");
			
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			
			out_socket.println("Hello! What your name!");
			
			String client_name = in_socket.readLine();
			System.out.println("Client name " +client+" is: " + client_name);

			while(true){
				out_socket.println("Please guess from [1 10]!");
				String message = in_socket.readLine();
				System.out.println("Client guess " + message);
				//case 1: nobody guess correct
				if(Integer.parseInt(message)==rand && server_main.getGuessed() == false ) {
					System.out.println("Client guess correct!");
					out_socket.println("Bye");
					server_main.setName(client_name);
					server_main.setGuessed(true);
					System.out.println(" getGuess become: "+server_main.getGuessed());
					socket.close();
					System.out.println("Client "+client + ". Disconnect!");
					break;
				}
				else if(Integer.parseInt(message)==rand && server_main.getGuessed() == true) {
					System.out.println(server_main.getName()+" already guessed correct");
					out_socket.println(server_main.getName()+" already guessed correct 1");
					socket.close();
					System.out.println("Socket close!");
				}
				else if (server_main.getGuessed() == true) {
					out_socket.println(server_main.getName()+" already guessed correct 2");
					break;
				}

			}
			

			
		} catch (Exception e) {
			// TODO: handle exception
		}	
			
		
	}

}
