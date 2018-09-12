import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static ServerSocket s1;
	public static ServerSocket s2;
	
	public static Socket ss;
	public static Socket ss2;
	public static void main(String args[]) throws IOException {		
		
		s1 = new ServerSocket(69);
		ss = s1.accept();
		System.out.println("CLiente0" + "Esperando J1");

		s2 = new ServerSocket(70);
		ss2 = s2.accept();
		System.out.println("CLiente1");

		
		while(true) {
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			if(number==0) {
				Server.C0();
			}
			else {
				Server.C1();
			}
		}
	}
	public static void C0() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
		while(true) {
			Object s = br.readLine();
			if(s.equals("exit")==true) {
				System.exit(1);
			}
			System.out.println("mensaje cliente " + s);
			return;
		}
	}
	
	public static void C1() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(ss2.getInputStream()));
		while(true) {
			Object s = br.readLine();
			if(s.equals("exit")==true) {
				System.exit(1);
			}
			System.out.println("mensaje cliente " + s);
			return;
		}
	}

}
