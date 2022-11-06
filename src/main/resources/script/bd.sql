
CREATE SCHEMA IF NOT EXISTS `coderbd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `coderbd` ;

CREATE TABLE IF NOT EXISTS `coderbd`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(11) NULL DEFAULT NULL,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `apellido` VARCHAR(45) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `coderbd`.`productos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sku` VARCHAR(50) NULL DEFAULT NULL,
  `descripcion` VARCHAR(150) NULL DEFAULT NULL,
  `precio_compra` DOUBLE NULL DEFAULT NULL,
  `precio_venta` DOUBLE NULL DEFAULT NULL,
  `stock` INT NULL DEFAULT NULL,
  `fecha_alta` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `coderbd`.`ventas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha_alta` DATE NULL DEFAULT NULL,
  `total` DOUBLE NULL DEFAULT NULL,
  `cliente_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ventas_clientes_idx` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_ventas_clientes`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `coderbd`.`clientes` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `coderbd`.`detalles_venta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `venta_id` INT NOT NULL,
  `producto_id` INT NOT NULL,
  `cantidad` INT NULL DEFAULT NULL,
  `sub_total` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_detalles_venta_ventas1_idx` (`venta_id` ASC) VISIBLE,
  INDEX `fk_detalles_venta_productos1_idx` (`producto_id` ASC) VISIBLE,
  CONSTRAINT `fk_detalles_venta_productos1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `coderbd`.`productos` (`id`),
  CONSTRAINT `fk_detalles_venta_ventas1`
    FOREIGN KEY (`venta_id`)
    REFERENCES `coderbd`.`ventas` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
