package model;

import java.io.File;
import java.sql.Timestamp;

/**
 * This is the model layer reimbursement.
 * 
 * @author corbi
 *
 */
public class Reimbursement {
	private int reimbId;
	private int amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private File receipt;
	private int authorId;
	private Integer resolverId;
	private int statusId;
	private int typeId;
	private String authorUsername;
	private String resolverUsername;
	private String status;
	private String type;

	public Reimbursement(int reimbId, int amount, Timestamp submitted, Timestamp resolved, String description,
			File receipt, int authorId, Integer resolverId, int statusId, int typeId) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public Reimbursement(int reimbId, int amount, Timestamp submitted, Timestamp resolved, String description,
			File receipt, int authorId, Integer resolverId, int statusId, int typeId, String authorUsername,
			String resolverUsername) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
		this.authorUsername = authorUsername;
		this.resolverUsername = resolverUsername;
	}

	public Reimbursement(int reimbId, int amount, Timestamp submitted, Timestamp resolved, String description,
			File receipt, int authorId, Integer resolverId, int statusId, int typeId, String authorUsername,
			String resolverUsername, String status, String type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
		this.authorUsername = authorUsername;
		this.resolverUsername = resolverUsername;
		this.status = status;
		this.type = type;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public File getReceipt() {
		return receipt;
	}

	public void setReceipt(File receipt) {
		this.receipt = receipt;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public Integer getResolverId() {
		if (this.resolverId == 0) {
			return null;
		}
		return resolverId;
	}

	public void setResolverId(Integer resolverId) {
		this.resolverId = resolverId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getAuthorUsername() {
		return authorUsername;
	}

	public void setAuthorUsername(String authorUsername) {
		this.authorUsername = authorUsername;
	}

	public String getResolverUsername() {
		return resolverUsername;
	}

	public void setResolverUsername(String resolverUsername) {
		this.resolverUsername = resolverUsername;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReimbStatus() {
		switch (this.statusId) {
		case 1:
			return "Pending";
		case 2:
			return "Approved";
		case 3:
			return "Denied";
		default:
			System.out.println("Issue in getReimbStatus() - Wrong argument");
			return null;
		}
	}

	public String getReimbType() {
		switch (this.typeId) {
		case 1:
			return "Lodging";
		case 2:
			return "Food";
		case 3:
			return "Travel";
		case 4:
			return "Other";
		default:
			System.out.println("Issue in getReimbType() - Wrong argument");
			return null;
		}
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", receipt=" + receipt + ", authorId=" + authorId
				+ ", resolverId=" + resolverId + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}

}
