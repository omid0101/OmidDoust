package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

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
import com.entities.Subject;
import com.entities.Teacher;
import com.hibernate.hibernateUtil;

/**
 * Servlet implementation class ClassRegisterController1
 */
@WebServlet("/ClassRegister")
public class ClassRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassRegisterController() {
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
			Set<Subject> subjects = new HashSet<Subject>();
			subjects.add(new Subject(100, "Algebra", "CLG10", "Math"));
			subjects.add(new Subject(200, "Dynamic", "CLG10", "Physics"));
			
			Set<Teacher> teachers = new HashSet<Teacher>();
			teachers.add(new Teacher(1000, "Ali", "Ahmadi", "Mathematics", "CLG10"));
			teachers.add(new Teacher(2000, "Mohammad", "Firouzi", "Physics", "CLG10"));
			
			/*Schoolcls clsch= new Schoolcls();
			Schoolcls clsch_name= clsch.getName_cl();
			if (clsch_name!= null) {
			 String	final_name= clsch_name;
			} else {
				final_name= "B1"
			}*/
			
			Set<Student> students = new HashSet<Student>();
			Student st=new Student(5000, "Ali", "Akbari", 647222580, "Otawa, Canada", "aakbari@gmail.com");
			students.add(st);
			//students.add(new Student(5001, "Mohammad", "Akbari", 647222590, "Otawa, Canada", "makbari@gmail.com"));
			
			
			Set<Student> students1 = new HashSet<Student>();
			Student st1= new Student(6000, "Omid", "Alijani", 647505232, "Toronto, Canada", "oalijani@gmail.com");
			students1.add(st1);
			//students1.add(new Student(6001, "Mazyar", "Aliparast", 647505244, "Toronto, Canada", "maliparast@gmail.com"));
			
			String clname = "A1";
			//String clname = "A1"+ Math.random();
			Schoolcls cls = new Schoolcls( 1 , "A1" , "CLG10", "In_cls" , subjects, teachers, students);
			Schoolcls cls1 = new Schoolcls( 2 , "B1" , "CLG10", "Online" , subjects, teachers, students1);
			
			
			st.setSch_class(cls);
			session.save(st);
			st1.setSch_class(cls1);
			session.save(st1);
			
			session.save(cls);
			session.save(cls1);
			transaction.commit();
			out.println("Record with name : "+clname +" Saved successfully." );

			out.println("Hibernate Session closed.<br>");
			out.println("</body></html>");
		} catch (Exception ex) {
			//throw ex;
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
