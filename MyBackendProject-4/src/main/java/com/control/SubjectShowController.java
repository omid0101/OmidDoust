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

import com.entities.Subject;
import com.hibernate.hibernateUtil;

/**
 * Servlet implementation class SubjectShowController
 */
@WebServlet("/SubjectShow")
public class SubjectShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectShowController() {
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
		out.println("<h1>Subject Report</h1>");
		SessionFactory factory = hibernateUtil.getSessionFactory();

		Session session = factory.openSession();

		try {

			List<Subject> list = session.createQuery("from Subject").list();

			if (list != null && list.size() > 0) {
				
				out.println("<table style=\"width:100%\">");
				out.println("<tr>" +  "    <th>Subject-Name</th>" + "    <th>Subject-Level</th>"
						+ "    <th>Subject-Category</th>" +  "  </tr>");
				
				out.println("<h2> This is a list of available subjects </h2>");
				
				for (Subject sj : list) {
					if(sj.getFltr_su() != null) {
					out.println("<tr>");
					out.println("<td>" + sj.getName_su() + "</td>");
					out.println("<td>" + sj.getLevel_su() + "</td>");
					out.println("<td>" + sj.getCat_su() + "</td>");
										
					out.println("</tr>");
					}
				}
					
			
				out.println("<table style=\"width:100%\">");
				out.println("<tr>" +  "    <th>Subject-Name</th>" + "    <th>Subject-Level</th>"
						+ "    <th>Subject-Category</th>" + "    <th>Subject_Class</th>" +  "  </tr>");
				
				out.println("<h2> This is a list of registered subjects to classes </h2>");
				
				for (Subject sj1 : list) {
					if(sj1.getFltr_su() == null) {
					out.println("<tr>");
					out.println("<td>" + sj1.getName_su() + "</td>");
					out.println("<td>" + sj1.getLevel_su() + "</td>");
					out.println("<td>" + sj1.getCat_su() + "</td>");
					out.println("<td>" + sj1.getClasses() + "</td>");
					
					out.println("</tr>");
					}
				}
				
			}
			
				
			
			out.println("</body></html>");
			
		} catch (Exception ex) {
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
