package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entities.Schoolcls;
import com.hibernate.hibernateUtil;

/**
 * Servlet implementation class ClassShowController
 */
@WebServlet("/ClassShow")
public class ClassShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassShowController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<head>" + "<style>" + "table, th, td {" + "  border: 1px solid black;" + "}"
				+ "</style>" + "</head>" + "<body>");
		out.println("<h1>Class Report</h1>");
		SessionFactory factory = hibernateUtil.getSessionFactory();

		Session session = factory.openSession();

		try {

			List<Schoolcls> list = session.createQuery("from Schoolcls").list();
			
			if (list != null && list.size() > 0) {
		
									
						out.println("<table style=\"width:100%\">");
						out.println("<tr>" +  "    <th>Class-name</th>" + "    <th>Class-level</th>"
								+ "    <th>Class-type</th>" + "  </tr>");
						out.println("<h2> This is a list of available classes </h2>");
						
					for (Schoolcls cls: list) {
												
						if(cls.getFltr() != null) {
							
							
							
							out.println("<tr>");	
							
							out.println("<td>" + cls.getName_cl() + "</td>");
							out.println("<td>" + cls.getLevel_cl() + "</td>");
							out.println("<td>" + cls.getType_cl() + "</td>");
							out.println("</tr>");} 
					}
						
							
							
							out.println("<table style=\"width:100%\">");
							out.println("<tr>" +  "    <th>Class-name</th>" + "    <th>Class-level</th>"
									+ "    <th>Class-type</th>" + "    <th>Class-subject</th>" + "    <th>Class-teacher</th>" + 
									"    <th>Class-student</th>" + "  </tr>");
							out.println("<h2> This is a list of registered subjects, teachers, and students to the classes </h2>");
							
								for (Schoolcls cls1:list) {
									if(cls1.getFltr() == null && cls1.getName_cl()!= null) {
							
								out.println("<tr>");
								
								out.println("<td>" + cls1.getName_cl() + "</td>");
								out.println("<td>" + cls1.getLevel_cl() + "</td>");
								out.println("<td>" + cls1.getType_cl() + "</td>");
								out.println("<td>" + cls1.getSubjects() + "</td>");
								out.println("<td>" + cls1.getTeachers() + "</td>");
								out.println("<td>" + cls1.getStudents() + "</td>");
								out.println("</tr>");
						}
					}
				}
			out.println("</body></html>");
		}
		 catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
