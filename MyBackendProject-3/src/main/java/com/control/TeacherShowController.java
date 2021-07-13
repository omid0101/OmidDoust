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

import com.entities.Teacher;
import com.hibernate.hibernateUtil;

/**
 * Servlet implementation class TeacherShowController
 */
@WebServlet("/TeacherShow")
public class TeacherShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherShowController() {
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
		out.println("<h1>Teacher Report</h1>");
		
		SessionFactory factory = hibernateUtil.getSessionFactory();

		Session session = factory.openSession();

		try {

			List<Teacher> list = session.createQuery("from Teacher").list();

			if (list != null && list.size() > 0) {
				
				
				out.println("<table style=\"width:100%\">");
				out.println("<tr>" +  "    <th>Teacher-Fistname</th>" + "    <th>Teacher-Lastname</th>"
						+ "    <th>Teacher-Expertise</th>" + "    <th>Teacher-Level</th>"+ 
						 "  </tr>");
				
				out.println("<h2> This is a list of available subjects </h2>");	
				
				
				for (Teacher tc1 : list) {
					if(tc1.getFltrt() != null) {
					out.println("<tr>");
				
					out.println("<td>" + tc1.getFname_tc() + "</td>");
					out.println("<td>" + tc1.getLname_tc() + "</td>");
					out.println("<td>" + tc1.getExpertise_tc() + "</td>");
					out.println("<td>" + tc1.getLevel_tc() + "</td>");
					
										
					out.println("</tr>");
					}
				}
				
				out.println("<table style=\"width:100%\">");
				out.println("<tr>" +  "    <th>Teacher-Fistname</th>" + "    <th>Teacher-Lastname</th>"
						+ "    <th>Teacher-Expertise</th>" + "    <th>Teacher-Level</th>"+ 
						"    <th>Teacher-Class</th>"+ "  </tr>");
				
				out.println("<h2> This is a list of registered teachers to classes </h2>");
				
				
				for (Teacher tc2 : list) {
					if(tc2.getFltrt() == null) {
					out.println("<tr>");
				
					out.println("<td>" + tc2.getFname_tc() + "</td>");
					out.println("<td>" + tc2.getLname_tc() + "</td>");
					out.println("<td>" + tc2.getExpertise_tc() + "</td>");
					out.println("<td>" + tc2.getLevel_tc() + "</td>");
					out.println("<td>" + tc2.getClasses() + "</td>");
										
					out.println("</tr>");
						}
					}
				}
			
			
					
			out.println("</body></html>");
				
		}catch (Exception ex) {
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
