package cs320stu47.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guestbook/GuestBookServlet")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//Create the list of guestbook entries
		List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		
		entries.add(new GuestBookEntry("Joe", "Hello, World!"));
		entries.add(new GuestBookEntry("Jim", "Game Over"));
		entries.add(new GuestBookEntry("Mary", "Hi!"));
		
		// Add the list of entries to the global scope
		this.getServletContext().setAttribute("entries", entries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		List<GuestBookEntry> entries = (List<GuestBookEntry>) context.getAttribute("entries");
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Guest Book</title>");
        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">");
        out.println("</head><body>" );
        out.println("<div class=\"container\">");

        out.println( "<table class=\"table table-striped table-bordered table-hover\">" );
        out.println( "<tr><th>Id</th><th>Name</th><th>Message</th><th>Created</th><th>&nbsp;</th></tr>" );
        
        for (GuestBookEntry entry : entries){
        	
	        out.println("<tr>");
	        out.println("   <td>" + entry.getId() + "</td>");
	        out.println("   <td>" + entry.getName() + "</td>");
	        out.println("   <td>" + entry.getMessage() + "</td>");
	        out.println("   <td>" + entry.getCreated() + "</td>");
	        out.println("   <td>");
	        out.println("      <a href=\"Edit?id=" + entry.getId() + "\">Edit</a> | ");
	        out.println("      <a href=\"Delete?id=" + entry.getId() + "\">Delete</a>");
	        out.println("   </td>");
	        out.println("</tr>");
        }

        out.println("</table>");
        
        out.println("<a class=\"btn btn-success\" href=\"AddPost\">Add New Post</a>");
        out.println("</div>"); // This div closes the .container        
        out.println("</body></html>");
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}