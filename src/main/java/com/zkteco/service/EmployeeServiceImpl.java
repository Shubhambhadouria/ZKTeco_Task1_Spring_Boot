package com.zkteco.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkteco.entity.Employee;
import com.zkteco.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public Employee updateEmployee(Long employeeId, Employee employee) {
		
		Employee emp = employeeRepository.findById(employeeId).get();
		
		if(Objects.nonNull(employee.getFirstName()) && 
			!"".equalsIgnoreCase(employee.getFirstName())) {
			emp.setFirstName(employee.getFirstName());
			}
				
		if(Objects.nonNull(employee.getLastName()) && 
			!"".equalsIgnoreCase(employee.getLastName())) {
			emp.setLastName(employee.getLastName());	
			}
				
		if(Objects.nonNull(employee.getEmail()) && 
			!"".equalsIgnoreCase(employee.getEmail())) {
			emp.setEmail(employee.getEmail());;
			}
		
		if(Objects.nonNull(employee.getPhone()) && 
				!"".equalsIgnoreCase(employee.getPhone())) {
				emp.setPhone(employee.getPhone());;
			}

		if(Objects.nonNull(employee.getDateOfBirth())) {
				emp.setDateOfBirth(employee.getDateOfBirth());;
			}
		
		if(Objects.nonNull(employee.getGender())) {
			emp.setGender(employee.getGender());;
		}
		
		return employeeRepository.save(emp);
		
	}

	@Override
	public void deleteEmployeeById(Long employeeId) {
		employeeRepository.deleteById(employeeId);
		
	}

}
