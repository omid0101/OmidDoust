<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entities.Subject" %>
<%@ page import="com.entities.Schoolcls" %>
<%@ page import="com.entities.Teacher" %>
<%@ page import="com.entities.Student" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%  
	Object Result=request.getSession().getAttribute("AllSubjects"); 
	Object Result1=request.getSession().getAttribute("AllClasses");
	Object Result2=request.getSession().getAttribute("AllTeachers"); 
	Object Result3=request.getSession().getAttribute("AllStudents");
	
	 
	   if (Result!=null || Result1!=null || Result2!=null || Result3!=null ){
	
		List<Schoolcls> AllClasses= (List<Schoolcls>) Result1; 
		List<Subject> AllSubjects=(List<Subject>) Result; 
		List<Teacher> AllTeachers= (List<Teacher>) Result2;
		List<Student> AllStudents= (List<Student>) Result3;
		
					%>	
	
	 <h1>Assign Subjects to Classes</h1>
    
<form action="ClassSubjectAssign" method="post">
<table align="left">
  
	<tr>
			<td><select name="SubjectName">
			<%for(Subject  sub1: AllSubjects){
				if(sub1.getFltr_su()!= null){%>
			<option value="<%=sub1.getName_su()%>"><%= sub1.getName_su() %></option>
			<% } 
			}%>
			</select>
			</td>
			<td>Subjects</td>
			
	</tr>
	<tr>
			<td><select name="ClassName">
			<%for(Schoolcls  c: AllClasses){
				if(c.getFltr()!= null){%>
			<option value="<%=c.getName_cl() %>"><%= c.getName_cl() %></option>
			<% }
				
				}%>
			</select>
			</td>
			<td>Classes</td>
 
	</tr>


	<tr>
		 <td align="center" colspan="2"><input type="submit" value="Assign!"></td>
	 </tr>
</table>
		
</form>

<br/>
<br/>
<br/>

 <h1>Assign Teachers to Classes to Subjects </h1>
    
<form action="TeacherAssignControl" method="post">
<table align="left">
    
	<tr>
			<td><select name="TeacherName">
			<%for(Teacher  t: AllTeachers){
				if(t.getFltrt()!= null){%>
			<option value="<%=t.getLname_tc()%>"><%= t.getLname_tc() %></option>
			<% } 
			}%>
			</select>
			</td>
			<td>Teachers</td>
			
	</tr>
	<tr>
			<td><select name="ClassName">
			<%for(Schoolcls  cl1: AllClasses){
				if(cl1.getFltr()!= null){%>
			<option value="<%=cl1.getName_cl() %>"><%= cl1.getName_cl() %></option>
			<% }
				
				}%>
			</select>
			</td>
			<td>Classes</td>
 
	</tr>
	
	<tr>
			<td><select name="SubjectName">
			<%for(Subject  sub2: AllSubjects){
				if(sub2.getFltr_su()!= null){%>
			<option value="<%=sub2.getName_su()%>"><%= sub2.getName_su() %></option>
			<% } 
			}%>
			</select>
			</td>
			<td>Subjects</td>
			
	</tr>


	<tr>
		 <td align="center" colspan="2"><input type="submit" value="Assign!"></td>
	 </tr>
</table>
		
</form>

<br/>
<br/>
<br/>
<br/>
<br/>
 <h1>Assign Students to Classes</h1>
<form action="StudentAssignControl" method="post">
<table align="left">
  
	<tr>
			<td><select name="StudentName">
			<%for(Student  std: AllStudents){
				if(std.getFltrs()!= null){%>
			<option value="<%=std.getLname_std()%>"><%= std.getLname_std() %></option>
			<% } 
			}%>
			</select>
			</td>
			<td>Students</td>
			
	</tr>
	<tr>
			<td><select name="ClassName">
			<%for(Schoolcls  cl2: AllClasses){
				if(cl2.getFltr()!= null){%>
			<option value="<%=cl2.getName_cl() %>"><%= cl2.getName_cl() %></option>
			<% }
				
				}%>
			</select>
			</td>
			<td>Classes</td>
 
	</tr>


	<tr>
		 <td align="center" colspan="2"><input type="submit" value="Assign!"></td>
	 </tr>
</table>
		
</form>


<%
	   }
%>


</body>
</html>