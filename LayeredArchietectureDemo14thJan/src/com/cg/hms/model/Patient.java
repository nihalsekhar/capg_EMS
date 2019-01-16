package com.cg.hms.model;

import java.util.Date;

public class Patient {

	private Integer id;
	private String name;
	private String gender;
	private Long phone;
	private Date appointmentDate;
	private String problem;
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", problem=" + problem + ", phone=" + phone
				+ ", appointmentDate=" + appointmentDate + "]";
	}
	public Patient(Integer id, String name, String gender, String problem,
			Long phone, Date appointmentDate) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.problem = problem;
		this.phone = phone;
		this.appointmentDate = appointmentDate;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
}
