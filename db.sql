
create database school;

use school;

CREATE TABLE student (
  studentId int(5) NOT NULL AUTO_INCREMENT,
  firstName varchar(25) DEFAULT NULL,
  lastName varchar(25) DEFAULT NULL,
  year int(2) DEFAULT NULL,
 PRIMARY KEY (studentId));