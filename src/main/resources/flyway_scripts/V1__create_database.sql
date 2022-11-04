
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;


CREATE SEQUENCE IF NOT EXISTS id_seq
AS BIGINT
INCREMENT BY 1
START WITH 10000;


CREATE TABLE IF NOT EXISTS `mydb`.`books` (
  `id` BIGINT NOT NULL DEFAULT nextval('id_seq'),
  `isbn` VARCHAR(13) NOT NULL,
  `number_of_pages` INT NOT NULL,
  `year_of_publication` INT NOT NULL,
  `publisher` VARCHAR(45) NOT NULL,
  `binding` ENUM("softcover", "hardcover", "e_book") NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `mydb`.`addresses` (
  `id` BIGINT NOT NULL DEFAULT nextval('id_seq'),
  `zip_code` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
  ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `mydb`.`users` (
  `id` BIGINT NOT NULL DEFAULT nextval('id_seq'),
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
    REFERENCES `mydb`.`addresses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `mydb`.`orders` (
  `id` BIGINT NOT NULL DEFAULT nextval('id_seq'),
  `status` ENUM("in_progress", "paid", "shipped") NOT NULL,
  `order_date` DATE NOT NULL,
  `total_price` DOUBLE NOT NULL,
  `users_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`, `users_id`),
  INDEX `fk_orders_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `mydb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE IF NOT EXISTS `mydb`.`authors` (
  `id` BIGINT NOT NULL DEFAULT nextval('id_seq'),
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `mydb`.`books_has_authors` (
  `books_id` BIGINT NOT NULL,
  `authors_id` BIGINT NOT NULL,
  PRIMARY KEY (`books_id`, `authors_id`),
  INDEX `fk_books_has_autors_autors1_idx` (`authors_id` ASC) VISIBLE,
  INDEX `fk_books_has_autors_books1_idx` (`books_id` ASC) VISIBLE,
  CONSTRAINT `fk_books_has_autors_books1`
    FOREIGN KEY (`books_id`)
    REFERENCES `mydb`.`books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_books_has_autors_autors1`
    FOREIGN KEY (`authors_id`)
    REFERENCES `mydb`.`authors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE IF NOT EXISTS `mydb`.`orders_info` (
  `id` BIGINT NOT NULL,
  `orders_id` BIGINT NOT NULL,
  `books_id` BIGINT NOT NULL,
  `books_amount` INT NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`, `orders_id`, `books_id`),
  INDEX `fk_orders_has_books_books1_idx` (`books_id` ASC) VISIBLE,
  INDEX `fk_orders_has_books_orders1_idx` (`orders_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_has_books_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `mydb`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_books_books1`
    FOREIGN KEY (`books_id`)
    REFERENCES `mydb`.`books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE=InnoDB DEFAULT CHARSET=UTF8;
