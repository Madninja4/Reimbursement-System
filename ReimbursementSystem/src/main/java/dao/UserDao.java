package dao;

import java.util.List;

import model.ERSUser;

public interface UserDao {
	public void insertUser(ERSUser user);

	public List<ERSUser> selectAllUsers();

	public ERSUser selectUserById(int userId);

	public ERSUser selectUserByUsername(String ersUsername);

	public ERSUser selectUserByEmail(String email);

	public List<ERSUser> selectUsersByRoleID(int roleId);

	public void updateUser(ERSUser user);

	public void deleteUser(int userId);

	// H2 DATABASE FUNCTIONALITY
	public void h2InitDao();

	public void h2DestroyDao();

}