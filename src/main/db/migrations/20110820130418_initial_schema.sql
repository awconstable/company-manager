-- MySQL dump 10.11
--
-- Host: localhost    Database: CROSSFIRE_company
-- ------------------------------------------------------
-- Server version	5.0.51a-3ubuntu5.8-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `contacts` (
  `id` int(11) NOT NULL auto_increment,
  `account_ref` varchar(50) NOT NULL,
  `title_id` int(10) unsigned NOT NULL default '0',
  `firstname` varchar(255) default NULL,
  `surname` varchar(255) default NULL,
  `company_name` varchar(255) default NULL,
  `address_1` varchar(255) default NULL,
  `address_2` varchar(255) default NULL,
  `address_3` varchar(255) default NULL,
  `city` varchar(255) default NULL,
  `county` varchar(255) default NULL,
  `postcode` varchar(50) default NULL,
  `tel_1` varchar(50) default NULL,
  `tel_2` varchar(50) default NULL,
  `mobile` varchar(50) default NULL,
  `fax` varchar(50) default NULL,
  `email` varchar(255) default NULL,
  `www` varchar(255) default NULL,
  `vat_number` varchar(30) default NULL,
  `company_reg` varchar(30) default NULL,
  `created` datetime NOT NULL default '0000-00-00 00:00:00',
  `modified` datetime default NULL,
  `country` varchar(255) default NULL,
  `role_id` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `account_ref` (`account_ref`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `credit_note_rows`
--

DROP TABLE IF EXISTS `credit_note_rows`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `credit_note_rows` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `line_number` smallint(5) unsigned NOT NULL default '0',
  `product_id` int(10) unsigned NOT NULL default '0',
  `description` varchar(255) NOT NULL,
  `quantity` decimal(10,2) unsigned NOT NULL default '0.00',
  `discount` smallint(5) unsigned NOT NULL default '0',
  `retail_cost` decimal(10,2) unsigned NOT NULL default '0.00',
  `discount_cost` decimal(10,2) unsigned NOT NULL default '0.00',
  `line_total` decimal(10,2) unsigned NOT NULL default '0.00',
  `created` datetime NOT NULL default '0000-00-00 00:00:00',
  `modified` datetime default NULL,
  `parent_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `credit_notes`
--

DROP TABLE IF EXISTS `credit_notes`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `credit_notes` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `contact_id` int(10) unsigned NOT NULL default '0',
  `doc_number` int(10) unsigned NOT NULL default '0',
  `parent_id` int(10) unsigned default NULL,
  `client_ref` varchar(45) default NULL,
  `date_issued` date NOT NULL default '0000-00-00',
  `shipping_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `net_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `vat_rate` decimal(5,2) unsigned NOT NULL default '0.00',
  `vat_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `total_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `created` datetime NOT NULL default '0000-00-00 00:00:00',
  `modified` datetime default NULL,
  `comment` text,
  `version` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `delivery_note_rows`
--

DROP TABLE IF EXISTS `delivery_note_rows`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `delivery_note_rows` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `line_number` smallint(5) unsigned NOT NULL default '0',
  `product_id` int(10) unsigned NOT NULL default '0',
  `description` varchar(255) NOT NULL,
  `quantity` decimal(10,2) unsigned NOT NULL default '0.00',
  `discount` smallint(5) unsigned default NULL,
  `retail_cost` decimal(10,2) unsigned default NULL,
  `discount_cost` decimal(10,2) unsigned default NULL,
  `line_total` decimal(10,2) unsigned default NULL,
  `created` datetime NOT NULL default '0000-00-00 00:00:00',
  `modified` datetime default NULL,
  `parent_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `delivery_notes`
--

DROP TABLE IF EXISTS `delivery_notes`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `delivery_notes` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `contact_id` int(10) unsigned NOT NULL default '0',
  `doc_number` int(10) unsigned NOT NULL default '0',
  `parent_id` int(10) unsigned default NULL,
  `client_ref` varchar(45) default NULL,
  `date_issued` date NOT NULL default '0000-00-00',
  `date_completed` date NOT NULL default '0000-00-00',
  `completed` tinyint(1) NOT NULL default '0',
  `cancelled` tinyint(1) NOT NULL default '0',
  `shipping_value` decimal(10,2) unsigned default NULL,
  `net_value` decimal(10,2) unsigned default NULL,
  `vat_rate` decimal(5,2) unsigned default NULL,
  `vat_value` decimal(10,2) unsigned default NULL,
  `total_value` decimal(10,2) unsigned default NULL,
  `date_cancelled` date NOT NULL default '0000-00-00',
  `created` datetime NOT NULL default '0000-00-00 00:00:00',
  `modified` datetime default NULL,
  `comment` text,
  `version` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `invoice_rows`
--

DROP TABLE IF EXISTS `invoice_rows`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `invoice_rows` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `parent_id` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL default '0',
  `line_number` smallint(6) unsigned NOT NULL default '0',
  `quantity` decimal(10,2) unsigned NOT NULL default '0.00',
  `retail_cost` decimal(10,2) unsigned NOT NULL default '0.00',
  `description` varchar(255) NOT NULL,
  `line_total` decimal(10,2) unsigned NOT NULL default '0.00',
  `created` datetime NOT NULL default '0000-00-00 00:00:00',
  `modified` datetime default NULL,
  `discount` smallint(5) unsigned NOT NULL default '0',
  `discount_cost` decimal(10,2) unsigned NOT NULL default '0.00',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=513 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `invoices`
--

DROP TABLE IF EXISTS `invoices`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `invoices` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `contact_id` int(10) unsigned NOT NULL default '0',
  `doc_number` int(10) unsigned NOT NULL default '0',
  `date_issued` date NOT NULL default '0000-00-00',
  `date_completed` date NOT NULL default '0000-00-00',
  `cancelled` tinyint(1) unsigned NOT NULL default '0',
  `net_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `vat_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `total_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `shipping_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `created` datetime NOT NULL default '0000-00-00 00:00:00',
  `modified` datetime default NULL,
  `client_ref` varchar(45) default NULL,
  `completed` tinyint(1) NOT NULL default '0',
  `vat_rate` decimal(5,2) unsigned NOT NULL default '0.00',
  `parent_id` int(10) unsigned default NULL,
  `comment` text,
  `date_cancelled` date NOT NULL default '0000-00-00',
  `version` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `invoice_number` (`doc_number`)
) ENGINE=InnoDB AUTO_INCREMENT=280 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `logs` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `created` datetime NOT NULL default '0000-00-00 00:00:00',
  `description` text NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `remote_address` varchar(15) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=531 DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 4096 kB';
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `options` (
  `key` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  PRIMARY KEY  (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `order_rows`
--

DROP TABLE IF EXISTS `order_rows`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `order_rows` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `line_number` smallint(5) unsigned NOT NULL default '0',
  `parent_id` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL default '0',
  `description` varchar(255) NOT NULL,
  `quantity` decimal(10,2) unsigned NOT NULL default '0.00',
  `discount` smallint(5) unsigned NOT NULL default '0',
  `retail_cost` decimal(10,2) unsigned NOT NULL default '0.00',
  `discount_cost` decimal(10,2) unsigned NOT NULL default '0.00',
  `line_total` decimal(10,2) unsigned NOT NULL default '0.00',
  `created` datetime NOT NULL default '0000-00-00 00:00:00',
  `modified` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `orders` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `doc_number` int(10) unsigned NOT NULL default '0',
  `parent_id` int(10) unsigned default NULL,
  `contact_id` int(10) unsigned NOT NULL default '0',
  `client_ref` varchar(45) default NULL,
  `date_issued` date NOT NULL default '0000-00-00',
  `cancelled` tinyint(1) NOT NULL default '0',
  `shipping_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `net_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `vat_rate` decimal(5,2) unsigned NOT NULL default '0.00',
  `vat_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `total_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `completed` tinyint(1) NOT NULL default '0',
  `date_completed` date NOT NULL default '0000-00-00',
  `created` datetime NOT NULL default '0000-00-00 00:00:00',
  `modified` datetime default NULL,
  `version` int(10) unsigned NOT NULL default '0',
  `date_cancelled` date NOT NULL default '0000-00-00',
  `comment` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `products` (
  `id` int(11) NOT NULL auto_increment,
  `contact_id` int(11) NOT NULL default '0',
  `product_ref` varchar(20) NOT NULL,
  `manf_code` varchar(255) default NULL,
  `description` varchar(255) NOT NULL,
  `purchase_cost` decimal(10,2) default NULL,
  `retail_cost` decimal(10,2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `quote_rows`
--

DROP TABLE IF EXISTS `quote_rows`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `quote_rows` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `line_number` smallint(5) unsigned NOT NULL default '0',
  `parent_id` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL default '0',
  `description` varchar(255) NOT NULL,
  `quantity` decimal(10,2) unsigned NOT NULL default '0.00',
  `discount` smallint(5) unsigned NOT NULL default '0',
  `retail_cost` decimal(10,2) unsigned NOT NULL default '0.00',
  `discount_cost` decimal(10,2) unsigned NOT NULL default '0.00',
  `line_total` decimal(10,2) unsigned NOT NULL default '0.00',
  `created` datetime NOT NULL default '0000-00-00 00:00:00',
  `modified` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `quotes`
--

DROP TABLE IF EXISTS `quotes`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `quotes` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `contact_id` int(10) unsigned NOT NULL default '0',
  `doc_number` int(10) unsigned NOT NULL default '0',
  `client_ref` varchar(45) default NULL,
  `date_issued` date NOT NULL default '0000-00-00',
  `date_completed` date default '0000-00-00',
  `completed` tinyint(1) NOT NULL default '0',
  `cancelled` tinyint(1) NOT NULL default '0',
  `shipping_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `net_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `vat_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `total_value` decimal(10,2) unsigned NOT NULL default '0.00',
  `created` datetime NOT NULL default '0000-00-00 00:00:00',
  `vat_rate` decimal(5,2) unsigned NOT NULL default '0.00',
  `date_cancelled` date default '0000-00-00',
  `comment` text,
  `version` int(10) unsigned NOT NULL default '0',
  `modified` datetime default NULL,
  `parent_id` int(10) unsigned default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `roles` (
  `id` int(10) unsigned NOT NULL default '0',
  `role` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `sessions` (
  `UUID` varchar(36) character set utf8 NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `remote_address` varchar(15) character set utf8 NOT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY  (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `titles`
--

DROP TABLE IF EXISTS `titles`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `titles` (
  `id` int(10) unsigned NOT NULL default '0',
  `title` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user_options`
--

DROP TABLE IF EXISTS `user_options`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `user_options` (
  `key` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  PRIMARY KEY  (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `access_level` int(11) NOT NULL default '0',
  `created` datetime NOT NULL,
  `modified` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `vat`
--

DROP TABLE IF EXISTS `vat`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `vat` (
  `id` int(10) unsigned NOT NULL default '0',
  `rate` decimal(5,2) unsigned NOT NULL default '0.00',
  `default_rate` tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-08-20 12:45:12
