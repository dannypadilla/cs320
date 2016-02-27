package cs320stu47.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CountdownServlet")
public class CountdownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CountdownServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// initialize my count down counter to 10
		getServletContext().setAttribute("countdown", 10);	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int countdown = (int) getServletContext().getAttribute("countdown");
		
		if (countdown > 0) {
			out.println("");
			out.println("<h1>");
			out.println("<small> T-Minus </small>");
			out.println(countdown);
			out.println("<small> seconds until launch</small>");
			out.println("</h1>");
			getServletContext().setAttribute("countdown", countdown - 1);
//			response.setHeader("Refresh", "1");
			response.setIntHeader("Refresh", 1);
			
		} else {
			out.println("<h1> Blast Off!<h1/>");
			getServletContext().getAttribute("countdown");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
