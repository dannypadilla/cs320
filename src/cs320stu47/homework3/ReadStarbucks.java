package cs320stu47.homework3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadStarbucks")
public class ReadStarbucks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadStarbucks() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
				
		String path = context.getRealPath("/WEB-INF/starbucks.csv").toString();
		FileInputStream file = new FileInputStream(path);
		
		System.out.println(path);
		
		Scanner input = new Scanner(file);
				
		String[] locations = new String[10];
		
		for (int i = 0; i < 4; i++) {
			if (input.useDelimiter(",").hasNextLine() ) {
				locations[i] = input.useDelimiter(",").next();
			}
		}
		input.close();
		
//		FileInputStream in = new FileInputStream( "/Volumes/MINIDANNYP/Work/EclipseWorkspace/cs320/WebContent/WEB-INF/data/starbucks.csv" );
//        OutputStream outStream = response.getOutputStream();
//
//        byte buffer[] = new byte[2048];
//        int bytesRead;
//        while( (bytesRead = in.read( buffer )) > 0 ) {
//        	outStream.write( buffer, 0, bytesRead );        	
//        }
//
//        in.close();
        
        out.println("<!doctype html>");
		out.println("<html>");
		out.println("	<head>");
		out.println("		<meta charset=\"utf-8\">");
		out.println("		<title>Starbucks Locations</title>");
		out.println("		<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">");
		out.println("		<link rel=\"stylesheet\" href=\"http://albertcervantes.com/cs320/cdn/homework2/styles/animate.css\">");
		out.println("		<link rel=\"stylesheet\" href=\"http://albertcervantes.com/cs320/cdn/homework2/styles/main2.css\" />");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<div class=\"container\">");
		out.println("			<div class=\"row\">");
		out.println("				<div class=\"col-sm-offset-2 col-sm-8 newsletter-form animated fadeInUp\">");
		out.println("					<div class=\"well\">");
		out.println("						<h1>Starbucks Locations <small>in the U.S.A.</small></h1>");
		out.println("						<hr />");
        
		out.println("						<table class=\"table table-bordered table-striped table-hover\">");
		out.println("							<tr>");
		out.println("								<th>Lattitude</th>");
		out.println("								<th>Longiture</th>");
		out.println("								<th>City</th>");
		out.println("								<th>Address</th>");
		out.println("							</tr>");
		for (int i = 0; i < locations.length; i++) {
			out.println("							<tr>");
			out.println("								<td>" + locations[0] + "</td>");
			out.println("								<td>" + locations[1] + "</td>");
			out.println("								<td>" + locations[2] + "</td>");
			out.println("								<td>" + locations[3] + "</td>");
			out.println("								<td>" + locations[4] + "</td>");
			out.println("							</tr>");
		}
		out.println("						</table>");
		
		out.println("						<p class=\"text-center\">");
		out.println("							<a>Cool</a>");
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
