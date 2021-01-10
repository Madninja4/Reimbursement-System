package service;

import java.util.ArrayList;

import model.ERSUser;
import model.Reimbursement;

public interface ReimbursementService {

	// READ
	public void insertReimbursement(String description, int typeId, int amount, int submitterId);

	public ArrayList<Reimbursement> getAllReimbursements();

	public ArrayList<Reimbursement> getReimbursementsFromAuthor(int authorUserId);

	public ArrayList<Reimbursement> getReimbursementsFromResolver(int resolverUserId);

	public ArrayList<Reimbursement> getReimbursementsByType(int typeId);

	public ArrayList<Reimbursement> getReimbursementsByStatus(int statusId);

	public ArrayList<Reimbursement> getUnresolverReimbursements();

	public ArrayList<Reimbursement> getUserFullReimbursements(int authorId);

	public ArrayList<Reimbursement> getFullReimbursements();

	public Reimbursement getReimbursementById(int reimbId);

	public void updateReimbursement(Reimbursement reimbursement);

	public void deleteReimbursement(int id);

	public void updateReimbursement(int reimbId, int userId, int statusId, ERSUser user);

}
