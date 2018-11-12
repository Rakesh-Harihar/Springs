package com.valtech.trainingprocess.vendor.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Vendor {

	private int vendorId;

	@NotEmpty(message = "This Field cannot be left empty")
	private String vendorName;

	@NotEmpty(message = "This Field cannot be left empty")
	private String address1;

	private String address2;

	@NotEmpty(message = "This Field cannot be left empty")
	private String city;

	@NotEmpty(message = "This Field cannot be left empty")
	private String state;

	@NotNull(message = "This Field cannot be left empty")
	private int pincode;

	@NotEmpty(message = "This Field cannot be left empty")
	private String mobile;

	private String offtel;

	@NotEmpty(message = "This Field cannot be left empty")
	private String email;

	private String altemail;

	private String name1;

	private String email1;

	private String mobile1;

	private String name2;

	private String mobile2;

	private String email2;

	private String createdBy;

	private String modifiedBy;

	public Vendor() {

	}

	public Vendor(int vendorId, String vendorName, String address1, String address2, String city, String state,
			int pincode, String mobile, String offtel, String email, String altemail, String name1, String email1,
			String mobile1, String name2, String email2, String mobile2) {
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobile = mobile;
		this.offtel = offtel;
		this.email = email;
		this.altemail = altemail;
		this.name1 = name1;
		this.email1 = email1;
		this.mobile1 = mobile1;
		this.name2 = name2;
		this.email2 = email2;
		this.mobile2 = mobile2;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOfftel() {
		return offtel;
	}

	public void setOfftel(String offtel) {
		this.offtel = offtel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAltemail() {
		return altemail;
	}

	public void setAltemail(String altemail) {
		this.altemail = altemail;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", address1=" + address1 + ", address2="
				+ address2 + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", mobile=" + mobile
				+ ", offtel=" + offtel + ", email=" + email + ", altemail=" + altemail + ", name1=" + name1
				+ ", email1=" + email1 + ", mobile1=" + mobile1 + ", name2=" + name2 + ", mobile2=" + mobile2
				+ ", email2=" + email2 + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
	}

}
