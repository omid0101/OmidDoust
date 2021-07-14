package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
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

import com.hibernate.hibernateUtil;

/**
 * Servlet implementation class StudentAssignController
 */
@WebServlet("/StudentAssignControl")
public class StudentAssignController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAssignController() {
        super();
       
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
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
			
			Object allClasses= request.getSession().getAttribute("AllClasses"); 

			Object allStudents= request.getSession().getAttribute("AllStudents"); 
			
			List<Schoolcls> AllClss= (List<Schoolcls>) allClasses;  

			List<Student> AllStuds=(List<Student>) allStudents;


			String studentName= request.getParameter("StudentName");

			Set<Student> students = new HashSet<Student>();
			Student stud= new Student();
			
			for (Student s2: AllStuds) {
			if(s2.getLname_std()!=null && s2.getLname_std().equals(studentName)) {
			
			String sfnm = s2.getFname_std();
			String slev= s2.getSlevel();
			long sphn= s2.getNumber_std();
			String stemail= s2.getSemail();
			String stadd= s2.getSaddress();
			stud.setFname_std(sfnm);
			stud.setNumber_std(sphn);
			stud.setSaddress(stadd);
			stud.setSlevel(slev);
			stud.setLname_std(studentName);
			stud.setSemail(stemail);
					}
			}
			
			students.add(stud);
			
			String className= request.getParameter("ClassName");
			
			Schoolcls cls1 = new Schoolcls();
			
			for (Schoolcls c1: AllClss) {
			if(c1.getName_cl()!=null && c1.getName_cl().equals(className)) {
				
				String clsnm= c1.getName_cl();
				String clslev= c1.getLevel_cl();
				String clstp= c1.getType_cl();
				cls1.setName_cl(clsnm);
				cls1.setLevel_cl(clslev);
				cls1.setType_cl(clstp);
				cls1.setFltr(null);
				}
			}
			
			
						
			out.println("Class recognized successfully!");
			

			cls1.setStudents(students);

			stud.setSch_class(cls1);
			session.saveOrUpdate(stud);
			session.saveOrUpdate(cls1);
			transaction.commit();
			out.println("Record with Subject ID : "+studentName +" Saved successfully." );

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}



}
