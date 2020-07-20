package com.finalHandson.SpringbootRestApi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finalHandson.SpringbootRestApi.Exceptions.ResourceNotFoundException;
import com.finalHandson.SpringbootRestApi.dao.EmployeeRepository;
import com.finalHandson.SpringbootRestApi.model.Employee;

@Service
public class EmployeeService {

	private EmployeeRepository repository;

	@Autowired
	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return (List<Employee>) repository.findAll();
	}

	public Employee getEmployee(Long id) throws ResourceNotFoundException {
		Employee employee = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not Found"));
		return employee;
	}

	public java.util.Map<String, Boolean> deleteEmployee(Long id) throws ResourceNotFoundException {
		Employee employee = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not Found"));
		repository.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
	
}
