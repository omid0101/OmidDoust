package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Teacher;
import com.hibernate.hibernateUtil;

/**
 * Servlet implementation class TeacherRegisterController
 */
@WebServlet("/TeacherRegister")
public class TeacherRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		System.out.println("servlet started!");
		
		SessionFactory factory = hibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		out.println("Hibernate Session opened.<br>");

			Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			out.println("Transaction began.<br>");
//			Set<PhoneNumbers> phoneNumbers = new HashSet<PhoneNumbers>();
//			phoneNumbers.add(new PhoneNumbers("house", "32354353"));
//			phoneNumbers.add(new PhoneNumbers("mobile", "9889343423"));
			
			String tname = "Teacher"+ Math.random();
			Teacher teacher= new Teacher(210, tname, "Corbin", "Mathematics", "Level2");

			session.save(teacher);
			transaction.commit();
			out.println("Record with name : "+tname +" Saved successfully." );

			out.println("Hibernate Session closed.<br>");
			out.println("</body></html>");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("There is an error in hinernate functionality!");
			
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
