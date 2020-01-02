/*
 Navicat Premium Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : maintain

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 30/12/2019 11:36:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限中文名称',
  `ename` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '英文名称',
  `catalog` int(11) DEFAULT NULL COMMENT '0表示目录，1表示功能',
  `parentid` int(11) DEFAULT NULL COMMENT '父级编号，关联自身',
  `path` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of permissions
-- ----------------------------
BEGIN;
INSERT INTO `permissions` VALUES (1, '系统管理', 'sys', 0, 0, NULL);
INSERT INTO `permissions` VALUES (2, '初始数据', 'initdata', 0, 1, NULL);
INSERT INTO `permissions` VALUES (3, '系统参数定义', 'param', 0, 2, 'sys/find.html');
INSERT INTO `permissions` VALUES (4, '查询所有', 'find', 1, 3, '/param/find');
INSERT INTO `permissions` VALUES (5, '根据编号查询', 'findById', 1, 3, '/param/findById');
INSERT INTO `permissions` VALUES (6, '人事', 'person', 0, 0, NULL);
INSERT INTO `permissions` VALUES (7, '员工资料', 'dep_recod', 0, 6, NULL);
INSERT INTO `permissions` VALUES (8, '岗位定义', 'post_def', 0, 7, 'person/find.html');
INSERT INTO `permissions` VALUES (9, '岗位查询', 'find', 1, 8, '/postDef/find');
INSERT INTO `permissions` VALUES (10, '岗位根据编号查询', 'findById', 1, 9, '/postDef/findById');
INSERT INTO `permissions` VALUES (11, '权限管理', 'permsmanager', 0, 1, NULL);
INSERT INTO `permissions` VALUES (12, '权限查询', 'permsfind', 0, 11, '/perms/find');
COMMIT;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of roles
-- ----------------------------
BEGIN;
INSERT INTO `roles` VALUES (1, '管理员');
INSERT INTO `roles` VALUES (2, '收银员');
COMMIT;

-- ----------------------------
-- Table structure for roles_perms
-- ----------------------------
DROP TABLE IF EXISTS `roles_perms`;
CREATE TABLE `roles_perms` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rid` int(11) DEFAULT NULL COMMENT '关联角色编号',
  `pid` int(11) DEFAULT NULL COMMENT '关联权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of roles_perms
-- ----------------------------
BEGIN;
INSERT INTO `roles_perms` VALUES (1, 1, 1);
INSERT INTO `roles_perms` VALUES (2, 1, 2);
INSERT INTO `roles_perms` VALUES (3, 1, 3);
INSERT INTO `roles_perms` VALUES (4, 1, 4);
INSERT INTO `roles_perms` VALUES (5, 1, 5);
INSERT INTO `roles_perms` VALUES (6, 1, 6);
INSERT INTO `roles_perms` VALUES (7, 1, 7);
INSERT INTO `roles_perms` VALUES (8, 1, 8);
INSERT INTO `roles_perms` VALUES (9, 1, 9);
INSERT INTO `roles_perms` VALUES (11, 1, 11);
INSERT INTO `roles_perms` VALUES (12, 1, 12);
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，学生编号',
  `username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '盐',
  `rid` int(11) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, 'admin', '123', '999', NULL);
INSERT INTO `users` VALUES (2, 'user1', '123', '888', NULL);
COMMIT;

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int(11) DEFAULT NULL COMMENT '用户编号',
  `rid` int(11) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of users_roles
-- ----------------------------
BEGIN;
INSERT INTO `users_roles` VALUES (1, 1, 1);
INSERT INTO `users_roles` VALUES (2, 1, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
