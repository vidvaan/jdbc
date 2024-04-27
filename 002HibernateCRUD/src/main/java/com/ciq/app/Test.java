package com.ciq.app;

import java.util.Iterator;
import java.util.List;

import com.ciq.dao.EmployeeDAO;
import com.ciq.dao.EmployeeDAOImpl;
import com.ciq.entity.Employee;

public class Test {
	
	public static void main(String[] args) {
		
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
//		
//		Employee employee = new Employee();
//		employee.setEid(6);
//		employee.setEname("Mahesh G");
//		employee.setEsal(50000.00);
//		employeeDAO.add(employee);
		
		
//		
//		employeeDAO.update(employee);
		
//		employeeDAO.deleteById(6);
		
		
//		Employee employee = employeeDAO.findById(1);
//		
//		System.out.println(employee);
		
		
		List<Employee> employees = employeeDAO.findAll();
		
		for(Employee employee : employees) {
			System.out.println(employee);
		}
		
		System.out.println("Done");
		
		
	}

}
