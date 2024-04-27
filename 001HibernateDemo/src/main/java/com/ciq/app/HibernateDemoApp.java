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
		
		Student student = new Student(1002, "Raja", 30000.00);
		session.persist(student);
		
	//	session.merge(student);
		
		
//		session.delete(student);
		
		
//		Student student2 =  session.get(Student.class, 1001);
//		
//		System.out.println(student2);
		
		
		transaction.commit();
		
		session.close();
		
		
	}

}
