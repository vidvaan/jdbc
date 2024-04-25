package com.ciq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ciq.entity.Employee;
import com.ciq.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void add(Employee employee) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO EMP_TAB VALUES(?,?,?)");
			preparedStatement.setInt(1, employee.getEid());
			preparedStatement.setString(2, employee.getEname());
			preparedStatement.setDouble(3, employee.getEsal());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}

	}

	@Override
	public void update(Employee employee) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE EMP_TAB SET ENAME = ? , ESAL = ? WHERE EID = ?");
			preparedStatement.setString(1, employee.getEname());
			preparedStatement.setDouble(2, employee.getEsal());
			preparedStatement.setInt(3, employee.getEid());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}

	}

	@Override
	public void deleteById(int eid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM EMP_TAB WHERE EID = ?");
			preparedStatement.setInt(1, eid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}

	}

	@Override
	public Employee findById(int eid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM EMP_TAB WHERE EID = ?");
			preparedStatement.setInt(1, eid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setEid(resultSet.getInt("EID"));
				employee.setEname(resultSet.getString("ENAME"));
				employee.setEsal(resultSet.getDouble("ESAL"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = null;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM EMP_TAB");
			resultSet = preparedStatement.executeQuery();
			employees = new ArrayList<>();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEid(resultSet.getInt("EID"));
				employee.setEname(resultSet.getString("ENAME"));
				employee.setEsal(resultSet.getDouble("ESAL"));
				employees.add(employee);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}
		return employees;
	}

}
