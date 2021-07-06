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

import com.entities.Student;
import com.hibernate.hibernateUtil;


/**
 * Servlet implementation class StudentShowController
 */
@WebServlet("/ShowStudent")
public class StudentShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentShowController() {
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

			List<Student> list = session.createQuery("from Student").list();

			if (list != null && list.size() > 0) {
				out.println("<table style=\"width:100%\">");
				out.println("<tr>" + "    <th>Student_Id</th>" + "    <th>Student_FirstName</th>" + "    <th>Student_LastName</th>"
						+ "    <th>Student_PhoneNumber</th>"+ "   <th>Student_Address</th>"+ "    <th>Student_Email</th>" +
						"    <th>Student_Class</th>" + "  </tr>");
				
				for (Student s : list) {
					out.println("<tr>");
					out.println("<td>" + s.getSid() + "</td>");
					out.println("<td>" + s.getFname_std() + "</td>");
					out.println("<td>" + s.getLname_std() + "</td>");
					out.println("<td>" + s.getNumber_std() + "</td>");
					out.println("<td>" + s.getSaddress() + "</td>");
					out.println("<td>" + s.getSemail() + "</td>");
					out.println("<td>" + s.getSch_class() + "</td>");
					
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
