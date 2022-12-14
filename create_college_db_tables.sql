-- MySQL Script generated by MySQL Workbench
-- Sat Oct  1 23:15:25 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema collegeDb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema collegeDb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `collegeDb` DEFAULT CHARACTER SET utf8 ;
USE `collegeDb` ;

-- -----------------------------------------------------
-- Table `collegeDb`.`course_table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `collegeDb`.`course_table` ;

CREATE TABLE IF NOT EXISTS `collegeDb`.`course_table` (
  `id` VARCHAR(256) NOT NULL,
  `name` VARCHAR(256) NOT NULL,
  `fees` DOUBLE NOT NULL,
  `duration` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collegeDb`.`college_table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `collegeDb`.`college_table` ;

CREATE TABLE IF NOT EXISTS `collegeDb`.`college_table` (
  `id` VARCHAR(256) NOT NULL,
  `name` VARCHAR(256) NOT NULL,
  `course_id` VARCHAR(256) NOT NULL,
  `accommodation_is_ac` TINYINT NULL,
  `accommodation_fees` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `course_id_UNIQUE` (`course_id` ASC) VISIBLE,
  CONSTRAINT `course_id`
    FOREIGN KEY (`course_id`)
    REFERENCES `collegeDb`.`course_table` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `collegeDb`.`course_table`
-- -----------------------------------------------------
START TRANSACTION;
USE `collegeDb`;
INSERT INTO `collegeDb`.`course_table` (`id`, `name`, `fees`, `duration`) VALUES ('1-1', 'Computer Science', 100.0, '1 month');
INSERT INTO `collegeDb`.`course_table` (`id`, `name`, `fees`, `duration`) VALUES ('2-1', 'English', 150.0, '3 months');

COMMIT;


-- -----------------------------------------------------
-- Data for table `collegeDb`.`college_table`
-- -----------------------------------------------------
START TRANSACTION;
USE `collegeDb`;
INSERT INTO `collegeDb`.`college_table` (`id`, `name`, `course_id`, `accommodation_is_ac`, `accommodation_fees`) VALUES ('1', 'Maharaja Agrasen University', '1-1', true, 1000.0);
INSERT INTO `collegeDb`.`college_table` (`id`, `name`, `course_id`, `accommodation_is_ac`, `accommodation_fees`) VALUES ('2', 'Bhartiye Vidyapeeth Deemed University', '2-1', false, 1500.0);

COMMIT;
