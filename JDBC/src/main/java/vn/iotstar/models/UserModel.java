package vn.iotstar.models;

import java.io.Serializable;
import java.util.Date;

public class UserModel implements Serializable{
	private int id;
	private String email;
	private String username;
	private String password;
	private String images;
	private String fullname;
	private int roleid;
	private String phone;
	private Date createdDate;
	
	
	public UserModel() {
		super();
	}
	
	public UserModel(String email, String username, String password, String images, String fullname, int roleid,
			String phone, Date createdDate) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.images = images;
		this.fullname = fullname;
		this.roleid = roleid;
		this.phone = phone;
		this.createdDate = createdDate;
	}

	public UserModel(int id, String email, String username, String password, String images, String fullname, int roleid,
			String phone, Date createdDate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.images = images;
		this.fullname = fullname;
		this.roleid = roleid;
		this.phone = phone;
		this.createdDate = createdDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
