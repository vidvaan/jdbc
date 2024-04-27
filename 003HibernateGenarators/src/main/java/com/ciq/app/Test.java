package com.ciq.app;

import java.util.Iterator;
import java.util.List;

import com.ciq.dao.EmployeeDAO;
import com.ciq.dao.EmployeeDAOImpl;
import com.ciq.entity.Employee;

public class Test {
	
	public static void main(String[] args) {
		
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
        
		
		Employee e1 = new Employee();
		e1.setEname("Balaji");
		e1.setEsal(50000.00);
		
		Employee e2 = new Employee();
		e2.setEname("Rama");
		e2.setEsal(50000.00);
		
		
		Employee e3 = new Employee();
		e3.setEname("Raju");
		e3.setEsal(50000.00);
		
		Employee e4 = new Employee();
		e4.setEname("Roy");
		e4.setEsal(50000.00);
		
		Employee e5 = new Employee();
		e5.setEname("Tom");
		e5.setEsal(50000.00);
		
		
		employeeDAO.add(e1);
		employeeDAO.add(e2);
		employeeDAO.add(e3);
		employeeDAO.add(e4);
		employeeDAO.add(e5);
		
		
		System.out.println("Done");
		
		
	}

}
