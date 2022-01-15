-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema movienightdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `movienightdb` ;

-- -----------------------------------------------------
-- Schema movienightdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `movienightdb` DEFAULT CHARACTER SET utf8 ;
USE `movienightdb` ;

-- -----------------------------------------------------
-- Table `snack`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `snack` ;

CREATE TABLE IF NOT EXISTS `snack` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `movie` ;

CREATE TABLE IF NOT EXISTS `movie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(150) NOT NULL,
  `season` INT NULL,
  `episode` INT NULL,
  `image_url` VARCHAR(2000) NULL,
  `category` VARCHAR(150) NOT NULL,
  `have_watched` TINYINT NULL,
  `date_watched` DATE NULL,
  `date_plan_to_see` DATE NULL,
  `snack_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_movie_snack_idx` (`snack_id` ASC),
  CONSTRAINT `fk_movie_snack`
    FOREIGN KEY (`snack_id`)
    REFERENCES `snack` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS movienightuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'movienightuser'@'localhost' IDENTIFIED BY 'movienightuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'movienightuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `snack`
-- -----------------------------------------------------
START TRANSACTION;
USE `movienightdb`;
INSERT INTO `snack` (`id`, `name`) VALUES (1, 'Popcorn');
INSERT INTO `snack` (`id`, `name`) VALUES (2, 'Chips');
INSERT INTO `snack` (`id`, `name`) VALUES (3, 'Snickers');
INSERT INTO `snack` (`id`, `name`) VALUES (4, 'Pretzels');
INSERT INTO `snack` (`id`, `name`) VALUES (5, 'Nachos');
INSERT INTO `snack` (`id`, `name`) VALUES (6, 'Pizza');
INSERT INTO `snack` (`id`, `name`) VALUES (7, 'Cookies');
INSERT INTO `snack` (`id`, `name`) VALUES (8, 'Fruit');
INSERT INTO `snack` (`id`, `name`) VALUES (9, 'Hamburger');
INSERT INTO `snack` (`id`, `name`) VALUES (10, 'Beer');
INSERT INTO `snack` (`id`, `name`) VALUES (11, 'Fries');
INSERT INTO `snack` (`id`, `name`) VALUES (12, 'Kettle Corn');
INSERT INTO `snack` (`id`, `name`) VALUES (13, 'Doughnuts');
INSERT INTO `snack` (`id`, `name`) VALUES (14, 'Trail Mix');
INSERT INTO `snack` (`id`, `name`) VALUES (15, 'Chicken');

COMMIT;


-- -----------------------------------------------------
-- Data for table `movie`
-- -----------------------------------------------------
START TRANSACTION;
USE `movienightdb`;
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (1, 'Titanic', NULL, NULL, 'https://upload.wikimedia.org/wikipedia/en/1/19/Titanic_%28Official_Film_Poster%29.png', 'Drama', 1, '1998-12-12', NULL, 1);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (2, 'Harry Potter And The Sorcerer\'s Stone', NULL, NULL, 'https://m.media-amazon.com/images/M/MV5BNjQ3NWNlNmQtMTE5ZS00MDdmLTlkZjUtZTBlM2UxMGFiMTU3XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_.jpg', 'Fantasy', 1, '2002-01-31', NULL, 2);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (3, 'Kung Fury', NULL, NULL, 'https://img.discogs.com/axCDKvh0_nLSuzLTkBPKi2vI-gs=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-7242400-1436972992-3742.jpeg.jpg', 'Comedy', 1, '2016-08-07', NULL, 3);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (4, 'The NoteBook', NULL, NULL, 'https://m.media-amazon.com/images/M/MV5BMTk3OTM5Njg5M15BMl5BanBnXkFtZTYwMzA0ODI3._V1_.jpg', 'Romance', 0, NULL, '2022-06-15', 4);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (5, 'Ferris Buellers Day Off', NULL, NULL, 'https://upload.wikimedia.org/wikipedia/en/9/9b/Ferris_Bueller%27s_Day_Off.jpg', 'Comedy', 1, '1999-11-12', NULL, 5);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (6, 'Jaws', NULL, NULL, 'https://m.media-amazon.com/images/I/41H5ZQQN4RL._SY445_.jpg', 'Horror', 0, NULL, '2022-06-15', 6);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (7, 'The Shining', NULL, NULL, 'https://flxt.tmsimg.com/assets/p40_p_v10_ap.jpg', 'Horror', 1, '2017-04-09', NULL, 7);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (8, 'Monty Python and the Holy Grail', NULL, NULL, 'https://m.media-amazon.com/images/M/MV5BMGE0YmJlMzAtNmU1YS00NzA5LWE0MWItODQzODhmZDBhZGU3XkEyXkFqcGdeQXVyMTA3MzQ4MTc0._V1_.jpg', 'Comedy', 1, '2019-11-14', NULL, 8);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (9, 'Jurassic Park', NULL, NULL, 'https://m.media-amazon.com/images/M/MV5BMjM2MDgxMDg0Nl5BMl5BanBnXkFtZTgwNTM2OTM5NDE@._V1_FMjpg_UX1000_.jpg', 'Action', 0, NULL, '2022-01-31', 11);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (10, 'Psycho', NULL, NULL, 'https://flxt.tmsimg.com/assets/p22092_p_v10_aa.jpg', 'Horror', 0, NULL, '2022-10-31', 12);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (11, 'The Sound of Music', NULL, NULL, 'https://flxt.tmsimg.com/assets/p5620_p_v10_an.jpg', 'Musical', 0, NULL, '2022-06-15', 5);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (12, 'The Truman Show', NULL, NULL, 'https://m.media-amazon.com/images/I/91QkSivUP9L._SL1500_.jpg', 'Comedy', 1, '2008-06-15', NULL, 13);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (13, 'Old', NULL, NULL, 'https://calendarmedia.blob.core.windows.net/assets/83f19de7-57d9-451e-8af8-a997ba51fe95.jpg', 'Thriller', 1, '2004-06-15', NULL, 3);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (14, 'Venom: Let There Be Carnage', NULL, NULL, 'https://www.sonypictures.com/sites/default/files/styles/max_560x840/public/title-key-art/venomltbc_onesheet_1400x2100_est.jpg?itok=SsAno7TI', 'Action', 0, NULL, '2022-02-15', 4);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (15, 'Diary Of  A Wimpy Kid', NULL, NULL, 'https://m.media-amazon.com/images/M/MV5BZDYyMjI1OWQtYjhmMS00MmU4LWI1N2UtNzFlZGQ0MDE2ODEwXkEyXkFqcGdeQXVyODkzNTgxMDg@._V1_.jpg', 'Childrens', 1, '2000-06-15', NULL, 9);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (16, 'Harry Potter and The Goblet of Fire', NULL, NULL, 'https://static.wikia.nocookie.net/harrypotter/images/2/2c/Goblet_of_Fire_Film_Poster.jpg/revision/latest?cb=20140817011104', 'Fantasy', 1, '2008-06-15', NULL, 10);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (17, 'The Good, The Bad, and The Ugly', NULL, NULL, 'https://sc-events.s3.amazonaws.com/4150351/main.jpg', 'Western', 0, NULL, '2022-10-15', 15);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (18, 'Sixteen Candles', NULL, NULL, 'https://ae01.alicdn.com/kf/H0603d721d24d418a92c7837549e88700s/D0776-Sixteen-Candles-Movie-John-Hughes-Molly-Ringwald-Silk-Fabric-Poster-Art-Decor-Indoor-Painting-Gift.jpg_Q90.jpg_.webp', 'Romance', 0, NULL, NULL, 3);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (19, 'Full Metal Jacket', NULL, NULL, 'https://flxt.tmsimg.com/assets/p10114_p_v10_ag.jpg', 'Action', 1, '2021-06-15', NULL, 13);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (20, 'Home Alone', NULL, NULL, 'https://m.media-amazon.com/images/I/A1T+lZ6iUZL._SL1500_.jpg', 'Childrens', 1, '2022-12-04', NULL, 11);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (21, 'Witcher', 1, 1, 'https://m.media-amazon.com/images/M/MV5BN2FiOWU4YzYtMzZiOS00MzcyLTlkOGEtOTgwZmEwMzAxMzA3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg', 'Fantasy', 1, '2019-12-15', NULL, 6);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (22, 'Witcher', 1, 2, 'https://m.media-amazon.com/images/M/MV5BN2FiOWU4YzYtMzZiOS00MzcyLTlkOGEtOTgwZmEwMzAxMzA3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg', 'Fantasy', 1, '2019-12-15', NULL, 6);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (23, 'Witcher', 1, 3, 'https://m.media-amazon.com/images/M/MV5BN2FiOWU4YzYtMzZiOS00MzcyLTlkOGEtOTgwZmEwMzAxMzA3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg', 'Fantasy', 1, '2019-12-15', NULL, 6);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (24, 'Witcher', 1, 4, 'https://m.media-amazon.com/images/M/MV5BN2FiOWU4YzYtMzZiOS00MzcyLTlkOGEtOTgwZmEwMzAxMzA3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg', 'Fantasy', 1, '2019-12-15', NULL, 6);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (25, 'Witcher', 1, 5, 'https://m.media-amazon.com/images/M/MV5BN2FiOWU4YzYtMzZiOS00MzcyLTlkOGEtOTgwZmEwMzAxMzA3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg', 'Fantasy', 1, '2019-12-15', NULL, 6);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (26, 'Witcher', 1, 6, 'https://m.media-amazon.com/images/M/MV5BN2FiOWU4YzYtMzZiOS00MzcyLTlkOGEtOTgwZmEwMzAxMzA3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg', 'Fantasy', 1, '2019-12-15', NULL, 6);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (27, 'Witcher', 2, 7, 'https://m.media-amazon.com/images/M/MV5BN2FiOWU4YzYtMzZiOS00MzcyLTlkOGEtOTgwZmEwMzAxMzA3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg', 'Fantasy', 1, '2021-01-07', NULL, 6);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (28, 'Witcher', 1, 8, 'https://m.media-amazon.com/images/M/MV5BN2FiOWU4YzYtMzZiOS00MzcyLTlkOGEtOTgwZmEwMzAxMzA3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg', 'Fantasy', 1, '2019-12-15', NULL, 6);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (29, 'Witcher', 2, 8, 'https://m.media-amazon.com/images/M/MV5BN2FiOWU4YzYtMzZiOS00MzcyLTlkOGEtOTgwZmEwMzAxMzA3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg', 'Fantasy', 1, '2022-01-07', NULL, 6);
INSERT INTO `movie` (`id`, `title`, `season`, `episode`, `image_url`, `category`, `have_watched`, `date_watched`, `date_plan_to_see`, `snack_id`) VALUES (30, 'You', 3, 1, 'https://flxt.tmsimg.com/assets/p14418847_b_v13_ab.jpg', 'Drama', 0, NULL, '2022-01-08', 5);

COMMIT;

