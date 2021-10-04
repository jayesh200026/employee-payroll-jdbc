package com.payrollservice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Employee {

	int id;
	String name;
	String gender;
	double salary;
	LocalDate startDate;

	public Employee() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Employee(int id, String name, String gender, double salary, LocalDate startDate) {

		this.id = id;
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.startDate = startDate;
	}

}
