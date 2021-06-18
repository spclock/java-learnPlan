/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50645
Source Host           : localhost:3306
Source Database       : sync_data

Target Server Type    : MYSQL
Target Server Version : 50645
File Encoding         : 65001

Date: 2021-06-09 08:41:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'zhangsan', '10');
INSERT INTO `person` VALUES ('2', 'lishi', '20');
INSERT INTO `person` VALUES ('3', 'wangwu', '30');
