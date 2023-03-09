package com.zkteco.service;

import com.zkteco.entity.Employee;

public interface EmployeeService {

	public Employee createEmployee(Employee employee);
	
	public Employee getEmployeeById(Long employeeId);
	
	public Employee updateEmployee(Long employeeId, Employee employee);
	
	public void deleteEmployeeById(Long employeeId);
}
