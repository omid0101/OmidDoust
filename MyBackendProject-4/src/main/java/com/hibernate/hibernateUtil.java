package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entities.Schoolcls;
import com.entities.Student;
import com.entities.Subject;
import com.entities.Teacher;
import com.loginentity.Login;


public class hibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		
		try {

			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
										
					.addAnnotatedClass(Student.class)
					.addAnnotatedClass(Schoolcls.class)
					.addAnnotatedClass(Subject.class)
     				.addAnnotatedClass(Teacher.class)
     				.addAnnotatedClass(Login.class)
					.buildSessionFactory();
			

			return sessionFactory;

		} catch (Throwable ex) {
			
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
