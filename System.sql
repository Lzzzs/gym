/*
 Navicat Premium Data Transfer

 Source Server         : study_mysql
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : gym

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 07/06/2023 17:28:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '课程表id',
  `img` varchar(255) NOT NULL COMMENT '课程图片',
  `detail_text` varchar(1000) NOT NULL COMMENT '课程详情',
  `name` varchar(255) NOT NULL COMMENT '课程名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for course_subscribe
-- ----------------------------
DROP TABLE IF EXISTS `course_subscribe`;
CREATE TABLE `course_subscribe` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '课程预约表id',
  `course_id` int unsigned NOT NULL COMMENT '预约的课程id',
  `user_id` varchar(255) NOT NULL COMMENT '用户id',
  `subscribe_time` varchar(100) NOT NULL COMMENT '预约截止时间',
  `is_done` int NOT NULL DEFAULT '0' COMMENT '是否完成，0还未完成，1已完成',
  PRIMARY KEY (`id`),
  KEY `course_subscribe_course_id` (`course_id`),
  KEY `course_subscribe_user_id` (`user_id`),
  CONSTRAINT `course_subscribe_course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `course_subscribe_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for gymnasium
-- ----------------------------
DROP TABLE IF EXISTS `gymnasium`;
CREATE TABLE `gymnasium` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '健身房id',
  `curnum` int NOT NULL COMMENT '当前人数',
  `totalnum` int NOT NULL COMMENT '总人数',
  `place` varchar(255) NOT NULL COMMENT '健身房地址',
  `detail_text` text NOT NULL COMMENT '详情文字',
  `detail_img` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '详情图片',
  `img` varchar(255) NOT NULL COMMENT '健身房图片',
  `name` varchar(255) NOT NULL COMMENT '健身房名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for gymnasium_subscribe
-- ----------------------------
DROP TABLE IF EXISTS `gymnasium_subscribe`;
CREATE TABLE `gymnasium_subscribe` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '健身房预约表id',
  `gymnasium_id` int unsigned NOT NULL COMMENT '健身房id',
  `user_id` varchar(255) NOT NULL COMMENT '用户id',
  `subscribe_time` varchar(100) NOT NULL COMMENT '预约截止时间',
  `is_done` int NOT NULL DEFAULT '0' COMMENT '是否完成，0还未完成，1已完成',
  `subscribe_time_start` varchar(100) NOT NULL COMMENT '预约开始时间',
  `ing` int NOT NULL DEFAULT '0' COMMENT '当前订阅是否正在进行中',
  PRIMARY KEY (`id`),
  KEY `gymnasium_sub_user_id` (`user_id`),
  KEY `gymnasium_sub_gymnasium_id` (`gymnasium_id`),
  CONSTRAINT `gymnasium_sub_gymnasium_id` FOREIGN KEY (`gymnasium_id`) REFERENCES `gymnasium` (`id`),
  CONSTRAINT `gymnasium_sub_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for leave_words
-- ----------------------------
DROP TABLE IF EXISTS `leave_words`;
CREATE TABLE `leave_words` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '留言表主键',
  `user_id` varchar(255) NOT NULL COMMENT '留言用户的id',
  `name` varchar(255) NOT NULL COMMENT '留言用户名字',
  `phone` varchar(255) NOT NULL COMMENT '留言用户号码',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '留言内容',
  `reply_content` text COMMENT '回复内容',
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  `is_read` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `leave_word_user_id` (`user_id`),
  CONSTRAINT `leave_word_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1904263178 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(255) NOT NULL COMMENT '用户主键',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `created_time` datetime NOT NULL COMMENT '账号创建时间',
  `role` int NOT NULL,
  `age` int DEFAULT NULL COMMENT '年龄',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `deleted` int NOT NULL DEFAULT '0' COMMENT '逻辑删除值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='1 管理员 2用户';

SET FOREIGN_KEY_CHECKS = 1;
