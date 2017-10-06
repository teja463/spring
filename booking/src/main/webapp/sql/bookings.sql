-- MySQL dump 10.11
--
-- Host: localhost    Database: bookings
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt

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
-- Table structure for table `city`
--
drop database `bookings`;
CREATE DATABASE `bookings` /*!40100 DEFAULT CHARACTER SET latin1 */;

use `bookings`;

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1001,'Hyderabad'),(1002,'Bangalore'),(1003,'Pune'),(1004,'Chennai');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) default NULL,
  `CITY` varchar(45) default NULL,
  `RATING` int(11) default NULL,
  `ROOM_PRICE` int(11) default NULL,
  `AVAILABLE_ROOMS` int(11) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1000,'Taj Banjara','Hyderabad',4,5600,33),(1001,'Fairfield','Bangalore',4,4500,24),(1002,'Park Hyatt','Hyderabad',5,4800,29),(1003,'JW Marriott Hotel','Pune',5,6200,50),(1004,'The O Hotel','Pune',3,3200,25),(1005,'The Westin Pune Koregaon Park','Pune',4,4500,35),(1006,'Courtyard Chenai','Chennai',5,6500,40),(1007,'Radisson Blu Hotel','Chennai',3,2500,20),(1008,'Sheranton Grand Banglore','Bangalore',3,3000,40),(1009,'The Ritz Carlton','Bangalore',4,3500,25),(1010,'Vivanta by Taj','Bangalore',5,4000,30),(1011,'The Gateway Hotel','Bangalore',4,4500,25),(1012,'Ginger Hotel','Bangalore',2,2000,40);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roombooking`
--

DROP TABLE IF EXISTS `roombooking`;
CREATE TABLE `roombooking` (
  `ID` int(11) NOT NULL auto_increment,
  `HOTEL` varchar(45) default NULL,
  `CITY` varchar(45) default NULL,
  `ROOMS_BOOKED` int(11) default NULL,
  `CHECKIN` datetime default NULL,
  `CHECKOUT` datetime default NULL,
  `TOTAL_COST` double default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roombooking`
--

LOCK TABLES `roombooking` WRITE;
/*!40000 ALTER TABLE `roombooking` DISABLE KEYS */;
INSERT INTO `roombooking` VALUES (1,'Park Hyatt','Hyderabad',4,'2017-01-12 00:00:00','2017-01-14 00:00:00',9600),(2,'Taj Banjara','Hyderabad',4,'2017-01-12 00:00:00','2017-01-14 00:00:00',104992),(3,'Taj Banjara','Hyderabad',4,'2017-01-12 00:00:00','2017-01-14 00:00:00',44800),(4,'Taj Banjara','Hyderabad',4,'2017-01-12 00:00:00','2017-01-14 00:00:00',44800),(5,'Taj Banjara','Hyderabad',4,'2017-01-12 00:00:00','2017-01-14 00:00:00',44800),(6,'Fairfield','Bangalore',2,'2017-01-12 00:00:00','2017-01-14 00:00:00',18000),(7,'Fairfield','Bangalore',4,'2017-01-12 00:00:00','2017-01-14 00:00:00',36000),(8,'Fairfield','Bangalore',4,'2017-01-12 00:00:00','2017-01-14 00:00:00',36000),(9,'Fairfield','Bangalore',4,'2017-01-25 00:00:00','2017-01-25 00:00:00',0),(10,'The O Hotel','Pune',4,'2017-01-19 00:00:00','2017-01-21 00:00:00',25600),(11,'Ginger Hotel','Bangalore',4,'2017-01-24 00:00:00','2017-01-25 00:00:00',1332000),(12,'Ginger Hotel','Bangalore',6666,'2017-01-18 00:00:00','2017-01-20 00:00:00',26664000),(13,'Ginger Hotel','Bangalore',555,'2017-01-19 00:00:00','2017-01-20 00:00:00',1110000),(14,'Ginger Hotel','Bangalore',4,'2017-01-25 00:00:00','2017-01-26 00:00:00',8000),(15,'Radisson Blu Hotel','Chennai',2,'2017-01-24 00:00:00','2017-01-25 00:00:00',5000),(16,'Sheranton Grand Banglore','Bangalore',4,'2017-01-24 00:00:00','2017-01-25 00:00:00',12000),(17,'Ginger Hotel','Bangalore',3,'2017-01-23 00:00:00','2017-01-26 00:00:00',18000),(18,'Park Hyatt','Hyderabad',1,'2017-01-12 00:00:00','2017-01-14 00:00:00',9600),(19,'Park Hyatt','Hyderabad',2,'2017-01-12 00:00:00','2017-01-14 00:00:00',19200),(20,'Park Hyatt','Hyderabad',21,'2017-01-12 00:00:00','2017-01-14 00:00:00',201600),(21,'Park Hyatt','Hyderabad',1,'2017-01-12 00:00:00','2017-01-14 00:00:00',9600),(22,'The Ritz Carlton','Bangalore',1,'2017-09-07 00:00:00','2017-09-08 00:00:00',3500);
/*!40000 ALTER TABLE `roombooking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-06 17:36:43
