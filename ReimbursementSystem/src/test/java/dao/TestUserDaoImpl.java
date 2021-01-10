package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.ERSUser;

public class TestUserDaoImpl {
	private static UserDao userDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MyConnectionFactory.url = MyConnectionFactory.h2url;
		MyConnectionFactory.username = MyConnectionFactory.h2username;
		MyConnectionFactory.password = MyConnectionFactory.h2password;
		userDao = new UserDaoImpl();
	}
	@Before
	public void setUp() throws Exception {
		userDao.h2InitDao();
	}
	
	@After
	public void tearDown() throws Exception {
		userDao.h2DestroyDao();
	}
	@Test
	public void testGetUserById() {
		ERSUser user = userDao.selectUserById(1);
		assertEquals("splatinum", user.getUsername());
		assertEquals(1, user.getUserId());
		
	}
	@Test
	public void testInsertUser() {
		ERSUser user = new ERSUser(7, "utest", "ptest", "ftest", "ltest", "etest", 1);
		userDao.insertUser(user);
		ERSUser newUser = userDao.selectUserById(7);
		assertEquals(7, newUser.getUserId());
	}
	@Test
	public void testGetUserByEmail() {
		ERSUser user = userDao.selectUserByEmail("jpp@turtle.com");
		assertEquals("jpp@turtle.com", user.getEmail());
		
	}
	@Test
	public void testGetUserByUsername() {
		ERSUser user = userDao.selectUserByUsername("schariot");
		assertEquals("jpp@turtle.com", user.getEmail());
		assertEquals(3, user.getUserId());
		
	}
	@Test
	public void testGetUsersByRoleId() {
		List<ERSUser> users = userDao.selectUsersByRoleID(1);
		assertEquals(5, users.size());
		
		
	}
	@Test
	public void testGetAllUsers() {
		List<ERSUser> users = userDao.selectAllUsers();
		assertEquals(6, users.size());
	}
	@Test
	public void testUpdateUser() {
		ERSUser user = new ERSUser(1, "utest", "ptest", "ftest", "ltest", "etest", 1);
		userDao.updateUser(user);
		ERSUser updatedUser = userDao.selectUserById(1);
		assertNotEquals("splatinum", updatedUser.getUsername());
		assertEquals("utest", updatedUser.getUsername());
	}
	@Test
	public void testDeleteUser() {
		userDao.deleteUser(1);
		assertEquals(null, userDao.selectUserById(1));
		List<ERSUser> users = userDao.selectAllUsers();
		assertEquals(5, users.size());
	}
	
	
}
