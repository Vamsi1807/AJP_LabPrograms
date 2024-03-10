package lab_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class SQLTable {
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Krishna");
			Statement smt=conn.createStatement();
			PreparedStatement stmt;
			int count=0;
			while(true) {
				System.out.println("1.Add\n2.Delete\n3.Modify\n4.Retrieve\n5.Exit\nSelect an option..");
				int x=sc.nextInt();
				switch(x) {
					case 1:
						System.out.println("Enter student number : ");
						int num=sc.nextInt();
						System.out.println("Enter student name : ");
						String name=sc.next();
						System.out.println("Enter student branch : ");
						String branch=sc.next();
						System.out.println("Enter student section : ");
						String sec=sc.next();
						stmt=conn.prepareStatement("insert into Students values(?,?,?,?)");  
						stmt.setInt(1,num);
						stmt.setString(2, name);
						stmt.setString(3, branch);
						stmt.setString(4, sec);
						stmt.executeUpdate();
						count++;
						break;
					case 2:
						System.out.println("Enter student id to delete details : ");
						int rno=sc.nextInt();
						//create table Students(R_no number(5),Stu_name varchar(12),Branch varchar(5),Section char(1))
						smt.executeUpdate("delete from Students where R_no="+rno);
						System.out.println("Student data with id "+rno+" is deleted.");
						if(count>0)
							count--;
						break;
					case 3:
						if(count==0) {
							System.out.println("Table is empty, can't be updated.");
							break;
						}
						System.out.print("Enter id to update : ");
                        int id1 = sc.nextInt();
                        System.out.print("Enter column to update: ");
                        String col = sc.next();
                        System.out.print("Enter value : ");
                        String val = sc.next();
                        String x1 ="'"+ val+"'";
                        String s = "update Students set "+col+"="+x1+" where R_no ="+id1+"";
                        try {
                        	smt.executeUpdate(s);
                            System.out.println("Data updated.");
                        } catch (SQLException e) {
                        	System.out.println("No such column is present..");        
                        }
						break;
					case 4:
						ResultSet rs=smt.executeQuery("select * from Students");
						int c=0;
						while(rs.next()) {
							c=1;
							System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
						}
						if(c==0) {
							System.out.println("End of the table....");
						}
						
						break;
					case 5:
						smt.executeUpdate("delete from Students");
						conn.close();
						return;
				}
			}
		}catch(ClassNotFoundException e){
				System.out.println(e);
		}catch(SQLException a) {
			System.out.println(a);
		}		
	}
}
