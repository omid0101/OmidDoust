<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Start Page</title>
</head>
<body>

<%
String LoginName= request.getParameter("fname");
String LoginName1= request.getSession().getAttribute("FName").toString();

if (LoginName!= null){
	
	%>
	<h1>Welcome to Hibernate  <%= LoginName %>!</h1>
	 <% }else{
		
		%>
		<h1>Welcome to Hibernate  <%= LoginName1 %>!</h1>
 	<% }
	 %>


	
	<br/>
	<br/>
	<br/>
	
	 <a href="Master_List.html"> Go to Master List for Set up data</a>
	
	<br/>
	<br/>
	<br/>
	 <a href="ClassSubjectAssign"> Go to Assign Page</a>
	
	<br/>
	<br/>
	<br/>
	
		<a href="ShowStudent">Show Student Report </a>
	<br/>
	<br/>
	<br/>

	
		<a href="ClassShow">Show Class Report </a>
	<br/>
	<br/>
	<br/>
	
		<a href="SubjectShow">Show Subject Report </a>
	<br/>
	<br/>
	<br/>
		
		<a href="TeacherShow">Show Teacher Report </a>
	<br/>
<br>
<br>
<br>
<a href="logout.jsp" >Log Out</a>

</body>
</html>