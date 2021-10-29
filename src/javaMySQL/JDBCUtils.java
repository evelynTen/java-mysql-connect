package javaMySQL;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class JDBCUtils {

	public JDBCUtils()
	{
		
	}
	
	private static Connection con;
	
	static
	{
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url = "jdbc:mysql://127.0.0.1:3306/javamysql?serverTimezone=UTC&characterEncoding=utf-8";
			String user = "root";
			String password = "liu102016@Liu";
			try {
				con = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static Connection getConnection()
	{
		return con;
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	
		Connection con = JDBCUtils.getConnection();
		
		String sql = "select * from S";
		Statement stmt = null;
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		
		int age;
		String sno,sname,sex;
		System.out.println("SNO\tSNAME\tSEX\tAGE");
		
		
		while(rs.next()) {        
		sno= rs.getString("SNO");
		sname = rs.getString("SNAME");
		sex = rs.getString("SEX");
		age = rs.getInt("AGE");
		System.out.println(sno + "\t" + sname + "\t" + sex + "\t" + age);
		}
	
	}
	
}
