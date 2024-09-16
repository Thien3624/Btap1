package configs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnectMySQL {
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
			Logger.getLogger(DBConnectMySQL.class.getName()).log(Level.SEVERE,null,ex);
		}
		return (con);
	}
	
	public static void main(String[] args) {
		 DBConnectMySQL dbConnect = new DBConnectMySQL();
	        Connection connection = null;
	        try {
	            connection = dbConnect.getConnection();  // Thử kết nối tới cơ sở dữ liệu
	            if (connection != null) {
	                System.out.println("Kết nối thành công đến cơ sở dữ liệu!");
	            } else {
	                System.out.println("Kết nối thất bại!");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            // Đóng kết nối nếu nó không null
	            if (connection != null) {
	                try {
	                    connection.close();
	                    System.out.println("Đóng kết nối thành công.");
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	}
	
}
