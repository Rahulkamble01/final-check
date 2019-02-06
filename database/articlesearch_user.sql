-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: articlesearch
-- ------------------------------------------------------
-- Server version	5.1.45-community

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `us_id` int(11) NOT NULL AUTO_INCREMENT,
  `us_name` varchar(70) NOT NULL,
  `us_email` varchar(45) NOT NULL,
  `us_password` varchar(255) NOT NULL,
  `us_ur_id` int(11) NOT NULL,
  `us_art_id` int(11) DEFAULT NULL,
  `us_lang_id` int(11) DEFAULT NULL,
  `us_status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`us_id`),
  KEY `us_ur_id_idx` (`us_ur_id`),
  KEY `us_art_id_idx` (`us_art_id`),
  KEY `us_lang_id_idx` (`us_lang_id`),
  CONSTRAINT `us_art_id` FOREIGN KEY (`us_art_id`) REFERENCES `article` (`art_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `us_lang_id` FOREIGN KEY (`us_lang_id`) REFERENCES `language` (`lang_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `us_ur_id` FOREIGN KEY (`us_ur_id`) REFERENCES `user_role` (`ur_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Rahul Kamble','Rahul.Kamble3@gmail.com','vishnu@01',1,NULL,1,'active'),(3,'RahulKamble','rahulkamble@gmail.com','rahulkamble01@',2,NULL,NULL,'inactive'),(4,'Rajesh','kamble@gmail.com','1234589',2,NULL,1,'inactive'),(5,'Ramesh','kamb@gmail.com','123589',2,NULL,1,'active'),(6,'Rajesh','rahukamble@gmail.com','123456789',2,NULL,1,'active'),(7,'Chandan Kamat','kamat@gmail.com','123456',2,NULL,2,'inactive'),(8,'Harsh Gupta','harsh@gmail.com','123456',2,NULL,2,'inactive'),(10,'active','active','5165',2,NULL,2,'fszdf'),(11,'Sangamesh','rahulkamble130595@gmail.com','rahulkamble01@',2,NULL,1,'active'),(12,'Sangamesh','rahulkamble1302595@gmail.com','rahulkamble01@',2,NULL,1,'active'),(13,'RahulVKamble','rahukamble11@gmail.com','123456789',2,NULL,1,'active');
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

-- Dump completed on 2019-02-06 14:30:02


-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: articlesearch
-- ------------------------------------------------------
-- Server version	5.1.45-community

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
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT,
  `ur_role` varchar(10) NOT NULL,
  PRIMARY KEY (`ur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'Admin'),(2,'user');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-06 14:30:03


-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: articlesearch
-- ------------------------------------------------------
-- Server version	5.1.45-community

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
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `language` (
  `lang_id` int(11) NOT NULL AUTO_INCREMENT,
  `lang_name` varchar(45) DEFAULT NULL,
  `lang_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`lang_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (1,'English','en'),(2,'French','fr'),(3,'Deutsch','de'),(4,'Arabic','ar'),(5,'Portuguese','pt'),(6,'Mandarin','zh');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-06 14:30:03


-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: articlesearch
-- ------------------------------------------------------
-- Server version	5.1.45-community

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
-- Table structure for table `favourite_article`
--

DROP TABLE IF EXISTS `favourite_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favourite_article` (
  `fa_id` int(11) NOT NULL AUTO_INCREMENT,
  `fa_art_id` int(11) NOT NULL,
  `fa_us_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`fa_id`),
  KEY `favart_art_id_idx` (`fa_art_id`),
  CONSTRAINT `favart_art_id` FOREIGN KEY (`fa_art_id`) REFERENCES `article` (`art_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favourite_article`
--

LOCK TABLES `favourite_article` WRITE;
/*!40000 ALTER TABLE `favourite_article` DISABLE KEYS */;
INSERT INTO `favourite_article` VALUES (152,28,4),(153,30,7),(154,31,8),(155,32,8),(156,29,5),(157,33,5),(158,35,5),(159,36,5),(160,37,5);
/*!40000 ALTER TABLE `favourite_article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-06 14:30:02


-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: articlesearch
-- ------------------------------------------------------
-- Server version	5.1.45-community

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `art_id` int(11) NOT NULL AUTO_INCREMENT,
  `art_title` varchar(255) DEFAULT NULL,
  `art_desc` varchar(1000) DEFAULT NULL,
  `art_content` varchar(5000) DEFAULT NULL,
  `art_author` varchar(70) DEFAULT NULL,
  `art_url` varchar(255) DEFAULT NULL,
  `art_urlToImage` varchar(255) DEFAULT NULL,
  `art_publishedat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`art_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (24,'The battle for Venezuela’s future','The world’s democracies are right to seek change in Latin America’s worst-governed country','IF PROTESTS ALONE could oust a president, Nicolás Maduro would already be on a plane to Cuba. On January 23rd at least 1m Venezuelans from across the country took to the streets demanding Mr Maduro step down. They were answering the call of Juan Guaidó, who l… [+6496 chars]','The Economist','http://www.economist.com/leaders/2019/02/02/the-battle-for-venezuelas-future','https://cdn.static-economist.com/sites/default/files/images/print-edition/20190202_LDD001_0.jpg','2019-02-02T00:00:00Z'),(25,'The battle for Venezuela’s future','The world’s democracies are right to seek change in Latin America’s worst-governed country','IF PROTESTS ALONE could oust a president, Nicolás Maduro would already be on a plane to Cuba. On January 23rd at least 1m Venezuelans from across the country took to the streets demanding Mr Maduro step down. They were answering the call of Juan Guaidó, who l… [+6496 chars]','The Economist','http://www.economist.com/leaders/2019/02/02/the-battle-for-venezuelas-future','https://cdn.static-economist.com/sites/default/files/images/print-edition/20190202_LDD001_0.jpg','2019-02-02T00:00:00Z'),(26,'The battle for Venezuela’s future','The world’s democracies are right to seek change in Latin America’s worst-governed country','IF PROTESTS ALONE could oust a president, Nicolás Maduro would already be on a plane to Cuba. On January 23rd at least 1m Venezuelans from across the country took to the streets demanding Mr Maduro step down. They were answering the call of Juan Guaidó, who l… [+6496 chars]','The Economist','http://www.economist.com/leaders/2019/02/02/the-battle-for-venezuelas-future','https://cdn.static-economist.com/sites/default/files/images/print-edition/20190202_LDD001_0.jpg','2019-02-02T00:00:00Z'),(27,'The battle for Venezuela’s future','The world’s democracies are right to seek change in Latin America’s worst-governed country','IF PROTESTS ALONE could oust a president, Nicolás Maduro would already be on a plane to Cuba. On January 23rd at least 1m Venezuelans from across the country took to the streets demanding Mr Maduro step down. They were answering the call of Juan Guaidó, who l… [+6496 chars]','The Economist','http://www.economist.com/leaders/2019/02/02/the-battle-for-venezuelas-future','https://cdn.static-economist.com/sites/default/files/images/print-edition/20190202_LDD001_0.jpg','2019-02-02T00:00:00Z'),(28,'\'Gas the Jews\' shouted at Australian Jewish teens','According to the Australian daily \'The Age,\' the three had gotten onto the wrong bus after an afternoon of shopping when they were accosted by a large group of teenagers.','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+4061 chars]','Ilanit Chernick','https://www.jpost.com/Diaspora/Gas-the-Jews-shouted-at-Australian-Jewish-teens-579618','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_Control/198089','2019-02-04T10:38:00Z'),(29,'Benjamin Netanyahu to enact penalty for Palestinian pay-for-slay - report','The Prime Minister is concerned about stability in the Palestinian Authority after law, deducting funds paid to terrorists, goes into effect.','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+3379 chars]','Lahav Harkov','https://www.jpost.com/Arab-Israeli-Conflict/Netanyahu-to-enact-penalty-for-Palestinian-pay-for-slay-report-579620','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/398705','2019-02-04T11:13:00Z'),(30,'Major European nations recognize Juan Guaido as Venezuelan president','\"Guaido has the capacity and the legitimacy to organize an election,\" French Foreign Minister Jean-Yves Le Drian told France Inter radio station.','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+4335 chars]',NULL,'https://www.jpost.com/International/Major-European-nations-recognize-Guaido-as-Venezuelan-president-579622','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/435204','2019-02-04T13:15:00Z'),(31,'On historic trip, Pope Francis meets UAE leaders, gets royal welcome','Writing in the palace guest book, Pope France asked that God grant the United Arab Emirates \"divine blessings of peace and fraternal solidarity.\"','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+4659 chars]',NULL,'https://www.jpost.com/Middle-East/On-historic-trip-Pope-Francis-meets-UAE-leaders-gets-royal-welcome-579636','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/435211','2019-02-04T13:43:00Z'),(32,'Coupe de la Ligue : la finale Guingamp-Strasbourg à guichets fermés','La Ligue de football professionnel (LFP) a annoncé ce lundi la tenue à guichets fermés de la finale de la Coupe de Ligue, le 30 mars, entre Guingamp et  Strasbourg.','La Ligue de Football Professionnel (LFP) a annoncé ce lundi que la finale de la Coupe de la Ligue, qui aura lieu le 30 mars prochain au Stade Pierre Mauroy de Villeneuve-d\'Ascq, se jouera à guichets fermé. La totalité des places mises en vente ont donc toutes… [+349 chars]','L\'EQUIPE','https://www.lequipe.fr/Football/Actualites/Coupe-de-la-ligue-la-finale-guingamp-strasbourg-a-guichets-fermes/985221','https://medias.lequipe.fr/img-photo-jpg/la-finale-de-la-coupe-de-la-ligue-aura-lieu-le-30-mars-prochain-a-lille-e-garnier-l-equipe/1500000001092805/0:0,2000:1333-624-416-75/47887.jpg','2019-02-04T11:38:00+00:00'),(33,'Cradle of \'Arab Spring\' in flux as massive protests rock Tunisia','The IMF has urged the country to freeze public sector wages and reduce the government’s ballooning deficit','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+5431 chars]',NULL,'https://www.jpost.com/Middle-East/Cradle-of-Arab-Spring-in-flux-as-massive-protests-rock-Tunisia-579711','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/422733','2019-02-05T06:17:00Z'),(34,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,'Cradle of \'Arab Spring\' in flux as massive protests rock Tunisia','The IMF has urged the country to freeze public sector wages and reduce the government’s ballooning deficit',NULL,NULL,NULL,NULL,NULL),(37,'Cradle of \'Arab Spring\' in flux as massive protests rock Tunisia','The IMF has urged the country to freeze public sector wages and reduce the government’s ballooning deficit',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-06 14:30:01
