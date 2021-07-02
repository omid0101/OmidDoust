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

			List<Schoolcls> list = session.createQuery("from Schoolcls").list();

			if (list != null && list.size() > 0) {
				out.println("<table style=\"width:100%\">");
				out.println("<tr>" + "    <th>Class-Id</th>" + "    <th>Class-name</th>" + "    <th>Class-level</th>"
						+ "    <th>Class-type</th>" + "  </tr>");
				for (Schoolcls s : list) {
					out.println("<tr>");
					out.println("<td>" + s.getClid() + "</td>");
					out.println("<td>" + s.getName_cl() + "</td>");
					out.println("<td>" + s.getLevel_cl() + "</td>");
					out.println("<td>" + s.getType_cl() + "</td>");
					
					
					
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
