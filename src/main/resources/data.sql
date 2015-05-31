/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : lhjz

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2015-04-08 20:05:57
*/

SET FOREIGN_KEY_CHECKS=0;
SET NAMES 'utf8';

-- ----------------------------
-- Table structure for authorities
-- ----------------------------
--DROP TABLE IF EXISTS `authorities`;
--CREATE TABLE `authorities` (
--  `username` varchar(50) NOT NULL,
--  `authority` varchar(50) NOT NULL,
--  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
--  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authorities
-- ----------------------------
INSERT INTO `authorities` (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO `authorities` (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO `authorities` (username, authority) VALUES ('xiwc', 'ROLE_ADMIN');
INSERT INTO `authorities` (username, authority) VALUES ('xiwc', 'ROLE_USER');
INSERT INTO `authorities` (username, authority) VALUES ('lhjz', 'ROLE_ADMIN');
INSERT INTO `authorities` (username, authority) VALUES ('lhjz', 'ROLE_USER');

-- ----------------------------
-- Table structure for groups
-- ----------------------------
--DROP TABLE IF EXISTS `groups`;
--CREATE TABLE `groups` (
--  `id` bigint(20) NOT NULL AUTO_INCREMENT,
--  `group_name` varchar(50) NOT NULL,
--  PRIMARY KEY (`id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groups
-- ----------------------------

-- ----------------------------
-- Table structure for group_authorities
-- ----------------------------
--DROP TABLE IF EXISTS `group_authorities`;
--CREATE TABLE `group_authorities` (
--  `group_id` bigint(20) NOT NULL,
--  `authority` varchar(50) NOT NULL,
--  KEY `fk_group_authorities_group` (`group_id`),
--  CONSTRAINT `fk_group_authorities_group` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_authorities
-- ----------------------------

-- ----------------------------
-- Table structure for group_members
-- ----------------------------
--DROP TABLE IF EXISTS `group_members`;
--CREATE TABLE `group_members` (
--  `id` bigint(20) NOT NULL AUTO_INCREMENT,
--  `username` varchar(50) NOT NULL,
--  `group_id` bigint(20) NOT NULL,
--  PRIMARY KEY (`id`),
--  KEY `fk_group_members_group` (`group_id`),
--  CONSTRAINT `fk_group_members_group` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_members
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
--DROP TABLE IF EXISTS `users`;
--CREATE TABLE `users` (
--  `username` varchar(50) NOT NULL,
--  `password` varchar(255) NOT NULL,
--  `enabled` tinyint(1) NOT NULL,
--  PRIMARY KEY (`username`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` (username, password, enabled) VALUES ('admin', '$2a$10$of1L1pNENMuUeP2/pMfy1ePScKhrOzHIrHsuhL2u1ieoXClLP5wFG', '');
INSERT INTO `users` (username, password, enabled) VALUES ('xiwc', '$2a$10$qR3ar2k/g9gsLgPKAqqprOcN4tsfQAiSd7mdLNDIEC4ytwAUKKgzO', '\0');
INSERT INTO `users` (username, password, enabled) VALUES ('lhjz', '$2a$10$cHoqi0vbJpkOe.ShF7A6qO0kf8lKOH/6tHr3oe7vA4UcKdtgGeJnq', '');

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
--DROP TABLE IF EXISTS `persistent_logins`;
--CREATE TABLE `persistent_logins` (
--  `series` varchar(64) NOT NULL,
--  `last_used` datetime NOT NULL,
--  `token` varchar(64) NOT NULL,
--  `username` varchar(64) NOT NULL,
--  PRIMARY KEY (`series`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persistent_logins

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('1', '2015-04-25 10:01:51', 'img08_b.jpg', 'upload/img/0/', 'Bultin', 'lhjz', '4dfa871e-6cc1-480c-a1a8-2a56dae30b51.jpg', '0');
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('2', '2015-04-25 10:01:51', 'img07_b.jpg', 'upload/img/0/', 'Bultin', 'lhjz', '91baaaf6-237f-47c1-80d1-6af3abd267a3.jpg', '0');
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('3', '2015-04-25 10:01:52', 'img04_b.jpg', 'upload/img/0/', 'Bultin', 'lhjz', '8734d1cc-0c69-4ab2-9611-3c86e7ca2c58.jpg', '0');
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('4', '2015-04-25 10:01:52', 'img01_b.jpg', 'upload/img/0/', 'Bultin', 'lhjz', 'b1e70aa4-2013-4150-9d71-47ebaca5963d.jpg', '0');
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('5', '2015-04-25 10:01:52', 'img02_b.jpg', 'upload/img/0/', 'Bultin', 'lhjz', '66170316-4b4c-45fe-bc55-9f25459a2072.jpg', '0');
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('6', '2015-04-25 10:01:52', 'img06_b.jpg', 'upload/img/0/', 'Bultin', 'lhjz', '94947a26-3c39-495e-8c65-62e7a7ade429.jpg', '0');
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('7', '2015-04-25 10:01:52', 'img05_b.jpg', 'upload/img/0/', 'Bultin', 'lhjz', 'ba77d88a-3a9f-4afc-bafe-27f05be65114.jpg', '0');
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('8', '2015-04-25 10:01:53', 'img03_b.jpg', 'upload/img/0/', 'Bultin', 'lhjz', '0c590fa7-430f-428a-aa38-fa29227caa43.jpg', '0');
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('10', '2015-05-31 14:27:58', '1.jpg', 'upload/img/0/', 'Bultin', 'lhjz', '09c2ec3a-3afc-43ff-af20-3828f0744446.jpg', '0');
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('11', '2015-05-31 14:27:58', '2.jpg', 'upload/img/0/', 'Bultin', 'lhjz', '749727e8-d955-4652-adf2-1ef217ee64b8.jpg', '0');
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('12', '2015-05-31 14:27:58', '3.jpg', 'upload/img/0/', 'Bultin', 'lhjz', 'bc2b78b3-e808-420e-a156-5ef54887d714.jpg', '0');
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('13', '2015-05-31 14:27:59', 'img-b1.jpg', 'upload/img/0/', 'Bultin', 'lhjz', '0a6bc830-91d4-4675-a413-4d93823f5ba0.jpg', '0');
INSERT INTO `file` (id, create_date, name, path, status, username, uuid_name, version) VALUES ('14', '2015-05-31 14:27:59', 'img-b2.jpg', 'upload/img/0/', 'Bultin', 'lhjz', '1dee3a09-87a5-463d-819f-0e1e93bb5e7d.jpg', '0');

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` (id, content, create_date, name, path, status, username, version) VALUES ('1', '<span style=\"color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</span><a href=\"http://www.jizhuwang.com.cn/\" jquery1336356008877=\"269\" style=\"padding: 0px; margin: 0px; color: rgb(1, 36, 92); font-family: Verdana, Arial, Tahoma; line-height: 25px; background-color: rgb(255, 255, 255);\"><span jquery1336356008877=\"270\" style=\"padding: 0px; margin: 0px; color: rgb(0, 0, 0);\">颈椎病</span></a><span jquery1336356008877=\"271\" style=\"padding: 0px; margin: 0px; font-family: Verdana, Arial, Tahoma; line-height: 25px; color: rgb(0, 0, 0);\">会引发的病症主要有哪些呢？伴随着颈椎病的发生，大部分会出现一些并发症。患者千万不要以为略微疼痛是小事，忍忍就过去，要知道，疼痛之后可能失明或瘫痪。专家介绍，颈椎病本身而言就是错综复杂的，不光会引起颈肩部的一些症状，还可能引起一些其它疾病的。这些看似与颈椎病绝不相关，实则都是由于颈椎病所引起的并发症，到底颈椎病所引起的并发症都有哪些呢？<br jquery1336356008877=\"272\" style=\"padding: 0px; margin: 0px;\">　　吞咽障碍：吞咽时有堵塞感。食管内有异物感。少数人有恶心。呕吐。声音沙哑。干咳。胸闷等症状。这是由于颈椎前缘直截压迫食管后壁而引起食管狭小。<br jquery1336356008877=\"273\" style=\"padding: 0px; margin: 0px;\">　　视力障碍：表现为视力下降。眼胀痛。怕光。流泪。</span><a href=\"http://www.jizhuwang.com.cn/\" jquery1336356008877=\"274\" style=\"padding: 0px; margin: 0px; color: rgb(1, 36, 92); font-family: Verdana, Arial, Tahoma; line-height: 25px; background-color: rgb(255, 255, 255);\"><span jquery1336356008877=\"275\" style=\"padding: 0px; margin: 0px; color: rgb(0, 0, 0);\">瞳孔</span></a><span jquery1336356008877=\"276\" style=\"padding: 0px; margin: 0px; font-family: Verdana, Arial, Tahoma; line-height: 25px; color: rgb(0, 0, 0);\">大小不等。甚至出现视野缩小和视力锐减。个别患者还可发生失明。<br jquery1336356008877=\"277\" style=\"padding: 0px; margin: 0px;\">　　高血压颈椎病：可引起血压升高或降低。<br jquery1336356008877=\"278\" style=\"padding: 0px; margin: 0px;\">　　胸部疼痛：表现为起病缓慢的顽固性的单侧胸大肌和乳房疼痛。<br jquery1336356008877=\"279\" style=\"padding: 0px; margin: 0px;\">　　下肢瘫痪：早期表现为下肢麻痹。疼痛。跛行。有的患者在走路时有如踏棉花的感觉。个别患者还可伴有排便。排尿障碍。</span>', '2015-05-24 11:18:50', '颈椎病所引发的病症介绍', null, 'Bultin', 'lhjz', '0');
INSERT INTO `article` (id, content, create_date, name, path, status, username, version) VALUES ('2', '<p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">长久地面对电脑，你一定觉得自己僵硬了。看看办公室的你，弯腰驼背，歪着肩膀，仰着油光可鉴的脸，被工作折磨得神形溃散——这是偶然你看到镜子中的自己时的状态，三个小时没离开座位，忘了托着大脑的身体，忽视了饥渴的肠胃，忽然感觉脖子发麻，腿脚沉重，腰背酸痛。<br style=\"padding: 0px; margin: 0px;\">&nbsp;<br style=\"padding: 0px; margin: 0px;\">&nbsp;&nbsp;&nbsp; 根据调查和医学临床显示，有75%以上的Office Lady都在受脊柱和脊柱相关疾病的煎熬。不要等疲劳过度才停下来关照自己，坐姿对于脊柱的压迫已经迫使你必须适度运动。要知道，那些在重重压力下仍然神采奕奕的MM，她们懂得养护脊柱，所以才能够在工作的战场上快速回神。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">1.猫伸展式</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 大幅度猫伸展式</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 双膝跪地，手臂着地向前伸直，把手向前推，让臀部高高抬起，凹下背部，胸部贴近地面，下巴抬起，感觉到背部肌肉充分拉伸，脊柱一节节延展。保持这个动作3~5个呼吸，可以很好地放松背部下端的张力。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 四点着地的猫伸展式</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 双膝和双手四点着地，吸气时，凹下背部，让肚脐最大限度地贴近地面，背部形成向下凹的弧线，头部和下巴抬起，脖子前侧尽量伸展。呼气时，背部向上弓起，下巴努力向胸部靠近。重复这个动作，让脊柱交替凹凸，完成3~5个呼吸，充分调动脊背和腹部的肌肉。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 功效：猫伸展式可以放松整个背部，特别是脊椎下端部分，缓解背部疼痛和疲劳。 使整条脊椎骨排列地更加整齐，改善脊椎和脊椎神经的血液流动，加固、调整和伸展背部肌肉，增强脊柱的灵活性。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\"><br style=\"padding: 0px; margin: 0px;\">2站立扭转</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 双腿开立约两步宽，吸气时双臂从体侧抬起与肩平行。呼气时身体带双臂自然向左后方扭转，左臂曲肘放在右后腰旁，右手曲肘放在左肩上。到最大限度保持3~5个呼吸，感觉到整个背部和脊柱的扭转。然后换方向做相同的动作。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 功效：增强脊柱与侧腰的柔软度，加强背与腰的灵活性，调节脊柱神经系统，让新鲜的血液供应得更加顺畅。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">3站立前弯曲</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 双腿并拢，身体重心放在脚底，深吸气，将两手向上伸直，全身向上延长。 呼气时，弯腰向前，身体下俯，双手抓住小腿后面或者抓住脚踝，把头和胸部推向双腿方向，放慢呼吸，保持3~5个呼吸，直到觉得有点疲累为止。在保持这个动作的过程中，能够感觉到臀部和背部往下拉。如果感觉韧带负担过重，可以稍微弯曲膝盖。<br style=\"padding: 0px; margin: 0px;\">&nbsp;<br style=\"padding: 0px; margin: 0px;\">&nbsp;&nbsp;&nbsp; 功效：让整个脊柱充分伸展，更有弹性，甚至会帮助脊柱生长，同时可以醒脑提神，调理肾脏，使整个神经系统充满活力。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">4眼镜蛇式</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 俯躺，双腿并拢，腹部和额头着地，伸直脚尖，手掌放在双肩下方，吸气时下巴慢慢抬起，双臂支撑地面带动上半身使身体向后仰，让腹部和髋部保持贴近地面，头部向上延伸。收紧臀部肌肉来支持后背的力量，手臂稍微弯曲，肩膀向下压。保持3~5个呼吸。呼气时，从脊柱最末节开始一节节往下还原，最后以额头着地结束。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 功效：弯曲动作可以使背部的肌肉更加强壮，加强脊椎的柔软度，促进脊椎的血液循环，活化神经，并使得脊柱供血充足。按摩并且调节背肌。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">5后仰式</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 双腿开立与肩同宽，双手放在臀部上方。吸气时整个身体后仰，脊柱向后弯曲，头部自然下垂，呼气时髋部微微向前推送，也可以稍微弯曲膝盖，控制身体的重心。吸气从尾骨慢慢带回上体还原到垂直状态。重复这个动作3~5次。如果颈椎有问题，应该在整个过程中保持脖子伸直，避免颈部向后仰。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 功效：矫正脊柱不正，增强脊柱的弹性，滋养脊椎神经，向它们供应新鲜的血液，使它们充满活力。能够消除背部疼痛及僵硬症状，改善平时的坐姿和站姿，使人更加挺拔。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">6侧腰伸展</p><p style=\"padding: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;&nbsp;&nbsp; 站立，两脚打开比肩略宽一点，将全身重量分配在两脚上。<br style=\"padding: 0px; margin: 0px;\">&nbsp;<br style=\"padding: 0px; margin: 0px;\">&nbsp;&nbsp;&nbsp; 吸气时右手臂沿耳旁向上尽量伸直，感觉身体的右侧充分被拉伸，左手沿腿部向下延伸。呼气时，身体弯向左侧，左手尽可能向下滑动，眼睛看向伸展的手臂，自然呼吸，保持这个姿势3~5个呼吸。吸气时慢慢带回上身。然后反方向做相同的动作。<br style=\"padding: 0px; margin: 0px;\">&nbsp;<br style=\"padding: 0px; margin: 0px;\">&nbsp;&nbsp;&nbsp; 功效：使脊柱得到侧面的伸展，同时腰部、腿部以及手臂的肌肉全面获得伸展，能够增强脊柱弹性，调理脊柱周围的神经，消除腰酸背痛的症状。</p>', '2015-05-24 11:19:13', '用瑜伽认识你的脊柱', null, 'Bultin', 'lhjz', '0');
INSERT INTO `article` (id, content, create_date, name, path, status, username, version) VALUES ('3', '<p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">对强直性脊柱炎有所了解的人都清楚，<a href=\"http://zhongyi.ifeng.com/qiangzhixingjizhuyan/\" target=\"_blank\" style=\"padding: 0px; margin: 0px; color: rgb(1, 36, 92);\">AS</a>的发病部位是以脊柱为主，也就是会影响正常的脊柱功能，在脊柱部位发生炎症。这也是<a href=\"http://zhongyi.ifeng.com/qiangzhixingjizhuyan/qzxjzyzjfx/73015.shtml\" target=\"_blank\" style=\"padding: 0px; margin: 0px; color: rgb(1, 36, 92);\">强直性脊柱炎的危害</a>。那么，脊柱对人体的作用是怎么样的呢?这种基本知识需要了解一下。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">可以说脊柱对人体的作用是特别大的，它是人体的栋梁。脊柱医学上常称其为“中轴关节”，也就是老百姓所说的“大梁骨”。它是由一个个椎体构成的，这些椎体又靠约lOOO根韧带和140多块肌肉连接成坚韧的脊柱。</p><p style=\"padding: 0px; margin-bottom: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">脊柱从上到下可以分为几个部分，一般分为颈椎、胸椎、腰椎、骶椎及尾骨。颈椎的任务是支撑头部，人能够抬头、低头及转头，都有它的功劳;胸椎与肋骨相连而组成了坚固的胸廓，它是胸腔内脏的保护“城堡”，腰椎是脊柱中的“顶梁柱”，它承受着身体大部分重量;骶椎和尾骨在人类的进化过程中发生了退化，个体差异比较大，骶椎与髂骨形成骶髂关节，主要靠软骨连接，参与构成骨盆，骶髂关节是微动关节，也是强直性脊柱炎最常侵犯的关节。</p><p style=\"padding: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">从上文可以看出脊柱对人体的重要作用，只要脊柱受到了损伤，人体的行动就会受到影响，这也就是为什么<a href=\"http://zhongyi.ifeng.com/qiangzhixingjizhuyan/\" style=\"padding: 0px; margin: 0px; color: rgb(1, 36, 92);\">强直性脊柱炎</a>晚期的病人会出现无法行走等现象了。强直性脊柱炎的危害太大了，此病要治疗和康复训练共同进行，以便控制病情。</p>', '2015-05-24 11:19:29', '脊柱对人体的作用是怎样的?', null, 'Bultin', 'lhjz', '0');
INSERT INTO `article` (id, content, create_date, name, path, status, username, version) VALUES ('4', '<div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\"><div align=\"left\" style=\"padding: 0px; margin: 0px;\"><font color=\"#ff0000\" style=\"padding: 0px; margin: 0px;\">认识脊柱病症位置</font><b style=\"padding: 0px; margin: 0px;\"><font color=\"#ff0000\" style=\"padding: 0px; margin: 0px;\"></font></b><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div></div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\"><b style=\"padding: 0px; margin: 0px;\">认识脊柱病症位置（一）------</b><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div><b style=\"padding: 0px; margin: 0px;\">胸椎位置&nbsp;</b><br style=\"padding: 0px; margin: 0px;\"><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">胸椎部位</div></div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第一胸椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>心脏病、气管炎、气喘、咳嗽、呼吸困难等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第二胸椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>心脏病、心悸、食道炎、胸痛等。</div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第三胸椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>食道炎、支气管炎、肺炎、肋膜炎、感冒等。</div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第四胸椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>肺炎、肋膜炎、胆囊炎、胸闷、胸痛等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第五胸椎&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>肝炎、胆囊炎、、胃炎、面疱、粉刺等。</div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第六胸椎&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>胃炎、胆囊炎、胃胀气、胃灼热、食欲不振、糖尿病等。</div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第七胸椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>糖尿病、胃炎、胃溃疡、十二指肠溃疡等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第八胸椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>肝炎、小肠炎、虚寒症、贫血等。</div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第九胸椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>小肠炎、肾上腺炎、膀胱炎、频尿、排尿困难、更年期障碍等。</div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第十胸椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>肾脏炎、水肿、痛风、肥胖症、输尿管炎、静脉曲张等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第十一胸椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>肾脏炎、大肠炎、水肿、输尿管炎、性功能减退等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第十二胸椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>膀胱炎、频尿、不孕排卵障碍、痛风等。</div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\"><b style=\"padding: 0px; margin: 0px;\">认识脊柱病症位置（二）------</b><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div><b style=\"padding: 0px; margin: 0px;\">颈椎部位</b><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">颈椎部位<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>第一节颈椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>头痛，头晕，失眠，眼睛酸痛，记忆力减退，高血压等.<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>第二节颈椎&nbsp;&nbsp;&nbsp; &nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>耳鸣，眼疾，昏眩，失声，扁桃体炎，腮腺炎，鼻窦炎，等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>第三节颈椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>咽喉炎，肩颈酸痛，呼吸困难，湿疹等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>第四节颈椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>肩膀酸痛，手臂无力，牙痛，胃痛，甲状腺炎等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>第五节颈椎&nbsp;&nbsp;&nbsp; &nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>手臂酸痛，气管炎，咽喉炎，甲状腺炎，口臭等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>第六节颈椎&nbsp;&nbsp;&nbsp; &nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>甲状腺炎，手腕痛，五十肩，拇指及食指酸麻等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>第七节颈椎&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>甲状腺炎，中指及无名指酸麻，气喘，气管炎，小指酸麻等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\"><b style=\"padding: 0px; margin: 0px;\">认识脊柱病症位置（三）------</b><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div><b style=\"padding: 0px; margin: 0px;\">腰椎部位</b><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">腰椎部位<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第一腰椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>大腿前侧痛、输尿管炎、子宫炎、更年期障碍、尿失禁等。</div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第二腰椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>卵巢炎、输卵管阻塞、月经失调、腰痛、坐骨神经痛等。<br style=\"padding: 0px; margin: 0px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第三腰椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>膀胱炎、月经失调、子宫肌瘤、坐骨神经痛、腰痛、水肿等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第四腰椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>小腿内侧酸麻胀痛、腰痛、坐骨神经痛、前列腺障碍等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">第五腰椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>小腿外侧酸麻胀痛、坐骨神经痛、膀胱炎、直肠炎、尿频、尿失禁、痔疮等。<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\"><b style=\"padding: 0px; margin: 0px;\">认识脊柱病症位置（四）------</b><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div><b style=\"padding: 0px; margin: 0px;\">骶椎尾椎部位</b><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div></div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">骶椎尾椎部位</div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">骶椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>前列腺炎、坐骨神经痛、痛经、月经失调、皮肤症状、尿频、尿失禁、痔疮等。</div><div class=\"fs-newline\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">&nbsp;</div><div align=\"left\" style=\"padding: 0px; margin: 0px; color: rgb(51, 51, 51); font-family: Verdana, Arial, Tahoma; line-height: 25px;\">尾椎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"fs-newline\" style=\"padding: 0px; margin: 0px;\">&nbsp;</div>尾椎痛、肛门炎、直肠炎、尿频、尿失禁、痔疮等。</div>', '2015-05-24 11:19:48', '关爱健康—认识脊柱病症位置', null, 'Bultin', 'lhjz', '0');
