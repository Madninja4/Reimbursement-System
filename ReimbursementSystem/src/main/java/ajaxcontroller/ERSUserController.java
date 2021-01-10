package ajaxcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import logging.TestLogs;
import model.ERSUser;
import model.Reimbursement;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;
import service.UserService;
import service.UserServiceImpl;

/**
 * This class interacts with the front end to grab important info for the service layer.
 * @author corbi
 *
 */
public class ERSUserController {
	
	public static UserService userServ = new UserServiceImpl();
	public static ReimbursementService reimbServ = new ReimbursementServiceImpl();

	//gets all of the users
	public static void allFinder(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException, IOException {

		//System.out.println("I am in ERSUserController");
		List<ERSUser> myUserList = userServ.getAllUsers();


		response.getWriter().write(new ObjectMapper().writeValueAsString(myUserList));

	}
	//sends us to the test page
	public static String getTest(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return "/resources/html/test.html";
	}
	//gets the currently logged in user
	public static void getUser(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		ERSUser user = (ERSUser) req.getSession().getAttribute("user");
		//System.out.println("Inside of getUser");
		//System.out.println(user.toString());
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(user));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void getUserReimbs(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		ERSUser user = (ERSUser) req.getSession().getAttribute("user");
		//System.out.println("Inside of getUser");
		//System.out.println(user.toString());
		ArrayList<Reimbursement> reimbursements = reimbServ.getUserFullReimbursements(user.getUserId());
		//System.out.println("Inside of reimbursements");
		//System.out.println(reimbursements);
		try {
			TestLogs.logger.info("Grabbed all reimbursements from a user");
			res.getWriter().write(new ObjectMapper().writeValueAsString(reimbursements));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
