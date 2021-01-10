package dao;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.ERSUser;
import model.Reimbursement;

public class TestReimbursementDaoImpl {

private static UserDao userDao;
private static ReimbursementDao reimbDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MyConnectionFactory.url = "jdbc:h2:./h2Data/theData";
		MyConnectionFactory.username = MyConnectionFactory.h2username;
		MyConnectionFactory.password = MyConnectionFactory.h2password;
		userDao = new UserDaoImpl();
		reimbDao = new ReimbursementDaoImpl();
	}
	@Before
	public void setUp() throws Exception {
		reimbDao.h2InitDao();
	}
	
	@After
	public void tearDown() throws Exception {
		reimbDao.h2DestroyDao();
	}
	@Test
	public void testGetReimbursementById() {
		Reimbursement reimb = reimbDao.selectReimbursementById(1);
		assertEquals(3, reimb.getStatusId());
		assertEquals(1, reimb.getReimbId());
		
	}
	@Test
	public void testInsertReimbursement() {
		Reimbursement reimb = new Reimbursement(3, 300, new Timestamp(System.currentTimeMillis()), null, "Testing an insert", null, 1, null, 1, 2);
		assertEquals(3, reimb.getReimbId());
		reimbDao.insertReimbursement(reimb, reimb.getAuthorId());
		Reimbursement returnedReimb = reimbDao.selectReimbursementById(3);
		assertEquals(3, returnedReimb.getReimbId());
		assertNull(returnedReimb.getResolverId());
		
	}
	@Test
	public void testSelectAllReimbursements() {
		assertEquals(2, (reimbDao.selectAllReimbursements()).size());
		
	}
	
	@Test
	public void testSelectReimbursementsByAuthor() {
		assertEquals(2, (reimbDao.selectReimbursementsByAuthorId(1)).size());
		
	}
	
	@Test
	public void testSelectReimbursementsByResolver() {
		assertEquals(0, (reimbDao.selectReimbursementsByResolverId(1)).size());
		
	}
	@Test
	public void testSelectReimbursementsByType() {
		assertEquals(1, (reimbDao.selectReimbursementsByTypeId(2)).size());
		
	}
	@Test
	public void testSelectReimbursementsByStatus() {
		assertEquals(1, (reimbDao.selectReimbursementsByStatusId(1)).size());
		
	}
	@Test
	public void testSelectUnresolvedReimbursements() {
		List<Reimbursement>reimbs=reimbDao.selectAllUnresolvedReimbursements();
		assertEquals(1, (reimbs).size());
		Reimbursement reimb =reimbs.get(0);
		assertEquals(null, reimb.getResolverId());
		
	}
	@Test
	public void testUpdateReimbursement() {
		Reimbursement reimb = new Reimbursement(3, 300, new Timestamp(System.currentTimeMillis()), null, "Testing an insert", null, 1, null, 1, 2);
		assertEquals(3, reimb.getReimbId());
		reimbDao.insertReimbursement(reimb, reimb.getAuthorId());
		Reimbursement returnedReimb = reimbDao.selectReimbursementById(3);
		assertEquals(3, returnedReimb.getReimbId());
		assertNull(returnedReimb.getResolverId());
		reimb = new Reimbursement(3, 300, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "Testing an update", null, 1, 6, 1, 2);
		reimbDao.updateReimbursement(reimb);
		returnedReimb = reimbDao.selectReimbursementById(3);
		assertEquals(3, returnedReimb.getReimbId());
		assertEquals((Integer)6, returnedReimb.getResolverId());
	}
	@Test
	public void testDeleteReimbursement() {
		reimbDao.deleteReimbursement(2);
		assertNull(reimbDao.selectReimbursementById(2));
	}
	

}
