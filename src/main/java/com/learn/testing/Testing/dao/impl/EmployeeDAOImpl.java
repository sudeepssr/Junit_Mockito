package com.learn.testing.Testing.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.learn.testing.Testing.dao.EmployeeDAO;
import com.learn.testing.Testing.model.AddressEntity;
import com.learn.testing.Testing.model.EmployeeEntity;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	public Map<String, EmployeeEntity> employeeRepo = null;
	public Map<String, AddressEntity> addressRepo = null;

	@Override
	public EmployeeEntity getEmployeeDetailsFromRepo(String employeeId) throws Exception {
		
		if (employeeRepo == null) {
			initEmployeeRepo();
		}
		return employeeRepo.get(employeeId);
	}
	
	@Override
	public AddressEntity getAddressDetailsFromRepo(String addressId) throws Exception {
		
		if (addressRepo == null) {
			initAddressRepo();
		}
		return addressRepo.get(addressId);
	}
	
	@Override
	public EmployeeEntity deleteEmployeeDetailsFromRepo(String employeeId) throws Exception {
		
		if (employeeRepo == null) {
			initEmployeeRepo();
		}
		EmployeeEntity employeeEntity=employeeRepo.get(employeeId);
		employeeRepo.remove(employeeId);
		return employeeEntity;
	}
	
	@Override
	public AddressEntity deleteAddressDetailsFromRepo(String addressId) throws Exception {
		
		if (addressRepo == null) {
			initAddressRepo();
		}
		AddressEntity addressEntity=addressRepo.get(addressId);
		addressRepo.remove(addressId);
		return addressEntity;
	}
	
	@Override
	public EmployeeEntity addEmployeeDetailsToRepo(EmployeeEntity employeeEntity) throws Exception {
		
		if (employeeRepo == null) {
			initEmployeeRepo();
		}
		employeeRepo.put(employeeEntity.getEmployeeId(), employeeEntity);
		return employeeRepo.get(employeeEntity.getEmployeeId());
	}
	
	@Override
	public AddressEntity addAddressDetailsToRepo(AddressEntity addressEntity) throws Exception {
		
		if (addressRepo == null) {
			initAddressRepo();
		}
		addressRepo.put(addressEntity.getAddressId(), addressEntity);
		return addressRepo.get(addressEntity.getAddressId());
	}

	private void initEmployeeRepo() {
		employeeRepo = new HashMap<>();
		employeeRepo.put("11111", new EmployeeEntity("Sudeep", "Singh", "11111", "66666"));
		employeeRepo.put("22222", new EmployeeEntity("Sudeep", "Singh", "22222", "77777"));
		employeeRepo.put("33333", new EmployeeEntity("Sudeep", "Singh", "33333", "88888"));
		employeeRepo.put("44444", new EmployeeEntity("Sudeep", "Singh", "44444", "99999"));
		employeeRepo.put("55555", new EmployeeEntity("Sudeep", "Singh", "55555", "97986"));
	}

	private void initAddressRepo() {
		addressRepo = new HashMap<>();
		addressRepo.put("66666", new AddressEntity("219", "RF-219", "Kankarbagh", "800020", "Bihar", "66666"));
		addressRepo.put("77777", new AddressEntity("219", "RF-219", "Kankarbagh", "800020", "Bihar", "77777"));
		addressRepo.put("88888", new AddressEntity("219", "RF-219", "Kankarbagh", "800020", "Bihar", "88888"));
		addressRepo.put("99999", new AddressEntity("219", "RF-219", "Kankarbagh", "800020", "Bihar", "99999"));
		addressRepo.put("97986", new AddressEntity("219", "RF-219", "Kankarbagh", "800020", "Bihar", "97986"));
	}

}
