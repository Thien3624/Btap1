package vn.iotstar.DAO;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDAO {
	UserModel get(String username);
	UserModel findByUserName(String username);
	void insert(UserModel user);
	boolean checkExistEmail(String email);
	boolean checkExistPhone(String phone);
	boolean checkExistUsername(String username);
}
