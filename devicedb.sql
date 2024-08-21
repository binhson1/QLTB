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
-- Table structure for table `auth_group`
--

DROP TABLE IF EXISTS `auth_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_group` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_group`
--

LOCK TABLES `auth_group` WRITE;
/*!40000 ALTER TABLE `auth_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_group_permissions`
--

DROP TABLE IF EXISTS `auth_group_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_group_permissions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `group_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_group_permissions_group_id_permission_id_0cd325b0_uniq` (`group_id`,`permission_id`),
  KEY `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` (`permission_id`),
  CONSTRAINT `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`),
  CONSTRAINT `auth_group_permissions_group_id_b120cbf9_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_group_permissions`
--

LOCK TABLES `auth_group_permissions` WRITE;
/*!40000 ALTER TABLE `auth_group_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_group_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_permission`
--

DROP TABLE IF EXISTS `auth_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `content_type_id` int NOT NULL,
  `codename` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_permission_content_type_id_codename_01ab375a_uniq` (`content_type_id`,`codename`),
  CONSTRAINT `auth_permission_content_type_id_2f476e4b_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_permission`
--

LOCK TABLES `auth_permission` WRITE;
/*!40000 ALTER TABLE `auth_permission` DISABLE KEYS */;
INSERT INTO `auth_permission` VALUES (1,'Can add log entry',1,'add_logentry'),(2,'Can change log entry',1,'change_logentry'),(3,'Can delete log entry',1,'delete_logentry'),(4,'Can view log entry',1,'view_logentry'),(5,'Can add permission',2,'add_permission'),(6,'Can change permission',2,'change_permission'),(7,'Can delete permission',2,'delete_permission'),(8,'Can view permission',2,'view_permission'),(9,'Can add group',3,'add_group'),(10,'Can change group',3,'change_group'),(11,'Can delete group',3,'delete_group'),(12,'Can view group',3,'view_group'),(13,'Can add content type',4,'add_contenttype'),(14,'Can change content type',4,'change_contenttype'),(15,'Can delete content type',4,'delete_contenttype'),(16,'Can view content type',4,'view_contenttype'),(17,'Can add session',5,'add_session'),(18,'Can change session',5,'change_session'),(19,'Can delete session',5,'delete_session'),(20,'Can view session',5,'view_session'),(21,'Can add device',6,'add_device'),(22,'Can change device',6,'change_device'),(23,'Can delete device',6,'delete_device'),(24,'Can view device',6,'view_device'),(25,'Can add device category',7,'add_devicecategory'),(26,'Can change device category',7,'change_devicecategory'),(27,'Can delete device category',7,'delete_devicecategory'),(28,'Can view device category',7,'view_devicecategory'),(29,'Can add employee',8,'add_employee'),(30,'Can change employee',8,'change_employee'),(31,'Can delete employee',8,'delete_employee'),(32,'Can view employee',8,'view_employee'),(33,'Can add location',9,'add_location'),(34,'Can change location',9,'change_location'),(35,'Can delete location',9,'delete_location'),(36,'Can view location',9,'view_location'),(37,'Can add maintenance type',10,'add_maintenancetype'),(38,'Can change maintenance type',10,'change_maintenancetype'),(39,'Can delete maintenance type',10,'delete_maintenancetype'),(40,'Can view maintenance type',10,'view_maintenancetype'),(41,'Can add manufacturer',11,'add_manufacturer'),(42,'Can change manufacturer',11,'change_manufacturer'),(43,'Can delete manufacturer',11,'delete_manufacturer'),(44,'Can view manufacturer',11,'view_manufacturer'),(45,'Can add repair type',12,'add_repairtype'),(46,'Can change repair type',12,'change_repairtype'),(47,'Can delete repair type',12,'delete_repairtype'),(48,'Can view repair type',12,'view_repairtype'),(49,'Can add user',13,'add_user'),(50,'Can change user',13,'change_user'),(51,'Can delete user',13,'delete_user'),(52,'Can view user',13,'view_user'),(53,'Can add device_ maintenance',14,'add_device_maintenance'),(54,'Can change device_ maintenance',14,'change_device_maintenance'),(55,'Can delete device_ maintenance',14,'delete_device_maintenance'),(56,'Can view device_ maintenance',14,'view_device_maintenance'),(57,'Can add location history',15,'add_locationhistory'),(58,'Can change location history',15,'change_locationhistory'),(59,'Can delete location history',15,'delete_locationhistory'),(60,'Can view location history',15,'view_locationhistory'),(61,'Can add report',16,'add_report'),(62,'Can change report',16,'change_report'),(63,'Can delete report',16,'delete_report'),(64,'Can view report',16,'view_report'),(65,'Can add schedule maintenance',17,'add_schedulemaintenance'),(66,'Can change schedule maintenance',17,'change_schedulemaintenance'),(67,'Can delete schedule maintenance',17,'delete_schedulemaintenance'),(68,'Can view schedule maintenance',17,'view_schedulemaintenance'),(69,'Can add schedule repair',18,'add_schedulerepair'),(70,'Can change schedule repair',18,'change_schedulerepair'),(71,'Can delete schedule repair',18,'delete_schedulerepair'),(72,'Can view schedule repair',18,'view_schedulerepair'),(73,'Can add job',19,'add_job'),(74,'Can change job',19,'change_job'),(75,'Can delete job',19,'delete_job'),(76,'Can view job',19,'view_job'),(77,'Can add report repair history',20,'add_reportrepairhistory'),(78,'Can change report repair history',20,'change_reportrepairhistory'),(79,'Can delete report repair history',20,'delete_reportrepairhistory'),(80,'Can view report repair history',20,'view_reportrepairhistory'),(81,'Can add post',21,'add_post'),(82,'Can change post',21,'change_post'),(83,'Can delete post',21,'delete_post'),(84,'Can view post',21,'view_post');
/*!40000 ALTER TABLE `auth_permission` ENABLE KEYS */;
UNLOCK TABLES;

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
  `status` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `device_category_id` bigint NOT NULL,
  `manufacturer_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Device_device_category_id_91164085_fk_DeviceCategory_id` (`device_category_id`),
  KEY `Device_manufacturer_id_88543ba1_fk_Manufacturer_id` (`manufacturer_id`),
  CONSTRAINT `Device_device_category_id_91164085_fk_DeviceCategory_id` FOREIGN KEY (`device_category_id`) REFERENCES `devicecategory` (`id`),
  CONSTRAINT `Device_manufacturer_id_88543ba1_fk_Manufacturer_id` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'dog','https://res.cloudinary.com/dluxogrmn/image/upload/v1723539847/izbz9byx68a3lrgc7fj0.png','adfbafbabsadfnsdng','2024-08-13','PENDING',1,1),(2,'Dog','https://res.cloudinary.com/dluxogrmn/image/upload/v1723877207/coiy89khrq2copvkgy1h.png','thiết bị tốt','2024-08-15','ACTIVE',1,2),(3,'cat','https://res.cloudinary.com/dluxogrmn/image/upload/v1723879188/oy6kmjmo183s8qundnwl.png','a very nice cat','2024-08-16','ACTIVE',1,3),(4,'cat','https://res.cloudinary.com/dluxogrmn/image/upload/v1723879188/oy6kmjmo183s8qundnwl.png','a very nice cat','2024-08-16','ACTIVE',1,3),(5,'cat','https://res.cloudinary.com/dluxogrmn/image/upload/v1723879188/oy6kmjmo183s8qundnwl.png','a very nice cat','2024-08-16','ACTIVE',1,2),(6,'cat','https://res.cloudinary.com/dluxogrmn/image/upload/v1723879188/oy6kmjmo183s8qundnwl.png','a very nice cat','2024-08-16','ACTIVE',1,3),(7,'cat','https://res.cloudinary.com/dluxogrmn/image/upload/v1723879188/oy6kmjmo183s8qundnwl.png','a very nice cat','2024-08-16','ACTIVE',1,2),(8,'cat','https://res.cloudinary.com/dluxogrmn/image/upload/v1723879188/oy6kmjmo183s8qundnwl.png','a very nice cat','2024-08-16','ACTIVE',1,2);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_maintenance`
--

DROP TABLE IF EXISTS `device_maintenance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device_maintenance` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `device_id` bigint NOT NULL,
  `schedule_maintenance_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Device_Maintenance_schedule_maintenance_52ac5d39_fk_ScheduleM` (`schedule_maintenance_id`),
  KEY `Device_Maintenance_device_id_dc74ce9f_fk_Device_id` (`device_id`),
  CONSTRAINT `Device_Maintenance_device_id_dc74ce9f_fk_Device_id` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`),
  CONSTRAINT `Device_Maintenance_schedule_maintenance_52ac5d39_fk_ScheduleM` FOREIGN KEY (`schedule_maintenance_id`) REFERENCES `schedulemaintenance` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_maintenance`
--

LOCK TABLES `device_maintenance` WRITE;
/*!40000 ALTER TABLE `device_maintenance` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_maintenance` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devicecategory`
--

LOCK TABLES `devicecategory` WRITE;
/*!40000 ALTER TABLE `devicecategory` DISABLE KEYS */;
INSERT INTO `devicecategory` VALUES (1,'Điện tử');
/*!40000 ALTER TABLE `devicecategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `django_admin_log`
--

