CREATE DATABASE  IF NOT EXISTS `consecionaria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `consecionaria`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: consecionaria
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auto` (
  `TIPO` varchar(50) NOT NULL,
  `PLACA` varchar(7) NOT NULL,
  `MARCA` varchar(50) NOT NULL,
  `PRECIO` double NOT NULL,
  `COLOR` varchar(20) NOT NULL,
  `AÑO` int NOT NULL,
  PRIMARY KEY (`PLACA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES ('AUTO','A-100','NISSAN',26060,'NEGRO',2020);
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprador`
--

DROP TABLE IF EXISTS `comprador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprador` (
  `dni` char(8) NOT NULL,
  `Nombres` varchar(60) NOT NULL,
  `Apellidos` varchar(60) NOT NULL,
  `Direccion` varchar(70) NOT NULL,
  `Edad` int NOT NULL,
  `Correo` varchar(120) NOT NULL,
  `Genero` varchar(30) NOT NULL,
  `Celular` varchar(15) NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprador`
--

LOCK TABLES `comprador` WRITE;
/*!40000 ALTER TABLE `comprador` DISABLE KEYS */;
INSERT INTO `comprador` VALUES ('35795145','Carlo Juan','Ninaja','las bahamas',23,'carlo@gmail.com','MASCULINO','974156234'),('5154','askdjkasjdkasdj','aklsdjkalsdj','akdjsklasjklasdj',20,'klasdjlkasdj','MASCULINO','41454');
/*!40000 ALTER TABLE `comprador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato` (
  `NUMERODECONTRATO` varchar(10) NOT NULL,
  `IDVENDEDOR` varchar(10) NOT NULL,
  `dni` char(8) NOT NULL,
  `PLACA` varchar(7) NOT NULL,
  `DEESCRIPCION` varchar(300) NOT NULL,
  `FECHADECREACION` varchar(15) NOT NULL,
  PRIMARY KEY (`NUMERODECONTRATO`) USING BTREE,
  KEY `contrato_ibfk_1` (`PLACA`),
  KEY `contrato_ibfk_2` (`IDVENDEDOR`),
  KEY `contrato_ibfk_2_idx` (`dni`),
  CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`PLACA`) REFERENCES `auto` (`PLACA`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `contrato_ibfk_2` FOREIGN KEY (`IDVENDEDOR`) REFERENCES `vendedor` (`IDVENDEDOR`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `contrato_ibfk_3` FOREIGN KEY (`dni`) REFERENCES `comprador` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='																								';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES ('001-0001','A-2001','5154','A-100','afasfasfsaffas','2023-03-12');
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mecanico`
--

DROP TABLE IF EXISTS `mecanico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mecanico` (
  `IDMECANICO` varchar(20) NOT NULL,
  `ESTADO` varchar(30) NOT NULL,
  `TURNO` varchar(30) NOT NULL,
  `NOMBRES` varchar(100) NOT NULL,
  `APELLIDOS` varchar(250) NOT NULL,
  `DIRECCION` varchar(250) NOT NULL,
  `EDAD` int NOT NULL,
  `CORREO` varchar(250) NOT NULL,
  `GENERO` varchar(250) NOT NULL,
  `CELULAR` varchar(11) NOT NULL,
  PRIMARY KEY (`IDMECANICO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanico`
--

LOCK TABLES `mecanico` WRITE;
/*!40000 ALTER TABLE `mecanico` DISABLE KEYS */;
INSERT INTO `mecanico` VALUES ('20','PAUSA','MAÑANA','sadasd','asdasd','232323',1312,'232323','MUJER','231123'),('asdads','DESPEDIDO','MAÑANA','asdads','aads','asdasda',233,'asdadsa','HOMBRE','993011788');
/*!40000 ALTER TABLE `mecanico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mecanicoxrevision`
--

DROP TABLE IF EXISTS `mecanicoxrevision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mecanicoxrevision` (
  `IDREVISION` int NOT NULL,
  `IDMECANICO` varchar(20) NOT NULL,
  PRIMARY KEY (`IDREVISION`,`IDMECANICO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanicoxrevision`
--

LOCK TABLES `mecanicoxrevision` WRITE;
/*!40000 ALTER TABLE `mecanicoxrevision` DISABLE KEYS */;
/*!40000 ALTER TABLE `mecanicoxrevision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `IDPROVEEDOR` varchar(20) NOT NULL,
  `SUCURSAL` varchar(30) NOT NULL,
  `NOMBRE` varchar(100) NOT NULL,
  `APELLIDO` varchar(200) NOT NULL,
  `EMPRESA` varchar(150) NOT NULL,
  `CELULAR` varchar(15) NOT NULL,
  `ESTADO` varchar(30) NOT NULL,
  PRIMARY KEY (`IDPROVEEDOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES ('adsads','asdasd','dasads','asdasd','AUDI','4564545','VIGENTE'),('C-100','LIMA','Sebastian','Pinto Montes','TESLA','993011788','RETIRADO');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedoresxauto`
--

DROP TABLE IF EXISTS `proveedoresxauto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedoresxauto` (
  `IDPROVEEDOR` varchar(20) NOT NULL,
  `PLACA` varchar(7) NOT NULL,
  PRIMARY KEY (`PLACA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedoresxauto`
--

LOCK TABLES `proveedoresxauto` WRITE;
/*!40000 ALTER TABLE `proveedoresxauto` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedoresxauto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revision`
--

DROP TABLE IF EXISTS `revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `revision` (
  `IDREVISION` int NOT NULL AUTO_INCREMENT,
  `PLACA` varchar(7) NOT NULL,
  `DESCRIPCION` varchar(300) NOT NULL,
  `FECHADECREACION` varchar(11) NOT NULL,
  PRIMARY KEY (`IDREVISION`) USING BTREE,
  UNIQUE KEY `PLACA` (`PLACA`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revision`
--

LOCK TABLES `revision` WRITE;
/*!40000 ALTER TABLE `revision` DISABLE KEYS */;
INSERT INTO `revision` VALUES (4,'A-100','Problemas con el motor y nueva pintura. ','2022-07-17'),(5,'ADS2','AASDJKASDJKAHA','2022-07-17'),(6,'300','alsdkjalkdshasdjkhasd','2022-07-17');
/*!40000 ALTER TABLE `revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Estado` varchar(60) NOT NULL DEFAULT 'Activo',
  `Usuario` varchar(60) NOT NULL,
  `Contraseña` varchar(60) NOT NULL,
  `Tipo` varchar(20) NOT NULL,
  `Nombres` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Edad` int NOT NULL,
  `Correo` varchar(60) NOT NULL,
  `Genero` varchar(25) NOT NULL,
  `Celular` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (10,'Activo','maycol','123','USUARIO','Maycol','Ninaja','Las palmeras de ñaña',23,'maycol@gmail.com','Masculino','985632145'),(11,'Activo','sebastian','123','ADMIN','Sebastian Alonso','Pinto Montes','ajksdhajksdhasjkdhasd',20,'sebastian@gmail.com','Masculino','993011788');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `IDVENDEDOR` varchar(10) NOT NULL,
  `ESTADO` varchar(20) NOT NULL,
  `NOMBRES` varchar(150) NOT NULL,
  `APELLIDOS` varchar(200) NOT NULL,
  `DIRECCION` varchar(250) NOT NULL,
  `EDAD` int NOT NULL,
  `CORREO` varchar(250) NOT NULL,
  `GENERO` varchar(20) NOT NULL,
  `CELULAR` varchar(15) NOT NULL,
  PRIMARY KEY (`IDVENDEDOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES ('A-2001','PAUSA','JKAKJAD','JKASDAJKDS','ADSAHASD',20,'ADKJSAA','MUJER','231'),('GA','CONTRATADO','AJSDHASDJKH','AKJDHK','ADSLKJASDKLAJSD',564,'6454','HOMBRE','354534');
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'consecionaria'
--

--
-- Dumping routines for database 'consecionaria'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-11 23:37:28
