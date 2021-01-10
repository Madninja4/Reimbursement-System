package dao;

import java.util.List;

import model.Reimbursement;
import model.ERSUser;

public interface ReimbursementDao {
	public void insertReimbursement(Reimbursement reimbursement, int reimbAuthor);

	public List<Reimbursement> selectAllReimbursements();

	public Reimbursement selectReimbursementById(int reimbId);

	public List<Reimbursement> selectReimbursementsByAuthorId(int authorId);

	public List<Reimbursement> selectReimbursementsByResolverId(int resolverId);

	public List<Reimbursement> selectReimbursementsByTypeId(int typeId);

	public List<Reimbursement> selectReimbursementsByStatusId(int statusId);

	public List<Reimbursement> selectAllUnresolvedReimbursements();

	public List<Reimbursement> selectFullInfoReimbursements();

	public List<Reimbursement> selectFullInfoReimbursementsByAuthorId(int authorId);

	public void updateReimbursement(Reimbursement reimbursement);

	public void updateReimbursement(int reimbId, int userId, int statusId);

	public void deleteReimbursement(int id);

	// H2 DATABASE FUNCTIONALITY
	public void h2InitDao();

	public void h2DestroyDao();

}