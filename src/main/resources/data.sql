/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : lhjz

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2015-04-07 22:29:17
*/

SET FOREIGN_KEY_CHECKS=0;
/*
-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------

INSERT INTO `users` VALUES ('admin', 'admin', '');
INSERT INTO `users` VALUES ('xiwc', 'xiwc', '');

-- ----------------------------
-- Table structure for authorities
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authorities
-- ----------------------------

INSERT INTO `authorities` VALUES ('admin', 'USER,ADMIN');
INSERT INTO `authorities` VALUES ('xiwc', 'USER');
*/


DROP TABLE IF EXISTS `users`;
create table users(
  username varchar(50) not null primary key,
  password varchar(50) not null,
  enabled boolean not null);
  
INSERT INTO `users` VALUES ('admin', 'admin', 0);
INSERT INTO `users` VALUES ('xiwc', 'xiwc', 1);

DROP TABLE IF EXISTS `authorities`;
create table authorities (
  username varchar(50) not null,
  authority varchar(50) not null,
  constraint fk_authorities_users foreign key(username) references users(username));
  create unique index ix_auth_username on authorities (username,authority);
  
INSERT INTO `authorities` VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO `authorities` VALUES ('admin', 'ROLE_USER');
INSERT INTO `authorities` VALUES ('xiwc', 'ROLE_ADMIN');
INSERT INTO `authorities` VALUES ('xiwc', 'ROLE_USER');

DROP TABLE IF EXISTS `groups`;
create table groups (
  id bigint AUTO_INCREMENT primary key,
  group_name varchar(50) not null);

DROP TABLE IF EXISTS `group_authorities`;
create table group_authorities (
  group_id bigint not null,
  authority varchar(50) not null,
  constraint fk_group_authorities_group foreign key(group_id) references groups(id));

DROP TABLE IF EXISTS `group_members`;
create table group_members (
  id bigint AUTO_INCREMENT primary key,
  username varchar(50) not null,
  group_id bigint not null,
  constraint fk_group_members_group foreign key(group_id) references groups(id));