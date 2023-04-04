package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userName = "C##PRACTICE";
	private static String password = "1234";
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// JNDI
			// Java Naming and Directory Interface
			
			Context init = new InitialContext();
			DataSource source = (DataSource) init.lookup("java:comp/env/jdbc/test");
			conn = source.getConnection();
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName,password);
			System.out.println("db연동 성공");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("db연동 실패");
		}
		return conn;
	}
	
	
	public static Connection getConnectionFromMySql() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
		String username = "root";
		String password = "nGnU^8YH";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("db연동 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db연동 실패"); 
		}
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
