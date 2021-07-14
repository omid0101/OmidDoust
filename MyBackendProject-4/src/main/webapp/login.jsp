<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Check Page</title>
</head>
<body>

<%
	Object userlogin=request.getSession().getAttribute("UserLog");
	Object userpass= request.getSession().getAttribute("UserPass");
	Object Ulogin= request.getSession().getAttribute("UserLog1");   
	Object Passwd= request.getSession().getAttribute("UserPass1"); 

	
	if (Ulogin.equals(userlogin) && Ulogin!=null && Passwd.equals(userpass) && Passwd!=null ){
		
		response.sendRedirect("start.jsp");
		
	} else 
	{
		response.sendRedirect("index.jsp?error=1");
		
	}

%>



</body>
</html>