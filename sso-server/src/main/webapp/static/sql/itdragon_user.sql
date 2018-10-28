/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : jpa

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-10-28 15:28:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `itdragon_user`
-- ----------------------------
DROP TABLE IF EXISTS `itdragon_user`;
CREATE TABLE `itdragon_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `plain_password` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `iphone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `updated_date` varchar(255) DEFAULT NULL,
  `platform` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itdragon_user
-- ----------------------------
INSERT INTO `itdragon_user` VALUES ('1', 'itdragon', 'ITDragonGit', null, 'da809e27dc5e065feb2415883b7c4ad2', '12349857999', 'itdragon@git.com', '2018-10-27 01:48:07', '2018-10-27 01:48:07', 'github', 'a5160bd1-f3d1-42e7-b3b9-dfd5110b9fe7');
