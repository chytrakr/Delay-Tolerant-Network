-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.8


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema virus
--

CREATE DATABASE IF NOT EXISTS virus;
USE virus;

--
-- Definition of table `evidence`
--

DROP TABLE IF EXISTS `evidence`;
CREATE TABLE `evidence` (
  `Virus` varchar(100) DEFAULT NULL,
  `Ipaddress` varchar(100) DEFAULT NULL,
  `Attaked_tir` varchar(100) DEFAULT NULL,
  `Result` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evidence`
--

/*!40000 ALTER TABLE `evidence` DISABLE KEYS */;
INSERT INTO `evidence` (`Virus`,`Ipaddress`,`Attaked_tir`,`Result`) VALUES 
 ('DirectDB.dll','192.168.43.26','Sat May 16 00:20:34 EDT 2015','Cleaned');
/*!40000 ALTER TABLE `evidence` ENABLE KEYS */;


--
-- Definition of table `router`
--

DROP TABLE IF EXISTS `router`;
CREATE TABLE `router` (
  `Fname` varchar(100) DEFAULT NULL,
  `Dest` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `router`
--

/*!40000 ALTER TABLE `router` DISABLE KEYS */;
INSERT INTO `router` (`Fname`,`Dest`) VALUES 
 ('PHR.txt','DA'),
 ('PHR.txt','DA'),
 ('Table1.txt','DA'),
 ('Table1.txt','DA'),
 ('Table1.txt','DA'),
 ('Table1.txt','DA');
/*!40000 ALTER TABLE `router` ENABLE KEYS */;


--
-- Definition of table `sender`
--

DROP TABLE IF EXISTS `sender`;
CREATE TABLE `sender` (
  `Fname` varchar(100) DEFAULT NULL,
  `Dest` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sender`
--

/*!40000 ALTER TABLE `sender` DISABLE KEYS */;
INSERT INTO `sender` (`Fname`,`Dest`) VALUES 
 ('PHR.txt','DA'),
 ('Table1.txt','DA'),
 ('Table1.txt','DA');
/*!40000 ALTER TABLE `sender` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
