CREATE SCHEMA `staj_javase_2` DEFAULT CHARACTER SET utf8 ;
use staj_javase_2;

-- register
CREATE TABLE `staj_javase_2`.`register` (
  `register_id` INT NOT NULL AUTO_INCREMENT,
  `register_name` VARCHAR(150) NOT NULL,
  `register_surname` VARCHAR(150) NOT NULL,
  `register_email` VARCHAR(150) NOT NULL,
  `register_password` VARCHAR(45) NOT NULL,
  `creation_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`register_id`),
  UNIQUE INDEX `register_email_UNIQUE` (`register_email` ASC));
  -- register roles
  ALTER TABLE `staj_javase_2`.`register` 
ADD COLUMN `roles` VARCHAR(45) NULL DEFAULT 'user' AFTER `register_password`;

-- register add
INSERT INTO `staj_javase_2`.`register` (`register_name`, `register_surname`, `register_email`, `register_password`) VALUES ('Hamit', 'mizrak', 'hamitmizrak@gmail.com', '123');

INSERT INTO `staj_javase_2`.`register` (`register_id`, `register_name`, `register_surname`, `register_email`, `register_password`, `roles`, `creation_date`) VALUES ('0', 'Hamit', 'mizrak', 'mizrak@gmail.com', '123', 'admin', '2021-07-12 20:26:31');


-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- user
CREATE TABLE `staj_javase_2`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(150) NULL,
  `user_surname` VARCHAR(150) NULL,
  `user_password` VARCHAR(15) NULL,
  `user_iban_number` VARCHAR(45) NULL,
  `user_cart_information` VARCHAR(45) NULL,
  `user_money_amount` VARCHAR(12) NULL,
  `creation_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`));

  -- admin
CREATE TABLE `staj_javase_2`.`admin` (
  `admin_id` INT NOT NULL AUTO_INCREMENT,
  `admin_name` VARCHAR(150) NULL,
  `admin_surname` VARCHAR(150) NULL,
  `admin_password` VARCHAR(15) NULL,
  `creation_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`admin_id`));

  
  -- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  ALTER TABLE `staj_javase_2`.`register` 
CHANGE COLUMN `register_name` `register_name` VARCHAR(150) NULL ,
CHANGE COLUMN `register_surname` `register_surname` VARCHAR(150) NULL ,
CHANGE COLUMN `register_email` `register_email` VARCHAR(150) NULL ,
CHANGE COLUMN `register_password` `register_password` VARCHAR(45) NULL ;

 -- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 


select * from user inner join register on user.register_register_id=register.register_id


-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema deneme_44
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema deneme_44
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `deneme_44` DEFAULT CHARACTER SET utf8 ;
USE `deneme_44` ;

-- -----------------------------------------------------
-- Table `deneme_44`.`register`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deneme_44`.`register` (
  `register_id` INT NOT NULL AUTO_INCREMENT,
  `register_name` VARCHAR(150) NULL,
  `register_surname` VARCHAR(45) NULL,
  `register_password` VARCHAR(45) NULL,
  `register_email` VARCHAR(45) NULL,
  `creation_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`register_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `deneme_44`.`banka`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deneme_44`.`banka` (
  `banka_id` INT NOT NULL AUTO_INCREMENT,
  `banka_name` VARCHAR(45) NULL,
  `banka_address` VARCHAR(45) NULL,
  `banka_email` VARCHAR(45) NULL,
  `creation_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`banka_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `deneme_44`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deneme_44`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `money` VARCHAR(45) NULL,
  `banka_banka_id` INT NOT NULL,
  `register_register_id` INT NOT NULL,
  `creation_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  INDEX `fk_user_banka_idx` (`banka_banka_id` ASC) ,
  INDEX `fk_user_register1_idx` (`register_register_id` ASC) ,
  CONSTRAINT `fk_user_banka`
    FOREIGN KEY (`banka_banka_id`)
    REFERENCES `deneme_44`.`banka` (`banka_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_register1`
    FOREIGN KEY (`register_register_id`)
    REFERENCES `deneme_44`.`register` (`register_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;






























