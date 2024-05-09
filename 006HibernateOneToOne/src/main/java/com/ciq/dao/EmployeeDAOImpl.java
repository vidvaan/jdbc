package com.ciq.dao;

import java.util.List;

import org.hibernate.Session;

import com.ciq.entity.Employee;
import com.ciq.util.SessionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void add(Employee employee) {
		Session session = SessionUtil.getSession();
		session.persist(employee);
		session.beginTransaction().commit();

	}

	@Override
	public void update(Employee employee) {
		Session session = SessionUtil.getSession();
		session.merge(employee);
		session.beginTransaction().commit();

	}

	@Override
	public void deleteById(int eid) {
		Employee employee = new Employee();
		employee.setEid(eid);
		Session session = SessionUtil.getSession();
		session.remove(employee);
		session.beginTransaction().commit();
	}

	@Override
	public Employee findById(int eid) {
		return SessionUtil.getSession().get(Employee.class, eid);
	}

	@Override
	public List<Employee> findAll() {
		return SessionUtil.getSession().createQuery("from Employee", Employee.class).list();
	}

}
