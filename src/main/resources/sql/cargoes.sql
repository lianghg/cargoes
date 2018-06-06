/*
SQLyog v10.2 
MySQL - 5.6.24-log : Database - cargoes
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cargoes` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cargoes`;

/*Table structure for table `sys_authority` */

DROP TABLE IF EXISTS `sys_authority`;

CREATE TABLE `sys_authority` (
  `id` varchar(128) NOT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_authority` */

/*Table structure for table `sys_department` */

DROP TABLE IF EXISTS `sys_department`;

CREATE TABLE `sys_department` (
  `id` varchar(128) NOT NULL,
  `code` char(3) DEFAULT NULL,
  `name` varchar(300) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `parent_id` varchar(128) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_fk` (`parent_id`),
  CONSTRAINT `parent_fk` FOREIGN KEY (`parent_id`) REFERENCES `sys_department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_department` */

/*Table structure for table `sys_operation_log` */

DROP TABLE IF EXISTS `sys_operation_log`;

CREATE TABLE `sys_operation_log` (
  `id` varchar(128) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  `request_url` varchar(300) DEFAULT NULL,
  `request_type` varchar(100) DEFAULT NULL,
  `request_info` varchar(300) DEFAULT NULL,
  `operation_desc` varchar(1000) DEFAULT NULL,
  `operation_time` datetime DEFAULT NULL,
  `operation_status` int(1) DEFAULT NULL COMMENT '0:失败，1:成功',
  `consumed_time` int(11) DEFAULT NULL COMMENT '耗时（毫秒）',
  `invoked_method` varchar(500) DEFAULT NULL,
  `error_message` varchar(4900) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_operation_log` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` varchar(128) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_authority` */

DROP TABLE IF EXISTS `sys_role_authority`;

CREATE TABLE `sys_role_authority` (
  `id` varchar(128) NOT NULL,
  `role_id` varchar(128) DEFAULT NULL,
  `authority_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `authority_fk` (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_authority` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` varchar(128) NOT NULL,
  `name` varchar(300) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(300) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  `role_id` varchar(128) DEFAULT NULL,
  `department_id` varchar(128) DEFAULT NULL,
  `salt` varchar(128) DEFAULT NULL,
  `last_change_password` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `expired` int(11) DEFAULT NULL,
  `disabled` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`name`,`username`,`password`,`gender`,`phone`,`email`,`birthday`,`create_time`,`modify_time`,`role_id`,`department_id`,`salt`,`last_change_password`,`status`,`expired`,`disabled`) values ('1','druid','druid','4da6cf36481ccfeff1efc1f1b7a86bef',1,'10086','123456@cargoes.com','2018-04-05','2018-01-23 10:01:45',NULL,NULL,NULL,'.efvhu5',NULL,1,1,0),('2','kate','kate','de24f29d3cd4d8329b4e4a70c37c23ff',0,'10086','1234567@cargoes.com','2018-01-04','2018-01-23 10:05:51',NULL,NULL,NULL,'.efvhu5',NULL,1,0,1),('3','string','admin','111117',0,NULL,'example@cargoes.top','1970-01-01','2018-01-23 10:05:51','2018-05-25 16:49:39','string','string','.efvhu5',NULL,1,0,0),('84b3974b-462f-4c5a-8cbf-25d7c8ba3ea7','string','string',NULL,0,'13713034567','example@cargoes.top','1970-01-01','2018-05-27 00:28:42',NULL,'string','string',NULL,NULL,0,0,0);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` varchar(128) NOT NULL,
  `user_id` varchar(128) DEFAULT NULL,
  `role_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
