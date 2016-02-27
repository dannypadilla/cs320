package cs320stu47.testing.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

        out.println("<html><head><title>" + "Starbucks Locations" + "</title></head><body>");
        
        FileInputStream in = new FileInputStream( "/Volumes/MINIDANNYP/Work/EclipseWorkspace/cs320/WebContent/WEB-INF/data/starbucks.csv" );
        OutputStream outStream = response.getOutputStream();
        byte buffer[] = new byte[2048];
        int bytesRead;
        while( (bytesRead = in.read( buffer )) > 0 ) {
        	out.println("");
        	outStream.write( buffer, 0, bytesRead );        	
        }
        in.close();
		
        out.println("</body></html>");
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
