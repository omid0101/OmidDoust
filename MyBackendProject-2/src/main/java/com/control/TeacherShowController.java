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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<head>" + "<style>" + "table, th, td {" + "  border: 1px solid black;" + "}"
				+ "</style>" + "</head>" + "<body>");
		out.println("Hello");
		SessionFactory factory = hibernateUtil.getSessionFactory();

		Session session = factory.openSession();

		try {

			List<Teacher> list = session.createQuery("from Teacher").list();

			if (list != null && list.size() > 0) {
				out.println("<table style=\"width:100%\">");
				out.println("<tr>" + "    <th>Teacher-Id</th>" + "    <th>Teacher-Fistname</th>" + "    <th>Teacher-Lastname</th>"
						+ "    <th>Teacher-Expertise</th>" + "    <th>Teacher-Level</th>"+ 
						"    <th>Teacher-Class</th>"+ "  </tr>");
				
				for (Teacher s : list) {
					out.println("<tr>");
					out.println("<td>" + s.getTid() + "</td>");
					out.println("<td>" + s.getFname_tc() + "</td>");
					out.println("<td>" + s.getLname_tc() + "</td>");
					out.println("<td>" + s.getExpertise_tc() + "</td>");
					out.println("<td>" + s.getLevel_tc() + "</td>");
					out.println("<td>" + s.getClasses() + "</td>");
					
					
					out.println("</tr>");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
