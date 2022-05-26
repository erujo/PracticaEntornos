package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static String bd = "biblioteca";
	private static String parametros = "?useSSL=false&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "trebujena";
	private static String url = "jdbc:mysql://localhost:3306/" + bd + parametros;
	private Connection conn = null;
	
	public DbConnection() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
				System.out.println("Connection database [" + conn + "] OK");
			}
		/*} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void disconnect() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
