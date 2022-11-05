
CREATE SCHEMA IF NOT EXISTS `bookstore` DEFAULT CHARACTER SET utf8 ;
USE `bookstore` ;



CREATE TABLE IF NOT EXISTS `bookstore`.`books` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `isbn` VARCHAR(13) NOT NULL,
  `number_of_pages` INT NOT NULL,
  `year_of_publication` INT NOT NULL,
  `publisher` VARCHAR(45) NOT NULL,
  `binding` ENUM("softcover", "hardcover", "e_book") NOT NULL,
  PRIMARY KEY (`id`))
  AUTO_INCREMENT = 10000
  ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `bookstore`.`addresses` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `zip_code` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
  AUTO_INCREMENT = 10000
  ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `bookstore`.`users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(30) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(9) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `addresses_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`, `addresses_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_users_addresses1_idx` (`addresses_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_addresses1`
    FOREIGN KEY (`addresses_id`)
    REFERENCES `bookstore`.`addresses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    AUTO_INCREMENT = 10000
    ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `bookstore`.`orders` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `status` ENUM("in_progress", "paid", "shipped") NOT NULL,
  `order_date` DATE NOT NULL,
  `total_price` DOUBLE NOT NULL,
  `users_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`, `users_id`),
  INDEX `fk_orders_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `bookstore`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    AUTO_INCREMENT = 10000
    ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE IF NOT EXISTS `bookstore`.`authors` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `bookstore`.`books_has_authors` (
  `books_id` BIGINT NOT NULL,
  `authors_id` BIGINT NOT NULL,
  PRIMARY KEY (`books_id`, `authors_id`),
  INDEX `fk_books_has_autors_autors1_idx` (`authors_id` ASC) VISIBLE,
  INDEX `fk_books_has_autors_books1_idx` (`books_id` ASC) VISIBLE,
  CONSTRAINT `fk_books_has_autors_books1`
    FOREIGN KEY (`books_id`)
    REFERENCES `bookstore`.`books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_books_has_autors_autors1`
    FOREIGN KEY (`authors_id`)
    REFERENCES `bookstore`.`authors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    AUTO_INCREMENT = 10000
    ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE IF NOT EXISTS `bookstore`.`orders_info` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `orders_id` BIGINT NOT NULL,
  `books_id` BIGINT NOT NULL,
  `books_amount` INT NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`, `orders_id`, `books_id`),
  INDEX `fk_orders_has_books_books1_idx` (`books_id` ASC) VISIBLE,
  INDEX `fk_orders_has_books_orders1_idx` (`orders_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_has_books_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `bookstore`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_books_books1`
    FOREIGN KEY (`books_id`)
    REFERENCES `bookstore`.`books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    AUTO_INCREMENT = 10000
    ENGINE=InnoDB DEFAULT CHARSET=UTF8;
