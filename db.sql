-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bankingsys2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bankingsys2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bankingsys2` DEFAULT CHARACTER SET utf8 ;
USE `bankingsys2` ;

-- -----------------------------------------------------
-- Table `bankingsys2`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankingsys2`.`customer` (
  `custid` INT(11) NOT NULL,
  `firstname` VARCHAR(20) NULL DEFAULT NULL,
  `lastname` VARCHAR(20) NULL DEFAULT NULL,
  `address` VARCHAR(20) NULL DEFAULT NULL,
  `email` VARCHAR(20) NULL DEFAULT NULL,
  `password` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`custid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bankingsys2`.`branch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankingsys2`.`branch` (
  `branchid` INT(11) NOT NULL,
  `phonenumber` VARCHAR(20) NULL DEFAULT NULL,
  `accounts_accountid` INT(11) NOT NULL,
  PRIMARY KEY (`branchid`),
  INDEX `fk_branch_accounts1_idx` (`accounts_accountid` ASC),
  CONSTRAINT `fk_branch_accounts1`
    FOREIGN KEY (`accounts_accountid`)
    REFERENCES `bankingsys2`.`accounts` (`accountid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bankingsys2`.`accounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankingsys2`.`accounts` (
  `accountid` INT(11) NOT NULL,
  `accountnumber` VARCHAR(20) NULL DEFAULT NULL,
  `balance` DECIMAL(10,0) NULL DEFAULT NULL,
  `sortcode` INT(11) NULL DEFAULT NULL,
  `customer_custid` INT(11) NULL,
  `customer_custid1` INT(11) NOT NULL,
  `branch_branchid` INT(11) NOT NULL,
  PRIMARY KEY (`accountid`),
  INDEX `fk_accounts_customer_idx` (`customer_custid1` ASC),
  INDEX `fk_accounts_branch1_idx` (`branch_branchid` ASC),
  CONSTRAINT `fk_accounts_customer`
    FOREIGN KEY (`customer_custid1`)
    REFERENCES `bankingsys2`.`customer` (`custid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_accounts_branch1`
    FOREIGN KEY (`branch_branchid`)
    REFERENCES `bankingsys2`.`branch` (`branchid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bankingsys2`.`transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankingsys2`.`transactions` (
  `trid` INT(11) NOT NULL,
  `phonenumber` VARCHAR(20) NULL DEFAULT NULL,
  `typeoft` VARCHAR(20) NULL DEFAULT NULL,
  `description` VARCHAR(20) NULL DEFAULT NULL,
  `date` DATE NULL DEFAULT NULL,
  `accounts_accountid` INT(11) NOT NULL,
  PRIMARY KEY (`trid`),
  INDEX `fk_transactions_accounts1_idx` (`accounts_accountid` ASC),
  CONSTRAINT `fk_transactions_accounts1`
    FOREIGN KEY (`accounts_accountid`)
    REFERENCES `bankingsys2`.`accounts` (`accountid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
