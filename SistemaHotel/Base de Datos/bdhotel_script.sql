SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `bdhotel` DEFAULT CHARACTER SET UTF8MB4 ;
USE `bdhotel` ;

-- -----------------------------------------------------
-- Table `bdhotel`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdhotel`.`producto` (
  `idproducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `unidad_medida` VARCHAR(20) NOT NULL,
  `precio_venta` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idproducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdhotel`.`habitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdhotel`.`habitacion` (
  `idhabitacion` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(5) NOT NULL,
  `piso` VARCHAR(2) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `caracteristicas` VARCHAR(512) NULL,
  `precio_diario` DECIMAL(10,2) NOT NULL,
  `estado` VARCHAR(15) NOT NULL,
  `tipo_habitacion` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idhabitacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdhotel`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdhotel`.`persona` (
  `idpersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apaterno` VARCHAR(45) NOT NULL,
  `amaterno` VARCHAR(45) NULL,
  `tipo_documento` VARCHAR(45) NOT NULL,
  `num_documento` VARCHAR(45) NOT NULL,
  `domicilio` VARCHAR(90) NOT NULL,
  `ciudad` VARCHAR(30) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `telefono` BIGINT NULL,
  `email` VARCHAR(45) NULL,
  `redes` VARCHAR(45) NULL,
  `rfc` VARCHAR(45) NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE INDEX `telefono_UNIQUE` (`telefono` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdhotel`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdhotel`.`cliente` (
  `idpersona` INT NOT NULL,
  `codigo_cliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE INDEX `codigo_cliente_UNIQUE` (`codigo_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_persona_cliente`
    FOREIGN KEY (`idpersona`)
    REFERENCES `bdhotel`.`persona` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdhotel`.`trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdhotel`.`trabajador` (
  `idpersona` INT NOT NULL,
  `sueldo` DECIMAL(10,2) NOT NULL,
  `acceso` VARCHAR(15) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC) VISIBLE,
  CONSTRAINT `fk_persona_trabajador`
    FOREIGN KEY (`idpersona`)
    REFERENCES `bdhotel`.`persona` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdhotel`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdhotel`.`reserva` (
  `idreserva` INT NOT NULL AUTO_INCREMENT,
  `idhabitacion` INT NOT NULL,
  `idcliente` INT NOT NULL,
  `idtrabajador` INT NOT NULL,
  `tipo_reserva` VARCHAR(20) NOT NULL,
  `fecha_reserva` DATE NOT NULL,
  `fecha_ingreso` DATE NOT NULL,
  `fecha_salida` DATE NOT NULL,
  `costo_alojamiento` DECIMAL(10,2) NOT NULL,
  `estado` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idreserva`),
  INDEX `fk_reserva_habitacion_idx` (`idhabitacion` ASC) VISIBLE,
  INDEX `fk_reserva_cliente_idx` (`idcliente` ASC) VISIBLE,
  INDEX `fk_reserva_trabajador_idx` (`idtrabajador` ASC) VISIBLE,
  CONSTRAINT `fk_reserva_habitacion`
    FOREIGN KEY (`idhabitacion`)
    REFERENCES `bdhotel`.`habitacion` (`idhabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_cliente`
    FOREIGN KEY (`idcliente`)
    REFERENCES `bdhotel`.`cliente` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_trabajador`
    FOREIGN KEY (`idtrabajador`)
    REFERENCES `bdhotel`.`trabajador` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdhotel`.`consumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdhotel`.`consumo` (
  `idconsumo` INT NOT NULL AUTO_INCREMENT,
  `idreserva` INT NOT NULL,
  `idproducto` INT NOT NULL,
  `cantidad` DECIMAL(10,2) NOT NULL,
  `precio_venta` DECIMAL(10,2) NOT NULL,
  `estado` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idconsumo`),
  INDEX `fk_consumo_producto_idx` (`idproducto` ASC) VISIBLE,
  INDEX `fk_consumo_reserva_idx` (`idreserva` ASC) VISIBLE,
  CONSTRAINT `fk_consumo_producto`
    FOREIGN KEY (`idproducto`)
    REFERENCES `bdhotel`.`producto` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consumo_reserva`
    FOREIGN KEY (`idreserva`)
    REFERENCES `bdhotel`.`reserva` (`idreserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdhotel`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdhotel`.`pago` (
  `idpago` INT NOT NULL AUTO_INCREMENT,
  `idreserva` INT NOT NULL,
  `tipo_comprobante` VARCHAR(20) NOT NULL,
  `num_comprobante` VARCHAR(90) NOT NULL,
  `iva` DECIMAL(10,2) NOT NULL,
  `total_pago` DECIMAL(10,2) NOT NULL,
  `fecha_emision` DATE NOT NULL,
  `fecha_pago` DATE NOT NULL,
  PRIMARY KEY (`idpago`),
  INDEX `fk_pago_reserva_idx` (`idreserva` ASC) VISIBLE,
  CONSTRAINT `fk_pago_reserva`
    FOREIGN KEY (`idreserva`)
    REFERENCES `bdhotel`.`reserva` (`idreserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
