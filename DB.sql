-- MySQL dump 10.10
--
-- Host: localhost    Database: struts
-- ------------------------------------------------------
-- Server version	5.0.27-community-nt

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
-- Table structure for table `details`
--

DROP TABLE IF EXISTS `details`;
CREATE TABLE `details` (
  `sno` int(10) unsigned NOT NULL auto_increment,
  `sname` varchar(45) NOT NULL,
  `scountry` varchar(45) NOT NULL,
  PRIMARY KEY  (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `details`
--

LOCK TABLES `details` WRITE;
/*!40000 ALTER TABLE `details` DISABLE KEYS */;
INSERT INTO `details` VALUES (1,'Parth Patel','34parth@gmail.c'),(2,'PARTH','p@gmail.com'),(4,'Dhruv Dalwadi','dhruv@gmail.com'),(5,'Vaishali Prajapari','vaishali@gmail.com'),(6,'Kinjal Patel','kinjal@gmail.com'),(7,'annu','annu@gmail.co'),(8,'saloni','saloni@saloni.com'),(9,'dhyana','dhyana@gmail.com'),(10,'d26ed22e6c75ca6861b75aa8d227bb12','india'),(11,'ishani','ishani@gmail.com'),(12,'jaykar','jaykar@gmail.com'),(13,'jainish','jainish@gmail.com'),(14,'jaay','jaay@gmail.com'),(15,'jugal','jugal@gmail.com'),(16,'bhavik','patelbhavik@gmail.com,'),(17,'akki','akki@gmail.com'),(18,'Ronak','ronak@gmail.com');
/*!40000 ALTER TABLE `details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-29 11:14:50
