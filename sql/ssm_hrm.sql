/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : ssm_hrm

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-08-28 19:10:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dep
-- ----------------------------
DROP TABLE IF EXISTS `dep`;
CREATE TABLE `dep` (
  `depId` int(10) NOT NULL AUTO_INCREMENT,
  `depLeader` varchar(255) NOT NULL,
  `depName` varchar(255) NOT NULL,
  PRIMARY KEY (`depId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dep
-- ----------------------------
INSERT INTO `dep` VALUES ('1', '赵洋', '生活部');
INSERT INTO `dep` VALUES ('2', '陈启航', '纪检部');
INSERT INTO `dep` VALUES ('3', '黄思涵', '后勤部');
INSERT INTO `dep` VALUES ('4', '何浩', '人事部');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empId` int(10) NOT NULL AUTO_INCREMENT,
  `empName` varchar(255) NOT NULL,
  `empEmail` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `depId` int(10) NOT NULL,
  `hiredate` date NOT NULL,
  `phone` varchar(255) NOT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('6', 'zzy7', '972193026@qq.com', '女', '3', '2019-08-10', '13000009999', '23141241');
INSERT INTO `emp` VALUES ('7', 'zzy7', '972193026@qq.com', '女', '2', '2019-08-10', '13000009999', null);
INSERT INTO `emp` VALUES ('8', 'zzy8', '972193026@qq.com', '女', '1', '2019-08-10', '13000009999', '412414141');
INSERT INTO `emp` VALUES ('9', 'zzy9', '972193026@qq.com', '男', '4', '2019-08-10', '13000009999', null);
INSERT INTO `emp` VALUES ('10', 'zzy10', '972193026@qq.com', '女', '3', '2019-08-10', '13000009999', null);
INSERT INTO `emp` VALUES ('12', 'test111', '2322141@qq.com', '男', '1', '2019-08-15', '13029998888', 'test');
INSERT INTO `emp` VALUES ('13', '11111', '97219321@qq.com', '男', '1', '2019-08-15', '13922228888', 'test');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `icon` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `authority` int(1) NOT NULL DEFAULT '1' COMMENT '用户类型:(1.为普通用户,2.为管理员)',
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('14ce8b4fd6094235b61fcb9dae50fb69', 'admin', '管理员', '/imgs/icon/user_default_icon.jpg', 'XWASL7svDLs9+0jfeNa5Wg==', '13086675350', '成都信息工程大学', '2', 'zyf695112338@qq.com');
INSERT INTO `user` VALUES ('8665252c0e5c4b7b830389010007f0f1', 'zzy001', 'jml', '/imgs/icon/8665252c0e5c4b7b830389010007f0f1_icon_2019_08_28_12_33_02.jpg', 'ZKG7+pnCZ46a+328DBu+Hg==', '13086665555', '成都信息工程大学', '1', '972193026@qq.com');
