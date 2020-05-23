package com.stackroute.spring.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stackroute.spring.hibernate.dao.IEmployeeDAO;
import com.stackroute.spring.hibernate.entity.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeDAO employeeDao;
	
	@GetMapping("/")
	public String getHomePage(ModelMap modelMap) {
		modelMap.addAttribute("employeeList", this.employeeDao.getAllEmployees());
		
		return "index";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
		Employee createdEmployee = this.employeeDao.saveEmployee(employee);
		modelMap.addAttribute("employeeList", this.employeeDao.getAllEmployees());
		
		return "index";
	}
	
	@GetMapping("/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam("empId") int empId) {
		ModelAndView modelAndView = new ModelAndView("index");
		this.employeeDao.deleteEmployee(empId);
		modelAndView.addObject("employeeList", this.employeeDao.getAllEmployees());
		return modelAndView;
	}

}
