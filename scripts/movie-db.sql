/*
SQLyog Enterprise v10.42 
MySQL - 5.6.11 : Database - movie_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`movie_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `movie_db`;

/*Table structure for table `admins` */

DROP TABLE IF EXISTS `admins`;

CREATE TABLE `admins` (
  `userid` int(11) NOT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `userid` (`userid`,`is_admin`),
  CONSTRAINT `admins_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admins` */

insert  into `admins`(`userid`,`is_admin`) values (1,1);

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT '',
  `text` varchar(500) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  `movieid` int(11) DEFAULT NULL,
  `rating` double DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `movieid` (`movieid`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`movieid`) REFERENCES `movies` (`movieid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `comments` */

insert  into `comments`(`id`,`title`,`text`,`userid`,`movieid`,`rating`) values (2,'Title 2','test text2',2,1,4.5),(3,'Title 3','movie2',1,2,4.5),(4,'Title 4','movie2',1,2,4.5),(5,'Title 5','movie2',1,2,4.5),(6,'Title 6','movie2',1,2,4.5);

/*Table structure for table `favorites` */

DROP TABLE IF EXISTS `favorites`;

CREATE TABLE `favorites` (
  `userid` int(11) NOT NULL,
  `movieid` int(11) NOT NULL,
  UNIQUE KEY `userid` (`userid`,`movieid`),
  KEY `movieid` (`movieid`),
  CONSTRAINT `favorites_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`),
  CONSTRAINT `favorites_ibfk_2` FOREIGN KEY (`movieid`) REFERENCES `movies` (`movieid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `favorites` */

insert  into `favorites`(`userid`,`movieid`) values (1,2),(1,3);

/*Table structure for table `movies` */

DROP TABLE IF EXISTS `movies`;

CREATE TABLE `movies` (
  `movieid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `imdburl` varchar(100) NOT NULL,
  `plotsimple` varchar(1000) DEFAULT NULL,
  `posterurl` varchar(100) NOT NULL,
  `imdbid` varchar(20) NOT NULL,
  `date` date DEFAULT NULL,
  `rel_year` int(11) DEFAULT NULL,
  PRIMARY KEY (`movieid`),
  UNIQUE KEY `imdbid` (`imdbid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `movies` */

insert  into `movies`(`movieid`,`title`,`rating`,`imdburl`,`plotsimple`,`posterurl`,`imdbid`,`date`,`rel_year`) values (1,'Harry Potter',7.8,'harry-potter.com','Blablabla','/resources/images/movie.png','tt123456','2003-03-03',2006),(2,'Tanya Grotter',6.5,'tanya-grotter.com','Blablabla','/resources/images/movie.png','tt438674','2005-07-25',2007),(3,'test3',4.5,'test3','hujfkyg','/resources/images/movie.png','tt56789','2004-10-16',2005);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `login` varchar(20) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `phonenumber` varchar(15) DEFAULT NULL,
  `pic_url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`userid`,`firstname`,`lastname`,`login`,`pass`,`email`,`birthday`,`phonenumber`,`pic_url`) values (1,'Nastya','Smirnova','aloren','pass','email@gmail.com','1992-05-15','51575',NULL),(2,'Vasya','Pupkin','vasya','pass','test@gmail.com','1786-05-07','65988794',NULL),(3,'Nastya','Smirnova','Nastya','pass','zminyty@gmail.com',NULL,'0931961390','http://assets3.lookatme.ru/assets/user-userpic/f7/33/318797/user-userpic.0527b27e-f90b-4eb8-b074-b756b9bc025f.jpg'),(4,'qw','qwe','ert','e','t','2013-05-08','1234567',NULL),(5,'ytr','gfd','gfd','hgf','hgf','2013-05-23','2345678',NULL),(6,'nhgnmhgm','nhgmghm','nmghm','mhgmgm',NULL,NULL,NULL,NULL),(7,'wert','ert','nhnh','rt',NULL,NULL,NULL,NULL),(8,'nhg','kjhk','xzwd','wdwdw',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
