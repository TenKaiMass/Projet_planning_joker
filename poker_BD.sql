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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
