package Controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import logging.TestLogs;
import model.ERSUser;
import service.UserService;
import service.UserServiceImpl;
import servlet.ForwardRequestHelper;
import logging.TestLogs;

/**
 * Contains login logic for the user whenever they attempt to login
 * 
 * @author corbi
 *
 */

public class LoginController {
	
	
	public static String login(HttpServletRequest request, HttpServletResponse res) {
		UserService userServ = new UserServiceImpl();

		if (!request.getMethod().equals("POST")) {
			res.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
			return "/welcomepage.html";
		}

		// extracting the form data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ERSUser user = userServ.getUserByUsername(username);
		if (user == null) {
			res.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
			return "api/forward/incorrectcredentials";
		}
		// check to see if the user has the correct username and password

		if (!(user.getPassword().equals(password))) {
			TestLogs.logger.info("Failed Login");
			res.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
			return "api/forward/incorrectcredentials";
		} else {

			request.getSession().setAttribute("loggedusername", username);
			request.getSession().setAttribute("loggedpassword", password);
			request.getSession().setAttribute("userroleid", user.getUserRoleId());
			request.getSession().setAttribute("user", user);
			TestLogs.logger.info(username+" has logged in");
			Enumeration<String> keys = request.getSession().getAttributeNames();

			/// Prints out all session keys
//			while (keys.hasMoreElements())
//			{
//			  String key = (String)keys.nextElement();
//			  System.out.println(key + ": " + request.getSession().getAttribute(key));
//			}
			if (user.getUserRoleId() == 2) {
				try {
					res.getWriter().write(new ObjectMapper().writeValueAsString(user));
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				res.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
				return "financemanagerhome";
			} else if (user.getUserRoleId() == 1) {
				res.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
				return "userhome";
			} else {
				res.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
				return "badlogin";
			}

		}
	}

	public static String logout(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		ERSUser user = (ERSUser) req.getSession().getAttribute("user");
		String username = user.getUsername();
		System.out.println(username);
		TestLogs.logger.info(username+" has logged out");
		req.getSession().invalidate();
		return "/resources/html/welcomepage.html";
	}

}
