package com.visionjava.SpringEmail.model;

import java.util.Date;

public class Student {
	private String firstName;
	private String lastName;
	private Date datEnrolled;
	private Double marksPercentage;

	public Student(String firstName, String lastName, Double marksPercentage,
			Date datEnrolled) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.datEnrolled = datEnrolled;
		this.marksPercentage = marksPercentage;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDatEnrolled() {
		return datEnrolled;
	}

	public void setDatEnrolled(Date datEnrolled) {
		this.datEnrolled = datEnrolled;
	}

	public Double getMarksPercentage() {
		return marksPercentage;
	}

	public void setMarksPercentage(Double marksPercentage) {
		this.marksPercentage = marksPercentage;
	}

	
}
