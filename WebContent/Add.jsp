<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Adder</title>
</head>
<body>

<%
	String n1 =  request.getParameter("num1");
	String n2 =  request.getParameter("num2");

	int sum = 0;
	try {
		sum = ( Integer.parseInt(n1) + Integer.parseInt(n2) ); 
	} catch(Exception e) {
		// display error
	}
%>

<form action="Add.jsp" method = "get">
	<input type="text" name="num1" placeholder="Enter a Number" />
	+
	<input type="text" name="num2" placeholder="Enter a Number" />
	= ??
	<input type="submit" value="Add"/>

</form>
<h2>
num1 = <%= request.getParameter("num1") %>
<br/>
</h2>


</body>
</html>