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

@WebServlet(urlPatterns = "/NewsSignupServ", loadOnStartup = 1)
public class NewsSignupServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ServletContext context = this.getServletContext();
		
		if (context.getAttribute("mailingList") == null ) {
			context.setAttribute("mailingList", new ArrayList<Homework2User>() );
		}
				
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext context = this.getServletContext();
		
		ArrayList<Homework2User> mailingList = (ArrayList<Homework2User>) context.getAttribute("mailingList");
				
		Homework2User user = new Homework2User("danny", "padilla", "dsdsdf@fff.com");
		try {
			Integer id = (Integer) request.getAttribute("id");
			
			for (int i = 0; i < mailingList.size(); i++) {
				if (mailingList.get(i).getId() == id) {
					user = mailingList.get(i);
					break;
				}		
			}
		} catch (Exception e) {}
		
		String firstName = request.getParameter("name");
//		String lastName = user.getLastName();
		String email = request.getParameter("email");
		
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("	<head>");
		out.println("		<meta charset=\"utf-8\">");
		out.println("		<title>CS320 Newsletter</title>");
		out.println("		<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">");
		out.println("    <link rel=\"stylesheet\" href=\"http://albertcervantes.com/cs320/cdn/homework2/styles/animate.css\">");
		out.println("		<link rel=\"stylesheet\" href=\"http://albertcervantes.com/cs320/cdn/homework2/styles/main.css\" />");
		out.println("	</head>");
		out.println("");
		out.println("	<body>");
		out.println("		<div class=\"container\">");
		out.println("			<div class=\"row\">");
		out.println("				<div class=\"col-sm-offset-3 col-sm-6 newsletter-form animated bounceInDown\">");
		out.println("");
		out.println("          <div class=\"well text-center\">");
		out.println("						<h1>CS320 Newsletter</h1>");
		out.println("						<hr />");
		// If Registered
		if (request.getAttribute("ready2Register") != null) { 
		out.println("            <p class=\"lead\">You're all set, <strong>" + firstName + "</strong>!<br />We'll e-mail you at <strong>" + email + "</strong> with regular updates.</p>");
		out.println("						<h1><span class=\"glyphicon glyphicon-ok text-success\"></span></h1>");
		out.println("						<a href=\"NewsletterAdmin\">View All E-mails</a>");
		out.println("				</div>");
		out.println("			</div>");
		out.println("		</div>");
		out.println("	</body>");
		out.println("</html>");
		} else {
			// else
		out.println("						<p class=\"lead\">Subscribe to our weekly Newsletter, and stay up-to-date with all things related to the course!</p>");
		out.println("");
		out.println("            <form action=\"NewsSignupServ\" method=\"post\">");
		out.println("");
		if (request.getAttribute("nameError") != null) {
		out.println("              <div class=\"form-group has-error\">");
		} else {
		out.println("              <div class=\"form-group\">");
		}
		out.println("								<div class=\"input-group\">");
		out.println("									<div class=\"input-group-addon\">");
		out.println("										<span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span>");
		out.println("									</div>");
		out.println("									<input class=\"form-control\" type=\"text\" name=\"name\" placeholder=\"Enter your first and last name\" />");
		out.println("								</div>");
		if (request.getAttribute("nameError") != null) {
		out.println("                <p class=\"text-danger\">Please enter your first and last names.</p>");
		}
		out.println("							</div>");
		out.println("");
		if (request.getAttribute("emailError") != null) {
		out.println("              <div class=\"form-group has-error\">");
		} else {
		out.println("              <div class=\"form-group\">");
		}
		out.println("								<div class=\"input-group\">");
		out.println("									<div class=\"input-group-addon\">");
		out.println("										<span class=\"glyphicon glyphicon-envelope\" aria-hidden=\"true\"></span>");
		out.println("									</div>");
		out.println("									<input class=\"form-control\" type=\"text\" name=\"email\" placeholder=\"Enter your e-mail address\" />");
		out.println("								</div>");
		if (request.getAttribute("emailError") != null) {
		out.println("                <p class=\"text-danger\">Please enter a valid e-mail address.</p>");
		}
		out.println("							</div>");
		out.println("");
		out.println("							<input type=\"hidden\" name=\"hidden\" value=\"" + user.getId() + "\" />");
		out.println("							<input type=\"submit\" class=\"btn btn-info btn-block btn-lg\" value=\"Subscribe Now!\" />");
		out.println("						</form>");
		out.println("					</div>");
		out.println("				</div>");
		out.println("			</div>"); 
		// was }
		out.println("");
		out.println("		</div>");
		out.println("	</body>");
		out.println("</html>");
		}
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean hasError = false;
		String[] fullName = request.getParameter("name").split(" ");
		String email = request.getParameter("email");
		
		Homework2User user = new Homework2User();
		
		String firstName = "";
		String lastName = "";
		
		// Checks for Valid Name input
		if (fullName == null || fullName.equals("") || fullName.length == 0) {
			request.setAttribute("nameError", "Name Error");
			hasError = true;
		} else {
			for (int i = 0; i < fullName.length; i++) {
				if (fullName[i].equals("") || fullName[i].length() < 2) {
					request.setAttribute("nameError", "Name Error");
					hasError = true;
					break;
				} else {
					if ( i == 0) {
						firstName = fullName[i];
						user.setFirstName(firstName);
					} else {
						if (i == fullName.length - 1) {
							lastName += fullName[i];
						} else {
							lastName += fullName[i] + " ";
						}
					}
					user.setLastName(lastName);
				}
			}
		}
		
		// Checks for Valid email input
		if ( (email == null) || (email.trim().length() < 7) || (email.indexOf("@") < 0) || (email.indexOf(".") < 0) ) {
			request.setAttribute("emailError", "Invalid Email");
			hasError = true;
		} else {
			user.setEmail(email);
		}
		
		if (hasError) {
			request.setAttribute("hasError", "Has Errors");
			doGet(request, response);
			
		} else { 

			request.setAttribute("ready2Register", "Ready to Register!");
			ServletContext context = this.getServletContext();
					
			ArrayList<Homework2User> mailingList = (ArrayList<Homework2User>) context.getAttribute("mailingList");
			mailingList.add(user);
			
			response.sendRedirect("NewsSignupServ");
		}
	}

}
