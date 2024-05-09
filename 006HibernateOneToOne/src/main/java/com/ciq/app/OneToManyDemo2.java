package com.ciq.app;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ciq.entity.Address;
import com.ciq.entity.Department;
import com.ciq.entity.Employee;
import com.ciq.util.SessionUtil;

public class OneToManyDemo2 {
	public static void main(String[] args) {
		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Department department = new Department();
		department.setDname("IT");

		Employee employee1 = new Employee();
		employee1.setEname("Balaji");
		employee1.setEsal(200000.00);

		Address address1 = new Address();
		address1.setAloc("SKLM");

		employee1.setAddress(address1);

		Employee employee2 = new Employee();
		employee2.setEname("Ram");
		employee2.setEsal(200000.00);

		Address address2 = new Address();
		address2.setAloc("HYD");

		employee2.setAddress(address2);

		department.setEmployees(Arrays.asList(new Employee[] { employee1, employee2 }));
		
		session.persist(department);

		transaction.commit();
		SessionUtil.close(session);
	}
}
