
DROP TABLE IF EXISTS books_has_authors;

CREATE TABLE IF NOT EXISTS `bookstore`.`books_has_authors` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `books_id` BIGINT NOT NULL,
    `authors_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`books_id`) references books(id),
    FOREIGN KEY (`authors_id`) references authors(id))
    AUTO_INCREMENT = 10000;