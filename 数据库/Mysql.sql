CREATE DATABASE `ssmlibrary`;

USE `ssmlibrary`;

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
`bookID` INT(10) NOT NULL AUTO_INCREMENT COMMENT '书id',
`bookName` VARCHAR(100) NOT NULL COMMENT '书名',
`bookCounts` INT(11) NOT NULL COMMENT '数量',
`detail` VARCHAR(200) NOT NULL COMMENT '描述',
KEY `bookID` (`bookID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT  INTO `books`(`bookID`,`bookName`,`bookCounts`,`detail`)VALUES
(1,'Java',1,'从入门到放弃'),
(2,'MySQL',10,'从删库到跑路'),
(3,'Linux',5,'从进门到进牢');

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`(
`id` INT(10) NOT NULL AUTO_INCREMENT  PRIMARY KEY COMMENT '用户id',
`username` VARCHAR(16) NOT NULL COMMENT '用户名',
`password` VARCHAR(16) NOT NULL COMMENT '密码'
) ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT  INTO `user`(`id`,`username`,`password`)VALUES
(1,'admin','123456'),
(2,'admin2','123456'),
(3,'admin3','123456');