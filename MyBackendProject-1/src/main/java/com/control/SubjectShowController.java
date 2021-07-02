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

			List<Subject> list = session.createQuery("from Subject").list();

			if (list != null && list.size() > 0) {
				out.println("<table style=\"width:100%\">");
				out.println("<tr>" + "    <th>Subject-Id</th>" + "    <th>Subject-name</th>" + "    <th>Subject-level</th>"
						+ "    <th>Subject-category</th>" + "  </tr>");
				for (Subject s : list) {
					out.println("<tr>");
					out.println("<td>" + s.getSuid() + "</td>");
					out.println("<td>" + s.getName_su() + "</td>");
					out.println("<td>" + s.getLevel_su() + "</td>");
					out.println("<td>" + s.getCat_su() + "</td>");
					
					
					
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
