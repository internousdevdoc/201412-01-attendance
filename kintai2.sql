DROP DATABASE IF EXISTS kintai2;
CREATE DATABASE kintai2;
use kintai2
DROP TABLE IF EXISTS login;
CREATE TABLE login (
  ID int(11) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY (username)
);