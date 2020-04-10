/*
 * to exit, hit exit
 */

package bonus4;

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
		String receive_message,name;
		
		//asking for name
		System.out.println(in_socket.readLine());
		name = scanner.nextLine();
		out_socket.println(name);

		while(true) {

			receive_message = in_socket.readLine();
			System.out.println("Guess from 1 to 10");

			//case 1: guess wrong
			if(receive_message.startsWith("Please")) {
				String guess = scanner.nextLine();
				out_socket.println(guess);
			}

			//case 2: wining
			else if(receive_message.startsWith("Bye")) {
				System.out.println("You win");
				socket.close();
				System.out.println("Socket closed!");
				break;
			}
			else {
				System.out.println(receive_message);
				socket.close();
				System.out.println("Socket Close!");
				break;
			}
			
		}
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
