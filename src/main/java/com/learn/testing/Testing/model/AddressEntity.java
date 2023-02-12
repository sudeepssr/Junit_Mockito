package com.learn.testing.Testing.model;

public class AddressEntity {
	String houseNo;
	String firstLine;
	String secondLine;
	String pinCode;
	String state;
	String addressId;

	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressEntity(String houseNo, String firstLine, String secondLine, String pinCode, String state,
			String addressId) {
		super();
		this.houseNo = houseNo;
		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.pinCode = pinCode;
		this.state = state;
		this.addressId = addressId;
	}


	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "AddressEntity [houseNo=" + houseNo + ", firstLine=" + firstLine + ", secondLine=" + secondLine
				+ ", pinCode=" + pinCode + ", state=" + state + ", addressId=" + addressId + "]";
	}

}
