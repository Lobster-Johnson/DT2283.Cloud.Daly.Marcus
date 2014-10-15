package ie.dit.daly.marcus;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;
@SuppressWarnings("serial")
public class Labservlet5_1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		PrintWriter writer = null;
		
		com.google.appengine.api.users.UserService userService = UserServiceFactory.getUserService();
		Principal myPrincipal = req.getUserPrincipal();
		String emailAddress = null;
		String thisURL = req.getRequestURI();
		String loginURL = userService.createLoginURL(thisURL);
		String logoutURL = userService.createLogoutURL(thisURL);
		resp.setContentType("text/html");
		
		if(myPrincipal == null) 
		{
			writer.println("<p>You are Not Logged In time</p>");
			writer.println("<p>You can <a href=\""+loginURL+ "\">sign in here</a>.</p>");
		} // end if not logged in
		
		if(myPrincipal !=null) 
		{
			emailAddress = myPrincipal.getName();
			writer.println("<p>You are Logged in as (email): "+emailAddress+"</p>");
			writer.println("<p>You can <a href=\"" + logoutURL + "\">sign out</a>.</p>");
		} // end if logged in
	}
}