DROP TABLE IF EXISTS `django_admin_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `django_admin_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext COLLATE utf8mb4_unicode_ci,
  `object_repr` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `action_flag` smallint unsigned NOT NULL,
  `change_message` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `content_type_id` int DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `django_admin_log_content_type_id_c4bce8eb_fk_django_co` (`content_type_id`),
  KEY `django_admin_log_user_id_c564eba6_fk_User_id` (`user_id`),
  CONSTRAINT `django_admin_log_content_type_id_c4bce8eb_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`),
  CONSTRAINT `django_admin_log_user_id_c564eba6_fk_User_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `django_admin_log_chk_1` CHECK ((`action_flag` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `django_admin_log`
--

LOCK TABLES `django_admin_log` WRITE;
/*!40000 ALTER TABLE `django_admin_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `django_admin_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `django_content_type`
--

DROP TABLE IF EXISTS `django_content_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `django_content_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `app_label` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `model` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `django_content_type_app_label_model_76bd3d3b_uniq` (`app_label`,`model`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `django_content_type`
--

LOCK TABLES `django_content_type` WRITE;
/*!40000 ALTER TABLE `django_content_type` DISABLE KEYS */;
INSERT INTO `django_content_type` VALUES (1,'admin','logentry'),(3,'auth','group'),(2,'auth','permission'),(4,'contenttypes','contenttype'),(6,'devices','device'),(14,'devices','device_maintenance'),(7,'devices','devicecategory'),(8,'devices','employee'),(19,'devices','job'),(9,'devices','location'),(15,'devices','locationhistory'),(10,'devices','maintenancetype'),(11,'devices','manufacturer'),(21,'devices','post'),(12,'devices','repairtype'),(16,'devices','report'),(20,'devices','reportrepairhistory'),(17,'devices','schedulemaintenance'),(18,'devices','schedulerepair'),(13,'devices','user'),(5,'sessions','session');
/*!40000 ALTER TABLE `django_content_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `django_migrations`
--

