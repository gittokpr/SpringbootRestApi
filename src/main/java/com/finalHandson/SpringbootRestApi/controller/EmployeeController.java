package com.finalHandson.SpringbootRestApi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalHandson.SpringbootRestApi.Exceptions.ResourceNotFoundException;
import com.finalHandson.SpringbootRestApi.model.Employee;
import com.finalHandson.SpringbootRestApi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee ) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity< Employee > getEmployee(@PathVariable("id") Long id) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(employeeService.getEmployee(id));
	}
	
	@DeleteMapping("/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable("id") Long id) throws ResourceNotFoundException{
		return employeeService.deleteEmployee(id);
	}
}
