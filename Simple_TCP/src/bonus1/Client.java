/*
 * to exit, hit exit
 */

package bonus1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public Client() throws Exception {
		
		Socket socket = new Socket("localhost",2020);
		System.out.println("socket has been connected! ");
		
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		Scanner scanner = new Scanner(System.in);
		String message = "khoa";
		
		boolean keep_playing = true;
		
		while(!(message.equalsIgnoreCase("EXIT"))) {
			
			System.out.println("Please enter your text here, to exit, hit exit!");
			message = scanner.nextLine();//read from user
			
			out_socket.println(message);//sent
			System.out.println("sent to server: " + message);
			
			message = in_socket.readLine();//read from server
			System.out.println("Server replied: " + message);
		}
		
		socket.close();
		System.out.println("Socket closed!");
	}
	
	public static void main(String[] args) {
		
		try {
			new Client();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
}
