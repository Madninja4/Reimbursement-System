package service;

import java.util.List;

import model.ERSUser;

public interface UserService {
	public void addUser(ERSUser user);// insertUser(ERSUser user)

	public List<ERSUser> getAllUsers();// List<ERSUser> selectAllUsers();

	public ERSUser getUserByUsername(String ersUsername);// public ERSUser selectUserByUsername(String ersUsername);

	public ERSUser getUser(int userId);// public ERSUser selectUserById(int userId);

	public ERSUser getUserByEmail(String email);// ERSUser selectUserByEmail(String email);

	public List<ERSUser> getAllUsers(int roleId);// List<ERSUser> selectUsersByRoleID(int roleId);

	public void editUser(ERSUser user);// updateFurniture

	public void deleteUser(int userId);// deleteFurniture

}
