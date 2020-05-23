package com.stackroute.spring.hibernate.dao;

import java.util.List;

import com.stackroute.spring.hibernate.entity.Employee;

public interface IEmployeeDAO {
	public Employee saveEmployee(Employee employee);
	public Employee getEmployeeById(int empId);
	public List<Employee> getAllEmployees();
	public boolean deleteEmployee(int empId);
	public Employee updateEmployee(Employee employee);
}
