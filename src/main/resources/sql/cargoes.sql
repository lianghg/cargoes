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
  `parent_id` varchar(128) DEFAULT NULL,
  `order` int(11) DEFAULT '999',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_authority` */

insert  into `sys_authority`(`id`,`code`,`name`,`description`,`parent_id`,`order`,`create_time`,`modify_time`) values ('0c692054689611e8b7ed107y44f33502','AUTH_SLT_USER_BY_ID','查询用户','根据ID查询用户',NULL,999,'2018-01-29 17:48:22',NULL);

/*Table structure for table `sys_department` */

DROP TABLE IF EXISTS `sys_department`;

CREATE TABLE `sys_department` (
  `id` varchar(128) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(300) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `parent_id` varchar(128) DEFAULT NULL,
  `order` int(11) DEFAULT '999',
  `create_time` datetime NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_fk` (`parent_id`),
  CONSTRAINT `parent_fk` FOREIGN KEY (`parent_id`) REFERENCES `sys_department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_department` */

insert  into `sys_department`(`id`,`code`,`name`,`description`,`parent_id`,`order`,`create_time`,`modify_time`) values ('0c692054689611e8b7ed107b44f33502','100200','开发部','string','2ab2d31a689e11e8b7ed107b44f33502',999,'2018-02-05 15:57:10',NULL),('215969a8689e11e8b7ed107b44f33502','100100','测试部','string','2ab2d31a689e11e8b7ed107b44f33502',999,'2018-02-05 16:55:01',NULL),('2ab2d31a689e11e8b7ed107b44f33502','100','软件部','string',NULL,999,'2018-02-28 16:55:17',NULL),('6ab2d31a689e11e8b7ed107b44f33502','100202','开发2组',NULL,'0c692054689611e8b7ed107b44f33502',999,'2018-02-05 16:55:17',NULL),('7ab2d31a689e11e8b7ed107b44f33502','100201','开发1组',NULL,'0c692054689611e8b7ed107b44f33502',999,'2018-02-05 16:55:17',NULL);

/*Table structure for table `sys_operation_log` */

DROP TABLE IF EXISTS `sys_operation_log`;

CREATE TABLE `sys_operation_log` (
  `id` varchar(128) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
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
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `order` int(11) DEFAULT '999',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`code`,`name`,`description`,`order`,`create_time`,`modify_time`) values ('8a76732dabcb4d428ff16a6b740775a4','ROLE_ADMIN','管理员',NULL,999,'2018-02-28 17:44:53',NULL),('9a76732dabcb4d428ff16a6b740775a4','ROLE_USER','普通用户',NULL,999,'2018-02-25 10:34:51',NULL);

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

insert  into `sys_role_authority`(`id`,`role_id`,`authority_id`) values ('9i76732dabcb4d428ff16a6b740775a4','8a76732dabcb4d428ff16a6b740775a4','0c692054689611e8b7ed107y44f33502');

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
  `department_id` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `salt` varchar(128) DEFAULT NULL,
  `last_change_password` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `expired` int(11) DEFAULT '0',
  `locked` int(11) DEFAULT '0',
  `credentials_expired` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`name`,`username`,`password`,`gender`,`phone`,`email`,`birthday`,`department_id`,`create_time`,`modify_time`,`salt`,`last_change_password`,`status`,`expired`,`locked`,`credentials_expired`) values ('1','druid','druid','4da6cf36481ccfeff1efc1f1b7a86bef',1,'10086','123456@cargoes.com','2009-11-01','0c692054689611e8b7ed107b44f33502','2018-01-23 10:01:45',NULL,'.efvhu5',NULL,1,0,0,0),('2','kate','kate','de24f29d3cd4d8329b4e4a70c37c23ff',0,'10086','1234567@cargoes.com','2009-01-04','0c692054689611e8b7ed107b44f33502','2018-01-23 10:05:51',NULL,'.efvhu5',NULL,1,0,0,0);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` varchar(128) NOT NULL,
  `user_id` varchar(128) DEFAULT NULL,
  `role_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`) values ('9fb7e32c687311e8b7ed107b44f33502','1','8a76732dabcb4d428ff16a6b740775a4'),('9fb7e5a3687311e8b7ed107b44f33502','1','9a76732dabcb4d428ff16a6b740775a4');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
