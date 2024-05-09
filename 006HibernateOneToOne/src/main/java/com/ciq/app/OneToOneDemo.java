package com.ciq.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ciq.entity.Address;
import com.ciq.entity.Employee;
import com.ciq.util.SessionUtil;

public class OneToOneDemo {
	public static void main(String[] args) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEname("Balaji");
		employee.setEsal(200000.00);

		Address address = new Address();
		address.setAloc("SKLM");

		employee.setAddress(address);
		
		session.persist(employee);

		transaction.commit();
		SessionUtil.close(session);
	}
}
