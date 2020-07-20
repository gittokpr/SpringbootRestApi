package com.finalHandson.SpringbootRestApi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finalHandson.SpringbootRestApi.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
