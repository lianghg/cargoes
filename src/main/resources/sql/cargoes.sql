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

insert  into `sys_operation_log`(`id`,`user_id`,`ip`,`request_url`,`request_type`,`request_info`,`operation_desc`,`operation_time`,`operation_status`,`consumed_time`,`invoked_method`,`error_message`) values ('03bf91d6-102b-417c-8413-58887e47ce02','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"1\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:40:30',0,4,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('0425810e-9a23-4bb0-8ae7-6fa7919d8b8f','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:02:19',0,15,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('0431d471-7520-472a-86e5-978eeaa9e364','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:04:19',0,3,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('0794396c-2afc-4a60-bff7-1a4442586ec2','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:10',0,15,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('08f6401c-2980-49a8-b518-c49238649656','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:34:44',0,4,'cargoes.web.controller.UserController.activateUser','java.lang.NullPointerException'),('0a9274c6-f1c2-49ea-a956-de5ef4d70ab0','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:33',0,4,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('11d6da47-3a9a-4877-b747-b6a6e3cafadc','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:47:33',0,5,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('1d91ac01-29a0-4596-893e-38a85f430bf2','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:04:18',0,4,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('21e84fae-6c5d-40b4-af36-aa0087aa009b','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:33',0,3,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('23290998-07b0-4b4f-a9c4-8d7a89a3d784','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:47:33',0,7,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('24f26d9d-5935-41b5-b099-d67e62fa920a','','127.0.0.1','http://localhost:8091/cargoes/users/activation','PUT','[\"1\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:40:01',0,23,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('2e10997c-f371-471d-97ba-c34a5ae166f6','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:47:11',0,5,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('3959b43e-05ce-4717-822d-cd71c3579ccb','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:34:28',0,6,'cargoes.web.controller.UserController.activateUser','java.lang.NullPointerException'),('4d4083a4-e74e-4ae1-a0bd-e3fc62d7df57','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:04:20',0,3,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('581df6df-073c-4c3f-8e5c-48dfe454a86e','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:32',0,4,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('5bfc29ef-9cc3-41ce-8af2-6a9c2c7339d8','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:32',0,3,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('6609d7b8-2764-42c8-ace7-e7a76a4b9393','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:32:30',1,12,'cargoes.web.controller.UserController.activateUser',NULL),('673004d3-1c9d-46cb-bec0-5b9b19e7254e','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:33',0,3,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('68e9ef27-1012-4691-aae1-50710fb40c1b','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"1\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:45:52',0,18,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('6ffbc460-eaaf-4631-b2ec-e48e4ffb4f2f','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:47:08',1,30,'cargoes.web.controller.UserController.activateUser',NULL),('7bddc8b4-2a1a-47f8-9e2b-69b0a42476ec','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:30',0,3,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('8f79a097-a158-4863-9d6a-d383a0baf7b7','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"1\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:45:13',0,23,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('917525bf-b835-44c9-b951-156344295cd8','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:32',0,4,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('9529b934-8cf1-4f95-bc6f-68dcb267f8a8','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"1\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:38:21',0,25,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('95bf5887-1efb-453e-bebd-dcc1f7642c3c','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:46:04',0,5,'cargoes.web.controller.UserController.activateUser','java.lang.NullPointerException'),('9f0d14b4-a1ba-4880-b99d-52e4f4e53069','','127.0.0.1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:37:26',0,26,'cargoes.web.controller.UserController.activateUser','java.lang.NullPointerException'),('9fa7ceb5-ead9-4b24-a891-16ad763e7388','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:59:48',0,16,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('a1bbc2a1-7dc9-439c-a678-66646046356c','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:47:09',0,5,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('aa6c05a1-80aa-4a85-bc49-68f6a185d172','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:47:33',0,4,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('b352be23-cab4-4384-af13-c08ae252ec6d','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:32',0,3,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('c8a69f2b-f8a1-4da6-b32f-d75bedf6d6f7','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:32',0,4,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('c8ec8734-a2a8-4559-9ad9-0b5f51a3345a','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:04:18',0,4,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('d2d45c2a-98e8-495e-811e-003e8c4902b6','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:32',0,4,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('d3528d3f-a46c-4bff-9975-754f6675c41b','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:31',0,4,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('d4a4afea-ae1a-44d7-ba92-be0a71e11792','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:33',0,3,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('d66d080b-956e-47ed-8753-ba274f12df28','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:33:55',0,24,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('d8705b54-919a-48ab-803a-55c120d22477','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:01:29',0,16,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('dd3c0ba8-549e-44d4-b4cf-cd4c839e6331','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:32:52',1,29070,'cargoes.web.controller.UserController.activateUser',NULL),('e391ba2e-a4f4-4f43-8057-4ecd62b837ab','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 21:34:00',0,6,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活'),('e3fb46d4-06f9-4ebb-bed6-6790cf2b5ec7','','0:0:0:0:0:0:0:1','http://localhost:8091/cargoes/users/activation','PUT','[\"3\",\"111117\",\"111117\"]','激活或账号','2018-05-26 22:04:17',0,13,'cargoes.web.controller.UserController.activateUser','cargoes.web.exception.UserActivationException: 用户已激活');

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

insert  into `sys_user`(`id`,`name`,`username`,`password`,`gender`,`phone`,`email`,`birthday`,`create_time`,`modify_time`,`role_id`,`department_id`,`salt`,`last_change_password`,`status`,`expired`,`disabled`) values ('1','druid','druid','4da6cf36481ccfeff1efc1f1b7a86bef',1,'10086','123456@cargoes.com','2018-04-05','2018-01-23 10:01:45',NULL,NULL,NULL,'.efvhu5',NULL,1,1,0),('2','kate','kate','de24f29d3cd4d8329b4e4a70c37c23ff',0,'10086','1234567@cargoes.com','2018-01-04','2018-01-23 10:05:51',NULL,NULL,NULL,'.efvhu5',NULL,1,0,1),('3','string','admin','111117',0,NULL,'example@cargoes.top','1970-01-01','2018-01-23 10:05:51','2018-05-25 16:49:39','string','string','.efvhu5',NULL,1,0,0);

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
