
CREATE TABLE IF NOT EXISTS `bookstore`.`author_gql` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
  auto_increment = 10000;

CREATE TABLE IF NOT EXISTS `bookstore`.`address_gql` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `zip_code` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
  AUTO_INCREMENT = 10000;

create table if not exists `bookstore`.`book_gql` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(80) NOT NULL,
    `isbn` VARCHAR(13) NOT NULL,
    `number_of_pages` INT NOT NULL,
    `year_of_publication` INT NOT NULL,
    `publisher` VARCHAR(45) NOT NULL,
    `price` DOUBLE NOT NULL,
    `author_id` BIGINT NOT NULL,
     PRIMARY KEY (`id`),
     foreign key (`author_id`) references author_gql(id))
     AUTO_INCREMENT = 1000;

CREATE TABLE IF NOT EXISTS `bookstore`.`user_gql` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(30) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(9) NOT NULL,
  `address_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  foreign key (`address_id`) references address_gql(id))
  auto_increment = 10000;
