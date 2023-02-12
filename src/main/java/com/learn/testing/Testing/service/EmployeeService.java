package com.learn.testing.Testing.service;

import com.learn.testing.Testing.model.Employee;

public interface EmployeeService {

	public Employee getEmployeeDetails(String employeeId) throws Exception;

	public Employee addEmployeeDetails(Employee employee) throws Exception;

	public Employee deleteEmployeeDetails(String employeeId) throws Exception;

}
