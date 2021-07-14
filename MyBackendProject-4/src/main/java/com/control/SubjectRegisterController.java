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

import com.entities.Subject;
//import com.entities.Teacher;
import com.hibernate.hibernateUtil;

/**
 * Servlet implementation class SubjectRegisterController
 */
@WebServlet("/SubjectRegister")
public class SubjectRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectRegisterController() {
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

			String subjectName= request.getParameter("Subject_Name");
			String subjectCat= request.getParameter("Subject_Cat");
			String subjectLevel= request.getParameter("Subject_Level");
			String fltrsu= "Ok";
			
			Subject sub= new Subject( subjectName, subjectLevel, subjectCat, fltrsu);
			
			
			session.save(sub);
			transaction.commit();
			out.println("Record with name : "+subjectName +" Saved successfully." );

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
