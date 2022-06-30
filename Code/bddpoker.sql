-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pokerBD
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pokerBD
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pokerBD` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema pokerbd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pokerbd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pokerbd` DEFAULT CHARACTER SET utf8mb3 ;
USE `pokerBD` ;

-- -----------------------------------------------------
-- Table `pokerBD`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokerBD`.`Users` (
  `idUsers` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `prenoms` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  `post` VARCHAR(45) NOT NULL,
  `roles` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsers`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokerBD`.`Session`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokerBD`.`Session` (
  `idSession` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `unites` VARCHAR(45) NOT NULL,
  `date_creation` DATETIME NULL,
  PRIMARY KEY (`idSession`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokerBD`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokerBD`.`roles` (
  `idroles` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  `label` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idroles`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokerBD`.`Users_has_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokerBD`.`Users_has_roles` (
  `id` VARCHAR(45) NOT NULL,
  `Users_idUsers` INT NOT NULL,
  `roles_idroles` INT NOT NULL,
  INDEX `fk_Users_has_roles_roles1_idx` (`roles_idroles` ASC) VISIBLE,
  INDEX `fk_Users_has_roles_Users_idx` (`Users_idUsers` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Users_has_roles_Users`
    FOREIGN KEY (`Users_idUsers`)
    REFERENCES `pokerBD`.`Users` (`idUsers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_has_roles_roles1`
    FOREIGN KEY (`roles_idroles`)
    REFERENCES `pokerBD`.`roles` (`idroles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokerBD`.`Session_has_Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokerBD`.`Session_has_Users` (
  `Session_idSession` INT NOT NULL,
  `Users_idUsers` INT NOT NULL,
  PRIMARY KEY (`Session_idSession`, `Users_idUsers`),
  INDEX `fk_Session_has_Users_Users1_idx` (`Users_idUsers` ASC) VISIBLE,
  INDEX `fk_Session_has_Users_Session1_idx` (`Session_idSession` ASC) VISIBLE,
  CONSTRAINT `fk_Session_has_Users_Session1`
    FOREIGN KEY (`Session_idSession`)
    REFERENCES `pokerBD`.`Session` (`idSession`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Session_has_Users_Users1`
    FOREIGN KEY (`Users_idUsers`)
    REFERENCES `pokerBD`.`Users` (`idUsers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `pokerbd` ;

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
-- Table `pokerbd`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokerbd`.`roles` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  `label` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
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
