package ie.dit.daly.marcus;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;
@SuppressWarnings("serial")
public class LoginInAndUploadServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		PrintWriter writer = resp.getWriter();
		
		com.google.appengine.api.users.UserService userService = UserServiceFactory.getUserService();
		Principal myPrincipal = req.getUserPrincipal();
		String emailAddress = null;
		String thisURL = req.getRequestURI();
		String loginURL = userService.createLoginURL(thisURL);
		String logoutURL = userService.createLogoutURL(thisURL);
		String downloads = "";
		String uploads = "";
		resp.setContentType("text/html");
		
		if(myPrincipal == null) 
		{
			writer.println("<p>You are not logged in time</p>");
			writer.println("<p>You can <a href=\""+loginURL+ "\">sign in here</a>.</p>");
			writer.println("<p>You can check the downloads screen</p>");
		} // end if not logged in
		
		if(myPrincipal !=null) 
		{
			emailAddress = myPrincipal.getName();
			writer.println("<p>You are logged in as (email): "+emailAddress+"</p>");
			writer.println("<p>You can <a href=\"" + logoutURL + "\">sign out</a>.</p>");
			if(emailAddress .equals( "daly.marcus@gmail.com") || emailAddress .equals("mark.deegan@dit.ie"))
			{
				writer.println("<p>Click here for the uploads screen</p>");
			}
			writer.println("<p>You can check the downloads screen</p>");
			
			}
		} // end if logged in
	}


