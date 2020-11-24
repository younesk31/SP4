CREATE DATABASE  IF NOT EXISTS `mariospizzabar` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mariospizzabar`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mariospizzabar
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `menucard`
--

DROP TABLE IF EXISTS `menucard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menucard` (
  `mid` int NOT NULL AUTO_INCREMENT,
  `navn` varchar(50) NOT NULL,
  `fyld` varchar(100) NOT NULL,
  `pris` varchar(3) NOT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menucard`
--

LOCK TABLES `menucard` WRITE;
/*!40000 ALTER TABLE `menucard` DISABLE KEYS */;
INSERT INTO `menucard` VALUES (1,'Vesuvio','Tomato sauce,cheese,ham & oregano','57'),(2,'Amerikaner','Tomato sauce,cheese,beef & oregano','53'),(3,'Caccoatore','Tomato sauce,cheese,pepperoni & oregano','57'),(4,'Carbona','Tomato sauce,cheese,beef sauce,spaghetti,cocktail sausage & oregano','63'),(5,'Dennis','Tomato sauce,cheese,ham,pepperoni,cocktail sausage & oregano','65'),(6,'Bertil','Tomato sauce,cheese,bacon & oregano','57'),(7,'Silvia','Tomato sauce,cheese,pepperoni,red pepper,onions,olive & oregano','61'),(8,'Victoria','Tomato sauce,cheese,ham,pineapple,mushroom,onions & oregano','61'),(9,'Toronfo','Tomato sauce,cheese,ham,bacon,kebab,chili & oregano','61'),(10,'Capricciosa','Tomato sauce,cheese,ham,mushroom & oregano','61'),(11,'Hawaii','Tomato sauce,cheese,ham,pineapple & oregano','61'),(12,'Le Blissola','Tomato sauce,cheese,ham,shrimp & oregano','61'),(13,'Venezia','Tomato sauce,cheese,ham,bacon & oregano','61'),(14,'Mafia','Tomato sauce,cheese,pepperoni,onions & oregano','61'),(15,'Mario','Tomato sauce,kebab,salad & dressing','35');
/*!40000 ALTER TABLE `menucard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderNr` int NOT NULL AUTO_INCREMENT,
  `pizzaName` varchar(50) NOT NULL,
  `pizzaNr` varchar(2) NOT NULL,
  `onlineOroffline` varchar(15) NOT NULL,
  `customer` varchar(60) NOT NULL,
  `pris` varchar(3) NOT NULL,
  `orderTime` varchar(20) NOT NULL,
  `filling` varchar(100) NOT NULL,
  `orderFinished` varchar(20) NOT NULL,
  PRIMARY KEY (`orderNr`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-23 16:06:48
