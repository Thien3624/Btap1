package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import configs.DBConnectMySQL;
import models.User;


public class UserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	public void registerUser(User user)
	 {
		 String INSERT_USER = "INSERT INTO users (username, email, fullname, password, images, phone, createdate ) VALUES (?,?,?,?,?,?,?)";
		 try {
				conn = new DBConnectMySQL().getConnection();
				ps = conn.prepareStatement(INSERT_USER);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getFullname());
				ps.setString(4, user.getPassword());
				ps.setString(5, user.getImages());
				ps.setString(6, user.getPhone());
				ps.setDate(7,(Date)user.getCreatedDate());
				ps.executeUpdate();
				}catch (Exception e) 
				{
					e.printStackTrace();
				}	
	 }
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "SELECT * FROM users where email = ?";
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
				}
			ps.close();
			conn.close();
		} catch (Exception ex) {}
		return duplicate;
	}
	
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "SELECT * FROM users where username = ?";
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {}
		return duplicate;
	}
	
	public User findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ?" ;
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) 
			{
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setUsername(username);
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdate"));
				return user;
			}
			} catch (Exception e) 
			{
				e.printStackTrace();	
			}
		return null;
	}
	public void changeInformation(User user) {
	    String UPDATE_USER = "UPDATE users SET fullname = ?, password = ?, images = ?, phone = ? WHERE username = ?";
	    try {
	        conn = new DBConnectMySQL().getConnection();
	        ps = conn.prepareStatement(UPDATE_USER);
	        ps.setString(1, user.getFullname());
	        ps.setString(2, user.getPassword());
	        ps.setString(3, user.getImages());
	        ps.setString(4, user.getPhone());
	        ps.setString(5, user.getUsername()); 
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
