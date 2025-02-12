package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping("/tcs/v1/")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(empService.saveEmployee(emp), HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/employee")
	public ResponseEntity<Employee> fetchAllEmployees() {
		return new ResponseEntity(empService.getAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> searchEmplById(@PathVariable long id) {
		return new ResponseEntity<Employee>(empService.getEmplbyID(id), HttpStatus.OK);
	}

	@DeleteMapping("/employee/{id}")
	public HttpStatus delEmplById(@PathVariable long id) {
		boolean isDeleted = empService.deleteEmpByID(id);
		return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;

		// return new ResponseEntity(empService.deleteEmpByID(id), HttpStatus.OK);
	}

}
