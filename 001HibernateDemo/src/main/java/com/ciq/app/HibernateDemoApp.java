package com.ciq.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ciq.entity.Student;

public class HibernateDemoApp {
	
	public static void main(String[] args) {
		
		
		Configuration configuration =  new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
         Student student1 = session.get(Student.class, 1001);
         Student student2 = session.get(Student.class, 1001);
         Student student3 = session.get(Student.class, 1001);
         
         System.out.println(student1);
         System.out.println(student2);
         System.out.println(student3);
		
		
         Session session2 = sessionFactory.openSession();
		
         Student student4 = session2.get(Student.class, 1001);
         Student student5 = session2.get(Student.class, 1001);
         System.out.println(student4);
         System.out.println(student5);
		
		transaction.commit();
		
		session.close();
		
		
	}

}
