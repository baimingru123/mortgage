/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : mortgage_lending

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-07-23 22:39:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sf_house_mortgage_info
-- ----------------------------
DROP TABLE IF EXISTS `sf_house_mortgage_info`;
CREATE TABLE `sf_house_mortgage_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '发布人id',
  `village_name` varchar(64) DEFAULT NULL COMMENT '小区名称',
  `village_address` varchar(255) DEFAULT NULL COMMENT '小区所处地址',
  `village_img_url` varchar(64) DEFAULT NULL COMMENT '小区照片',
  `house_in_img_url` varchar(64) DEFAULT NULL COMMENT '房屋内部照片',
  `certificate_house_img_url` varchar(64) DEFAULT NULL COMMENT '房产证照片',
  `mortgage_price` decimal(8,2) DEFAULT '0.00' COMMENT '抵押价格  单位:万元',
  `contact_phone` varchar(64) DEFAULT NULL COMMENT '联系方式',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态  1发布中  2已抵押',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `status` (`status`) USING BTREE,
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='房屋抵押信息表';

-- ----------------------------
-- Records of sf_house_mortgage_info
-- ----------------------------

-- ----------------------------
-- Table structure for sf_lend_info
-- ----------------------------
DROP TABLE IF EXISTS `sf_lend_info`;
CREATE TABLE `sf_lend_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '发布人id',
  `lend_total_amount` decimal(8,2) DEFAULT '0.00' COMMENT '出借金额  单位:万元',
  `lend_cycle` int(11) DEFAULT NULL COMMENT '出借周期',
  `lend_cycle_unit` tinyint(4) DEFAULT NULL COMMENT '出借周期单位  1天  2月  3年',
  `lend_rate` decimal(8,2) DEFAULT NULL COMMENT '利率  单位：%',
  `already_lend_amount` decimal(8,2) DEFAULT '0.00' COMMENT '已出借金额  单位：万元',
  `no_lend_amount` decimal(8,2) DEFAULT '0.00' COMMENT '未出借金额  单位：万元',
  `already_lend_count` int(11) DEFAULT '0' COMMENT '已出借次数',
  `lend_total_count` int(11) DEFAULT '0' COMMENT '总出借次数',
  `contact_phone` varchar(32) DEFAULT NULL COMMENT '联系方式',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  1发布中  2部分出借  3全部出借',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='出借款信息表';

-- ----------------------------
-- Records of sf_lend_info
-- ----------------------------

-- ----------------------------
-- Table structure for sf_user
-- ----------------------------
DROP TABLE IF EXISTS `sf_user`;
CREATE TABLE `sf_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of sf_user
-- ----------------------------
INSERT INTO `sf_user` VALUES ('1', '18754190709', '123456', '2019-07-23 07:30:09', null);
