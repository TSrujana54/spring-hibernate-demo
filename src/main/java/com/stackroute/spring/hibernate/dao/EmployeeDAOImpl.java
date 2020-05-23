package com.stackroute.spring.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.spring.hibernate.entity.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		Employee createdEmployee = null;
		
		try {
			 this.sessionFactory.getCurrentSession().save(employee);
			  createdEmployee = employee;
		} catch (Exception e) {
			createdEmployee = null;
		}
	 
		
		return createdEmployee;
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return this.sessionFactory.getCurrentSession().load(Employee.class, empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		//HQL 
		return this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public boolean deleteEmployee(int empId) {
	Employee employeeToBeDeleted = 	this.sessionFactory.getCurrentSession().load(Employee.class, empId);
		this.sessionFactory.getCurrentSession().delete(employeeToBeDeleted);
		return true;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
