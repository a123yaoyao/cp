/*
Navicat MySQL Data Transfer

Source Server         : b
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : jpa

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-11-22 15:24:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_params
-- ----------------------------
DROP TABLE IF EXISTS `sys_params`;
CREATE TABLE `sys_params` (
  `id` char(32) DEFAULT NULL,
  `modifier` char(32) DEFAULT NULL,
  `modifytime` date DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `creator` char(32) DEFAULT NULL,
  `value` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_params
-- ----------------------------
