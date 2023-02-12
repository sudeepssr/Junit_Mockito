package com.learn.testing.Testing.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.testing.Testing.model.Employee;
import com.learn.testing.Testing.model.ErrorMessage;
import com.learn.testing.Testing.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employee")
	public Employee getEmployee(@RequestParam String employeeId) {
		Employee employee = null;
		try {
			employee = employeeService.getEmployeeDetails(employeeId);
		} catch (Exception e) {
			employee = new Employee();
			employee.setMessage(new ErrorMessage("ER1234", e.getMessage()));
		}
		return employee;
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee employeeFromRepo = null;
		try {
			employeeFromRepo = employeeService.addEmployeeDetails(employee);
		} catch (Exception e) {
			e.printStackTrace();
			employeeFromRepo = new Employee();
			employeeFromRepo.setMessage(new ErrorMessage("ER1234", e.getMessage()));
		}
		return employeeFromRepo;
	}
	
	@DeleteMapping("/employee")
	public Employee deleteEmployee(@RequestParam String employeeId) {
		Employee employeeFromRepo = null;
		try {
			employeeFromRepo = employeeService.deleteEmployeeDetails(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
			employeeFromRepo = new Employee();
			employeeFromRepo.setMessage(new ErrorMessage("ER1234", e.getMessage()));
		}
		return employeeFromRepo;
	}

}
