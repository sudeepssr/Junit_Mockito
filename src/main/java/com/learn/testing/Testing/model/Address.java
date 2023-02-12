package com.learn.testing.Testing.model;

public class Address {
	String houseNo;
	String firstLine;
	String secondLine;
	String pinCode;
	String state;

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

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", firstLine=" + firstLine + ", secondLine=" + secondLine + ", pinCode="
				+ pinCode + ", state=" + state + "]";
	}

	public Address(String houseNo, String firstLine, String secondLine, String pinCode, String state) {
		super();
		this.houseNo = houseNo;
		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.pinCode = pinCode;
		this.state = state;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

}
