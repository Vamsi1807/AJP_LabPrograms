package lab_programs;
import java.io.*;
import java.util.*;
public class Exp2 {
	public static void main(String arg[]) throws FileNotFoundException {
		FileInputStream fis=new FileInputStream("C:\\Users\\a\\eclipse-workspace\\JavaExamples\\src\\lab_programs\\lab2_textfile");
		Scanner sc=new Scanner(fis).useDelimiter("\t");
		Scanner sc1=new Scanner(System.in);
		Hashtable<String,String> ht=new Hashtable<String,String>();
		String strarr[];
		String a,str;
		while(sc.hasNext()) {
			str=sc.nextLine();
			strarr=str.split("\t");
			ht.put(strarr[1], strarr[0]);
		}
		System.out.println("Enter the key value : ");
		String key=sc1.nextLine();
		//System.out.println("Hashtable : "+ht);
		if(ht.containsKey(key)) 
			System.out.println("Value for entered key is : "+ht.get(key));
		else
			System.out.println("Key not found.");
	}
}
