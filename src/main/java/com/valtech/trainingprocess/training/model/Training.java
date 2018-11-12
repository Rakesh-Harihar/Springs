package com.valtech.trainingprocess.training.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Training {
	private int trainingId;

	private String category;

	@NotEmpty(message = "This Field cannot be left empty")
	private String topic;

	private int numberOfPeople;

	private String remarks;

	private String tentativeStartDate;

	private String vendorName;

	private String trainerName;

	private int vendorId;

	private int trainerId;

	@NotEmpty(message = "This Field cannot be left empty")
	private String startDate;

	@NotEmpty(message = "This Field cannot be left empty")
	private String endDate;

	private String status;

	private int statusId;

	private String createdBy;

	private String updatedBy;

	private byte[] trainingToc;
	
	private String trainingFile;

	private String trainingFileName;
	
	private byte[] trainerToc;

	private String trainerTableOfContent;

	private String trainerTocFileName;

	private byte[] profile;

	private String trainerProfile;

	private String profileFileName;

	public Training() {

	}

	public Training(int trainingId, String category, String topic, int numberOfPeople, String remarks,
			String tentativeStartDate, String vendorName, String trainerName, String startDate, String endDate,
			String status, String createdBy, String updatedBy, String trainingFile, String trainingFileName) {
		this.trainingId = trainingId;
		this.category = category;
		this.topic = topic;
		this.numberOfPeople = numberOfPeople;
		this.remarks = remarks;
		this.tentativeStartDate = tentativeStartDate;
		this.vendorName = vendorName;
		this.trainerName = trainerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.trainingFile = trainingFile;
		this.trainingFileName = trainingFileName;
	}
	



	

	public Training(int trainingId, String category, String topic, int numberOfPeople, String remarks,
			String tentativeStartDate, String vendorName, String trainerName, int vendorId, int trainerId,
			String startDate, String endDate, String status, int statusId, String createdBy, String updatedBy,
			String trainingFile, String trainingFileName, String trainerTableOfContent, String trainerTocFileName,
			String trainerProfile, String profileFileName) {
		this.trainingId = trainingId;
		this.category = category;
		this.topic = topic;
		this.numberOfPeople = numberOfPeople;
		this.remarks = remarks;
		this.tentativeStartDate = tentativeStartDate;
		this.vendorName = vendorName;
		this.trainerName = trainerName;
		this.vendorId = vendorId;
		this.trainerId = trainerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.statusId = statusId;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.trainingFile = trainingFile;
		this.trainingFileName = trainingFileName;
		this.trainerTableOfContent = trainerTableOfContent;
		this.trainerTocFileName = trainerTocFileName;
		this.trainerProfile = trainerProfile;
		this.profileFileName = profileFileName;
	}

	public byte[] getTrainerToc() {
		return trainerToc;
	}

	public void setTrainerToc(byte[] trainerToc) {
		this.trainerToc = trainerToc;
	}

	public String getTrainerTableOfContent() {
		return trainerTableOfContent;
	}

	public void setTrainerTableOfContent(String trainerTableOfContent) {
		this.trainerTableOfContent = trainerTableOfContent;
	}

	public String getTrainerTocFileName() {
		return trainerTocFileName;
	}

	public void setTrainerTocFileName(String trainerTocFileName) {
		this.trainerTocFileName = trainerTocFileName;
	}

	public byte[] getTrainingToc() {
		return trainingToc;
	}

	public void setTrainingToc(byte[] trainingToc) {
		this.trainingToc = trainingToc;
	}

	public String getTrainingFile() {
		return trainingFile;
	}

	public void setTrainingFile(String trainingFile) {
		this.trainingFile = trainingFile;
	}

	public String getTrainingFileName() {
		return trainingFileName;
	}

	public void setTrainingFileName(String trainingFileName) {
		this.trainingFileName = trainingFileName;
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

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTentativeStartDate() {
		return tentativeStartDate;
	}

	public void setTentativeStartDate(String tentativeStartDate) {
		this.tentativeStartDate = tentativeStartDate;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", category=" + category + ", topic=" + topic
				+ ", numberOfPeople=" + numberOfPeople + ", remarks=" + remarks + ", tentativeStartDate="
				+ tentativeStartDate + ", vendorName=" + vendorName + ", trainerName=" + trainerName + ", vendorId="
				+ vendorId + ", trainerId=" + trainerId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", status=" + status + ", statusId=" + statusId + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + "]";
	}

}
