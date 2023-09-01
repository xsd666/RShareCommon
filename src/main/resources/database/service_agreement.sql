/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : service_engine

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 01/09/2023 10:50:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for service_agreement
-- ----------------------------
DROP TABLE IF EXISTS `service_agreement`;
CREATE TABLE `service_agreement`  (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `service_agreement_identifier` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '服务规约标识符号',
  `service_agreement_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '服务规约名称',
  `service_agreement_desc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '服务规约描述',
  `service_agreement_version` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '服务规约版本号',
  `service_agreement_org` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '规约单位代码',
  `service_agreement_org_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '规约单位名称',
  `data_service_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据接口代码',
  `data_service` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据接口',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `service_file_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '接口定义规则文件名称',
  `service_file_store_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '接口定义规则文件存储位置',
  `service_interface_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '接口url',
  `service_interface_http_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '接口方法,get,post等',
  `service_resp_file_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '接口响应规则文件名称',
  `service_resp_file_store_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '接口响应规则文件存储位置',
  `service_agreement_lang_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '规约语言',
  `wsdl_xml` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '规约xml',
  `open_api_json` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '规约json',
  `deleted` int(1) DEFAULT 0 COMMENT '删除标准',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `service_agreement_identifier`(`service_agreement_identifier`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务规约' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
