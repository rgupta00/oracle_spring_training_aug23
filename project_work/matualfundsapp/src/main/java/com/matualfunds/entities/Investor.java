package com.matualfunds.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invertor_table")
public class Investor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int investorId;
	private String name;
	private String mobileNo;
	private String email;
	private String address;
	private String password;
	
	
	
	
	public Investor() {}
	
	
	public Investor(String name, String mobileNo, String email, String address, String password) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.password = password;
	}




	public Investor(int investorId, String name, String mobileNo, String email, String address, String password) {
		super();
		this.investorId = investorId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.password = password;
	}
	public int getInvestorId() {
		return investorId;
	}
	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
