
package servlet;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import Controller.HomeController;
import Controller.LoginController;
import ajaxcontroller.ERSUserController;
import logging.TestLogs;

/**
 * This is the functionality and page switching helper to the ForwardingMasterServlet
 * @author corbi
 *
 */
public class ForwardRequestHelper {
	
	final static Logger loggy = Logger.getLogger(ForwardRequestHelper.class);
	
	public static String process(HttpServletRequest req, HttpServletResponse res) {


		switch (req.getRequestURI()) {
		case "/ReimbursementSystem/api/forward/goTest":
			TestLogs.logger.info("Performed a Test");
			return HomeController.getTest(req, res);
		case "/ReimbursementSystem/api/forward/login":
			return LoginController.login(req, res);
		case "/ReimbursementSystem/api/forward/userhome":
			return HomeController.userHome(req, res);
		case "/ReimbursementSystem/api/forward/financemanagerhome":
			return HomeController.financeManagerHome(req, res);
		case "/ReimbursementSystem/api/forward/logout":
			System.out.println("in forward request helper in logout");
			TestLogs.logger.info("User Logged out");
			return LoginController.logout(req, res);

		default:
			System.out.println("bad checkpoint");
			return "/resources/html/badlogin.html";
		}
	}
}
