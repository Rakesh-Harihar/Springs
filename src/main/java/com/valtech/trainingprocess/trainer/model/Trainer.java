package com.valtech.trainingprocess.trainer.model;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Trainer {

	private int trainerId;

/*	@NotEmpty(message = "This Field cannot be left empty")*/
	private String trainerName;

	/*@NotEmpty(message = "This Field cannot be left empty")*/
	private String subject;

	private byte[] toc;

	private String tableOfContent;

	private String tocFileName;

	private byte[] profile;

	private String trainerProfile;

	private String profileFileName;

	private String address1;

	private String address2;

	private String city;

	private String state;

	private int vendorId;

	/*@NotNull(message = "This Field cannot be left empty")*/
	private int pincode;

	
	private String vendorName;

	/*@NotEmpty(message = "This Field cannot be left empty")*/
	private String phone;

	private String createdBy;

	private String modifiedBy;

	public Trainer() {
	}

	public Trainer(String trainerName, String subject, String tableOfContent, String trainerProfile, String address1,
			String address2, String city, String state, int vendorId, int pincode, String vendorName, String phone,
			int trainerId, String tocFileName, String profileFileName) {
		this.trainerName = trainerName;
		this.subject = subject;
		this.tableOfContent = tableOfContent;
		this.trainerProfile = trainerProfile;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.vendorId = vendorId;
		this.pincode = pincode;
		this.vendorName = vendorName;
		this.phone = phone;
		this.trainerId = trainerId;
		this.tocFileName = tocFileName;
		this.profileFileName = profileFileName;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public byte[] getToc() {
		return toc;
	}

	public void setToc(byte[] toc) {
		this.toc = toc;
	}

	public String getTableOfContent() {
		return tableOfContent;
	}

	public void setTableOfContent(String tableOfContent) {
		this.tableOfContent = tableOfContent;
	}

	public String getTocFileName() {
		return tocFileName;
	}

	public void setTocFileName(String tocFileName) {
		this.tocFileName = tocFileName;
	}

	public byte[] getProfile() {
		return profile;
	}

	public void setProfile(byte[] profile) {
		this.profile = profile;
	}

	public String getTrainerProfile() {
		return trainerProfile;
	}

	public void setTrainerProfile(String trainerProfile) {
		this.trainerProfile = trainerProfile;
	}

	public String getProfileFileName() {
		return profileFileName;
	}

	public void setProfileFileName(String profileFileName) {
		this.profileFileName = profileFileName;
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

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", subject=" + subject + ", toc="
				+ Arrays.toString(toc) + ", tableOfContent=" + tableOfContent + ", tocFileName=" + tocFileName
				+ ", profile=" + Arrays.toString(profile) + ", trainerProfile=" + trainerProfile + ", profileFileName="
				+ profileFileName + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state="
				+ state + ", vendorId=" + vendorId + ", pincode=" + pincode + ", vendorName=" + vendorName + ", phone="
				+ phone + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
	}

}
