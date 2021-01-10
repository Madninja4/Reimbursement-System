package service;

import java.util.List;

/**
 * This is the service implementation for sending front end data to the back end dao layer. This one interacts with users.
 * @author corbi
 *
 */

import dao.UserDao;
import dao.UserDaoImpl;
import model.ERSUser;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public void addUser(ERSUser user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}

	@Override
	public List<ERSUser> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.selectAllUsers();
	}

	@Override
	public ERSUser getUserByUsername(String ersUsername) {
		// TODO Auto-generated method stub
		return userDao.selectUserByUsername(ersUsername);
	}

	@Override
	public ERSUser getUser(int userId) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(userId);
	}

	@Override
	public ERSUser getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.selectUserByEmail(email);
	}

	@Override
	public List<ERSUser> getAllUsers(int roleId) {
		// TODO Auto-generated method stub
		return userDao.selectUsersByRoleID(roleId);
	}

	@Override
	public void editUser(ERSUser user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userId);
	}

}
