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

import org.hibernate.query.Query;

import com.entities.Schoolcls;
import com.entities.Subject;
import com.hibernate.hibernateUtil;

/**
 * Servlet implementation class ClassAssignController
 */
@WebServlet("/ClassSubjectAssign")
public class SubjectAssignController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectAssignController() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
			Object allSubjects = request.getSession().getAttribute("AllSubjects"); 

			
			List<Schoolcls> AllClss= (List<Schoolcls>) allClasses;  
			List<Subject> AllSubjcts=(List<Subject>) allSubjects;


			
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
			
			
			String subjectName= request.getParameter("SubjectName");
			Set<Subject> subjects = new HashSet<Subject>();
			Subject sub= new Subject();
			
			for (Subject s1: AllSubjcts) {
			if(s1.getName_su()!=null && s1.getName_su().equals(subjectName)) {
			String subnm = s1.getName_su();
			String sublev= s1.getLevel_su();
			String subcat= s1.getCat_su();
			sub.setName_su(subnm);
			sub.setLevel_su(sublev);
			sub.setCat_su(subcat);
					}
			}
			
			subjects.add(sub);
			
			
						
			out.println("Class recognized successfully!");
			
			cls1.setSubjects(subjects);

			session.saveOrUpdate(cls1);
			transaction.commit();
			out.println("Record with Subject ID : "+subjectName +" Saved successfully." );

			out.println("Hibernate Session closed.<br>");
			out.println("</body></html>");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.err.println("There is an error in hinernate functionality!");
			
		} finally {
			
			session.close();
		}
		
	}
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		System.out.println("doGet servlet started!");
    	SessionFactory factory = hibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		out.println("Hibernate Session opened.<br>");

			Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			out.println("Transaction began.<br>");
			
							
				@SuppressWarnings("unchecked")
				Query<Subject> query = session.createQuery("from Subject" ).setCacheable(true);//.setHint("org.hibernate.cacheable","true");
				List<Subject> Result = (List<Subject>) query.getResultList();
			
				@SuppressWarnings("unchecked")
				Query<Schoolcls> query1 = session.createQuery("from Schoolcls" ).setCacheable(true);//.setHint("org.hibernate.cacheable","true");
				List<Schoolcls> Result1 = (List<Schoolcls>) query1.getResultList();
				
				@SuppressWarnings("unchecked")
				Query<Subject> query2 = session.createQuery("from Teacher" ).setCacheable(true);//.setHint("org.hibernate.cacheable","true");
				List<Subject> Result2 = (List<Subject>) query2.getResultList();
				
				@SuppressWarnings("unchecked")
				Query<Subject> query3 = session.createQuery("from Student" ).setCacheable(true);//.setHint("org.hibernate.cacheable","true");
				List<Subject> Result3 = (List<Subject>) query3.getResultList();
				
				request.getSession().setAttribute("AllSubjects", Result);
				request.getSession().setAttribute("AllClasses", Result1);
				request.getSession().setAttribute("AllTeachers", Result2);
				request.getSession().setAttribute("AllStudents", Result3);
				response.sendRedirect("Assign.jsp");
				
				
				
				transaction.commit();
				out.println("Record with Result and Result1 received successfully." );

				out.println("Hibernate doGet Session closed.<br>");
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


}
