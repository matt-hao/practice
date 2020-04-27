/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.0.89-community-nt : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `card` */

DROP TABLE IF EXISTS `card`;

CREATE TABLE `card` (
  `uuid` varchar(32) NOT NULL,
  `title` varchar(128) NOT NULL,
  `content` varchar(1024) NOT NULL,
  `item_id` int(10) NOT NULL default '0',
  `author_id` varchar(32) NOT NULL,
  `author_name` varchar(64) NOT NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `updateTime` timestamp NOT NULL default '2015-01-10 00:00:00',
  PRIMARY KEY  (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `card` */

insert  into `card`(`uuid`,`title`,`content`,`item_id`,`author_id`,`author_name`,`createTime`,`updateTime`) values ('1e0e8978e00d4b27bc923970c373de3c','恐怕这样说来就不是很对','<p>我也是这么觉得的<br></p>',6,'1e5c24847789469e93aab670d7b13b3c','123123','2015-09-23 20:03:45','2015-09-23 20:03:45'),('32ab6bad4b1e4f6b96ee3d1e43a9f526','afafaf','<p>afasfsafsafsa<br></p>',1,'1e5c24847789469e93aab670d7b13b3c','123123','2015-10-10 14:40:58','2015-10-10 14:40:58'),('402882034fc98de0014fc98e40080000','我发了一比较搞笑的帖子','<p>哈哈哈，好尼玛的搞笑啊<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 09:53:06','2015-09-14 09:53:06'),('402882034fc98de0014fc98ee8f80001','我发了一比较搞笑的帖子','<p>哈哈哈，好尼玛的搞笑啊<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 09:53:50','2015-09-14 09:53:50'),('402882034fc98de0014fc98fbe250002','我发了一比较搞笑的帖子','<p>哈哈哈，好尼玛的搞笑啊<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 09:54:44','2015-09-14 09:54:44'),('402882034fc98de0014fc99195470003','我发了一比较搞笑的帖子','<p>哈哈哈，好尼玛的搞笑啊<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 09:56:45','2015-09-14 09:56:45'),('402882034fc98de0014fc993f11e0004','我发了一比较搞笑的帖子','<p>哈哈哈，好尼玛的搞笑啊<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 09:59:20','2015-09-14 09:59:20'),('402882034fc98de0014fc995e03e0005','我又发了一个比较搞笑的帖子','<p>哈哈哈，我又笑翻了<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 10:01:26','2015-09-14 10:01:26'),('402882034fc98de0014fc998cf430006','我又发了一个比较搞笑的帖子','<p>哈哈哈，我又笑翻了<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 10:04:39','2015-09-14 10:04:39'),('402882034fc9a10b014fc9a148ea0000','舒服舒服','<p>爽肤水是否是否双方都 <br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 10:13:54','2015-09-14 10:13:54'),('402882034fc9a348014fc9a3f06c0000','我发了一个测试的帖子','<p>我又来了<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 10:16:48','2015-09-14 10:16:48'),('402882034fc9a6c8014fc9a7cff70000','老是发不成功是怎么jb回事','<p>牛逼的人牛逼之前都是要怂很多次<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 10:21:02','2015-09-14 10:21:02'),('402882034fc9a865014fc9a8c7720000','发布不成功是怎么一回事','<p>啊大大<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 10:22:05','2015-09-14 10:22:05'),('402882034fc9aa58014fc9aa8e4a0000','啊大大','<p>阿达<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 10:24:02','2015-09-14 10:24:02'),('402882034fc9d3cc014fc9d405bb0000','啊飒飒大','<p>阿萨达阿达啊<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 11:09:19','2015-09-14 11:09:19'),('402882034fca9786014fca9952c60000','啊大大','<p>啊大大<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 14:44:49','2015-09-14 14:44:49'),('402882034fca9d99014fca9e4ca70000','啊大大','<p>阿达<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 14:50:16','2015-09-14 14:50:16'),('402882034fca9d99014fcaa333520001','啊大大','<p>阿达<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 14:55:37','2015-09-14 14:55:37'),('402882034fca9d99014fcaa5d6330002','啊大大','<p>阿达<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 14:58:30','2015-09-14 14:58:30'),('402882034fcaa979014fcaaa02160000','阿达','<p>阿达<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 15:03:03','2015-09-14 15:03:03'),('402882034fcab0fe014fcab13d2b0000','发是否','<p>是否<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 15:10:57','2015-09-14 15:10:57'),('402882034fcab0fe014fcab368ff0001','发是否','<p>是否<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 15:13:19','2015-09-14 15:13:19'),('402882034fcabb94014fcabbda260000','adad ','<p>ada a<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 15:22:32','2015-09-14 15:22:32'),('402882034fcabb94014fcabe5de70001','adad ','<p>ada a<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 15:25:17','2015-09-14 15:25:17'),('402882034fcabeb6014fcabf5ef30000','ada','<p>ada<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 15:26:23','2015-09-14 15:26:23'),('402882034fcac427014fcac458c40000','ac','<p>ac<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 15:31:49','2015-09-14 15:31:49'),('402882034fcac518014fcac54cf90000','ac','<p>ac<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 15:32:52','2015-09-14 15:32:52'),('402882034fcacf37014fcacfbf590000','ada','<p>adad<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 15:44:16','2015-09-14 15:44:16'),('402882034fcad142014fcad18f580000','ac','<p>ac<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 15:46:15','2015-09-14 15:46:15'),('402882034fcad435014fcad48c670000','ad','<p>adada<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 15:49:31','2015-09-14 15:49:31'),('402882034fcae564014fcae5b4ee0000','adada','<p>adad<br></p>',5,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 16:08:15','2015-09-14 16:08:15'),('402882034fcb1b5c014fcb1be0ec0000','阿达','<p>阿达<br></p>',2,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 17:07:26','2015-09-14 17:07:26'),('402882034fcbfeb7014fcc0226ae0000','这是一个什么贴','<p>&nbsp;请来跟帖<br></p>',2,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-14 21:18:57','2015-09-14 21:18:57'),('402882034fcc08ca014fcc0ac6550001','123','<p>123</p>',1,'402882034fcc08ca014fcc0a72df0000','zx333333','2015-09-14 21:28:22','2015-09-14 21:28:22'),('402882034fcc0bab014fcc0ef00f0001','asdfsadf','<p>adsfasdfasdfasdf<br></p>',7,'402882034fcc0bab014fcc0c745b0000','hengheng','2015-09-14 21:32:55','2015-09-14 21:32:55'),('402882614fcf078f014fcf097b760001','这个是我发的一帖子','<p>发帖子的控件。叫wangeditor<br></p>',1,'402882614fcf078f014fcf088e2e0000','superMairo','2015-09-15 11:25:49','2015-09-15 11:25:49'),('402882ea4fbf64b0014fbf663d010001','啊啊发','<p>阿凡达啊啊发顺丰安抚安抚安抚<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 10:33:12','2015-09-12 10:33:12'),('402882ea4fbf64b0014fbf66b4fb0002','啊啊发','<p>阿凡达啊啊发顺丰安抚安抚安抚<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 10:33:43','2015-09-12 10:33:43'),('402882ea4fbf64b0014fbf66eb9c0003','啊啊发','<p>阿凡达啊啊发顺丰安抚安抚安抚<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 10:33:57','2015-09-12 10:33:57'),('402882ea4fbf72d0014fbf762e4c0000','dad ','<p>addadadadadadad<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 10:50:37','2015-09-12 10:50:37'),('402882ea4fbf72d0014fbf78aaa50001','dad ','<p>addadadadadadad<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 10:53:20','2015-09-12 10:53:20'),('402882ea4fbf79a0014fbf79e90e0000','sdfsf','<p>sfsfsfsfsf<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 10:54:41','2015-09-12 10:54:41'),('402882ea4fbf7bac014fbf7bdbe70000','adad','<p>adadad<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 10:56:49','2015-09-12 10:56:49'),('402882ea4fbf7bac014fbf7dc69c0001','adad','<p>adadad<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 10:58:55','2015-09-12 10:58:55'),('402882ea4fc0da40014fc0da8d870000','12','<p>啊大大<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 17:19:52','2015-09-12 17:19:52'),('402882ea4fc0f4da014fc0f530b20000','adadad','<p>adadadad<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 17:48:58','2015-09-12 17:48:58'),('402882ea4fc0f4da014fc0f5902c0001','第二页','<p>adadad<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 17:49:22','2015-09-12 17:49:22'),('402882ea4fc0fcbc014fc0fe5f850000','啊大大','<p>&nbsp;啊大大阿达阿萨德阿达阿达阿达啊<br></p>',1,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 17:59:00','2015-09-12 17:59:00'),('402882ea4fc0fcbc014fc0fe98080001','啊大大','<p>阿达阿达<br></p>',7,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 17:59:14','2015-09-12 17:59:14'),('402882ea4fc0fcbc014fc10022f10002','啊啊发','<p>按时发生发生发顺丰啊发<br></p>',7,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 18:00:55','2015-09-12 18:00:55'),('402882ea4fc0fcbc014fc112f6130003','啊啊发','<p>按时发生发生发顺丰啊发<br></p>',7,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 18:21:29','2015-09-12 18:21:29'),('402882ea4fc0fcbc014fc1135ff10004','啊啊发','<p>按时发生发生发顺丰啊发<br></p>',7,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 18:21:56','2015-09-12 18:21:56'),('402882ea4fc0fcbc014fc11388320005','啊啊发','<p>按时发生发生发顺丰啊发<br></p>',7,'402882bb4fba89bd014fba8a5e5c0000','boomshakalaka','2015-09-12 18:22:06','2015-09-12 18:22:06'),('6cd18c555d74408889811b9f5f7a9ff7','ada ','<p>adad <br></p>',2,'1e5c24847789469e93aab670d7b13b3c','123123','2015-09-25 12:00:04','2015-09-25 12:00:04'),('a87d757897844de4b9577f4d2eedf547','么有轨迹','<p>么有轨迹<br></p>',12,'1e5c24847789469e93aab670d7b13b3c','123123','2015-10-01 12:31:18','2015-10-01 12:31:18'),('b2cfabf057a84064bf8d4a97d861985a','搭理的东西','需求这些东西就不要乱说了嘛',6,'1e5c24847789469e93aab670d7b13b3c','123123','2015-09-23 20:03:10','2015-09-23 20:03:10');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `uuid` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`uuid`,`name`,`createTime`) values ('402882da4fb6536c014fb654acde0000','科技交流','2015-09-10 16:17:26'),('402882da4fb6536c014fb654ee0f0001','成电校园','2015-09-10 16:17:43'),('402882da4fb6536c014fb65537c20002','休闲娱乐','2015-09-10 16:18:02'),('402882da4fb6536c014fb65558a80003','跳蚤市场','2015-09-10 16:18:10'),('402882da4fb6536c014fb65579450004','校园服务','2015-09-10 16:18:19'),('402882da4fb6536c014fb65595660005','论坛服务','2015-09-10 16:18:26');

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` int(10) NOT NULL auto_increment,
  `item_name` varchar(64) NOT NULL,
  `summary` varchar(512) NOT NULL,
  `category_id` varchar(32) NOT NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `updateTime` timestamp NOT NULL default '2015-01-01 00:00:00',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `item` */

insert  into `item`(`id`,`item_name`,`summary`,`category_id`,`createTime`,`updateTime`) values (1,'电脑FAQ','<br/><font color=\"red\">\n<font size=\"5\">\n【发帖须知】1、发帖前请先使用论坛的\n搜索功能\n，可能会找到您所需要的答案。\n<br>\n2、发帖时请写清标题，尽量言简意赅，清晰明确；请尽可能地把问题描述清楚，这样有助于更快地解决您的问题。\n<br>\n3、禁止无意义回复，“帮顶”、“mark”等回复将删除。\n<br>\n4、对于提供直接解决方法与建设性意见者，都会有水滴的奖励 。\n</font>\n</font>','402882da4fb6536c014fb654acde0000','2015-09-11 12:59:30','2015-01-01 00:00:00'),(2,'程序员','Stay Hungry, Stay Foolish','402882da4fb6536c014fb654acde0000','2015-09-10 16:26:13','2015-01-01 00:00:00'),(3,'Unix/linux','Unix/linux的简介','402882da4fb6536c014fb654acde0000','2015-09-10 16:26:42','2015-01-01 00:00:00'),(4,'硬件数码','硬件数码的简介','402882da4fb6536c014fb654acde0000','2015-09-10 16:27:00','2015-01-01 00:00:00'),(5,'电子设计','电子设计的简介。。。。。。','402882da4fb6536c014fb654acde0000','2015-09-10 16:27:21','2015-01-01 00:00:00'),(6,'科技资讯','科技资讯的简介。。。。。。。。。。。。','402882da4fb6536c014fb654acde0000','2015-09-10 16:27:44','2015-01-01 00:00:00'),(7,'前端之美','前段之美的简介','402882da4fb6536c014fb654acde0000','2015-09-10 16:28:06','2015-01-01 00:00:00'),(8,'数学前言','数学前言的简介','402882da4fb6536c014fb654acde0000','2015-09-10 16:28:31','2015-01-01 00:00:00'),(9,'老乡会','老乡会还是有简介的','402882da4fb6536c014fb654ee0f0001','2015-09-10 16:30:05','2015-01-01 00:00:00'),(10,'学术交流','学术的交流就像身体的交流一样，无色无形','402882da4fb6536c014fb654ee0f0001','2015-09-10 16:31:59','2015-01-01 00:00:00'),(11,'情感专区','知心姐姐呀呀呀呀呀呀呀呀呀','402882da4fb6536c014fb654ee0f0001','2015-09-10 16:32:10','2015-01-01 00:00:00'),(12,'成电轨迹','新校区哪来他妈来的轨迹呀','402882da4fb6536c014fb654ee0f0001','2015-09-10 16:32:28','2015-01-01 00:00:00'),(13,'就业创业','就业可以，创业就算了，你那破样','402882da4fb6536c014fb654ee0f0001','2015-09-10 16:32:42','2015-01-01 00:00:00'),(14,'出国留学','出国留学的时候有一个比较好的现象','402882da4fb6536c014fb654ee0f0001','2015-09-10 16:32:54','2015-01-01 00:00:00'),(15,'出行有道','怎么叫做出行有道','402882da4fb6536c014fb654ee0f0001','2015-09-10 16:33:00','2015-01-01 00:00:00'),(16,'校园热点','霍，前面那人好像一条狗也','402882da4fb6536c014fb654ee0f0001','2015-09-10 16:33:17','2015-01-01 00:00:00'),(17,'毕业感言','我好感动啊','402882da4fb6536c014fb654ee0f0001','2015-09-10 16:33:24','2015-01-01 00:00:00'),(18,'学院在线','啊大大大','402882da4fb6536c014fb654ee0f0001','2015-09-10 16:33:29','2015-01-01 00:00:00');

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `id` int(10) NOT NULL auto_increment,
  `content` varchar(1024) NOT NULL,
  `card_id` varchar(32) NOT NULL,
  `author_id` varchar(32) NOT NULL,
  `author_name` varchar(64) NOT NULL,
  `reply_id` int(10) NOT NULL,
  `create_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `reply` */

insert  into `reply`(`id`,`content`,`card_id`,`author_id`,`author_name`,`reply_id`,`create_time`) values (1,'<p>啊大大<br></p>','402882034fcb1b5c014fcb1be0ec0000','402882bb4fba89bd014fba8a5e5c0000','boomshakalaka',0,'2015-09-14 17:20:17'),(2,'<p>ad<br></p>','402882034fcb1b5c014fcb1be0ec0000','402882bb4fba89bd014fba8a5e5c0000','boomshakalaka',0,'2015-09-14 17:42:26'),(5,'<p>啊大大aada <br></p>','402882034fcb1b5c014fcb1be0ec0000','402882bb4fba89bd014fba8a5e5c0000','boomshakalaka',0,'2015-09-14 19:12:36'),(6,'<p>阿达<br></p>','402882034fcb1b5c014fcb1be0ec0000','402882bb4fba89bd014fba8a5e5c0000','boomshakalaka',0,'2015-09-14 21:14:24'),(7,'<p>有一个姑娘</p><p><br></p>','402882034fcb1b5c014fcb1be0ec0000','402882bb4fba89bd014fba8a5e5c0000','boomshakalaka',0,'2015-09-14 21:14:31'),(8,'哎呀哎呀','402882034fcbfeb7014fcc0226ae0000','402882bb4fba89bd014fba8a5e5c0000','boomshakalaka',0,'2015-09-14 21:19:06'),(9,'<p>123213</p>','402882034fcc08ca014fcc0ac6550001','402882034fcc08ca014fcc0a72df0000','zx333333',0,'2015-09-14 21:28:27'),(10,'<p>12312</p>','402882034fcc08ca014fcc0ac6550001','402882034fcc08ca014fcc0a72df0000','zx333333',0,'2015-09-14 21:28:29'),(11,'<p>12312</p>','402882034fcc08ca014fcc0ac6550001','402882034fcc08ca014fcc0a72df0000','zx333333',0,'2015-09-14 21:28:29'),(12,'<p>12321</p>','402882034fcc08ca014fcc0ac6550001','402882034fcc08ca014fcc0a72df0000','zx333333',0,'2015-09-14 21:28:32'),(13,'<p>123</p>','402882034fcc08ca014fcc0ac6550001','402882034fcc08ca014fcc0a72df0000','zx333333',0,'2015-09-14 21:28:39'),(14,'<p>123</p>','402882034fcc08ca014fcc0ac6550001','402882034fcc08ca014fcc0a72df0000','zx333333',0,'2015-09-14 21:28:41'),(15,'<p>123</p>','402882034fcc08ca014fcc0ac6550001','402882034fcc08ca014fcc0a72df0000','zx333333',0,'2015-09-14 21:28:44'),(16,'这是回复的界面 ，回复的窗口<br>','402882034fc98de0014fc98e40080000','402882614fcf078f014fcf088e2e0000','superMairo',0,'2015-09-15 11:25:25'),(17,'<p>这里进入了帖子的详情页，做的还是比较简陋，没有楼层的这些业务，就仅仅是发帖和回帖，而且只能回复主贴的功能<br></p>','402882614fcf078f014fcf097b760001','402882614fcf078f014fcf088e2e0000','superMairo',0,'2015-09-15 11:26:30'),(18,'这就是一个回复','402882034fc98de0014fc98e40080000','1e5c24847789469e93aab670d7b13b3c','123123',0,'2015-09-23 19:54:48'),(19,'<blockquote style=\"display:block; border-left: 5px solid #d0e5f2; padding:0 0 0 10px; margin:0; line-height:1.4; font-size: 100%;\"><u>讽德诵功的所发生的</u></blockquote>','a87d757897844de4b9577f4d2eedf547','1e5c24847789469e93aab670d7b13b3c','123123',0,'2015-10-01 12:37:11'),(20,'<p>adadad<br></p>','21e188e5cbe341ecbac20ff50766a3c4','','',0,'2015-10-10 11:50:25'),(21,'<p>adadad<br></p>','402882034fc98de0014fc98e40080000','1e5c24847789469e93aab670d7b13b3c','123123',0,'2015-10-10 14:40:49');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `uuid` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `age` int(10) NOT NULL,
  `gender` varchar(40) NOT NULL,
  PRIMARY KEY  (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

insert  into `test`(`uuid`,`name`,`age`,`gender`) values ('0468d8f92a6746d59c602eaaa58024c2','ada',12,'1'),('309473b1795942b7809167de725529a8','ada',12,'ad'),('8fa02cef389447d7984fcf34d2d8f1ff','ada',12,'ad'),('a2681d295f9e4b58ba8c073159c373fc','ada',12,'ad'),('b6c44d7a270a4ff896982ac9f42e8c5b','ada',12,'ad');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uuid` varchar(32) NOT NULL,
  `name` varchar(64) NOT NULL,
  `email` varchar(128) NOT NULL,
  `password` varchar(64) NOT NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `updateTime` timestamp NOT NULL default '2015-01-01 00:00:00',
  PRIMARY KEY  (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uuid`,`name`,`email`,`password`,`createTime`,`updateTime`) values ('1e5c24847789469e93aab670d7b13b3c','123123','123@qq.com','4297f44b13955235245b2497399d7a93','2015-09-23 16:55:50','2015-09-23 16:55:50'),('2714adf0fe344430b56cdeb2d82c320b','dfgwef','1234@qq.com','e10adc3949ba59abbe56e057f20f883e','2015-10-08 19:35:55','2015-10-08 19:35:55'),('4ac8abbe815f4fdbbc11a0a3937ac22e','adad','123456@qq.com','4297f44b13955235245b2497399d7a93','2015-10-10 09:59:13','2015-10-10 09:59:13'),('ba7fe92aad934c2fb999fc57d9216f0e','werqw','12345@qq.com','4297f44b13955235245b2497399d7a93','2015-10-10 09:57:15','2015-10-10 09:57:15');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
