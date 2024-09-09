package vn.iotstar.service.impl;

import java.util.Date;

import vn.iotstar.DAO.IUserDAO;
import vn.iotstar.DAO.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.service.UserService;

public class UserServiceImpl implements UserService{
	
	IUserDAO userDao = new UserDaoImpl();
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		
		if(user!=null && password.equals(user.getPassword()))
		{
			return user;
		}
		return null;
	}

	private UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public UserModel getUser(String username) {
		return userDao.get(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if(userDao.checkExistUsername(username))
		{
			return false;
		}
		long millis = System.currentTimeMillis();
		Date date = new Date();
		userDao.insert(new UserModel(email,username,password,null,fullname,5,phone,date));
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

}
