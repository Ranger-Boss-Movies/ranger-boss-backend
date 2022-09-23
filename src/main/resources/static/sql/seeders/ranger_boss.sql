USE `ranger_boss`;

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `actors`;
CREATE TABLE
    `actors` (
        `id` bigint(20) NOT NULL AUTO_INCREMENT,
        `actor_name` varchar(255) NOT NULL,
        PRIMARY KEY (`id`),
        UNIQUE KEY `UK_1a0sjog3wgxkki3882gmp7rrq` (`actor_name`)
             )
    ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

INSERT INTO `actors` (`id`, `actor_name`)
VALUES
    (1,'Anne Hathaway'),
    (2,'Billy Zane'),
    (3,'Bob Gunton'),
    (4,'Brad Pitt'),
    (5,'Burt Young'),
    (6,'Daryl Hannah'),
    (7,'David Carradine'),
    (8,'David Morse'),
    (9,'Jessica Chastain'),
    (10,'John Travolta'),
    (11,'Kate Winslet'),
    (12,'Kevin Spacey'),
    (13,'Kieran Culkin'),
    (14,'Leonardo DiCaprio'),
    (15,'Mary Elizabeth Winstead'),
    (16,'Matthew McConaughey'),
    (17,'Michael Cera'),
    (18,'Michael Clarke Duncan'),
    (19,'Morgan Freeman'),
    (20,'Samuel L. Jackson'),
    (21,'Sylvester Stallone'),
    (22,'Talia Shire'),
    (25,'Tim Robbins'),
    (23,'Tom Hanks'),
    (24,'Uma Thurman');

DROP TABLE IF EXISTS `directors`;
CREATE TABLE
    `directors` (
        `id` bigint(20) NOT NULL AUTO_INCREMENT,
        `director_name` varchar(255) NOT NULL,
        PRIMARY KEY (`id`)
                )
    ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

INSERT INTO `directors` (`id`, `director_name`)
VALUES
    (1,'Christopher Nolan'),
    (2,'David Fincher'),
    (3,'Edgar Wright'),
    (4,'Frank Darabont'),
    (5,'James Cameron'),
    (6,'John G. Avildsen'),
    (7,'Quentin Tarantino');

DROP TABLE IF EXISTS `genres`;
CREATE TABLE
    `genres` (
        `id` bigint(20) NOT NULL AUTO_INCREMENT,
        `genre_name` varchar(255) NOT NULL,
        PRIMARY KEY (`id`)
             )
    ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

INSERT INTO
    `genres` (`id`, `genre_name`)
VALUES
    (1,'Action'),
    (2,'Adventure'),
    (3,'Comedy'),
    (4,'Crime'),
    (5,'Drama'),
    (6,'Fantasy'),
    (7,'Mystery'),
    (8,'Romance'),
    (9,'Sci-Fi'),
    (10,'Sport');

DROP TABLE IF EXISTS `movies`;
CREATE TABLE
    `movies` (
        `id` bigint(20) NOT NULL AUTO_INCREMENT,
        `plot` varchar(1024) DEFAULT NULL,
        `poster` varchar(255) DEFAULT NULL,
        `rating` varchar(255) DEFAULT NULL,
        `score` double DEFAULT NULL,
        `title` varchar(255) NOT NULL,
        `year` bigint(20) DEFAULT NULL,
        `director_id` bigint(20) DEFAULT NULL,
        PRIMARY KEY (`id`),
        KEY `FK5ft3u8k962bmjd8rn2mr77j8d` (`director_id`),
        CONSTRAINT `FK5ft3u8k962bmjd8rn2mr77j8d` FOREIGN KEY (`director_id`) REFERENCES `directors` (`id`)
             )
    ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

