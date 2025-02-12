package com.ems.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		 return empRepo.save(emp);
	}

	@Override
	public Employee getEmplbyID(long id) { 
		Optional<Employee> employee =  empRepo.findById(id);
		if(employee.isPresent()){
			return employee.get();
		}
		return null;
	}

	@Override
	public boolean deleteEmpByID(long id) {
		Optional<Employee> emp = empRepo.findById(id);
		if(emp.isPresent()) {
			empRepo.deleteById(id);
			return true;
		}
		return false;
		
	}

}
