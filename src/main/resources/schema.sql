-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema finalproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS finalproject DEFAULT CHARACTER SET utf8 ;
USE finalproject ;

-- -----------------------------------------------------
-- Table finalproject.benefits
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS finalproject.benefits (
  benefit_id INT NOT NULL AUTO_INCREMENT,
  dental INT NULL DEFAULT NULL,
  life INT NULL DEFAULT NULL,
  health INT NULL DEFAULT NULL,
  401k_match_amount DECIMAL(10,0) NULL DEFAULT NULL,
  PRIMARY KEY (benefit_id),
  UNIQUE INDEX benefit_id_UNIQUE (benefit_id ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 9	
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table finalproject.paygrade_hourly
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS finalproject.paygrade_hourly (
  grade INT NOT NULL,
  step0 DECIMAL(4,2) NULL DEFAULT NULL,
  step1 DECIMAL(4,2) NULL DEFAULT NULL,
  step2 DECIMAL(4,2) NULL DEFAULT NULL,
  step3 DECIMAL(4,2) NULL DEFAULT NULL,
  step4 DECIMAL(4,2) NULL DEFAULT NULL,
  PRIMARY KEY (grade),
  UNIQUE INDEX grade_UNIQUE (grade ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table finalproject.paygrade_salary
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS finalproject.paygrade_salary (
  grade INT NOT NULL,
  step0 INT NULL DEFAULT NULL,
  step1 INT NULL DEFAULT NULL,
  step2 INT NULL DEFAULT NULL,
  step3 INT NULL DEFAULT NULL,
  step4 INT NULL DEFAULT NULL,
  PRIMARY KEY (grade),
  UNIQUE INDEX grade_UNIQUE (grade ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table finalproject.employee
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS finalproject.employee (
  emp_id INT(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  benefit_id INT NULL DEFAULT NULL,
  first_name VARCHAR(45) NULL DEFAULT NULL,
  last_name VARCHAR(45) NULL DEFAULT NULL,
  email VARCHAR(45) NULL DEFAULT NULL,
  phone_num VARCHAR(15) NULL DEFAULT NULL,
  pay_grade INT NULL DEFAULT NULL,
  pay_step INT NULL DEFAULT NULL,
  salaried TINYINT DEFAULT 0,
  PRIMARY KEY (emp_id),
  UNIQUE INDEX emp_id_UNIQUE (emp_id ASC) VISIBLE,
  INDEX benefit_id_idx (benefit_id ASC) VISIBLE,
  INDEX pay_grade_idx (pay_grade ASC) VISIBLE,
  CONSTRAINT benefit_id
    FOREIGN KEY (benefit_id)
    REFERENCES finalproject.benefits (benefit_id),
  CONSTRAINT grade_hour
    FOREIGN KEY (pay_grade)
    REFERENCES finalproject.paygrade_hourly (grade),
  CONSTRAINT grade_sal
    FOREIGN KEY (pay_grade)
    REFERENCES finalproject.paygrade_salary (grade))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;