package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee emp);
	
	Employee getEmplbyID(long id);
	
	boolean deleteEmpByID(long id);
	
}
