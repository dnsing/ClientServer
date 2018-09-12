import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
//import java.net.*;
//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		JSONObject obj = new JSONObject();
		obj.put("X", "numero en X");
		obj.put("Y", "numero en Y");
	 
		 try (FileWriter file = new FileWriter("test.json")) {

	            file.write(obj.toJSONString());
	            file.flush();
	            
		  } catch (IOException e) {
	            e.printStackTrace();
	        }

	       // System.out.print(obj);

	    
	            
		Socket s = new Socket("127.0.0.1",69);
		System.out.println("AK7");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps = new PrintStream(s.getOutputStream());
		BufferedReader brs = new BufferedReader(new InputStreamReader(s.getInputStream()));
		while(true) {
			System.out.println("mandelo");
			String st = br.readLine();
			ps.println(obj);
			
			if(s.equals("exit")) {
				System.exit(1);
			}
			System.out.println("Data returned " + s);
		}

	}

}
