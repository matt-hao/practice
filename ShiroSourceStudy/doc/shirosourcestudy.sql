/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : shirosourcestudy

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-08-24 01:19:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shiro_admin
-- ----------------------------
DROP TABLE IF EXISTS `shiro_admin`;
CREATE TABLE `shiro_admin` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_admin
-- ----------------------------

-- ----------------------------
-- Table structure for shiro_permission
-- ----------------------------
DROP TABLE IF EXISTS `shiro_permission`;
CREATE TABLE `shiro_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_permission
-- ----------------------------
INSERT INTO `shiro_permission` VALUES ('1', 'student_permission1');
INSERT INTO `shiro_permission` VALUES ('2', 'student_permission2');
INSERT INTO `shiro_permission` VALUES ('3', 'student_permission3');
INSERT INTO `shiro_permission` VALUES ('4', 'teacher_permission1');
INSERT INTO `shiro_permission` VALUES ('5', 'teacher_permission2');
INSERT INTO `shiro_permission` VALUES ('6', 'teacher_permission3');
INSERT INTO `shiro_permission` VALUES ('7', 'admin_permission1');
INSERT INTO `shiro_permission` VALUES ('8', 'admin_permission2');
INSERT INTO `shiro_permission` VALUES ('9', 'admin_permission3');

-- ----------------------------
-- Table structure for shiro_role
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role`;
CREATE TABLE `shiro_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `discription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_role
-- ----------------------------
INSERT INTO `shiro_role` VALUES ('1', 'student', 'this is student role');
INSERT INTO `shiro_role` VALUES ('2', 'teacher', 'this is teacher role');
INSERT INTO `shiro_role` VALUES ('3', 'admin', 'this is admin role');

-- ----------------------------
-- Table structure for shiro_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role_permission`;
CREATE TABLE `shiro_role_permission` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_role_permission
-- ----------------------------
INSERT INTO `shiro_role_permission` VALUES ('1', '1');
INSERT INTO `shiro_role_permission` VALUES ('1', '2');
INSERT INTO `shiro_role_permission` VALUES ('1', '3');
INSERT INTO `shiro_role_permission` VALUES ('2', '4');
INSERT INTO `shiro_role_permission` VALUES ('2', '5');
INSERT INTO `shiro_role_permission` VALUES ('2', '6');
INSERT INTO `shiro_role_permission` VALUES ('3', '7');
INSERT INTO `shiro_role_permission` VALUES ('3', '8');
INSERT INTO `shiro_role_permission` VALUES ('3', '9');

-- ----------------------------
-- Table structure for shiro_student
-- ----------------------------
DROP TABLE IF EXISTS `shiro_student`;
CREATE TABLE `shiro_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_student
-- ----------------------------

-- ----------------------------
-- Table structure for shiro_teacher
-- ----------------------------
DROP TABLE IF EXISTS `shiro_teacher`;
CREATE TABLE `shiro_teacher` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_teacher
-- ----------------------------

-- ----------------------------
-- Table structure for shiro_user_role
-- ----------------------------
DROP TABLE IF EXISTS `shiro_user_role`;
CREATE TABLE `shiro_user_role` (
  `role_id` bigint(20) NOT NULL,
  `row_id` bigint(20) NOT NULL,
  `row_table` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`,`row_id`,`row_table`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_user_role
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
