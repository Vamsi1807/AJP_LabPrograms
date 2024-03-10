package lab_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaData {
	public static void main(String arg[]) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Krishna");
			Statement smt=conn.createStatement();
			//smt.executeUpdate("create table Students(R_no number(5),Stu_name varchar(12),Branch varchar(5),Section char(1))");
			ResultSet rs=smt.executeQuery("select * from Students");
			ResultSetMetaData rsmd=rs.getMetaData();  
			int c=rsmd.getColumnCount();
			System.out.println("Total columns : "+c);  
			int i=1;
			while(i<=c) {
				System.out.println("\nColumn "+i+": "+rsmd.getColumnName(i));  
				System.out.printf("%s type : %s(%d)\n",rsmd.getColumnName(i),rsmd.getColumnTypeName(i),rsmd.getPrecision(i));
				i++;
			}
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(SQLException a) {
			System.out.println(a);
		}
	}	
}
