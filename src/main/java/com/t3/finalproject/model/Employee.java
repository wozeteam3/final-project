package com.t3.finalproject.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 *
 * @author 
 */
public class Employee {
  
  /** The emp id. */
  private int empId;
  
  /** The benefit id. */
  private int benefitId;
  
  /** The first name. */
  private String firstName;
  
  /** The last name. */
  private String lastName;
  
  /** The email. */
  private String email;
  
  /** The phone num. */
  private String phoneNum;
  
  /** The pay grade. */
  private int payGrade;
  
  /** The pay step. */
  private int payStep;
  
  /** The is salaried. */
  private boolean isSalaried;

  /**
   * Instantiates a new employee.
   */
  public Employee() {}

  /**
   * Instantiates a new employee.
   *
   * @param id the id
   * @param benId the ben id
   * @param f the f
   * @param l the l
   * @param email the email
   * @param phone the phone
   * @param grade the grade
   * @param step the step
   * @param salaried the salaried
   */
  public Employee(
      int id,
      int benId,
      String f,
      String l,
      String email,
      String phone,
      int grade,
      int step,
      boolean salaried) {
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
   * Instantiates a new employee.
   *
   * @param e the e
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

  /**
   * Gets the emp id.
   *
   * @return the emp id
   */
  public int getEmpId() {
    return this.empId;
  }

  /**
   * Sets the emp id.
   *
   * @param empId the new emp id
   */
  public void setEmpId(int empId) {
    this.empId = empId;
  }

  /**
   * Gets the benefit id.
   *
   * @return the benefit id
   */
  public int getBenefitId() {
    return this.benefitId;
  }

  /**
   * Sets the benefit id.
   *
   * @param benefitId the new benefit id
   */
  public void setBenefitId(int benefitId) {
    this.benefitId = benefitId;
  }

  /**
   * Gets the first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Sets the first name.
   *
   * @param firstName the new first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Sets the last name.
   *
   * @param lastName the new last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the email.
   *
   * @return the email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Sets the email.
   *
   * @param email the new email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the phone num.
   *
   * @return the phone num
   */
  public String getPhoneNum() {
    return this.phoneNum;
  }

  /**
   * Sets the phone num.
   *
   * @param phoneNum the new phone num
   */
  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  /**
   * Gets the pay grade.
   *
   * @return the pay grade
   */
  public int getPayGrade() {
    return this.payGrade;
  }

  /**
   * Sets the pay grade.
   *
   * @param payGrade the new pay grade
   */
  public void setPayGrade(int payGrade) {
    this.payGrade = payGrade;
  }

  /**
   * Gets the pay step.
   *
   * @return the pay step
   */
  public int getPayStep() {
    return this.payStep;
  }

  /**
   * Sets the pay step.
   *
   * @param payStep the new pay step
   */
  public void setPayStep(int payStep) {
    this.payStep = payStep;
  }

  /**
   * Checks if is salaried.
   *
   * @return true, if is salaried
   */
  public boolean isSalaried() {
    return this.isSalaried;
  }

  /**
   * Sets the salaried.
   *
   * @param isSalaried the new salaried
   */
  public void setSalaried(boolean isSalaried) {
    this.isSalaried = isSalaried;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "Employee [empId="
        + this.empId
        + ", benefitId="
        + this.benefitId
        + ", firstName="
        + this.firstName
        + ", lastName="
        + this.lastName
        + ", email="
        + this.email
        + ", phoneNum="
        + this.phoneNum
        + ", payGrade="
        + this.payGrade
        + ", payStep="
        + this.payStep
        + ", isSalaried="
        + this.isSalaried
        + "]";
  }
}
