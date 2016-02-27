package cs320stu47.Homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework2/NewsletterAdmin")
public class NewsletterAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewsletterAdminServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		ArrayList<Homework2User> mailingList = (ArrayList<Homework2User>) context.getAttribute("mailingList");
		
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("	<head>");
		out.println("		<meta charset=\"utf-8\">");
		out.println("		<title>CS320 Newsletter</title>");
		out.println("		<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">");
		out.println("		<link rel=\"stylesheet\" href=\"http://albertcervantes.com/cs320/cdn/homework2/styles/animate.css\">");
		out.println("		<link rel=\"stylesheet\" href=\"http://albertcervantes.com/cs320/cdn/homework2/styles/main2.css\" />");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<div class=\"container\">");
		out.println("			<div class=\"row\">");
		out.println("				<div class=\"col-sm-offset-2 col-sm-8 newsletter-form animated fadeInUp\">");
		out.println("					<div class=\"well\">");
		out.println("						<h1>E-mail List <small>CS320 Newsletter</small></h1>");
		out.println("						<hr />");
		
		out.println("						<table class=\"table table-bordered table-striped table-hover\">");
		out.println("							<tr>");
		out.println("								<th>First</th>");
		out.println("								<th>Last</th>");
		out.println("								<th>E-mail</th>");
		out.println("								<th>Date</th>");
		out.println("							</tr>");
		for (int i = 0; i < mailingList.size(); i++) {
			out.println("							<tr>");
			out.println("								<td>" + mailingList.get(i).getFirstName() + "</td>");
			out.println("								<td>" + mailingList.get(i).getLastName() + "</td>");
			out.println("								<td>" + mailingList.get(i).getEmail() + "</td>");
			out.println("								<td>" + mailingList.get(i).getDate() + "</td>");			
			out.println("							</tr>");
		}
		out.println("						</table>");
		
		out.println("						<p class=\"text-center\">");
		out.println("							<a href=\"NewsletterSignup\">Back to Sign-Up</a>");
		out.println("						</p>");
		out.println("					</div>");
		out.println("				</div>");
		out.println("			</div>");
		out.println("		</div>");
		out.println("	</body>");
		out.println("</html>");

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
