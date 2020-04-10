/*
 * to exit, hit exit
 */

package bonus3;

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
		String send_message;
		
		boolean wrong = true;
		
		while(wrong) {
			if((in_socket.readLine()).startsWith("Please")==false) {
				wrong = false;
			}else {
			System.out.println("Start guessing!");
			send_message = scanner.nextLine();
			out_socket.println(send_message);
			}


		}
		System.out.println("You got it!");
		
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