INSERT INTO `movies` (`id`, `plot`, `poster`, `rating`, `score`, `title`, `year`, `director_id`)
VALUES
    (1,'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.','https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg','R',9.3,'The Shawshank Redemption',1994,4),
    (2,'The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.','https://m.media-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1_SX300.jpg','R',8.6,'The Green Mile',1999,4),
    (3,'Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his motives.','https://m.media-amazon.com/images/M/MV5BOTUwODM5MTctZjczMi00OTk4LTg3NWUtNmVhMTAzNTNjYjcyXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg','R',8.6,'Se7en',1995,2),
    (4,'A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.','https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg','PG-13',7.9,'Titanic',1997,5),
    (5,'After awakening from a four-year coma, a former assassin wreaks vengeance on the team of assassins who betrayed her.','https://m.media-amazon.com/images/M/MV5BNzM3NDFhYTAtYmU5Mi00NGRmLTljYjgtMDkyODQ4MjNkMGY2XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg','R',8.2,'Kill Bill: Vol. 1',2003,7),
    (6,'In a magically realistic version of Toronto, a young man must defeat his new girlfriend\'s seven evil exes one by one in order to win her heart.','https://m.media-amazon.com/images/M/MV5BYWQ2OGIyZTgtZmY5MC00NzY3LTg5NDYtMjdkZjgxZmFhZTMzXkEyXkFqcGdeQXVyOTA3ODI3NDA@._V1_SX300.jpg','PG-13',7.5,'Scott Pilgrim vs. the World',2010,3),
    (7,'A team of explorers travel through a wormhole in space in an attempt to ensure humanity\'s survival.','https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg','PG-13',8.6,'Interstellar',2014,1),
    (8,'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.','https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg','R',8.9,'Pulp Fiction',1994,7),
(9,'A small-time Philadelphia boxer gets a supremely rare chance to fight the world heavyweight champion in a bout in which he strives to go the distance for his self-respect.','https://m.media-amazon.com/images/M/MV5BNTBkMjg2MjYtYTZjOS00ODQ0LTg0MDEtM2FiNmJmOGU1NGEwXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg','PG',8.1,'Rocky',1976,6);

DROP TABLE IF EXISTS `movie_actor`;
CREATE TABLE
    `movie_actor` (
        `movie_id` bigint(20) NOT NULL,
        `actor_id` bigint(20) NOT NULL,
        KEY `FKr5wsak3io275nfc8jc5mtup2` (`actor_id`),
        KEY `FK90bbe6vpr6eoahw20ta95nkta` (`movie_id`),
        CONSTRAINT `FK90bbe6vpr6eoahw20ta95nkta` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
        CONSTRAINT `FKr5wsak3io275nfc8jc5mtup2` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`id`)
                  )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `movie_actor` (`movie_id`, `actor_id`)
VALUES
    (1,25),
    (1,19),
    (1,3),
    (2,23),
    (2,18),
    (2,8),
    (3,19),
    (3,4),
    (3,12),
    (4,14),
    (4,11),
    (4,2),
    (5,24),
    (5,7),
    (5,6),
    (6,17),
    (6,15),
    (6,13),
    (7,16),
    (7,1),
    (7,9),
    (8,10),
    (8,24),
    (8,20),
    (9,21),
    (9,22),
    (9,5);

DROP TABLE IF EXISTS `movie_genre`;
CREATE TABLE
    `movie_genre` (
        `movie_id` bigint(20) NOT NULL,
        `genre_id` bigint(20) NOT NULL,
        KEY `FK3pdaf1ai9eafeypc7qe401l07` (`genre_id`),
        KEY `FKg7f38h6umffo51no9ywq91438` (`movie_id`),
        CONSTRAINT `FK3pdaf1ai9eafeypc7qe401l07` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`),
        CONSTRAINT `FKg7f38h6umffo51no9ywq91438` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`)
)
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `movie_genre` (`movie_id`, `genre_id`)
VALUES
    (1,5),
    (2,4),
    (2,5),
    (2,6),
    (3,4),
    (3,5),
    (3,7),
    (4,5),
    (4,8),
    (5,1),
    (5,4),
    (5,5),
    (6,1),
    (6,3),
    (6,6),
    (7,2),
    (7,5),
    (7,9),
    (8,4),
    (8,5),
    (9,5),
    (9,10);