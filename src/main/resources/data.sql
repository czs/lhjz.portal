/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : lhjz

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2015-04-08 20:05:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authorities
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authorities
-- ----------------------------
INSERT INTO `authorities` VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO `authorities` VALUES ('admin', 'ROLE_USER');
INSERT INTO `authorities` VALUES ('xiwc', 'ROLE_ADMIN');
INSERT INTO `authorities` VALUES ('xiwc', 'ROLE_USER');
INSERT INTO `authorities` VALUES ('lhjz', 'ROLE_ADMIN');
INSERT INTO `authorities` VALUES ('lhjz', 'ROLE_USER');

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groups
-- ----------------------------

-- ----------------------------
-- Table structure for group_authorities
-- ----------------------------
DROP TABLE IF EXISTS `group_authorities`;
CREATE TABLE `group_authorities` (
  `group_id` bigint(20) NOT NULL,
  `authority` varchar(50) NOT NULL,
  KEY `fk_group_authorities_group` (`group_id`),
  CONSTRAINT `fk_group_authorities_group` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_authorities
-- ----------------------------

-- ----------------------------
-- Table structure for group_members
-- ----------------------------
DROP TABLE IF EXISTS `group_members`;
CREATE TABLE `group_members` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_group_members_group` (`group_id`),
  CONSTRAINT `fk_group_members_group` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_members
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('admin', '$2a$10$of1L1pNENMuUeP2/pMfy1ePScKhrOzHIrHsuhL2u1ieoXClLP5wFG', '1');
INSERT INTO `users` VALUES ('xiwc', '$2a$10$qR3ar2k/g9gsLgPKAqqprOcN4tsfQAiSd7mdLNDIEC4ytwAUKKgzO', '1');
INSERT INTO `users` VALUES ('lhjz', '$2a$10$cHoqi0vbJpkOe.ShF7A6qO0kf8lKOH/6tHr3oe7vA4UcKdtgGeJnq', '1');


/*
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
  */