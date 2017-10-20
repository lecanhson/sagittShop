/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.19-0ubuntu0.14.04.1 : Database - sagitt_shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sagitt_shop` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_vietnamese_ci */;

USE `sagitt_shop`;

/*Table structure for table `attribute` */

DROP TABLE IF EXISTS `attribute`;

CREATE TABLE `attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `type` smallint(3) NOT NULL,
  `status` smallint(3) DEFAULT '0',
  `created_at` int(10) DEFAULT '0',
  `updated_at` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_unique_name` (`category_id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `attribute` */

insert  into `attribute`(`id`,`category_id`,`name`,`type`,`status`,`created_at`,`updated_at`) values (1,1,'Color',1,1,1504017094,1504778156),(2,1,'Size',1,1,1504770483,1504774908),(3,2,'Size',1,1,1504777273,0),(4,2,'Màu',1,1,1504777282,0);

/*Table structure for table `attribute_value` */

DROP TABLE IF EXISTS `attribute_value`;

CREATE TABLE `attribute_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(64) NOT NULL,
  `attribute_id` int(11) NOT NULL,
  `status` smallint(3) DEFAULT '0',
  `created_at` int(10) DEFAULT '0',
  `updated_at` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_unique_value` (`attribute_id`,`value`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `attribute_value` */

insert  into `attribute_value`(`id`,`value`,`attribute_id`,`status`,`created_at`,`updated_at`) values (1,'Đỏ',1,1,1504019728,0),(2,'Vàng',1,1,1504770465,0),(3,'Xanh',1,1,1504770470,0),(4,'L',2,1,1504770565,0),(5,'M',2,1,1504770570,0),(6,'XL',2,1,1504770575,0);

/*Table structure for table `blog` */

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_category_id` int(11) NOT NULL,
  `title` varchar(128) NOT NULL,
  `image_url` text,
  `content` text,
  `status` smallint(3) DEFAULT '0',
  `created_at` int(10) DEFAULT '0',
  `updated_at` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_category_id` (`blog_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `blog` */

/*Table structure for table `blog_category` */

DROP TABLE IF EXISTS `blog_category`;

CREATE TABLE `blog_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `description` text,
  `status` smallint(3) DEFAULT '0',
  `created_at` int(10) DEFAULT '0',
  `updated_at` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `blog_category` */

insert  into `blog_category`(`id`,`name`,`description`,`status`,`created_at`,`updated_at`) values (2,'Dây chuyền','',1,1505550523,1505550526);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `status` smallint(3) DEFAULT '0',
  `created_at` int(10) DEFAULT '0',
  `updated_at` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`name`,`status`,`created_at`,`updated_at`) values (1,'Dây chuyền',1,1504016882,1504777291),(2,'Vòng đeo tay',0,1504777262,1504777305);

/*Table structure for table `migration` */

DROP TABLE IF EXISTS `migration`;

CREATE TABLE `migration` (
  `version` varchar(180) NOT NULL,
  `apply_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `migration` */

insert  into `migration`(`version`,`apply_time`) values ('m000000_000000_base',1503325059),('m140209_132017_init',1503326792),('m140403_174025_create_account_table',1503326792),('m140504_113157_update_tables',1503326792),('m140504_130429_create_token_table',1503326792),('m140830_171933_fix_ip_field',1503326792),('m140830_172703_change_account_table_name',1503326792),('m141222_110026_update_ip_field',1503326792),('m141222_135246_alter_username_length',1503326792),('m150614_103145_update_social_account_table',1503326792),('m150623_212711_fix_username_notnull',1503326792),('m151218_234654_add_timezone_to_profile',1503326792),('m160929_103127_add_last_login_at_to_user_table',1503326792),('m170823_140454_add_user_phone_number',1503497315),('m170828_143347_create_tbl_category',1504016546),('m170831_145501_create_tbl_product',1505382434),('m170916_072459_create_tbl_blog',1505548539);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `category_id` int(11) NOT NULL,
  `status` smallint(3) DEFAULT '0',
  `created_at` int(10) DEFAULT '0',
  `updated_at` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_category_id` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`name`,`category_id`,`status`,`created_at`,`updated_at`) values (1,'Dây chuyền vàng 6 hột',1,1,1504770318,1504777246);

/*Table structure for table `product_image` */

DROP TABLE IF EXISTS `product_image`;

CREATE TABLE `product_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `image_url` text NOT NULL,
  `created_at` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_image` */

/*Table structure for table `product_item` */

DROP TABLE IF EXISTS `product_item`;

CREATE TABLE `product_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `product_id` int(11) NOT NULL,
  `price` int(10) NOT NULL,
  `discount` int(10) DEFAULT '0',
  `status` smallint(3) DEFAULT '0',
  `created_at` int(10) DEFAULT '0',
  `updated_at` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_item` */

/*Table structure for table `product_item_attribute` */

DROP TABLE IF EXISTS `product_item_attribute`;

CREATE TABLE `product_item_attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_item_id` int(11) NOT NULL,
  `attribute_id` int(11) NOT NULL,
  `value` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_unique_item_attribute` (`product_item_id`,`attribute_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `product_item_attribute` */

insert  into `product_item_attribute`(`id`,`product_item_id`,`attribute_id`,`value`) values (1,1,1,'Đỏ'),(2,1,2,'M'),(3,2,1,'Đỏ'),(4,2,2,'L'),(5,3,1,'Đỏ'),(6,3,2,'L'),(7,4,1,'Đỏ'),(8,4,2,'L');

/*Table structure for table `product_item_image` */

DROP TABLE IF EXISTS `product_item_image`;

CREATE TABLE `product_item_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_item_id` int(11) NOT NULL,
  `image_url` int(10) NOT NULL,
  `created_at` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_product_item` (`product_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_item_image` */

/*Table structure for table `profile` */

DROP TABLE IF EXISTS `profile`;

CREATE TABLE `profile` (
  `user_id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `public_email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gravatar_email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gravatar_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `location` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `website` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bio` text COLLATE utf8_unicode_ci,
  `timezone` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_user_profile` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `profile` */

insert  into `profile`(`user_id`,`name`,`public_email`,`gravatar_email`,`gravatar_id`,`location`,`website`,`bio`,`timezone`) values (1,'Admin',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Test','','','d41d8cd98f00b204e9800998ecf8427e','','','',NULL);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(100) NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `role` */

/*Table structure for table `social_account` */

DROP TABLE IF EXISTS `social_account`;

CREATE TABLE `social_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `provider` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `client_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `data` text COLLATE utf8_unicode_ci,
  `code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` int(11) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_unique` (`provider`,`client_id`),
  UNIQUE KEY `account_unique_code` (`code`),
  KEY `fk_user_account` (`user_id`),
  CONSTRAINT `fk_user_account` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `social_account` */

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `user_id` int(11) NOT NULL,
  `code` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` int(11) NOT NULL,
  `type` smallint(6) NOT NULL,
  UNIQUE KEY `token_unique` (`user_id`,`code`,`type`),
  CONSTRAINT `fk_user_token` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `token` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password_hash` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `auth_key` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `confirmed_at` int(11) DEFAULT NULL,
  `unconfirmed_email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `blocked_at` int(11) DEFAULT NULL,
  `registration_ip` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `flags` int(11) NOT NULL DEFAULT '0',
  `last_login_at` int(11) DEFAULT NULL,
  `phone_number` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_unique_username` (`username`),
  UNIQUE KEY `user_unique_email` (`email`),
  KEY `index_phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`email`,`password_hash`,`auth_key`,`confirmed_at`,`unconfirmed_email`,`blocked_at`,`registration_ip`,`created_at`,`updated_at`,`flags`,`last_login_at`,`phone_number`) values (1,'admin','admin@sagitt.vn','$2y$10$CYuqCl6HRIjpYDmUVF8JWuoZ4l7eag./TKMqRBz7WtVFMvA6xEYAC','123123213',NULL,NULL,NULL,NULL,'0000-00-00 00:00:00','0000-00-00 00:00:00',0,1504014743,''),(2,'canhson','stephen.canhle@gmail.com','123456','12222',22222,'22222',1,'1','2017-10-12 15:35:33','2017-10-12 15:35:35',1,1,'0973619424'),(3,'','test@gmail.com','$2y$10$Obm2IfFLdi1ll4WGbwYMBuuewKvPs47iXSAIYXGQcjPoNEluHSYhy','4uTyK-FeSvtiMjCz9BI6Cdh60miwIIg7',1503498614,NULL,NULL,'127.0.0.1','0000-00-00 00:00:00','0000-00-00 00:00:00',0,NULL,'0977409352');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
