package com.ciq.app;

import org.hibernate.Session;

import com.ciq.entity.Department;
import com.ciq.util.SessionUtil;

public class SelectDataDemo {
	public static void main(String[] args) {
		Session session = SessionUtil.getSession();

		   Department department = session.get(Department.class, 1);
		  System.out.println(department.getEmployees());
		SessionUtil.close(session);
	}
}
