package com.learn.testing.Testing.dao;

import com.learn.testing.Testing.model.AddressEntity;
import com.learn.testing.Testing.model.EmployeeEntity;

public interface EmployeeDAO {

	public EmployeeEntity getEmployeeDetailsFromRepo(String employeeId) throws Exception;

	public AddressEntity getAddressDetailsFromRepo(String addressId) throws Exception;

	public AddressEntity addAddressDetailsToRepo(AddressEntity addressEntity) throws Exception;

	public EmployeeEntity addEmployeeDetailsToRepo(EmployeeEntity employeeEntity) throws Exception;

	public AddressEntity deleteAddressDetailsFromRepo(String addressId) throws Exception;

	public EmployeeEntity deleteEmployeeDetailsFromRepo(String employeeId) throws Exception;

}
