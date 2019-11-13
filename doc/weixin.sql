/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : flb_weixin

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-12-21 10:59:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for weixin_channel
-- ----------------------------
DROP TABLE IF EXISTS `weixin_channel`;
CREATE TABLE `weixin_channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT '0' COMMENT '父渠道ID',
  `code` varchar(25) DEFAULT NULL COMMENT '编码',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=234 DEFAULT CHARSET=utf8 COMMENT='渠道';

-- ----------------------------

-- ----------------------------
-- Table structure for weixin_media
-- ----------------------------
DROP TABLE IF EXISTS `weixin_media`;
CREATE TABLE `weixin_media` (
  `id` int(11) NOT NULL,
  `message_id` varchar(64) DEFAULT NULL COMMENT '所属消息id',
  `media_id` varchar(64) DEFAULT NULL COMMENT '通过素材管理接口上传多媒体文件，得到的id',
  `title` varchar(64) DEFAULT NULL COMMENT '消息的标题',
  `description` varchar(64) DEFAULT NULL COMMENT '消息的描述',
  `music_url` varchar(256) DEFAULT NULL COMMENT '音乐链接',
  `hqmusic_url` varchar(256) DEFAULT NULL COMMENT '高质量音乐链接，WIFI环境优先使用该链接播放音乐',
  `thumb_media_id` varchar(64) DEFAULT NULL COMMENT '缩略图的媒体id，通过上传多媒体文件，得到的id',
  `pic_url` varchar(256) DEFAULT NULL COMMENT '图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致',
  `url` varchar(256) DEFAULT NULL COMMENT '点击图文消息跳转链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='媒体消息\r\n';

-- ----------------------------
-- Records of weixin_media
-- ----------------------------

-- ----------------------------
-- Table structure for weixin_robot_msg
-- ----------------------------
DROP TABLE IF EXISTS `weixin_robot_msg`;
CREATE TABLE `weixin_robot_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '消息创建时间 （整型）',
  `msg_type` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '消息类型，event',
  `keyword` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '关键字,多个关键字使用逗号分隔开',
  `content` text COLLATE utf8mb4_bin COMMENT '消息内容',
  `desc` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='自动回复表';

---------------------------
-- Table structure for weixin_subscribe
-- ----------------------------
DROP TABLE IF EXISTS `weixin_subscribe`;
CREATE TABLE `weixin_subscribe` (
  `opend_id` varchar(28) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '微信openid',
  `event_key` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '关注渠道码',
  `subscribe_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '关注时间',
  PRIMARY KEY (`opend_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='关注消息';

-- ----------------------------
-- Records of weixin_subscribe
-- ----------------------------
INSERT INTO `weixin_subscribe` VALUES ('odEb6svImr1hPa62nlD_ROUBCfno', 'wusimin', '2015-12-14 16:29:15');

-- ----------------------------
-- Table structure for wexin_template_msg
-- ----------------------------
DROP TABLE IF EXISTS `wexin_template_msg`;
CREATE TABLE `wexin_template_msg` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  `touser` varchar(28) DEFAULT NULL COMMENT '模板消息接收人',
  `template_id` varchar(43) DEFAULT NULL COMMENT '模板id',
  `url` varchar(256) DEFAULT NULL COMMENT '详情url',
  `topcolor` varchar(7) DEFAULT NULL COMMENT 'topcolor',
  `errcode` int(5) DEFAULT NULL COMMENT '错误编码,含义参考微信文档',
  `errmsg` varchar(200) DEFAULT NULL,
  `msgid` varchar(13) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL COMMENT '推送结果回调状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板消息';

-- ----------------------------
-- Records of wexin_template_msg
-- ----------------------------

-- ----------------------------
-- Table structure for wexin_template_msg_data
-- ----------------------------
DROP TABLE IF EXISTS `wexin_template_msg_data`;
CREATE TABLE `wexin_template_msg_data` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `template_msg_id` bigint(20) DEFAULT NULL COMMENT '模板消息外键',
  `name` varchar(30) DEFAULT NULL COMMENT '字符串key名称',
  `value` varchar(300) DEFAULT NULL COMMENT '字符串值',
  `color` varchar(7) DEFAULT NULL COMMENT '文字颜色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板消息详情';

-- ----------------------------
-- Records of wexin_template_msg_data
-- ----------------------------
