/*
Navicat MySQL Data Transfer

Source Server         : MyConnection
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-03-06 01:17:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'Lucy');
INSERT INTO `student` VALUES ('2', 'Nami');
INSERT INTO `student` VALUES ('3', 'Elsa');
INSERT INTO `student` VALUES ('5', 'Gundum');
INSERT INTO `student` VALUES ('6', 'Loki');
INSERT INTO `student` VALUES ('7', 'Lufy');
INSERT INTO `student` VALUES ('8', 'Sanji');
INSERT INTO `student` VALUES ('9', 'Solo');
INSERT INTO `student` VALUES ('10', 'Yumi');
