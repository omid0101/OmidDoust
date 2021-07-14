<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log Out Page</title>
</head>
<body>

<%
session.invalidate();
%>
<br>
<h2>You Logged out successfully!</h2>
<br>
<br>
<br>
<br>
<a href="index.jsp">
Click here to login again!
</a>

</body>
</html>