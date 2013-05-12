/* Films */
insert into movies (movieid, title, rating, imdburl, plotsimple, posterurl, imdbid, date, rel_year) 
values('1','Harry Potter','7.8','harry-potter.com','Blablabla','poster.url.test','tt123456','2003-03-03','2006');

insert into movies (movieid, title, rating, imdburl, plotsimple, posterurl, imdbid, date, rel_year) 
values('2','Tanya Grotter','6.5','tanya-grotter.com','Blablabla','poster.tanya.jpg','tt438674','2005-07-25','2007');

/* Users */
insert into users (userid, firstname, lastname, login, pass, email, birthday, phonenumber, pic_url) 
values('1','Nastya','Smirnova','aloren','pass','email@gmail.com','1991-09-20','51575',NULL);

insert into users (userid, firstname, lastname, login, pass, email, birthday, phonenumber, pic_url) 
values('2','Vasya','Pupkin','login','pass','test@gmail.com','1786-05-07','65988794',NULL);

/* Favorites */
insert into favorites (userid, movieid) values('1','1');
insert into favorites (userid, movieid) values('1','2');
insert into favorites (userid, movieid) values('2','2');

/* Admins */
insert into admins (userid, is_admin) values('1', '1');

/* Comments */
INSERT INTO comments (id, title, text, userid, movieid, rating) 
VALUES (1, 'title1', 'text1', '1', '1', '1.0'); 

INSERT INTO comments (id, title, text, userid, movieid, rating) 
VALUES (2, 'title2', 'text2', '1', '2', '2.0'); 