DROP TABLE IF EXISTS `django_migrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `django_migrations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `app` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `applied` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `django_migrations`
--

LOCK TABLES `django_migrations` WRITE;
/*!40000 ALTER TABLE `django_migrations` DISABLE KEYS */;
INSERT INTO `django_migrations` VALUES (1,'contenttypes','0001_initial','2024-08-12 09:21:31.479978'),(2,'contenttypes','0002_remove_content_type_name','2024-08-12 09:21:31.535371'),(3,'auth','0001_initial','2024-08-12 09:21:31.759831'),(4,'auth','0002_alter_permission_name_max_length','2024-08-12 09:21:31.816218'),(5,'auth','0003_alter_user_email_max_length','2024-08-12 09:21:31.820218'),(6,'auth','0004_alter_user_username_opts','2024-08-12 09:21:31.826219'),(7,'auth','0005_alter_user_last_login_null','2024-08-12 09:21:31.832221'),(8,'auth','0006_require_contenttypes_0002','2024-08-12 09:21:31.834221'),(9,'auth','0007_alter_validators_add_error_messages','2024-08-12 09:21:31.838224'),(10,'auth','0008_alter_user_username_max_length','2024-08-12 09:21:31.843213'),(11,'auth','0009_alter_user_last_name_max_length','2024-08-12 09:21:31.850213'),(12,'auth','0010_alter_group_name_max_length','2024-08-12 09:21:31.864941'),(13,'auth','0011_update_proxy_permissions','2024-08-12 09:21:31.871535'),(14,'auth','0012_alter_user_first_name_max_length','2024-08-12 09:21:31.876537'),(15,'devices','0001_initial','2024-08-12 09:21:32.957909'),(16,'admin','0001_initial','2024-08-12 09:21:33.080936'),(17,'admin','0002_logentry_remove_auto_add','2024-08-12 09:21:33.087937'),(18,'admin','0003_logentry_add_action_flag_choices','2024-08-12 09:21:33.095947'),(19,'sessions','0001_initial','2024-08-12 09:21:33.125953'),(20,'devices','0002_post','2024-08-18 03:25:54.483581');
/*!40000 ALTER TABLE `django_migrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `django_session`
--

DROP TABLE IF EXISTS `django_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `django_session` (
  `session_key` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `session_data` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `expire_date` datetime(6) NOT NULL,
  PRIMARY KEY (`session_key`),
  KEY `django_session_expire_date_a5c62663` (`expire_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `django_session`
--

LOCK TABLES `django_session` WRITE;
/*!40000 ALTER TABLE `django_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `django_session` ENABLE KEYS */;
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
  `status` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_date` datetime(6) NOT NULL,
  `employee_id` bigint NOT NULL,
  `maintenance_id` bigint DEFAULT NULL,
  `repair_id` bigint DEFAULT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'HCM','123'),(2,'HN','321'),(3,'Da Nang','abc');
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
  `end_date` date DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  `device_id` bigint NOT NULL,
  `location_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `LocationHistory_device_id_8c59ecca_fk_Device_id` (`device_id`),
  KEY `LocationHistory_location_id_23f20ec5_fk_Location_id` (`location_id`),
  CONSTRAINT `LocationHistory_device_id_8c59ecca_fk_Device_id` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`),
  CONSTRAINT `LocationHistory_location_id_23f20ec5_fk_Location_id` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locationhistory`
