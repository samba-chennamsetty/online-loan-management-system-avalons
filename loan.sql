-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: loan
-- ------------------------------------------------------
-- Server version	8.0.28

--
-- CREATES DATABASE IF NOT EXISTS 'LOAN'
--

-- /* drop database if exists
DROP DATABASE loan;
-- /* create database loan
CREATE DATABASE IF NOT EXISTS loan;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch` (
  `branch_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `branch_code` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`branch_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `email_id` varchar(50) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `contact_num` varchar(11) NOT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `ssn_number` varchar(11) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `UK_p1nyof8six1aupbuhnlax3tkk` (`email_id`),
  UNIQUE KEY `UK_hkdfchj3embfpp4il3faxtmob` (`contact_num`),
  UNIQUE KEY `UK_o20411kg49mn48qltiide7j1a` (`ssn_number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emi`
--

DROP TABLE IF EXISTS `emi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emi` (
  `emi_id` bigint NOT NULL AUTO_INCREMENT,
  `current_balance` decimal(9,2) DEFAULT NULL,
  `payment` decimal(9,2) DEFAULT NULL,
  `payment_date` datetime DEFAULT NULL,
  `period` bigint DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `info_id` bigint DEFAULT NULL,
  PRIMARY KEY (`emi_id`),
  KEY `FK7gf3eqd6srpo16sdebvve6dda` (`customer_id`),
  KEY `FKiyxfbim5vmc9maldskar7elg6` (`info_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emi`
--

LOCK TABLES `emi` WRITE;
/*!40000 ALTER TABLE `emi` DISABLE KEYS */;
/*!40000 ALTER TABLE `emi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emp_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email_id` varchar(50) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `contact_num` varchar(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `ssn` varchar(11) NOT NULL,
  `branch_id` bigint NOT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `UK_af534w03av8srcldugewrmpbi` (`email_id`),
  UNIQUE KEY `UK_hguaimrlyleyvddv7j0cef2b3` (`contact_num`),
  UNIQUE KEY `UK_f35rkopwr25n69dtp946lt3rh` (`ssn`),
  KEY `FKcvhlsx8tao1rxt7mpxrot61jt` (`branch_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan_information`
--

DROP TABLE IF EXISTS `loan_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loan_information` (
  `info_id` bigint NOT NULL AUTO_INCREMENT,
  `loan_date` datetime DEFAULT NULL,
  `loan_due_date` datetime DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `request_id` bigint DEFAULT NULL,
  PRIMARY KEY (`info_id`),
  KEY `FKlfwhu72xpu9n16m6bmikypprw` (`customer_id`),
  KEY `FKn5pnfdf0jet0ig62lhauok6co` (`request_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan_information`
--

LOCK TABLES `loan_information` WRITE;
/*!40000 ALTER TABLE `loan_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `loan_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan_offers`
--

DROP TABLE IF EXISTS `loan_offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loan_offers` (
  `offer_id` bigint NOT NULL AUTO_INCREMENT,
  `ending_date` datetime DEFAULT NULL,
  `loan_name` varchar(255) DEFAULT NULL,
  `loan_range` decimal(9,2) DEFAULT NULL,
  `starting_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type_id` bigint DEFAULT NULL,
  PRIMARY KEY (`offer_id`),
  KEY `FK6k5lhyf066g4ls5624eo1sqy0` (`type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan_offers`
--

LOCK TABLES `loan_offers` WRITE;
/*!40000 ALTER TABLE `loan_offers` DISABLE KEYS */;
/*!40000 ALTER TABLE `loan_offers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan_request`
--

DROP TABLE IF EXISTS `loan_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loan_request` (
  `request_id` bigint NOT NULL AUTO_INCREMENT,
  `amount` decimal(9,2) DEFAULT NULL,
  `emi_months` bigint DEFAULT NULL,
  `requested_date` datetime DEFAULT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `branch_id` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `offer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`request_id`),
  KEY `FK8cwtnlnhwepf7t56rvpsdrjm1` (`branch_id`),
  KEY `FKci6wtsgtmh8bu9y7kjpo1ai04` (`customer_id`),
  KEY `FKcvx1y2kjm25t9m2e1f9urg0hf` (`offer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan_request`
--

LOCK TABLES `loan_request` WRITE;
/*!40000 ALTER TABLE `loan_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `loan_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan_type`
--

DROP TABLE IF EXISTS `loan_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loan_type` (
  `type_id` bigint NOT NULL AUTO_INCREMENT,
  `interest` decimal(4,2) DEFAULT NULL,
  `loan_tenure` bigint DEFAULT NULL,
  `loan_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan_type`
--

LOCK TABLES `loan_type` WRITE;
/*!40000 ALTER TABLE `loan_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `loan_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_info`
--

DROP TABLE IF EXISTS `payment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_info` (
  `payment_id` bigint NOT NULL AUTO_INCREMENT,
  `payment_amount` decimal(9,2) DEFAULT NULL,
  `payment_date` datetime DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `emi_id` bigint NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `FK6vjni38hfp072blwssgi8tw86` (`emi_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_info`
--

LOCK TABLES `payment_info` WRITE;
/*!40000 ALTER TABLE `payment_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_activity`
--

DROP TABLE IF EXISTS `user_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_activity` (
  `activity_id` bigint NOT NULL AUTO_INCREMENT,
  `activity_time` datetime DEFAULT NULL,
  `activity_type` varchar(255) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `FKoya0mpejmkuueb83ws72i0tpp` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_activity`
--

LOCK TABLES `user_activity` WRITE;
/*!40000 ALTER TABLE `user_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_activity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-19 12:11:12
