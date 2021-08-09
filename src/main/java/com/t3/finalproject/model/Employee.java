package com.t3.finalproject.model;

/**
 * @author 
 *
 */
public class Employee {
	private int empId;
	private int benefitId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNum;
	private int payGrade;
	private int payStep;
	private boolean isSalaried;
	
	public Employee() {}
	
	/**
	 * @param id
	 * @param benId
	 * @param f
	 * @param l
	 * @param email
	 * @param phone
	 * @param grade
	 * @param step
	 * @param salaried
	 */
	public Employee(int id, int benId, String f, String l, String email, 
			String phone, int grade, int step, boolean salaried) {
		this.empId = id;
		this.benefitId = benId;
		this.firstName = f;
		this.lastName = l;
		this.email = email;
		this.phoneNum = phone;
		this.payGrade = grade;
		this.payStep = step;
		this.isSalaried = salaried;
	}
	
	/**
	 * @param e
	 */
	public Employee(Employee e) {
		this.empId = e.getEmpId();
		this.benefitId = e.getBenefitId();
		this.firstName = e.getFirstName();
		this.lastName = e.getLastName();
		this.email = e.getEmail();
		this.phoneNum = e.getPhoneNum();
		this.payGrade = e.getPayGrade();
		this.payStep = e.getPayStep();
		this.isSalaried = e.isSalaried();
	}
 
	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getBenefitId() {
		return this.benefitId;
	}

	public void setBenefitId(int benefitId) {
		this.benefitId = benefitId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getPayGrade() {
		return this.payGrade;
	}

	public void setPayGrade(int payGrade) {
		this.payGrade = payGrade;
	}

	public int getPayStep() {
		return this.payStep;
	}

	public void setPayStep(int payStep) {
		this.payStep = payStep;
	}

	public boolean isSalaried() {
		return this.isSalaried;
	}

	public void setSalaried(boolean isSalaried) {
		this.isSalaried = isSalaried;
	}
}
