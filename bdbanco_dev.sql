-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: bdbanco
-- ------------------------------------------------------
-- Server version	5.7.31-log

create database bdbanco;

use bdbanco;

drop table clientes;

create table `clientes` (
	`dni` int(11) NOT NULL,
	`usuario` varchar(45) NOT NULL,
	`cuil` varchar(45) DEFAULT NULL,
	`nombre` varchar(45) DEFAULT NULL,
	`apellido` varchar(45) DEFAULT NULL,
	`sexo` varchar(45) DEFAULT NULL,
	`nacionalidad` varchar(45) DEFAULT NULL,
	`fechanac` varchar(45) DEFAULT NULL,
	`direccion` varchar(255) DEFAULT NULL,
	`localidad` varchar(255) DEFAULT NULL,
	`provincia` varchar(45) DEFAULT NULL,
	`correo` varchar(45) DEFAULT NULL,
	`telefono` varchar(45) DEFAULT NULL,
    `password` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`dni`)
);

--
-- Table structure for table `clientes`
--

/*DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
/* CREATE TABLE `clientes` (
  `dni` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `cuil` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `nacionalidad` varchar(45) DEFAULT NULL,
  `fechanac` varchar(45) DEFAULT NULL,
  `dirección` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dni`,`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `idcuenta` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `tipocuenta` varchar(45) DEFAULT NULL,
  `saldo` float DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `cuentascol` varchar(45) DEFAULT NULL,
  `cbu` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcuenta`,`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentasxclientes`
--

DROP TABLE IF EXISTS `cuentasxclientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentasxclientes` (
  `usuario` varchar(45) NOT NULL,
  `idcuenta` int(11) NOT NULL,
  PRIMARY KEY (`usuario`,`idcuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentasxclientes`
--

LOCK TABLES `cuentasxclientes` WRITE;
/*!40000 ALTER TABLE `cuentasxclientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuentasxclientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `fecha` date DEFAULT NULL,
  `detalle` varchar(45) DEFAULT NULL,
  `importe` float DEFAULT NULL,
  `tipomovimiento` varchar(45) DEFAULT NULL,
  `idtransacion` varchar(45) NOT NULL,
  PRIMARY KEY (`idtransacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientosxcuenta`
--

DROP TABLE IF EXISTS `movimientosxcuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientosxcuenta` (
  `idmovimiento` int(11) NOT NULL,
  `cuenta` varchar(45) NOT NULL,
  PRIMARY KEY (`idmovimiento`,`cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientosxcuenta`
--

LOCK TABLES `movimientosxcuenta` WRITE;
/*!40000 ALTER TABLE `movimientosxcuenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientosxcuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamos`
--

DROP TABLE IF EXISTS `prestamos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamos` (
  `cliente` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `importe` float DEFAULT NULL,
  `importeinteres` float DEFAULT NULL,
  `plazopago` int(11) DEFAULT NULL,
  `montopormes` float DEFAULT NULL,
  `numcuotas` int(11) DEFAULT NULL,
  `idprestamo` int(11) NOT NULL,
  PRIMARY KEY (`idprestamo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamos`
--

LOCK TABLES `prestamos` WRITE;
/*!40000 ALTER TABLE `prestamos` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamosxcuenta`
--

DROP TABLE IF EXISTS `prestamosxcuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamosxcuenta` (
  `idcuenta` int(11) NOT NULL,
  `idprestamo` int(11) NOT NULL,
  `detalle` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcuenta`,`idprestamo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamosxcuenta`
--

LOCK TABLES `prestamosxcuenta` WRITE;
/*!40000 ALTER TABLE `prestamosxcuenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamosxcuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocuentas`
--

DROP TABLE IF EXISTS `tipocuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipocuentas` (
  `tipo` varchar(45) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocuentas`
--

LOCK TABLES `tipocuentas` WRITE;
/*!40000 ALTER TABLE `tipocuentas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipocuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipomovimiento`
--

DROP TABLE IF EXISTS `tipomovimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipomovimiento` (
  `idtipomovimiento` int(11) NOT NULL,
  `detalle` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipomovimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipomovimiento`
--

LOCK TABLES `tipomovimiento` WRITE;
/*!40000 ALTER TABLE `tipomovimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipomovimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipousuario` (
  `idtiposusuario` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtiposusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipousuario`
--

LOCK TABLES `tipousuario` WRITE;
/*!40000 ALTER TABLE `tipousuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `dni` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(45) DEFAULT NULL,
  `tipousuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dni`,`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bdbanco'
--

--
-- Dumping routines for database 'bdbanco'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-27 18:27:26
