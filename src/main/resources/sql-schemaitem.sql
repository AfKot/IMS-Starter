drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `item_price` DECIMAL(5,2) DEFAULT NULL,
    `stock` INT(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
