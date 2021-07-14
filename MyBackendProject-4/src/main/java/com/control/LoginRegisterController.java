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
import org.hibernate.Transaction;


import com.hibernate.hibernateUtil;
import com.loginentity.Login;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginRegister")
public class LoginRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRegisterController() {
        super();
       
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		System.out.println("servlet started!");

		SessionFactory factory = hibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
		
			String Fname = request.getParameter("fname");
			String Lname = request.getParameter("lname");
			String login = request.getParameter("ulogin");
			String password = request.getParameter("userpassword");
			
			Login userLogin = new Login(Fname, Lname, login, password);

			session.saveOrUpdate(userLogin);
			transaction.commit();
					
			out.println("</body></html>");
			
			request.getSession().setAttribute("FName", Fname);
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("There is an error in hinernate functionality!");

		} finally {

			session.close();
						
			response.sendRedirect("start.jsp");
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out= response.getWriter();
		out.println("<html><body>");
				
		SessionFactory factory= hibernateUtil.getSessionFactory();
		Session session= factory.openSession();
				
		Transaction transaction=null;
		 try {
			  transaction = session.beginTransaction();
			 			  
			  List<Login> logininfo= session.createQuery("from Login").list();
			  
			  if(logininfo!=null && logininfo.size()>0) {
				 
				  
			  String Userlog1= request.getParameter("ulogin");
			  String Userpass1= request.getParameter("passwd");
			  request.getSession().setAttribute("UserLog1", Userlog1);
			  request.getSession().setAttribute("UserPass1", Userpass1);
			  
			 
			  for (Login lg:logininfo) {
				   if (lg.getUlogin().equals(Userlog1)) {
				  String userLog=lg.getUlogin();
				  String userPass= lg.getUpassword();
				  String firstnm= lg.getUfname();
				 
				  request.getSession().setAttribute("UserLog", userLog);
				  request.getSession().setAttribute("UserPass", userPass);
				  request.getSession().setAttribute("FName", firstnm);
				   }
			  	}
			  }
			  
			
			  transaction.commit();
			  
			 
		 }
		catch(Exception ex) {
			 
			 ex.printStackTrace();
			 System.err.println("Error in hibernate functionality!");
			 
		 }finally {
			 
			 session.close();
			 response.sendRedirect("login.jsp");
		 }
			
	}

}
