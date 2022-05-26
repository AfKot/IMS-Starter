drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11) NOT NULL,
    `progress` VARCHAR(40) DEFAULT NULL,
    `total` DECIMAL(5,2) DEFAULT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY(`customer_id`) references customers(id)
);
