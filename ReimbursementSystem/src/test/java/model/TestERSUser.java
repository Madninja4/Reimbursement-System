package model;

import static org.junit.Assert.*;

import org.apache.tomcat.jni.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.ERSUser;

public class TestERSUser {

	ERSUser user = new ERSUser(1,"splatinum","yare yare daze","Jotoro","Kujo","jkujo@ora.com",1);
	@Test
	public void testGetUserID() {
		assertEquals(user.getUserId(),1);
	}
	@Test
	public void testSetUserID() {
		user.setUserId(2);
		assertEquals(user.getUserId(),2 );
	}

	@Test
	public void testGetUsername() {
		assertEquals(user.getUsername(), "splatinum");
	}

	@Test
	public void testSetUsername() {
		user.setUsername("test");
		assertEquals(user.getUsername(),"test" );
	}

	@Test
	public void testGetPassword() {
		assertEquals(user.getPassword(), "yare yare daze");
	}
	@Test
	public void testSetPassword() {
		user.setPassword("test");
		assertEquals(user.getPassword(),"test" );
	}
	@Test
	public void testGetFirstname() {
		assertEquals(user.getFirstName(), "Jotoro");
	}
	@Test
	public void testSetFirstname() {
		user.setFirstName("test");
		assertEquals(user.getFirstName(),"test" );
	}
	@Test
	public void testGetLastname() {
		assertEquals(user.getLastName(), "Kujo");
	}
	@Test
	public void testSetLastname() {
		user.setLastName("test");
		assertEquals(user.getLastName(),"test" );
	}
	@Test
	public void testGetEmail() {
		assertEquals(user.getEmail(), "jkujo@ora.com");
	}
	@Test
	public void testSetEmail() {
		
		user.setEmail("test");
		assertEquals(user.getEmail(),"test" );
	}
	@Test
	public void testGetUserRoleId() {
		assertEquals(user. getUserRoleId(),1);
	}
	@Test
	public void testSetUserRoleId() {
	
		user.setUserRoleId(2);
		assertEquals(user. getUserRoleId(),2 );
	}
	@Test
	public void testGetUserRole() {
		assertEquals(user.getUserRole(),"Employee");
	}


}
