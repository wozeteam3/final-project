package com.t3.finalproject.model;

public class Employee {
  private int emp_id;
  private int benefit_id;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNum;

  public int getEmp_id() {
    return this.emp_id;
  }

  public void setEmp_id(int emp_id) {
    this.emp_id = emp_id;
  }

  public int getBenefit_id() {
    return this.benefit_id;
  }

  public void setBenefit_id(int benefit_id) {
    this.benefit_id = benefit_id;
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

  private int payGrade;
  private int payStep;
  private boolean isSalaried;
}
