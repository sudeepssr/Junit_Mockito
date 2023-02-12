package com.learn.testing.Testing.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.testing.Testing.dao.EmployeeDAO;
import com.learn.testing.Testing.model.Address;
import com.learn.testing.Testing.model.AddressEntity;
import com.learn.testing.Testing.model.Employee;
import com.learn.testing.Testing.model.EmployeeEntity;
import com.learn.testing.Testing.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public Employee getEmployeeDetails(String employeeId) throws Exception {
		AddressEntity addrEntity = null;

		if (employeeId == null) {
			throw new Exception("EmployeeId not valid");
		}

		EmployeeEntity empEntity = employeeDAO.getEmployeeDetailsFromRepo(employeeId);

		if (empEntity != null) {
			addrEntity = employeeDAO.getAddressDetailsFromRepo(empEntity.getAddressId());
			if (addrEntity == null) {
				throw new Exception("Address Not Found");
			}
		} else {
			throw new Exception("User Not Found");
		}
		Employee employee = generateEmployeeData(empEntity, addrEntity);
		return employee;

	}

	@Override
	public Employee addEmployeeDetails(Employee employee) throws Exception {
		if (employee != null) {
			EmployeeEntity employeeFromRepo = employeeDAO.getEmployeeDetailsFromRepo(employee.getEmployeeId());
			if (employeeFromRepo != null) {
				throw new Exception("User Already Present");
			} else {
				AddressEntity addressEntityForDB = generateAddressEntity(employee.getAddress());
				EmployeeEntity employeeEntityForDB = generateEmployeeEntity(employee,
						addressEntityForDB.getAddressId());

				EmployeeEntity employeeEntitySavedToDB = employeeDAO.addEmployeeDetailsToRepo(employeeEntityForDB);
				AddressEntity addressEntitySavedToDB = employeeDAO.addAddressDetailsToRepo(addressEntityForDB);

				Employee employeeSavedToDB = generateEmployeeData(employeeEntitySavedToDB, addressEntitySavedToDB);
				return employeeSavedToDB;
			}
		} else {
			throw new Exception("Employee Data incorrect");
		}

	}

	@Override
	public Employee deleteEmployeeDetails(String employeeId) throws Exception {
		if (employeeId == null) {
			throw new Exception("EmployeeId not valid");
		}
		EmployeeEntity employeeEntity = employeeDAO.getEmployeeDetailsFromRepo(employeeId);
		if (employeeEntity != null) {
			EmployeeEntity employeeEntityFromDB = employeeDAO.deleteEmployeeDetailsFromRepo(employeeId);
			AddressEntity addressEntityFromDB = employeeDAO.deleteAddressDetailsFromRepo(employeeEntity.getAddressId());
			return generateEmployeeData(employeeEntityFromDB, addressEntityFromDB);
		} else {
			throw new Exception("Employee doesnt exist");
		}
	}

	private AddressEntity generateAddressEntity(Address address) {
		AddressEntity addressEntity = new AddressEntity(address.getHouseNo(), address.getFirstLine(),
				address.getSecondLine(), address.getPinCode(), address.getState(), generateRandomAddressId());
		return addressEntity;
	}

	private EmployeeEntity generateEmployeeEntity(Employee employee, String addressId) {
		EmployeeEntity employeeEntity = new EmployeeEntity(employee.getFirstName(), employee.getLastName(),
				employee.getEmployeeId(), addressId);
		return employeeEntity;
	}

	private String generateRandomAddressId() {
		Random r = new Random();
		int low = 1000000;
		int high = 9999999;
		int result = r.nextInt(high - low) + low;
		return result + "";
	}

	private Employee generateEmployeeData(EmployeeEntity empEntity, AddressEntity addrEntity) {
		Address address = new Address(addrEntity.getHouseNo(), addrEntity.getFirstLine(), addrEntity.getSecondLine(),
				addrEntity.getPinCode(), addrEntity.getState());
		Employee employee = new Employee(empEntity.getFirstName(), empEntity.getLastName(), empEntity.getEmployeeId(),
				address);
		return employee;
	}

}
