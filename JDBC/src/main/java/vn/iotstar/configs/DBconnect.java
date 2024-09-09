package vn.iotstar.configs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBconnect {
	private static String URL = "jdbc:mysql://localhost:3306/bt4";
	private static String USER_NAME = "root";
	private static String PASSWORD = "Thientyvk1234.";
	private static Connection con;
	public Connection getConnection() throws IOException {
		con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = (Connection) DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		}catch (SQLException ex) {
			Logger.getLogger(DBconnect.class.getName()).log(Level.SEVERE,null,ex);
		}
		return (con);
	}
	
}
