<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<%
if (request.getParameter("error")!= null){
	
	out.println("Invalid Credential! Please Try Again!");
}

%>


<form action="LoginRegister" method="GET">

Enter Login <input type="text"  name="ulogin" maxlength=40>
Enter Password <input type="password" name="passwd" maxlength=20>
<button>Log In</button>
</form>

<a href="Sign Up.jsp">Sign Up</a>


</body>
</html>