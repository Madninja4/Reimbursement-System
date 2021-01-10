package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Messes with the links of what home to send the client.
 * @author corbi
 *
 */
public class HomeController {
	public static String getTest(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		res.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		return "/resources/html/test.html";
	}
	public static String userHome(HttpServletRequest request,HttpServletResponse res) {
		res.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		return "/resources/html/userhome.html";
	}
	public static String financeManagerHome(HttpServletRequest request,HttpServletResponse res) {
		res.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		return "/resources/html/financemanagerhome.html";
	}

}
