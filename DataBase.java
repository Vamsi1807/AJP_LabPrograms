package lab_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	public static void main(String arg[]) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Krishna");
			Statement smt=conn.createStatement();
			smt.executeUpdate("create table Stu2(R_no number(5),Stu_name varchar(12),Branch varchar(5),Section char(1))");
			System.out.println("Adding values into table...");
			smt.executeUpdate("insert into Stu2 values(1249,'Vamsi','IT','A')");
			smt.executeUpdate("insert into Stu2 values(3484,'Krishna','ECE','B')");
			smt.executeUpdate("insert into Stu2 values(4202,'Manish','CSM','C')");
			smt.executeUpdate("insert into Stu2 values(1250,'vamsi','IT','A')");
			//smt.executeUpdate("delete from Students1");
			System.out.println("Retrieving the data...");
			ResultSet rs=smt.executeQuery("select * from Stu2");//retrieving the data
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			smt.executeUpdate("delete from Stu2 where R_no=1250");//deleting the data
			System.out.println("\nAfter deletion....\n");
			ResultSet rs1=smt.executeQuery("select * from Stu2");
			while(rs1.next()){
				System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4));
			}
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(SQLException a) {
			System.out.println(a);
		}
	}
}
