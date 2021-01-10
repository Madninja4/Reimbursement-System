package service;

import java.sql.Timestamp;
import java.util.ArrayList;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import model.ERSUser;
import model.Reimbursement;

/**
 * This is the service implementation for sending front end data to the back end
 * dao layer. This one interacts with reimbursements
 * 
 * @author corbi
 *
 */
public class ReimbursementServiceImpl implements ReimbursementService {
	private ReimbursementDao reimbDao = new ReimbursementDaoImpl();

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		return (ArrayList<Reimbursement>) reimbDao.selectAllReimbursements();
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementsFromAuthor(int authorUserId) {
		// TODO Auto-generated method stub
		return (ArrayList<Reimbursement>) reimbDao.selectReimbursementsByAuthorId(authorUserId);
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementsFromResolver(int resolverUserId) {
		// TODO Auto-generated method stub
		return (ArrayList<Reimbursement>) reimbDao.selectReimbursementsByResolverId(resolverUserId);
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementsByType(int typeId) {
		// TODO Auto-generated method stub
		return (ArrayList<Reimbursement>) reimbDao.selectReimbursementsByTypeId(typeId);
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementsByStatus(int statusId) {
		// TODO Auto-generated method stub
		return (ArrayList<Reimbursement>) reimbDao.selectReimbursementsByStatusId(statusId);
	}

	@Override
	public ArrayList<Reimbursement> getUnresolverReimbursements() {
		// TODO Auto-generated method stub
		return (ArrayList<Reimbursement>) reimbDao.selectAllUnresolvedReimbursements();
	}

	@Override
	public Reimbursement getReimbursementById(int reimbId) {
		// TODO Auto-generated method stub
		return reimbDao.selectReimbursementById(reimbId);
	}

	@Override
	public void updateReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		reimbDao.updateReimbursement(reimbursement);
	}

	@Override
	public void deleteReimbursement(int id) {
		// TODO Auto-generated method stub
		reimbDao.deleteReimbursement(id);
	}

	@Override
	public void insertReimbursement(String description, int typeId, int amount, int submitterId) {
		// TODO Auto-generated method stub
		Reimbursement reimb = new Reimbursement(100, amount, new Timestamp(System.currentTimeMillis()), null,
				description, null, submitterId, null, 1, typeId);
		reimbDao.insertReimbursement(reimb, submitterId);
	}

	@Override
	public ArrayList<Reimbursement> getUserFullReimbursements(int authorId) {
		// TODO Auto-generated method stub
		return (ArrayList<Reimbursement>) reimbDao.selectFullInfoReimbursementsByAuthorId(authorId);
	}

	@Override
	public ArrayList<Reimbursement> getFullReimbursements() {
		// TODO Auto-generated method stub
		return (ArrayList<Reimbursement>) reimbDao.selectFullInfoReimbursements();
	}

	@Override
	public void updateReimbursement(int reimbId, int userId, int statusId, ERSUser user) {
		// TODO Auto-generated method stub
		reimbDao.updateReimbursement(reimbId, userId, statusId);

	}

}
