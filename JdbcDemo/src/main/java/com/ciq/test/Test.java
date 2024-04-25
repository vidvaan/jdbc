package com.ciq.test;

import java.util.Iterator;
import java.util.List;

import com.ciq.dao.EmployeeDAO;
import com.ciq.dao.EmployeeDAOImpl;
import com.ciq.entity.Employee;

public class Test {
	
	public static void main(String[] args) {
		
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		
//		Employee employee = new Employee();
//		employee.setEid(10);
//		employee.setEname("Raja Updated");
//		employee.setEsal(50000.00);
//		
//		employeeDAO.update(employee);
		
//		employeeDAO.deleteById(23);
		
		
//		Employee employee = employeeDAO.findById(10);
		
//		System.out.println(employee);
		
		
		List<Employee> employees = employeeDAO.findAll();
		
		for(Employee employee : employees) {
			System.out.println(employee);
		}
		
		System.out.println("Done");
		
		
	}

}
