<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bg" class="cs320.models.BGBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:setProperty name="bg" property="r" value="180" />
<jsp:setProperty name="bg" property="g" param="green"/>

bg.r = <jsp:getProperty property="r" name="bg" />
<br/>
bg.r = <jsp:getProperty property="g" name="bg" />
<br />
bg.r = <jsp:getProperty property="b" name="bg" />
</body>

</html>