--

LOCK TABLES `locationhistory` WRITE;
/*!40000 ALTER TABLE `locationhistory` DISABLE KEYS */;
INSERT INTO `locationhistory` VALUES (1,'2024-08-13',NULL,1,1,1),(2,'2024-08-17',NULL,1,2,2),(3,'2024-08-17',NULL,1,3,3),(4,'2024-08-17',NULL,1,4,1),(5,'2024-08-17',NULL,1,5,2),(6,'2024-08-17',NULL,1,6,3),(7,'2024-08-17',NULL,1,7,1),(8,'2024-08-17',NULL,1,8,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maintenancetype`
--

LOCK TABLES `maintenancetype` WRITE;
/*!40000 ALTER TABLE `maintenancetype` DISABLE KEYS */;
INSERT INTO `maintenancetype` VALUES (1,'Bảo trì dầu máy'),(2,'Bảo trì linh kiện'),(3,'Bảo trì động cơ');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES (1,'Panasonic'),(2,'Xiaomi'),(3,'Apple');
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `create_date` date NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Post_user_id_1eab9b38_fk_User_id` (`user_id`),
  CONSTRAINT `Post_user_id_1eab9b38_fk_User_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'abc','<p>Tình bạn là một mối quan hệ đặc biệt và quý giá trong cuộc sống, nơi mà hai người không chỉ chia sẻ niềm vui mà còn cả những nỗi buồn, khó khăn. Tình bạn không phân biệt tuổi tác, địa vị hay hoàn cảnh sống, mà dựa trên sự tin tưởng, tôn trọng và hiểu biết lẫn nhau. Một người bạn tốt sẽ luôn ở bên cạnh, lắng nghe và động viên, ngay cả khi ta đối diện với những thử thách lớn nhất. Tình bạn mang lại sự ấm áp và hỗ trợ tinh thần, giúp mỗi người cảm thấy không cô đơn trên con đường đời. Khi có một người bạn chân thành, cuộc sống trở nên ý nghĩa và đầy màu sắc hơn. Tình bạn, vì thế, là một trong những món quà vô giá mà cuộc đời ban tặng.</p>','2024-08-18',2),(2,'Đi Du Lịch Trong Cuộc Sống','<h2>The three greatest things you learn from traveling</h2><p>Like all the great things on earth traveling teaches us by example. Here are some of the most precious lessons I’ve learned over the years of traveling.</p><figure class=\"image image-style-side\"><img style=\"aspect-ratio:600/400;\" src=\"https://ckeditor.com/docs/ckeditor5/latest/assets/img/volcano.jpg\" alt=\"A lone wanderer looking at Mount Bromo volcano in Indonesia.\" srcset=\"https://ckeditor.com/docs/ckeditor5/latest/assets/img/volcano.jpg, https://ckeditor.com/docs/ckeditor5/latest/assets/img/volcano_2x.jpg 2x\" sizes=\"100vw\" width=\"600\" height=\"400\"><figcaption>Leaving your comfort zone might lead you to such beautiful sceneries like this one.</figcaption></figure><h3>Appreciation of diversity</h3><p>Getting used to an entirely different culture can be challenging. While it’s also nice to learn about cultures online or from books, nothing comes close to experiencing cultural diversity in person. You learn to appreciate each and every single one of the differences while you become more culturally fluid.</p><blockquote><p>The real voyage of discovery consists not in seeking new landscapes, but having new eyes.</p><p><strong>Marcel Proust</strong></p></blockquote><h3>Improvisation</h3><p>Life doesn\'t allow us to execute every single plan perfectly. This especially seems to be the case when you travel. You plan it down to every minute with a big checklist. But when it comes to executing it, something always comes up and you’re left with your improvising skills. You learn to adapt as you go. Here’s how my travel checklist looks now:</p><ul><li>buy the ticket</li><li>start your adventure</li></ul><figure class=\"image image-style-side\"><img style=\"aspect-ratio:600/252;\" src=\"https://ckeditor.com/docs/ckeditor5/latest/assets/img/umbrellas.jpg\" alt=\"Three monks ascending the stairs of an ancient temple.\" srcset=\"https://ckeditor.com/docs/ckeditor5/latest/assets/img/umbrellas.jpg, https://ckeditor.com/docs/ckeditor5/latest/assets/img/umbrellas_2x.jpg 2x\" sizes=\"100vw\" width=\"600\" height=\"252\"><figcaption>Three monks ascending the stairs of an ancient temple.</figcaption></figure><h3>Confidence</h3><p>Going to a new place can be quite terrifying. While change and uncertainty make us scared, traveling teaches us how ridiculous it is to be afraid of something before it happens. The moment you face your fear and see there is nothing to be afraid of, is the moment you discover bliss.</p>','2024-08-19',2),(3,'Thành Phố Valletta ','<h3>Destination of the Month</h3><h4>Valletta</h4><figure class=\"image image-style-align-left\"><img style=\"aspect-ratio:450/301;\" src=\"https://ckeditor.com/docs/ckeditor5/latest/assets/img/malta.jpg\" alt=\"Picture of a sunlit facade of a Maltan building.\" srcset=\"https://ckeditor.com/docs/ckeditor5/latest/assets/img/malta.jpg, https://ckeditor.com/docs/ckeditor5/latest/assets/img/malta_2x.jpg 2x\" sizes=\"100vw\" width=\"450\" height=\"301\"><figcaption>It\'s siesta time in Valletta.</figcaption></figure><p>The capital city of <a href=\"https://en.wikipedia.org/wiki/Malta\">Malta</a> is the top destination this summer. It’s home to cutting-edge contemporary architecture, baroque masterpieces, delicious local cuisine, and at least 8 months of sun. It’s also a top destination for filmmakers, so you can take a tour through locations familiar to you from Game of Thrones, Gladiator, Troy, and many more.</p>','2024-08-19',2),(4,'Taj Mahal','<h2>Taj Mahal: A breathtaking ode to love</h2><figure class=\"image image-style-side\"><img src=\"https://ckeditor.com/docs/ckeditor5/latest/assets/img/tajmahal.jpg\" alt=\"Taj Mahal illustration.\" srcset=\"https://ckeditor.com/docs/ckeditor5/latest/assets/img/tajmahal.jpg, https://ckeditor.com/docs/ckeditor5/latest/assets/img/tajmahal_2x.jpg 2x\" sizes=\"100vw\" height=\"400\"><figcaption>Taj Mahal with its poetic white marble tomb</figcaption></figure><p>No trip to India is complete without visiting this spectacular monument, <a href=\"https://en.wikipedia.org/wiki/New7Wonders_of_the_World\"><strong>counted among the Seven Wonders of the World</strong></a>.</p><p>Tourists frequently admit that Taj Mahal \"simply cannot be described with words\". And that’s probably true. The more you try the more speechless you become. Words give only a semblance of truth. The real truth about its beauty is revealed when you adore <strong>different shades of “Taj” depending on the time of the day</strong> or when you admire the exquisite inlay work in different corners of the façade.</p><h3>Masterpiece of the world’s heritage</h3><p>Taj Mahal is a mausoleum built in Agra between 1631 and 1648 by Emperor Shah Jahan <strong>in the memory of his beloved wife</strong>, Mumtaz Mahal, whose body lies there. It took 20,000 workers to complete and the excellence of this building is visible in every brick.</p><p>In 1983, Taj Mahal was appointed <a href=\"https://en.wikipedia.org/wiki/World_Heritage_Site\">UNESCO World Heritage Site</a> for being \"the jewel of Muslim art in India and one of the universally admired masterpieces of the world’s heritage\".</p><p>If you like having a methodology for visiting historical places, here are the four elements on which we recommend to focus your attention:</p><ul><li>The tomb</li><li>The decorations</li><li>The garden</li><li>The outlying buildings</li></ul><p>The tomb is what immediately catches your eyesight. The <strong>white and soft marble</strong> embroidered with stones leaves you totally enchanted.</p>','2024-08-19',2),(5,'Thành Phố Valletta ','<h2>Walking the capitals of Europe: Warsaw</h2><figure class=\"media\"><oembed url=\"https://www.youtube.com/watch?v=7YRyFvjA_a8\"></oembed></figure><p>If you enjoyed my previous articles in which we discussed wandering around <a href=\"https://en.wikipedia.org/wiki/Copenhagen\">Copenhagen</a> and <a href=\"https://en.wikipedia.org/wiki/Vilnius\">Vilnius</a>, you’ll definitely love exploring <a href=\"https://en.wikipedia.org/wiki/Warsaw\">Warsaw</a>.</p><h3>Time to put comfy sandals on!</h3><p>The best time to visit the city is July and August when it’s cool enough not to break a sweat and hot enough to enjoy summer. The city, which has quite a combination of both old and modern textures, is located by the river of Vistula.</p><p>The historic <strong>Old Town</strong>, reconstructed after World War II, with its late 18th-century characteristics, is a must-see. You can start your walk from <strong>Nowy Świat Street</strong> which will take you straight to the Old Town.</p><p>Then you can go to the <strong>Powiśle</strong>area and take a walk on the newly renovated promenade on the riverfront. There are also lots of cafes, bars, and restaurants where you can shake off the exhaustion of the day. On Sundays, there are many parks where you can enjoy nature or listen to pianists from around the world playing Chopin.</p><p>For museum lovers, you can add these to your list:</p><ul><li><a href=\"http://www.polin.pl/en\">POLIN</a></li><li><a href=\"http://www.1944.pl/en\">Warsaw Uprising Museum</a></li><li><a href=\"http://chopin.museum/en\">Fryderyk Chopin Museum</a></li></ul><h3>Next destination</h3><p>We will go to Berlin and have a night walk in the city that never sleeps! Make sure you subscribe to our newsletter!</p>','2024-08-19',2),(6,'Bóng Đá: Môn Thể Thao Vua Trên Toàn Thế Giới','<p>&nbsp;</p><p>Bóng đá, còn được gọi là \"môn thể thao vua\", không chỉ là một trò chơi mà còn là niềm đam mê, văn hóa và lối sống của hàng triệu người trên khắp thế giới. Với lịch sử phát triển hơn một thế kỷ, bóng đá đã trở thành môn thể thao phổ biến nhất hành tinh, thu hút người hâm mộ từ mọi lứa tuổi và tầng lớp xã hội.</p><h4>1. Lịch sử và Phát Triển</h4><p>Bóng đá có nguồn gốc từ các trò chơi cổ xưa, nhưng phiên bản hiện đại của nó bắt đầu được hình thành ở Anh vào thế kỷ 19. Năm 1863, Liên đoàn bóng đá đầu tiên trên thế giới, The Football Association (FA), được thành lập tại Anh, đánh dấu sự ra đời của các quy tắc chính thức cho môn thể thao này.</p><p>Kể từ đó, bóng đá đã lan rộng khắp châu Âu và sau đó là toàn thế giới. Năm 1904, Liên đoàn Bóng đá Thế giới (FIFA) được thành lập, trở thành cơ quan quản lý chính thức của môn thể thao này. Các giải đấu quốc tế như World Cup, UEFA Champions League, và Copa America đã góp phần thúc đẩy sự phát triển của bóng đá và làm tăng thêm sự hâm mộ đối với môn thể thao này.<br><br>&nbsp;</p><figure class=\"image\"><img style=\"aspect-ratio:1200/1200;\" src=\"http://res.cloudinary.com/dluxogrmn/image/upload/v1724059994/e4npzrol5tpg44yx8osx.png\" width=\"1200\" height=\"1200\"></figure>','2024-08-19',2);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repairtype`
--

LOCK TABLES `repairtype` WRITE;
/*!40000 ALTER TABLE `repairtype` DISABLE KEYS */;
INSERT INTO `repairtype` VALUES (1,'Sửa linh kiện');
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (7,'This is a detailed description of the report.','2024-08-13 07:00:00.000000','High','PENDING',1,1),(8,'This is a detailed description of the report.','2024-09-13 07:00:00.000000','High','PENDING',1,1),(9,'This is a detailed description of the report.','2024-04-13 07:00:00.000000','High','PENDING',1,1),(10,'bad','2024-08-13 07:00:00.000000','bad','PENDING',1,1),(11,'bad','2024-08-12 07:00:00.000000','bad','PENDING',1,1),(12,'abc','2024-08-13 07:00:00.000000','abac','PENDING',1,1),(13,'hy vong dc','2024-08-16 07:00:00.000000','dc','PENDING',1,1),(14,'badsc','2024-07-30 07:00:00.000000','casdcasd','PENDING',1,1);
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
  `last_maintenance_date` date NOT NULL,
  `next_maintenance_date` date NOT NULL,
  `interval_month` int NOT NULL,
  `maintenance_type_id` bigint NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ScheduleMaintenance_maintenance_type_id_a54605c0_fk_Maintenan` (`maintenance_type_id`),
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
  `repair_type_id` bigint NOT NULL,
  `report_id` bigint NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ScheduleRepair_repair_type_id_80a06ae2_fk_RepairType_id` (`repair_type_id`),
  KEY `ScheduleRepair_report_id_ab8a65db_fk_Report_id` (`report_id`),
  CONSTRAINT `ScheduleRepair_repair_type_id_80a06ae2_fk_RepairType_id` FOREIGN KEY (`repair_type_id`) REFERENCES `repairtype` (`id`),
  CONSTRAINT `ScheduleRepair_report_id_ab8a65db_fk_Report_id` FOREIGN KEY (`report_id`) REFERENCES `report` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedulerepair`
--

LOCK TABLES `schedulerepair` WRITE;
/*!40000 ALTER TABLE `schedulerepair` DISABLE KEYS */;
INSERT INTO `schedulerepair` VALUES (1,'2024-08-17',123456,1,7,'lich sửa linh kiện'),(2,'2024-08-17',123456,1,7,'lich sửa linh kiện'),(3,'2024-08-15',123213,1,7,'lich sửa linh kiện');
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
  `username` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `avatar` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_role` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'$2a$10$5N2Q4V9vFt9otpHXHiCKrOiIeLrXMTX0djs2tP.bfZb9xJsW0nlwq','binhson1','son','vu',0,'https://res.cloudinary.com/dluxogrmn/image/upload/v1723454897/lf8zkw6vkvhnlb2myomg.png','ROLE_ADMIN','ab@gmail.com','123'),(2,'$2a$10$zps1ix8XGp.OpsRDZmWfD.1l5Lp9paGFUOC48uWQ4ePahoQYGcWqu','binhson2','Son','Vu',0,'https://res.cloudinary.com/dluxogrmn/image/upload/v1723620217/z5kdasesbtiprbk2aluq.png','ROLE_USER','xyz@gmail.com','045614031'),(6,'$2a$10$b2cPHH4lBLJhgwtgEso6Bu.Y5X27.VaQoHL05/jN6tEzjiuyxTXAm','bacon123','son','vu',0,'https://res.cloudinary.com/dluxogrmn/image/upload/v1724140150/bejuvfvgltftrwscywbh.png','ROLE_USER','2151010325son@ou.edu.vn','89604564');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_groups`
--

DROP TABLE IF EXISTS `user_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_groups` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `group_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `User_groups_user_id_group_id_d63e199e_uniq` (`user_id`,`group_id`),
  KEY `User_groups_group_id_328392a3_fk_auth_group_id` (`group_id`),
  CONSTRAINT `User_groups_group_id_328392a3_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`),
  CONSTRAINT `User_groups_user_id_8f675f72_fk_User_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_groups`
--

LOCK TABLES `user_groups` WRITE;
/*!40000 ALTER TABLE `user_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_user_permissions`
--

DROP TABLE IF EXISTS `user_user_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_user_permissions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `User_user_permissions_user_id_permission_id_af0f54ec_uniq` (`user_id`,`permission_id`),
  KEY `User_user_permission_permission_id_8e998ba4_fk_auth_perm` (`permission_id`),
  CONSTRAINT `User_user_permission_permission_id_8e998ba4_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`),
  CONSTRAINT `User_user_permissions_user_id_2c6da4d4_fk_User_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_user_permissions`
--

LOCK TABLES `user_user_permissions` WRITE;
/*!40000 ALTER TABLE `user_user_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_user_permissions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-20 14:58:13
