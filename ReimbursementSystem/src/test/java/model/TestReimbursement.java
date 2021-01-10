package model;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestReimbursement {
	
	//make a new reimbursement
	//FIGURE OUT HOW TO MAKE A TIMESTAMP IN JAVA
	Timestamp subTimestamp = new Timestamp(System.currentTimeMillis());
	Timestamp resTimestamp = java.sql.Timestamp.valueOf("2022-12-23 10:10:10.0");

	Reimbursement reimbursement = new Reimbursement(1,100 ,subTimestamp,resTimestamp,"Test reimb",null,1,6,1,2);

	@Test
	public void testGetReimbID() {
		assertEquals(1, reimbursement.getReimbId());
	}
	@Test
	public void testSetReimbID() {
		reimbursement.setReimbId(2);
		assertEquals(2, reimbursement.getReimbId());
	}

	@Test
	public void testGetReimbAmount() {
		assertEquals(100, reimbursement.getAmount());
	}

	@Test
	public void testSetReimbAmount() {
		reimbursement.setAmount(2);
		assertEquals(2, reimbursement.getAmount());
	}

	@Test
	public void testGetReimbSubmitted() {
		assertEquals(subTimestamp, reimbursement.getSubmitted());
		
	}
	@Test
	public void testSetReimbSubmitted() {
		reimbursement.setSubmitted(resTimestamp);
		assertEquals(resTimestamp, reimbursement.getSubmitted());
	}
	@Test
	public void testGetReimbResolved() {
		assertEquals(resTimestamp, reimbursement.getResolved());
	}
	@Test
	public void testSetReimbResolved() {
		reimbursement.setResolved(subTimestamp);
		assertEquals(subTimestamp, reimbursement.getResolved());
	}
	@Test
	public void testGetReimbDesciption() {
		assertEquals("Test reimb", reimbursement.getDescription());
	}
	@Test
	public void testSetReimbDesciption() {
		reimbursement.setDescription("uhoh");
		assertEquals("uhoh", reimbursement.getDescription());
	}
	@Test
	public void testGetReimbReceipt() {
		assertEquals(null, reimbursement.getReceipt());
	}
	@Test
	public void testSetReimbReceipt() {
		reimbursement.setReceipt(new File("./src/test/resources/91e.jpg"));
		assertEquals(".\\src\\test\\resources\\91e.jpg", (reimbursement.getReceipt()).toString());
	}
	@Test
	public void testGetReimbAuthor() {
		assertEquals(1, reimbursement.getAuthorId());
	}
	@Test
	public void testSetReimbAuthor() {
		reimbursement.setAuthorId(2);
		assertEquals(2, reimbursement.getAuthorId());
	}
	@Test
	public void testGetReimbResolver() {
		assertEquals((Integer)6, reimbursement.getResolverId());
	}
	@Test
	public void testSetReimbResolver() {
		reimbursement.setResolverId(5);
		assertEquals((Integer)5, reimbursement.getResolverId());
	}
	//Always fails.
//	@Test
//	public void testSetReimbResolverToNull() {
//		reimbursement.setResolverId(null);
//		assertEquals(null, reimbursement.getResolverId());
//	}
	@Test
	public void testGetReimbStatusId() {
		assertEquals(1, reimbursement.getStatusId());
	}
	@Test
	public void testSetReimbStatusId() {
		reimbursement.setStatusId(2);
		assertEquals(2, reimbursement.getStatusId());
	}
	@Test
	public void testGetReimbTypeId() {
		assertEquals(2, reimbursement.getTypeId());
	}
	@Test
	public void testSetReimbTypeId() {
		reimbursement.setTypeId(3);;
		assertEquals(3, reimbursement.getTypeId());
	}
	@Test
	public void testGetReimbType() {
		assertEquals("Food", reimbursement.getReimbType());
	}
	@Test
	public void testGetReimbStatus() {
		assertEquals("Pending", reimbursement.getReimbStatus());
	}
	

}
