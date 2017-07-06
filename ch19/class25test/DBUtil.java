package lww.class25test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	//����
	private Connection conn;
	private String url;
	private String user;
	private String password;
	
	public DBUtil(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	//����
	// ��ȡ���ݿ����Ӷ��󷽷� Connection openConnection();
	public Connection openConnection() throws SQLException, ClassNotFoundException{
		if(isDatabaseAvalable()){
			return conn;
		} else {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		}
	}
	// ��ѯ���� ResultSet query(sql)
	public ResultSet query(String sql) throws SQLException, ClassNotFoundException{
		if(!isDatabaseAvalable()){
			openConnection();
		} 
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	// ���·��� int update(sql)
	
	// �ر����ݿ����ӷ���  close()
	public void close() throws SQLException{
		if(isDatabaseAvalable()){
			conn.close();
		}
	}
	// ���ݿ����Ӷ����Ƿ����   boolean isDatabaseAvalable()
	public boolean isDatabaseAvalable() throws SQLException{
		if(null != conn && !(conn.isClosed())){
			return true;
		} else {
			return false;
		}
	}
}
