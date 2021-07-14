package com.control;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.HashSet;
//import java.util.Set;

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
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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

			String teacherFname= request.getParameter("Teacher_FName");
			String teacherLname= request.getParameter("Teacher_LName");
			String teacherExpert= request.getParameter("Teacher_Expert");
			String teacherLevel= request.getParameter("Teacher_Level");
			
			Teacher teacher= new Teacher( teacherFname, teacherLname, teacherExpert, teacherLevel, "Ok");
			
			session.save(teacher);
			transaction.commit();
			out.println("Record with name : "+teacherFname +" Saved successfully." );

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
