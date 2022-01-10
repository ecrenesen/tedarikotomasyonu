-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: giyim
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `giyimbilgileri`
--

DROP TABLE IF EXISTS `giyimbilgileri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giyimbilgileri` (
  `barkodno` int NOT NULL AUTO_INCREMENT,
  `tur` varchar(45) DEFAULT NULL,
  `fiyat` varchar(45) DEFAULT NULL,
  `renk` varchar(45) DEFAULT NULL,
  `stok` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`barkodno`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giyimbilgileri`
--

LOCK TABLES `giyimbilgileri` WRITE;
/*!40000 ALTER TABLE `giyimbilgileri` DISABLE KEYS */;
INSERT INTO `giyimbilgileri` VALUES (56,'kazak','92','siyah','56'),(136,'eldiven','20','mavi','45'),(137,'ayakkabı','320','sarı','65'),(138,'pantolon','150','kırmızı','86'),(139,'aksesuar','15','siyah','87'),(140,'etek','65','mor','52'),(141,'bluz','85','pembe','69'),(142,'çorap','10','gri','34'),(143,'tayt','43','beyaz','98'),(144,NULL,NULL,NULL,'');
/*!40000 ALTER TABLE `giyimbilgileri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-10 21:03:39
