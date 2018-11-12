package com.valtech.trainingprocess.training.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Trainee {
	@NotEmpty(message = "This Field cannot be left empty")
	private String trainingTopic;

	@NotNull(message = "This Field cannot be left empty")
	private int employeeId;

	@NotEmpty(message = "This Field cannot be left empty")
	private String name;

	@NotEmpty(message = "This Field cannot be left empty")
	private String project;

	@NotEmpty(message = "This Field cannot be left empty")
	private String manager;

	private int trainingId;

	public Trainee() {

	}

	public Trainee(int trainingId, int employeeId, String name, String project) {

		this.trainingId = trainingId;
		this.employeeId = employeeId;
		this.name = name;
		this.project = project;
	}

	public Trainee(String trainingTopic, int employeeId, String name, String project, String manager) {
		super();
		this.trainingTopic = trainingTopic;
		this.employeeId = employeeId;
		this.name = name;
		this.project = project;
		this.manager = manager;
	}

	public Trainee(int employeeId, String name, String project) {
		this.employeeId = employeeId;
		this.name = name;
		this.project = project;

	}

	public String getTrainingTopic() {
		return trainingTopic;
	}

	public void setTrainingTopic(String trainingTopic) {
		this.trainingTopic = trainingTopic;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	@Override
	public String toString() {
		return "Trainee [trainingTopic=" + trainingTopic + ", employeeId=" + employeeId + ", name=" + name
				+ ", project=" + project + ", manager=" + manager + "]";
	}

}
