package models;

import java.util.Date;

public class User {
	private String email;
	private String username;
	private String password;
	private String images;
	private String fullname;
	private String phone;
	private Date createdDate;
	
	
	
	public User() {
		super();
	}

	public User(String email, String username, String password, String images, String fullname, int roleid,
			String phone, Date createdDate) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.images = images;
		this.fullname = fullname;
		this.phone = phone;
		this.createdDate = createdDate;
	}
	

	public User(String email, String username, String password, String fullname, String phone, Date createdDate) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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


	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
