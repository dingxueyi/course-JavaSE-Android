package lww.class24test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCConnect {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//1���������ݿ����������ǰ�������������ݿ�������jar����
		Class.forName("com.mysql.jdbc.Driver");
		//2���������ݿ�����
		String url = "jdbc:mysql://localhost:3306/lazy_test" ;    
	     String username = "root" ;   
	     String password = "840701lww" ;     
	    Connection con =    
	             DriverManager.getConnection(url , username , password ) ;
		//3��ִ�����ݿ����SQL
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from student");
		while(rs.next()){
			System.out.println(rs.getString("name"));
		}
		//����stmt.execute(sql);
		//4���ر����ݿ�����
		con.close();

	}
}
