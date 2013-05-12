/*Table structure for table users */

DROP TABLE users IF EXISTS;

CREATE TABLE users (
  userid int(11) NOT NULL AUTO_INCREMENT,
  firstname varchar(50) DEFAULT NULL,
  lastname varchar(50) DEFAULT NULL,
  login varchar(20) NOT NULL,
  pass varchar(100) NOT NULL,
  email varchar(30) DEFAULT NULL,
  birthday date DEFAULT NULL,
  phonenumber varchar(15) DEFAULT NULL,
  pic_url varchar(100) DEFAULT NULL,
  PRIMARY KEY (userid),
  UNIQUE KEY login (login)
);

/*Table structure for table admins */

DROP TABLE admins IF EXISTS;

CREATE TABLE admins (
  userid int(11) NOT NULL,
  is_admin tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (userid),
  UNIQUE KEY userid_admin (userid, is_admin),
  CONSTRAINT admins_ibfk_1 FOREIGN KEY (userid) REFERENCES users (userid) ON DELETE CASCADE ON UPDATE NO ACTION
);

/*Table structure for table movies */

DROP TABLE movies IF EXISTS;

CREATE TABLE movies (
  movieid int(11) NOT NULL AUTO_INCREMENT,
  title varchar(200) DEFAULT NULL,
  rating double DEFAULT NULL,
  imdburl varchar(100) NOT NULL,
  plotsimple varchar(1000) DEFAULT NULL,
  posterurl varchar(100) NOT NULL,
  imdbid varchar(20) NOT NULL,
  date date DEFAULT NULL,
  rel_year int(11) DEFAULT NULL,
  PRIMARY KEY (movieid),
  UNIQUE KEY imdbid (imdbid)
);

/*Table structure for table comments */

DROP TABLE comments IF EXISTS;

CREATE TABLE comments (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(100) DEFAULT '',
  text varchar(500) DEFAULT NULL,
  userid int(11) NOT NULL,
  movieid int(11) DEFAULT NULL,
  rating double DEFAULT '0',
  PRIMARY KEY (id),
  CONSTRAINT comments_ibfk_1 FOREIGN KEY (userid) REFERENCES users (userid),
  CONSTRAINT comments_ibfk_2 FOREIGN KEY (movieid) REFERENCES movies (movieid)
);

/*Table structure for table favorites */

DROP TABLE favorites IF EXISTS;

CREATE TABLE favorites (
  userid int(11) NOT NULL,
  movieid int(11) NOT NULL,
  UNIQUE KEY userid (userid, movieid),
  CONSTRAINT favorites_ibfk_1 FOREIGN KEY (userid) REFERENCES users (userid),
  CONSTRAINT favorites_ibfk_2 FOREIGN KEY (movieid) REFERENCES movies (movieid)
);