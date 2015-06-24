SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `cart` ;
CREATE SCHEMA IF NOT EXISTS `cart` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `cart` ;

-- -----------------------------------------------------
-- Table `cart`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cart`.`Producto` ;

CREATE TABLE IF NOT EXISTS `cart`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `imagen` LONGBLOB NULL,
  `producto` VARCHAR(45) NULL,
  `descripcion` VARCHAR(50) NULL,
  `precio` DOUBLE NULL,
  `existencia` INT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
DROP TABLE IF EXISTS `cart`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `cart`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `imagen` LONGBLOB NULL,
  `nombre` VARCHAR(45) NULL,
  `paterno` VARCHAR(45) NULL,
  `materno` VARCHAR(45) NULL,
  `correo` VARCHAR(50) NOT NULL,
  `usuario` VARCHAR(50) NOT NULL,
  `pass` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
