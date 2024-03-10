package Network;
import java.io.*;
import java.net.*;
import java.util.*;
public class TcpServerDemo2 {
	public static void main(String arg[]) {
		try{
			ServerSocket ss= new ServerSocket(4848);
			Socket s = ss.accept();
			Scanner sc=new Scanner(System.in);
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String req="";
			String res="";
			do {
				req=dis.readUTF();
				System.out.println("Client says : "+req);
				System.out.println("Enter response message : ");
				res=sc.nextLine();
				dos.writeUTF(res);
			}while(!req.equalsIgnoreCase("byee"));
			s.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
