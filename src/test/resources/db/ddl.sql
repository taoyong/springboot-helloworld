CREATE TABLE  user
(
  id bigint(20) NOT NULL auto_increment,
  userName varchar(25) DEFAULT NULL ,
  userAge tinyint(4) DEFAULT NULL,
  userSex varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);