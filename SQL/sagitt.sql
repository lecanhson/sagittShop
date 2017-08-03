/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.25-MariaDB : Database - sagitt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sagitt` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sagitt`;

/*Table structure for table `dye` */

DROP TABLE IF EXISTS `dye`;

CREATE TABLE `dye` (
  `DYE_ID` int(100) NOT NULL,
  `NAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `PHOTO` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`DYE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `dye` */

/*Table structure for table `five_element` */

DROP TABLE IF EXISTS `five_element`;

CREATE TABLE `five_element` (
  `FIVE_ELEMENT_ID` int(100) NOT NULL,
  `NAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `CREATE_DATE` date NOT NULL,
  `STONE_ID` int(100) NOT NULL,
  `PHOTO` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`FIVE_ELEMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `five_element` */

/*Table structure for table `fromproduct` */

DROP TABLE IF EXISTS `fromproduct`;

CREATE TABLE `fromproduct` (
  `FROM_PRODUCT_ID` int(100) NOT NULL,
  `NAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `PHOTO` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`FROM_PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `fromproduct` */

/*Table structure for table `material` */

DROP TABLE IF EXISTS `material`;

CREATE TABLE `material` (
  `MATERIAL_ID` int(100) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `PHOTO` varchar(100) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MATERIAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `material` */

/*Table structure for table `pleasenote` */

DROP TABLE IF EXISTS `pleasenote`;

CREATE TABLE `pleasenote` (
  `PLEASE_NOTE_ID` int(100) NOT NULL,
  `NOTE` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`PLEASE_NOTE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `pleasenote` */

/*Table structure for table `productdetail` */

DROP TABLE IF EXISTS `productdetail`;

CREATE TABLE `productdetail` (
  `PRODUCT_DETAIL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCT_TYPE_ID` int(11) NOT NULL,
  `PRODUCT_DETAIL_NAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `PRODUCT_FROM_ID` int(11) NOT NULL,
  `MATERIAL_ID` int(11) NOT NULL,
  `FIVE_ELEMENT_ID` int(11) NOT NULL,
  `DYE_ID` int(11) NOT NULL,
  `STONE_ID` int(11) NOT NULL,
  `ROPE_ID` int(11) NOT NULL,
  `DESCRIPTION` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_DATE` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHOTO` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_DETAIL_ID`),
  KEY `PRODUCT_TYPE_ID` (`PRODUCT_TYPE_ID`),
  KEY `PRODUCT_FROM_ID` (`PRODUCT_FROM_ID`),
  KEY `MATERIAL_ID` (`MATERIAL_ID`),
  KEY `FIVE_ELEMENT_ID` (`FIVE_ELEMENT_ID`),
  KEY `DYE_ID` (`DYE_ID`),
  KEY `STONE_ID` (`STONE_ID`),
  KEY `ROPE_ID` (`ROPE_ID`),
  CONSTRAINT `productdetail_ibfk_1` FOREIGN KEY (`PRODUCT_TYPE_ID`) REFERENCES `producttype` (`PRODUCT_TYPE_ID`),
  CONSTRAINT `productdetail_ibfk_2` FOREIGN KEY (`PRODUCT_FROM_ID`) REFERENCES `fromproduct` (`FROM_PRODUCT_ID`),
  CONSTRAINT `productdetail_ibfk_3` FOREIGN KEY (`MATERIAL_ID`) REFERENCES `material` (`MATERIAL_ID`),
  CONSTRAINT `productdetail_ibfk_4` FOREIGN KEY (`FIVE_ELEMENT_ID`) REFERENCES `five_element` (`FIVE_ELEMENT_ID`),
  CONSTRAINT `productdetail_ibfk_5` FOREIGN KEY (`DYE_ID`) REFERENCES `dye` (`DYE_ID`),
  CONSTRAINT `productdetail_ibfk_6` FOREIGN KEY (`STONE_ID`) REFERENCES `stone` (`STONE_ID`),
  CONSTRAINT `productdetail_ibfk_7` FOREIGN KEY (`ROPE_ID`) REFERENCES `rope` (`ROPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `productdetail` */

/*Table structure for table `producttype` */

DROP TABLE IF EXISTS `producttype`;

CREATE TABLE `producttype` (
  `PRODUCT_TYPE_ID` int(100) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `CREATE` date DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_TYPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `producttype` */

insert  into `producttype`(`PRODUCT_TYPE_ID`,`PRODUCT_NAME`,`CREATE`) values (1,'Dây chuyền','2017-07-27'),(2,'',NULL),(3,'',NULL);

/*Table structure for table `rope` */

DROP TABLE IF EXISTS `rope`;

CREATE TABLE `rope` (
  `ROPE_ID` int(11) NOT NULL,
  `ROPE_TYPE_ID` int(11) NOT NULL,
  `ROPE_SIZE_ID` int(11) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `PHOTO` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ROPE_ID`),
  KEY `PP` (`ROPE_TYPE_ID`),
  KEY `ROPE_SIZE_ID` (`ROPE_SIZE_ID`),
  CONSTRAINT `PP` FOREIGN KEY (`ROPE_TYPE_ID`) REFERENCES `ropetype` (`ROPE_TYPE_ID`),
  CONSTRAINT `rope_ibfk_1` FOREIGN KEY (`ROPE_SIZE_ID`) REFERENCES `ropesize` (`ROPE_SIZE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rope` */

/*Table structure for table `ropesize` */

DROP TABLE IF EXISTS `ropesize`;

CREATE TABLE `ropesize` (
  `ROPE_SIZE_ID` int(100) NOT NULL,
  `ROPE_SIZE` int(100) NOT NULL,
  `ROPE_UNIT` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `DESRIPTION` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHOTO` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ROPE_SIZE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `ropesize` */

/*Table structure for table `ropetype` */

DROP TABLE IF EXISTS `ropetype`;

CREATE TABLE `ropetype` (
  `ROPE_TYPE_ID` int(100) NOT NULL,
  `ROPE_NAME` varchar(100) NOT NULL,
  `ROPE_COLOUR` varchar(100) NOT NULL,
  `ROPE_MATERIAL` varchar(100) NOT NULL,
  `ROPE_FROM` varchar(100) DEFAULT NULL,
  `CREATE_DATE` date NOT NULL,
  `PHOTO` varchar(100) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ROPE_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ropetype` */

/*Table structure for table `stone` */

DROP TABLE IF EXISTS `stone`;

CREATE TABLE `stone` (
  `STONE_ID` int(100) NOT NULL AUTO_INCREMENT,
  `FIVE_ELEMENT_ID` int(100) NOT NULL,
  `TYPE_STONE` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `ORIGINAL` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `USED` tinyint(1) NOT NULL,
  `PHOTO` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`STONE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stone` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
