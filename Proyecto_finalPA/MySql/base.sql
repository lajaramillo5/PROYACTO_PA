-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema proyecto_final
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proyecto_final
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyecto_final` DEFAULT CHARACTER SET utf8 ;
USE `proyecto_final` ;

-- -----------------------------------------------------
-- Table `proyecto_final`.`docente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`docente` (
  `idDoc` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Edad` INT(11) NOT NULL,
  `Cedula` VARCHAR(11) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(45) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDoc`),
  UNIQUE INDEX `Cedula_UNIQUE` (`Cedula` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `proyecto_final`.`año_lectivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`año_lectivo` (
  `idAño` INT(11) NOT NULL AUTO_INCREMENT,
  `Fecha_inicial` DATE NOT NULL,
  `Fecha_Final` DATE NOT NULL,
  PRIMARY KEY (`idAño`),
  UNIQUE INDEX `idAño_lectivo_UNIQUE` (`idAño` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `proyecto_final`.`paralelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`paralelo` (
  `idParalelo` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idParalelo`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `proyecto_final`.`grado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`grado` (
  `idGra` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `idParal` INT(11) NOT NULL,
  `idAño` INT(11) NOT NULL,
  PRIMARY KEY (`idGra`),
  INDEX `fk_Grado_Paralelo1_idx` (`idParal` ASC),
  INDEX `fk_Grado_Año_lectivo1_idx` (`idAño` ASC),
  CONSTRAINT `fk_Grado_Año_lectivo1`
    FOREIGN KEY (`idAño`)
    REFERENCES `proyecto_final`.`año_lectivo` (`idAño`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Grado_Paralelo1`
    FOREIGN KEY (`idParal`)
    REFERENCES `proyecto_final`.`paralelo` (`idParalelo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `proyecto_final`.`asignatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`asignatura` (
  `idAsignatura` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Horario` VARCHAR(45) NOT NULL,
  `idDoc` INT(11) NOT NULL,
  `idGra` INT(11) NOT NULL,
  PRIMARY KEY (`idAsignatura`),
  INDEX `fk_Asignatura_Docente1_idx` (`idDoc` ASC),
  INDEX `fk_Asignatura_Grado1_idx` (`idGra` ASC),
  CONSTRAINT `fk_Asignatura_Docente1`
    FOREIGN KEY (`idDoc`)
    REFERENCES `proyecto_final`.`docente` (`idDoc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asignatura_Grado1`
    FOREIGN KEY (`idGra`)
    REFERENCES `proyecto_final`.`grado` (`idGra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `proyecto_final`.`estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`estudiante` (
  `idEst` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Edad` INT(11) NOT NULL,
  `Cedula` VARCHAR(11) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEst`),
  UNIQUE INDEX `Cedula_UNIQUE` (`Cedula` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `proyecto_final`.`matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`matricula` (
  `idMatri` INT(11) NOT NULL AUTO_INCREMENT,
  `idAño` INT(11) NOT NULL,
  `idEst` INT(11) NOT NULL,
  `idRepre` INT(11) NOT NULL,
  `idGra` INT(11) NOT NULL,
  PRIMARY KEY (`idMatri`),
  INDEX `fk_Matricula_Año_lectivo1_idx` (`idAño` ASC),
  INDEX `fk_Matricula_Estudiante1_idx` (`idEst` ASC),
  INDEX `fk_Matricula_Representante1_idx` (`idRepre` ASC),
  INDEX `fk_Matricula_Grado1_idx` (`idGra` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `proyecto_final`.`nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`nota` (
  `idNota` INT(11) NOT NULL AUTO_INCREMENT,
  `idAsig` INT(11) NOT NULL,
  `parcial1_1` DOUBLE NOT NULL,
  `parcial1_2` DOUBLE NOT NULL,
  `parcial1_3` DOUBLE NOT NULL,
  `Quimestre1` DOUBLE NOT NULL,
  `parcial2_1` DOUBLE NOT NULL,
  `parcial2_2` DOUBLE NOT NULL,
  `parcial2_3` DOUBLE NOT NULL,
  `Quimestre2` DOUBLE NOT NULL,
  `NotaFinal` DOUBLE NOT NULL,
  `idEst` INT(11) NOT NULL,
  PRIMARY KEY (`idNota`),
  UNIQUE INDEX `idNota_UNIQUE` (`idNota` ASC),
  INDEX `fk_Nota_Asignatura1_idx` (`idAsig` ASC),
  INDEX `fk_Nota_Estudiante1_idx` (`idEst` ASC),
  CONSTRAINT `fk_Nota_Asignatura1`
    FOREIGN KEY (`idAsig`)
    REFERENCES `proyecto_final`.`asignatura` (`idAsignatura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Nota_Estudiante1`
    FOREIGN KEY (`idEst`)
    REFERENCES `proyecto_final`.`estudiante` (`idEst`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `proyecto_final`.`representante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`representante` (
  `idRepre` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Edad` INT(11) NOT NULL,
  `Cedula` VARCHAR(11) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(45) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRepre`),
  UNIQUE INDEX `Cedula_UNIQUE` (`Cedula` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `proyecto_final`.`secretaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`secretaria` (
  `idSecre` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Edad` INT(11) NOT NULL,
  `Cedula` VARCHAR(11) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(45) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSecre`),
  UNIQUE INDEX `Cedula_UNIQUE` (`Cedula` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `proyecto_final`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `Funcion` INT(11) NOT NULL,
  `User` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC),
  UNIQUE INDEX `User_UNIQUE` (`User` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
