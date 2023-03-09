package com.zkteco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zkteco.entity.Employee;
import com.zkteco.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save")
	public Employee saveEmployeeController(@Valid @RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeByIdController(@PathVariable("id") Long Id) {
		return employeeService.getEmployeeById(Id);
	}
	
	@PutMapping("/employee/{id}")
	public Employee getEmployeeByIdController(@PathVariable("id") Long Id,
											  @RequestBody Employee employee) {
	    return employeeService.updateEmployee(Id, employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id) {
		employeeService.deleteEmployeeById(id);
		return "Employee Deleted Successfully!";
	}
}
