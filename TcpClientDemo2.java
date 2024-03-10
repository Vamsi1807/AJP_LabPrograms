package Network;
import java.io.*;
import java.net.*;
import java.util.*;
public class TcpClientDemo2 {
	public static void main(String arg[]) {
		try {
			Socket s=new Socket("localhost",4848);
			Scanner sc=new Scanner(System.in);
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String req="";
			String res="";
			do {
				System.out.println("Enter the message to send to server : ");
				req=sc.nextLine();
				dos.writeUTF(req);
				res=dis.readUTF();
				System.out.println("Server says : "+res);
			}while(!req.equalsIgnoreCase("byee"));
			s.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
