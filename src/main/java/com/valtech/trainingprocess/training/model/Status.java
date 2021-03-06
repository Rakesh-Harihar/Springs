package com.valtech.trainingprocess.training.model;

public class Status {

	private int statusId;

	private String status;

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Status(int statusId, String status) {
		this.statusId = statusId;
		this.status = status;
	}

	public Status() {
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", status=" + status + "]";
	}
}
