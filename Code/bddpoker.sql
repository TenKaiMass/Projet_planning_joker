-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- Schema pokerbd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pokerbd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pokerbd` DEFAULT CHARACTER SET utf8mb3 ;
USE `pokerBD` ;



-- -----------------------------------------------------
-- Table `pokerbd`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokerbd`.`role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `label` VARCHAR(255) NULL DEFAULT NULL,
  `role` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;



-- -----------------------------------------------------
-- Table `pokerbd`.`session`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokerbd`.`session` (
  `session_id` INT NOT NULL AUTO_INCREMENT,
  `resultat_vote` INT NULL DEFAULT NULL,
  `date_creation` DATETIME(6) NULL DEFAULT NULL,
  `nom` VARCHAR(255) NULL DEFAULT NULL,
  `unites` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`session_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `pokerbd`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokerbd`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `post` VARCHAR(45) NULL DEFAULT NULL,
  `role` VARCHAR(45) NULL DEFAULT NULL,
  `passwords` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `pokerbd`.`session_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokerbd`.`session_users` (
  `session_idsession` INT NOT NULL,
  `users_idusers` INT NOT NULL,
  INDEX `FK3kiahaeejbdcs31q5kvh6unch` (`users_idusers` ASC) VISIBLE,
  INDEX `FKrly21dl479967gddmyr03ksxx` (`session_idsession` ASC) VISIBLE,
  CONSTRAINT `FK3kiahaeejbdcs31q5kvh6unch`
    FOREIGN KEY (`users_idusers`)
    REFERENCES `pokerbd`.`session` (`session_id`),
  CONSTRAINT `FKrly21dl479967gddmyr03ksxx`
    FOREIGN KEY (`session_idsession`)
    REFERENCES `pokerbd`.`users` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `pokerbd`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokerbd`.`user_roles` (
  `users_user_id` INT NOT NULL,
  `roles_idroles` INT NOT NULL,
  PRIMARY KEY (`users_user_id`, `roles_idroles`),
  INDEX `fk_users_has_roles_roles1_idx` (`roles_idroles` ASC) VISIBLE,
  INDEX `fk_users_has_roles_users1_idx` (`users_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_has_roles_roles1`
    FOREIGN KEY (`roles_idroles`)
    REFERENCES `pokerbd`.`roles` (`role_id`),
  CONSTRAINT `fk_users_has_roles_users1`
    FOREIGN KEY (`users_user_id`)
    REFERENCES `pokerbd`.`users` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
