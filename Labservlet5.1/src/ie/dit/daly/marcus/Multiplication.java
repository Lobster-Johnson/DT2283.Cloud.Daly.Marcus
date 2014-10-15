package ie.dit.daly.marcus;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Multiplication extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Multiplication happens here");
		
		String AString ;
		String BString ;
		float result;
		AString = req.getParameter("A");
		BString = req.getParameter("B");
		
		float b = Float.parseFloat(BString);
		if(AString == null){
			AString = "1";
		}
		if(BString == null){
			BString = "1";
		}
		
		resp.getWriter().println(""+b);
		result = Float.parseFloat((AString.trim())) * Float.parseFloat((BString.trim()));
		resp.getWriter().println(""+ AString + " X " + BString + " = "  +result);
	}
}