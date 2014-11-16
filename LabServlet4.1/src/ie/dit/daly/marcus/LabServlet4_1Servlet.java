package ie.dit.daly.marcus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class LabServlet4_1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		displayTextFile(resp);
	}
	
	
	public int displayTextFile(HttpServletResponse write) throws IOException 
	{
		BufferedReader input = null;
		input = new BufferedReader(new FileReader("Sample.txt"));
		String line = null;
		while (( line = input.readLine()) != null) 
		write.getWriter().println("\t"+line);
		input.close();
		return 0; 
	}
}
