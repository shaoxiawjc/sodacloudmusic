/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 8.0.34 : Database - cloudmusic
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cloudmusic` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `cloudmusic`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `song_id` int NOT NULL COMMENT '对应歌曲id',
  `detail` text CHARACTER SET utf8mb3 NOT NULL COMMENT '内容',
  `user_id` int NOT NULL COMMENT '用户id',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `collected_nums` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `comment` */

insert  into `comment`(`id`,`song_id`,`detail`,`user_id`,`create_date`,`collected_nums`) values 
(1,4,'idolsama',1,'2023-12-23',1),
(2,2,'最好听的歌',1,'2023-12-23',1),
(3,2,'最好听的歌!',1,'2023-12-23',1),
(4,3,'666',11,'2023-12-29',1);

/*Table structure for table `commentuser` */

DROP TABLE IF EXISTS `commentuser`;

CREATE TABLE `commentuser` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comment_id` int NOT NULL COMMENT '评论的id',
  `user_id` int NOT NULL COMMENT '收藏的用户的id',
  PRIMARY KEY (`id`),
  KEY `fk_comment_id` (`comment_id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `fk_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

/*Data for the table `commentuser` */

insert  into `commentuser`(`id`,`comment_id`,`user_id`) values 
(5,1,11),
(6,2,11),
(7,3,11),
(8,4,11);

/*Table structure for table `listuser` */

DROP TABLE IF EXISTS `listuser`;

CREATE TABLE `listuser` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `list_id` int NOT NULL COMMENT '歌单id',
  `user_id` int NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

/*Data for the table `listuser` */

insert  into `listuser`(`id`,`list_id`,`user_id`) values 
(1,11,1),
(2,12,2),
(3,13,3),
(4,14,4);

/*Table structure for table `song` */

DROP TABLE IF EXISTS `song`;

CREATE TABLE `song` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '音乐id',
  `name` varchar(20) NOT NULL COMMENT '音乐名称',
  `picture_path` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '音乐的图片的路径地址',
  `song_path` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '音乐的资源路劲',
  `singer` varchar(20) NOT NULL COMMENT '歌手',
  `issuing_date` date DEFAULT NULL COMMENT '发行日期',
  `upload_id` int NOT NULL COMMENT '上传的用户的id',
  `collect_nums` int DEFAULT '0' COMMENT '被收藏的数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

/*Data for the table `song` */

insert  into `song`(`id`,`name`,`picture_path`,`song_path`,`singer`,`issuing_date`,`upload_id`,`collect_nums`) values 
(2,'夜に駆ける','https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/musicImg/eda725ec-de69-4a90-a4ad-b424fa302f80.png','https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/musicResource/b796eeac-0ae2-4509-b244-bc3b2e6fa505.mp3','yoasobi','2023-12-15',1,0),
(3,'勇者','https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/musicImg/4d49ab42-866d-4b86-9af0-4a67843a8b5a.jpg','https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/musicResource/25b6ffef-de4c-494f-8572-b4000eb72473.mp3','yoasobi','2023-12-23',1,0),
(4,'idol','https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/musicImg/c22e30d4-f14e-4553-b9ff-385fabed2937.png','https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/musicResource/15d1c1fa-6adb-4882-bffa-c65f2622d0a1.mp3','yoasobi','2023-12-23',1,0);

/*Table structure for table `songlist` */

DROP TABLE IF EXISTS `songlist`;

CREATE TABLE `songlist` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '歌单的唯一标识id',
  `user_id` int NOT NULL COMMENT '所属的用户的id',
  `title` varchar(20) DEFAULT NULL COMMENT '歌单标题',
  `introduction` varchar(255) DEFAULT NULL COMMENT '歌单简介',
  `collected_nums` int DEFAULT '0' COMMENT '歌单收藏量',
  `picture_path` varchar(300) DEFAULT NULL COMMENT '歌单图片url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

/*Data for the table `songlist` */

insert  into `songlist`(`id`,`user_id`,`title`,`introduction`,`collected_nums`,`picture_path`) values 
(1,11,'我的喜欢','无',1,'https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/songPicturePath/heart.png'),
(2,12,'我的喜欢','无',1,'https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/songPicturePath/heart.png'),
(3,13,'我的喜欢','无',1,'https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/songPicturePath/heart.png'),
(4,14,'我的喜欢','无',1,'https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/songPicturePath/heart.png');

/*Table structure for table `songsonglist` */

DROP TABLE IF EXISTS `songsonglist`;

CREATE TABLE `songsonglist` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `list_id` int NOT NULL COMMENT '歌单id',
  `song_id` int NOT NULL COMMENT '歌曲id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `songsonglist` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(20) NOT NULL COMMENT '用户昵称',
  `password` varchar(20) NOT NULL DEFAULT '123456' COMMENT '用户密码',
  `gender` int DEFAULT '0' COMMENT '用户性别',
  `img` varchar(100) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`gender`,`img`) values 
(1,'少侠','123456',2,NULL),
(2,'侠','123456',2,NULL),
(3,'吴金超','a123456',2,NULL),
(4,'少','a1234567',2,NULL),
(6,'可爱胶胶子','654321',0,NULL),
(11,'神秘打胶男','123456789',0,NULL),
(12,'22','22',0,NULL),
(13,'用户1','abc123',0,NULL),
(14,'33','33',0,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
