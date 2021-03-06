package cs320stu47.homework3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework3/CoffeeShopLocator")
public class CoffeeShopLocator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoffeeShopLocator() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String query = (String) request.getParameter("query");
		String radius = (String) request.getParameter("radius");
		String type = (String) request.getParameter("type");
		
		ArrayList<Location> locationList = (ArrayList<Location>)request.getAttribute("locationList");
		
		if (request.getAttribute("locationList") != null) {
			out.println("<html>");
			out.println("  <head>");
			out.println("    <title> Starbucks Coffee Locations</title>");
			out.println("  </head>");
			out.println("  <body>");
			out.println("    <div class=\"container\">");
			out.println("      <center>");
			out.println("        <form actions=\"CoffeeShopServlet\" method=\"post\">");
			out.println("");
			out.println("          <input type=\"text\" name=\"query\" placeholder=\"Enter Search Term(s)\" value=\"" + request.getAttribute("query") + "\" />");
			out.println("");
			out.println("          Radius: ");
			out.println("          <select name=\"radius\">");
			if (radius.equals("10") ) {
				out.println("            <option value=\"5\">5</option>");
				out.println("            <option value=\"10\" selected=\"selected\">10</option>");
				out.println("            <option value=\"25\">25</option>");
				out.println("            <option value=\"50\">50</option>");
			} else if (radius.equals("25") ) {
				out.println("            <option value=\"5\">5</option>");
				out.println("            <option value=\"10\">10</option>");
				out.println("            <option value=\"25\" selected=\"selected\">25</option>");
				out.println("            <option value=\"50\">50</option>");
			} else if (radius.equals("50") ) {
				out.println("            <option value=\"5\">5</option>");
				out.println("            <option value=\"10\">10</option>");
				out.println("            <option value=\"25\">25</option>");
				out.println("            <option value=\"50\" selected=\"selected\">50</option>");				
			} else {
				out.println("            <option value=\"5\" selected=\"selected\">5</option>");
				out.println("            <option value=\"10\">10</option>");
				out.println("            <option value=\"25\">25</option>");
				out.println("            <option value=\"50\">50</option>");	
			}
			out.println("          </select>");
			out.println("");
			out.println("          Type: ");
			out.println("          <select name=\"type\">");
			if (type.equals("city") ) {				
				out.println("              <option value=\"location\">Location</option>");
				out.println("              <option value=\"city\" selected=\"selected\">City</option>");
				out.println("              <option value=\"zip\">Zip Code</option>");
			} else if (type.equals("zip") ) {
				out.println("              <option value=\"location\">Location</option>");
				out.println("              <option value=\"city\">City</option>");
				out.println("              <option value=\"zip\" selected=\"selected\">Zip Code</option>");
			} else {
				out.println("              <option value=\"location\">Location</option>");
				out.println("              <option value=\"city\">City</option>");
				out.println("              <option value=\"zip\">Zip Code</option>");					
			}
			out.println("          </select>");
			out.println("");
			out.println("<input type=\"submit\" value=\"Search\" />");
			out.println("        </form>");
			out.println("        <hr />");
			out.println("");
			out.println("        <p> We found " + locationList.size() + " result(s)!</p>");
			if (locationList.size() != 0) {
			out.println("        <table id=\"results\" border=\"1\" style=\"width:75%\">");
			out.println("          <tr>");
			out.println("            <th class=\"name\">Starbucks Location</th>");
			out.println("            <th class=\"address\">Address</th>");
			out.println("            <th class=\"city\">City</th>");
			out.println("            <th class=\"zip\">Zip</th>");
			out.println("            <th class=\"phonenumber\">Phone Number</th>");
			out.println("          </tr>");
			for (int i = 0; i < locationList.size(); i++) {
				out.println("							<tr>");
				out.println("								<td>" + locationList.get(i).getLocation() + "</td>");
				out.println("								<td>" + locationList.get(i).getAddress() + "</td>");
				out.println("								<td>" + locationList.get(i).getCity() + "</td>");			
				out.println("								<td>" + locationList.get(i).getZip() + "</td>");
				out.println("								<td>" + locationList.get(i).getPhoneNumber() + "</td>");
				out.println("							</tr>");
			}
			
			out.println("        </table>");
			}
			out.println("");
			out.println("      </center>");
			out.println("    </div>");
			out.println("  </body>");
			out.println("");
			out.println("  </html>");
		} else if (request.getAttribute("hasError") != null ) {
			out.println("<html>");
			out.println("  <head>");
			out.println("    <title> Starbucks Coffee Locations</title>");
			out.println("  </head>");
			out.println("  <body>");
			out.println("    <div class=\"container\">");
			out.println("      <center>");
			out.println("        <form actions=\"CoffeeShopServlet\" method=\"post\">");
			out.println("");
			if (request.getParameter("query") != null) {
				out.println("          <input type=\"text\" name=\"query\" placeholder=\"Enter Search Term(s)\" value=\"" + request.getParameter("query") + "\" />");				
			} else {
				out.println("          <input type=\"text\" name=\"query\" placeholder=\"Enter Search Term(s)\" />");

			}
			out.println("");
			out.println("          Radius:");
			out.println("          <select name=\"radius\">");
			if (radius.equals("10") ) {
				out.println("            <option value=\"5\">5</option>");
				out.println("            <option value=\"10\" selected=\"selected\">10</option>");
				out.println("            <option value=\"25\">25</option>");
				out.println("            <option value=\"50\">50</option>");
			} else if (radius.equals("25") ) {
				out.println("            <option value=\"5\">5</option>");
				out.println("            <option value=\"10\">10</option>");
				out.println("            <option value=\"25\" selected=\"selected\">25</option>");
				out.println("            <option value=\"50\">50</option>");
			} else if (radius.equals("50") ) {
				out.println("            <option value=\"5\">5</option>");
				out.println("            <option value=\"10\">10</option>");
				out.println("            <option value=\"25\">25</option>");
				out.println("            <option value=\"50\" selected=\"selected\">50</option>");				
			} else {
				out.println("            <option value=\"5\" selected=\"selected\">5</option>");
				out.println("            <option value=\"10\">10</option>");
				out.println("            <option value=\"25\">25</option>");
				out.println("            <option value=\"50\">50</option>");	
			}
			out.println("          </select>");
			out.println("");
			out.println("          Type:");
			out.println("          <select name=\"type\">");
			if (type.equals("city") ) {				
				out.println("              <option value=\"location\">Location</option>");
				out.println("              <option value=\"city\" selected=\"selected\">City</option>");
				out.println("              <option value=\"zip\">Zip Code</option>");
			} else if (type.equals("zip") ) {
				out.println("              <option value=\"location\">Location</option>");
				out.println("              <option value=\"city\">City</option>");
				out.println("              <option value=\"zip\" selected=\"selected\">Zip Code</option>");
			} else {
				out.println("              <option value=\"location\" selected=\"selected\">Location</option>");
				out.println("              <option value=\"city\">City</option>");
				out.println("              <option value=\"zip\">Zip Code</option>");					
			}
			out.println("          </select>");
			out.println("");
			out.println("<input type=\"submit\" value=\"Search\" />");
			out.println("        </form>");
			out.println("        <hr />");
			out.println("");
			out.println("No search results found.");
			out.println("      </center>");
			out.println("    </div>");
			out.println("  </body>");
			out.println("");
			out.println("  </html>");
		} else {
			out.println("<html>");
			out.println("  <head>");
			out.println("    <title> Starbucks Coffee Locations</title>");
			out.println("  </head>");
			out.println("  <body>");
			out.println("    <div class=\"container\">");
			out.println("      <center>");
			out.println("        <form actions=\"CoffeeShopServlet\" method=\"post\">");
			out.println("");
			out.println("          <input type=\"text\" name=\"query\" placeholder=\"Enter Search Term(s)\" />");
			out.println("");
			out.println("          Radius: ");
			out.println("          <select name=\"radius\">");
			out.println("            <option value=\"5\">5</option>");
			out.println("            <option value=\"10\" selected=\"selected\">10</option>");
			out.println("            <option value=\"25\">25</option>");
			out.println("            <option value=\"50\">50</option>");
			out.println("          </select>");
			out.println("");
			out.println("          Type:");
			out.println("          <select name=\"type\">");
			out.println("              <option value=\"location\">Location</option>");
			out.println("              <option value=\"city\">City</option>");
			out.println("              <option value=\"zip\">Zip Code</option>");
			out.println("          </select>");
			out.println("");
			out.println("<input type=\"submit\" value=\"Search\" />");
			out.println("        </form>");
			out.println("        <hr />");
			out.println("");
			out.println("      </center>");
			out.println("    </div>");
			out.println("  </body>");
			out.println("");
			out.println("  </html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// users input
		String query = request.getParameter("query");
		// choice of radius
		String radius = request.getParameter("radius");
		// type choice of lat/long, city, or zip
		String type = request.getParameter("type");
		
		boolean hasError = false;
				
		if (query == null || query.trim().equals("") ) {
			hasError = true;
		}
		
		ArrayList<Location> locationList = getLocations(query, radius, type);
		
		if (hasError || locationList == null) {
			request.setAttribute("hasError", "Has Errors");
			doGet(request, response);
		} else {
			request.setAttribute("query", query);
			request.setAttribute("locationList", locationList);
			doGet(request, response);
		}
	}
	
	public ArrayList<Location> getLocations(String query, String radius, String type) throws FileNotFoundException {
		Integer searchRadius = Integer.parseInt(radius);
		String userInput = query.trim();
		
		double entryLat = 0.0;
		double entryLong = 0.0;
		
		
		ArrayList<Location> locationsFound = new ArrayList<Location>();
		
		ServletContext context = this.getServletContext();
		
//		String path1 = context.getContextPath();
		String path2 = context.getRealPath("/WEB-INF/starbucks.csv").toString();
		
//		File file = new File("/Volumes/MINIDANNYP/Work/EclipseWorkspace/cs320/WebContent/WEB-INF/data/starbucks.csv");
		
		File file = new File(path2);
		
		Scanner input = new Scanner(file);
		
		if (type.equals("location") ) {
			try {
				if (userInput.indexOf(",") < 0) {
					String[] queryLatLong = query.split(" ");
					entryLat = Double.parseDouble(queryLatLong[0].trim() );
					entryLong = Double.parseDouble(queryLatLong[1].trim() );
					
				} else {
					String[] queryLatLong = query.split(",");				
					entryLat = Double.parseDouble(queryLatLong[0].trim() );
					entryLong = Double.parseDouble(queryLatLong[1].trim() );
				}				
			} catch (Exception e) {
				input.close();
				return null;
			}
		}
		
		while(input.hasNextLine() ) {
					
				Double lattitude = 0.0;
				Double longitude = 0.0;
				String loc = "N/A";
				String address = "N/A";
				String city = "N/A";
				String state = "N/A";
				String zip = "N/A";
				String phoneNumber = "N/A";
				
				String[] nextLine = input.nextLine().replaceAll("\"", "").trim().split(",", 4);
				
				// will always have lat/long
				lattitude = Double.parseDouble(nextLine[1].trim() );
				longitude = Double.parseDouble(nextLine[0].trim() );
				
				// will always have location
				if (nextLine[2].indexOf(":") < 0) {
					loc = nextLine[2].trim();
				} else {
					loc = nextLine[2].substring(nextLine[2].indexOf(":") + 1, nextLine[2].length() ).trim();
				}
				
				
				// this part varies.... a lot..
				String[] splitBlockD = nextLine[3].trim().split(";");
				
				// if len is 1 entries vary as;
				if(splitBlockD.length == 1 && !splitBlockD[0].equals("") ) {
					if (splitBlockD[0].indexOf(",") < 0 && splitBlockD[0].indexOf("&") < 0)  {
						state = splitBlockD[0];
					} else if (splitBlockD[0].indexOf("&") > 0) {
						address = splitBlockD[0];
					} else {
						city = splitBlockD[0].substring(0, splitBlockD[0].indexOf(",") ).trim();
						String[] splitStateZip = splitBlockD[0].substring(splitBlockD[0].indexOf(",") + 1).trim().split(" ");
						state = splitStateZip[0];
						if(splitStateZip.length > 1) {
							zip = splitStateZip[1];
						}
					}
				}
				
				if (splitBlockD.length == 2) {
					address = splitBlockD[0].trim();
					if (splitBlockD[1].trim().indexOf(",") < 0 ) {
						if (splitBlockD[1].trim().length() > 2) {
							phoneNumber = splitBlockD[1].trim();
						} else {
							state = splitBlockD[1].trim();
						}
	
					} else {
						city = splitBlockD[1].substring(0, splitBlockD[1].indexOf(",") ).trim();
						String[] splitStateZip = splitBlockD[1].substring(splitBlockD[1].indexOf(",") + 1).trim().split(" ");
						state = splitStateZip[0].trim();
						if(splitStateZip.length > 1) {
							zip = splitStateZip[1].trim();
						}
	 				}
				}
				
				if (splitBlockD.length == 3) {
					address = splitBlockD[0].trim();
					city = splitBlockD[1].substring(0, splitBlockD[1].indexOf(",") ).trim();
					String[] splitStateZip = splitBlockD[1].substring(splitBlockD[1].indexOf(",") + 1).trim().split(" ");
					state = splitStateZip[0].trim();
					if(splitStateZip.length > 1) {
						zip = splitStateZip[1].trim();
					}
					// if time is available add more constraints: where '&' in in entry
					phoneNumber = splitBlockD[2].trim();
				}			
				
				// checks entries then adds them to arrayList if entry is FOUND
				// done; tested
				if (type.equals("location") ) {
					if (greatDistanceFormula(entryLat, entryLong, lattitude, longitude) <= searchRadius) {
						locationsFound.add(new Location(lattitude, longitude, loc, address, city, state, zip, phoneNumber));
					}
					
				} else if (type.equals("city") ) {
					// incorporate partial search; maybe .split then check if each .startsWith at least 3 chars ex los
					String[] citySplit = city.split(" ");
					String[] querySplit = query.split(" ");
					boolean found = false;
					
					
					if (city.equalsIgnoreCase(query) ) {
						locationsFound.add(new Location(lattitude, longitude, loc, address, city, state, zip, phoneNumber));
						found = true;
					}
					// something wrong here; duplicates why!??
					if (!found) {
						for (int i = 0; i < citySplit.length; i++) {
							for (int j = 0; j < querySplit.length; j++) {
								if (citySplit[i].equalsIgnoreCase(querySplit[j]) ) {
									locationsFound.add(new Location(lattitude, longitude, loc, address, city, state, zip, phoneNumber));
									found = true;
								}
							}
						}
					}
						
				} else if (type.equals("zip") ) {
					if (zip.equals(query) || query.equals(zip) ) {
						locationsFound.add(new Location(lattitude, longitude, loc, address, city, state, zip, phoneNumber));					
					} else if (zip.split("-")[0].equals(query.split("-")[0]) )   {
						locationsFound.add(new Location(lattitude, longitude, loc, address, city, state, zip, phoneNumber));
					}
				} else {
					// no entries
				}
				
			}
		input.close();
		
		return locationsFound;
	}
	
	// from princeton website
	public static double greatDistanceFormula(double lattitude1, double longitude1, double lattitude2, double longitude2) {
		double lat1 = Math.toRadians(lattitude1);
		double long1 = Math.toRadians(longitude1);
		double lat2 = Math.toRadians(lattitude2);
		double long2 = Math.toRadians(longitude2);
		
		double haverside = Math.pow(Math.sin( (lat2 - lat1)/ 2 ), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin( (long2 - long1)/ 2 ), 2);
		double angle = Math.toDegrees(2 * Math.asin(Math.min(1, Math.sqrt(haverside) )) );
		// nautical miles to miles
		double distance = (60 * angle) * 1.15078;
		
		return distance;
	}

}
