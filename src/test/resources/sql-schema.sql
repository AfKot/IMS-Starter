DROP schema testims;

CREATE DATABASE IF NOT EXISTS `testims`;

use `testims`;

DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS `items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `item_price` DECIMAL(5,2) DEFAULT NULL,
    `stock` INT(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `orders`;

create table if not exists `orders` (
`id` int NOT NULL auto_increment,
`customer_id` INT NOT NULL,
`progress` varchar(40),
`total` DECIMAL (5,2),
primary key(`id`),
FOREIGN KEY(`customer_id`) references `customers`(`id`) ON update cascade ON DELETE CASCADE
);

DROP TABLE IF EXISTS `indexing`;

create table if not exists `indexing` (
`order_id` int NOT NULL,
`item_id` INT NOT NULL,
foreign key(`order_id`) references `orders`(`id`) ON update cascade ON DELETE CASCADE,
foreign key(`item_id`) references `items`(`id`) ON update cascade ON DELETE CASCADE
);

