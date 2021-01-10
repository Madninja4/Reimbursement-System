package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ajaxcontroller.ERSUserController;
import ajaxcontroller.ReimbursementController;

/**
 * This is the helper for the AjaxMasterServlet that updates, and grabs users and reimbursements
 * @author corbi
 *
 */
public class AjaxRequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		switch (request.getRequestURI()) {
		case "/ReimbursementSystem/api/ajax/allUsers":
			System.out.println("Inside switch in AjaxRequestHelper: AllUsers");
			ERSUserController.allFinder(request, response);
			break;
		case "/ReimbursementSystem/api/ajax/currentUser":
			System.out.println("Inside switch in AjaxRequestHelper: currentUser");
			ERSUserController.getUser(request, response);
			break;
		case "/ReimbursementSystem/api/ajax/currentUserGetReimbs":
			System.out.println("Inside switch in AjaxRequestHelper: currentUserGetReimbs");
			ERSUserController.getUserReimbs(request, response);
			break;
		case "/ReimbursementSystem/api/ajax/submitReimb/send":
			System.out.println("Inside switch in AjaxRequestHelper: submitReimb");
			ReimbursementController.submitReimb(request, response);
			break;
		case "/ReimbursementSystem/api/ajax/updateReimb/send":
			System.out.println("Inside switch in AjaxRequestHelper: updateReimb");
			ReimbursementController.updateReimb(request, response);
			break;
		case "/ReimbursementSystem/api/ajax/allFinder":
			System.out.println("Inside switch in AjaxRequestHelper: allFinder");
			ReimbursementController.allFinder(request, response);
			break;
		default:

			response.getWriter().println("null");
		}
	}
}
