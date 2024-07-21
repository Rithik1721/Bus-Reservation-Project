package Busresv;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static final String url="jdbc:mysql://localhost:3306/busresv";
	private static final String user="root";
	private static final String pass="1234";
	public static Connection getConnection()throws Exception {
		return DriverManager.getConnection(url,user,pass);
	}
}
