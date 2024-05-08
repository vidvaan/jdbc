package com.ciq.app;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ciq.entity.Address;
import com.ciq.entity.Department;
import com.ciq.entity.Employee;
import com.ciq.entity.Organization;
import com.ciq.entity.Project;
import com.ciq.util.SessionUtil;

public class SaveDemo {

	public static void main(String[] args) {

		Session session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();

		Address address1 = new Address();
		address1.setAloc("SKLM");

		Address address2 = new Address();
		address2.setAloc("HYD");

		Address address3 = new Address();
		address3.setAloc("BNG");

		Address address4 = new Address();
		address4.setAloc("CHE");

		Department department1 = new Department();
		department1.setDname("IT");

		Department department2 = new Department();
		department2.setDname("OPS");

		Project project1 = new Project();
		project1.setPname("SMS");

		Project project2 = new Project();
		project2.setPname("EMS");

		List<Project> projects = Arrays.asList(new Project[] { project1, project2 });

		Employee employee1 = new Employee();
		employee1.setEname("Balaji");
		employee1.setEsal(200000.00);
		employee1.setAddress(address1);
		employee1.setDepartment(department1);
		employee1.setProjects(projects);

		Employee employee2 = new Employee();
		employee2.setEname("Rama");
		employee2.setEsal(200000.00);
		employee2.setAddress(address2);
		employee2.setDepartment(department1);
		employee2.setProjects(projects);

		Employee employee3 = new Employee();
		employee3.setEname("Raja");
		employee3.setEsal(200000.00);
		employee3.setAddress(address3);
		employee3.setDepartment(department2);
		employee3.setProjects(projects);

		Employee employee4 = new Employee();
		employee4.setEname("Tom");
		employee4.setEsal(200000.00);
		employee4.setAddress(address4);
		employee4.setDepartment(department2);
		employee4.setProjects(projects);

		Organization organization = new Organization();
		organization.setOname("CIQ");
		List<Department> departments = Arrays.asList(new Department[] { department1, department2 });
		organization.setDepartments(departments);

		session.persist(organization);

		session.persist(employee1);
		session.persist(employee2);
		session.persist(employee3);
		session.persist(employee4);

		transaction.commit();

		SessionUtil.close(session);

	}

}
