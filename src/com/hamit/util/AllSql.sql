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
 






























