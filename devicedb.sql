-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: devicedb
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `descriptions` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `bought_date` date NOT NULL,
  `status` int DEFAULT NULL,
  `device_category_id` bigint NOT NULL,
  `manufacturer_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Device_device_category_id_91164085_fk_DeviceCategory_id` (`device_category_id`),
  KEY `Device_manufacturer_id_88543ba1_fk_Manufacturer_id` (`manufacturer_id`),
  CONSTRAINT `Device_device_category_id_91164085_fk_DeviceCategory_id` FOREIGN KEY (`device_category_id`) REFERENCES `devicecategory` (`id`),
  CONSTRAINT `Device_manufacturer_id_88543ba1_fk_Manufacturer_id` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devicecategory`
--

DROP TABLE IF EXISTS `devicecategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `devicecategory` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devicecategory`
--

LOCK TABLES `devicecategory` WRITE;
/*!40000 ALTER TABLE `devicecategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `devicecategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CCCD` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CCCD` (`CCCD`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `start_date` datetime(6) NOT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `updated_date` datetime(6) NOT NULL,
  `employee_id` bigint NOT NULL,
  `maintenance_id` bigint DEFAULT NULL,
  `repair_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Job_employee_id_20ecd29a_fk_Employee_id` (`employee_id`),
  KEY `Job_maintenance_id_1ca0395e_fk_ScheduleMaintenance_id` (`maintenance_id`),
  KEY `Job_repair_id_f053a5b5_fk_ScheduleRepair_id` (`repair_id`),
  CONSTRAINT `Job_employee_id_20ecd29a_fk_Employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `Job_maintenance_id_1ca0395e_fk_ScheduleMaintenance_id` FOREIGN KEY (`maintenance_id`) REFERENCES `schedulemaintenance` (`id`),
  CONSTRAINT `Job_repair_id_f053a5b5_fk_ScheduleRepair_id` FOREIGN KEY (`repair_id`) REFERENCES `schedulerepair` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locationhistory`
--

DROP TABLE IF EXISTS `locationhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locationhistory` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `begin_date` date NOT NULL,
  `end_date` date NOT NULL,
  `device_id` bigint NOT NULL,
  `location_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `LocationHistory_device_id_8c59ecca_fk_Device_id` (`device_id`),
  KEY `LocationHistory_location_id_23f20ec5_fk_Location_id` (`location_id`),
  CONSTRAINT `LocationHistory_device_id_8c59ecca_fk_Device_id` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`),
  CONSTRAINT `LocationHistory_location_id_23f20ec5_fk_Location_id` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locationhistory`
--

LOCK TABLES `locationhistory` WRITE;
/*!40000 ALTER TABLE `locationhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `locationhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maintenancetype`
--

DROP TABLE IF EXISTS `maintenancetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maintenancetype` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maintenancetype`
--

LOCK TABLES `maintenancetype` WRITE;
/*!40000 ALTER TABLE `maintenancetype` DISABLE KEYS */;
/*!40000 ALTER TABLE `maintenancetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manufacturer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repairtype`
--

DROP TABLE IF EXISTS `repairtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repairtype` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repairtype`
--

LOCK TABLES `repairtype` WRITE;
/*!40000 ALTER TABLE `repairtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `repairtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `occurrence_date` datetime(6) NOT NULL,
  `severity` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `device_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Report_device_id_ad44e1ec_fk_Device_id` (`device_id`),
  KEY `Report_user_id_d2415d9b_fk_User_id` (`user_id`),
  CONSTRAINT `Report_device_id_ad44e1ec_fk_Device_id` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`),
  CONSTRAINT `Report_user_id_d2415d9b_fk_User_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedulemaintenance`
--

DROP TABLE IF EXISTS `schedulemaintenance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedulemaintenance` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `frequency` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `next_date` date NOT NULL,
  `reminder_sent` tinyint(1) NOT NULL,
  `device_id` bigint NOT NULL,
  `maintenance_type_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ScheduleMaintenance_device_id_2e4bfe89_fk_Device_id` (`device_id`),
  KEY `ScheduleMaintenance_maintenance_type_id_a54605c0_fk_Maintenan` (`maintenance_type_id`),
  CONSTRAINT `ScheduleMaintenance_device_id_2e4bfe89_fk_Device_id` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`),
  CONSTRAINT `ScheduleMaintenance_maintenance_type_id_a54605c0_fk_Maintenan` FOREIGN KEY (`maintenance_type_id`) REFERENCES `maintenancetype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedulemaintenance`
--

LOCK TABLES `schedulemaintenance` WRITE;
/*!40000 ALTER TABLE `schedulemaintenance` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedulemaintenance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedulerepair`
--

DROP TABLE IF EXISTS `schedulerepair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedulerepair` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `cost` double NOT NULL,
  `device_id` bigint NOT NULL,
  `repair_type_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ScheduleRepair_device_id_e03f5748_fk_Device_id` (`device_id`),
  KEY `ScheduleRepair_repair_type_id_80a06ae2_fk_RepairType_id` (`repair_type_id`),
  CONSTRAINT `ScheduleRepair_device_id_e03f5748_fk_Device_id` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`),
  CONSTRAINT `ScheduleRepair_repair_type_id_80a06ae2_fk_RepairType_id` FOREIGN KEY (`repair_type_id`) REFERENCES `repairtype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedulerepair`
--

LOCK TABLES `schedulerepair` WRITE;
/*!40000 ALTER TABLE `schedulerepair` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedulerepair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL,
  `avatar` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_role` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-04 19:21:14
