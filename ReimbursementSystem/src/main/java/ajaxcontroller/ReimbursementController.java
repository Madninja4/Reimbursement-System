package ajaxcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Controller.LoginController;
import logging.TestLogs;
import model.ERSUser;
import model.Reimbursement;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;

/**
 * This class interacts with the front end to grab important info for the
 * service layer.
 * 
 * @author corbi
 *
 */
public class ReimbursementController {
	
	
	
	public static ReimbursementService reimbServ = new ReimbursementServiceImpl();
	
	//Finds all reimbursements
	public static void allFinder(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException, IOException {
	

		List<Reimbursement> myReimbList = reimbServ.getFullReimbursements();
		TestLogs.logger.info("Getting all reimbursements");
		response.getWriter().write(new ObjectMapper().writeValueAsString(myReimbList));

	}
	//Adding a new reimbursement to the DB
	public static void submitReimb(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException, IOException {
		
		response.setContentType("application/json");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String description = request.getParameter("description");
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		ERSUser user = (ERSUser) request.getSession().getAttribute("user");
		int userId = user.getUserId();
		
		
		TestLogs.logger.info("Added new reimbursement from:" + user.getUsername());
		
		reimbServ.insertReimbursement(description, typeId, amount, userId);
		
		

	}
	//Updates the status, resolver, and resolved of a reimbursement
	public static void updateReimb(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		int reimbId = Integer.parseInt(request.getParameter("reimbId"));
		int statusId = Integer.parseInt(request.getParameter("statusId"));
		ERSUser user = (ERSUser) request.getSession().getAttribute("user");
		
		int userId = user.getUserId();
		TestLogs.logger.info("Updated info of id "+ reimbId  +" of reimbursement from: " + user.getUsername());
		reimbServ.updateReimbursement(reimbId, userId, statusId, user);
	}

}
