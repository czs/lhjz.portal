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

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'name_xiwc', 'password');
INSERT INTO `user` VALUES ('2', 'xiwc', 'pwd');
INSERT INTO `user` VALUES ('3', '张三', 'password');
