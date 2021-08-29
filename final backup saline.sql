-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.19


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema saline_level
--

CREATE DATABASE IF NOT EXISTS saline_level;
USE saline_level;

--
-- Definition of table `admin_login`
--

DROP TABLE IF EXISTS `admin_login`;
CREATE TABLE `admin_login` (
  `sr` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`sr`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_login`
--

/*!40000 ALTER TABLE `admin_login` DISABLE KEYS */;
INSERT INTO `admin_login` (`sr`,`email`,`password`,`name`) VALUES 
 (1,'admin@gmail.com','admin','Admin');
/*!40000 ALTER TABLE `admin_login` ENABLE KEYS */;


--
-- Definition of table `admitted_details`
--

DROP TABLE IF EXISTS `admitted_details`;
CREATE TABLE `admitted_details` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `patient_id` varchar(45) NOT NULL,
  `nurse_id` varchar(45) NOT NULL,
  `bed_number` varchar(45) NOT NULL,
  `admitted_on` varchar(45) NOT NULL,
  `discharge_on` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `saline_level` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admitted_details`
--

/*!40000 ALTER TABLE `admitted_details` DISABLE KEYS */;
INSERT INTO `admitted_details` (`id`,`patient_id`,`nurse_id`,`bed_number`,`admitted_on`,`discharge_on`,`description`,`saline_level`,`status`) VALUES 
 (1,'1','1','1','03/16/2019 15:44','NA','Sss','0','Admitted');
/*!40000 ALTER TABLE `admitted_details` ENABLE KEYS */;


--
-- Definition of table `nurse_details`
--

DROP TABLE IF EXISTS `nurse_details`;
CREATE TABLE `nurse_details` (
  `nurse_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `education` varchar(45) NOT NULL,
  `joining_date` varchar(45) NOT NULL,
  `salary` varchar(45) NOT NULL,
  `ward_id` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`nurse_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nurse_details`
--

/*!40000 ALTER TABLE `nurse_details` DISABLE KEYS */;
INSERT INTO `nurse_details` (`nurse_id`,`name`,`email`,`password`,`mobile`,`education`,`joining_date`,`salary`,`ward_id`,`status`) VALUES 
 (1,'Elina','elina@gmail.com','12345','7350456969','MBBS','02/20/2019','45000','1','2'),
 (2,'Kritika','kritika@gmail.com','12345','7350706868','DHMS','06/15/2018','30200','2','1');
/*!40000 ALTER TABLE `nurse_details` ENABLE KEYS */;


--
-- Definition of table `patient_details`
--

DROP TABLE IF EXISTS `patient_details`;
CREATE TABLE `patient_details` (
  `patient_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(45) NOT NULL,
  `patient_email` varchar(45) NOT NULL,
  `patient_mobile` varchar(45) NOT NULL,
  `patient_address` varchar(45) NOT NULL,
  `patient_added_on` varchar(45) NOT NULL,
  `patient_status` varchar(45) NOT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient_details`
--

/*!40000 ALTER TABLE `patient_details` DISABLE KEYS */;
INSERT INTO `patient_details` (`patient_id`,`patient_name`,`patient_email`,`patient_mobile`,`patient_address`,`patient_added_on`,`patient_status`) VALUES 
 (1,'Dinesh Ubale','ubaledinesh4u@gmail.com','7350456969','Pune','03/16/2019 15:44','Active');
/*!40000 ALTER TABLE `patient_details` ENABLE KEYS */;


--
-- Definition of table `ward_details`
--

DROP TABLE IF EXISTS `ward_details`;
CREATE TABLE `ward_details` (
  `ward_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ward_name` varchar(45) NOT NULL,
  `cot_details` int(10) unsigned NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`ward_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ward_details`
--

/*!40000 ALTER TABLE `ward_details` DISABLE KEYS */;
INSERT INTO `ward_details` (`ward_id`,`ward_name`,`cot_details`,`status`) VALUES 
 (1,'Ward 1',20,'Assigned'),
 (2,'Ward 2',10,'Not Assigned');
/*!40000 ALTER TABLE `ward_details` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
