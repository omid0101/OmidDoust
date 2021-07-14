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

import com.entities.Schoolcls;
import com.entities.Student;
import com.hibernate.hibernateUtil;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentRegister")
public class StudentRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public StudentRegisterController() {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

			String studentFname = request.getParameter("Student_FName");
			String studentLname = request.getParameter("Student_LName");
			String studentPhone = request.getParameter("Student_Phone");
			String studentAddress = request.getParameter("Student_Address");
			String studentEmail = request.getParameter("Student_Email");
			String studentLevel = request.getParameter("Student_Level");
			String fltrs = "Ok";

			Schoolcls clss = new Schoolcls();
			clss.setStudents(null);

			Student student = new Student(studentFname, studentLname, Integer.parseInt(studentPhone), studentAddress,
					studentEmail, studentLevel, fltrs, clss);

			session.save(student);
			transaction.commit();
			out.println("Record with name : " + studentFname + " Saved successfully.");

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}

}
