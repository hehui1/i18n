/*
 Navicat Premium Data Transfer

 Source Server         : 11
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : i18n

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 19/02/2020 13:35:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for language
-- ----------------------------
DROP TABLE IF EXISTS `language`;
CREATE TABLE `language`  (
  `id` int(11) NOT NULL,
  `message_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `message_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of language
-- ----------------------------
INSERT INTO `language` VALUES (1, 'message_user', '请输入用户名', 'zh');
INSERT INTO `language` VALUES (2, 'message_pass', '请输入密码', 'zh');
INSERT INTO `language` VALUES (3, 'message_login', '登录', 'zh');
INSERT INTO `language` VALUES (4, 'message_user', 'Enter username', 'en');
INSERT INTO `language` VALUES (5, 'message_pass', 'Enter password', 'en');
INSERT INTO `language` VALUES (6, 'message_login', 'Login', 'en');
INSERT INTO `language` VALUES (7, 'message_index', '欢迎进入首页', 'zh');
INSERT INTO `language` VALUES (8, 'message_index', 'welcome to index', 'en');

SET FOREIGN_KEY_CHECKS = 1;
