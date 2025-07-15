-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: industria
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id_funcionario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  `sobrenome` varchar(40) NOT NULL,
  `id_setor` int NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  KEY `id_setor` (`id_setor`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`id_setor`) REFERENCES `setor` (`id_setor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Lucas','Dos Santos Crispim',1),(2,'Ana','Silva Souza',2),(3,'Carlos','Oliveira Santos',3),(4,'Mariana','Ferreira Gomes',4),(5,'João','Pereira Costa',5),(6,'Fernanda','Lima Rocha',1),(7,'Pedro','Martins Oliveira',2),(8,'Juliana','Ribeiro Alves',3),(9,'Ricardo','Almeida Pereira',4),(10,'Patrícia','Sousa Ferreira',5),(11,'Gabriel','Dias Silva',1),(12,'Cláudia','Barbosa Pinto',2),(13,'Felipe','Mendes Carvalho',3),(14,'Isabela','Nascimento Ferreira',4),(15,'Vinícius','Cavalcanti Ribeiro',5),(16,'Aline','Cardoso Costa',1),(17,'Tiago','Gomes Martins',2),(18,'Luciana','Pinto Silva',3),(19,'Ricardo','Fernandes Lima',4),(20,'Sofia','Costa Almeida',5),(21,'Lucas','Dos Santos Crispim',1),(22,'Ana','Silva Souza',2),(23,'Carlos','Oliveira Santos',3),(24,'Mariana','Ferreira Gomes',4),(25,'João','Pereira Costa',5),(26,'Fernanda','Lima Rocha',1),(27,'Pedro','Martins Oliveira',2),(28,'Juliana','Ribeiro Alves',3),(29,'Ricardo','Almeida Pereira',4),(30,'Patrícia','Sousa Ferreira',5),(31,'Gabriel','Dias Silva',1),(32,'Cláudia','Barbosa Pinto',2),(33,'Felipe','Mendes Carvalho',3),(34,'Isabela','Nascimento Ferreira',4),(35,'Vinícius','Cavalcanti Ribeiro',5),(36,'Aline','Cardoso Costa',1),(37,'Tiago','Gomes Martins',2),(38,'Luciana','Pinto Silva',3),(39,'Ricardo','Fernandes Lima',4),(40,'Sofia','Costa Almeida',5),(41,'Sérgio','Brito',3);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producao`
--

DROP TABLE IF EXISTS `producao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producao` (
  `id_producao` int NOT NULL AUTO_INCREMENT,
  `id_produtos` int NOT NULL,
  `id_funcionario` int NOT NULL,
  `data_producao` varchar(10) NOT NULL,
  `quantidade` int NOT NULL,
  PRIMARY KEY (`id_producao`),
  KEY `id_produtos` (`id_produtos`),
  KEY `id_funcionario` (`id_funcionario`),
  CONSTRAINT `producao_ibfk_1` FOREIGN KEY (`id_produtos`) REFERENCES `produtos` (`id_produtos`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `producao_ibfk_2` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producao`
--

LOCK TABLES `producao` WRITE;
/*!40000 ALTER TABLE `producao` DISABLE KEYS */;
INSERT INTO `producao` VALUES (1,1,1,'2025-06-01',100),(2,2,2,'2025-06-02',150),(3,3,3,'2025-06-03',200),(4,4,4,'2025-06-04',120),(5,5,5,'2025-06-05',80),(6,1,6,'2025-06-06',90),(7,2,7,'2025-06-07',110),(8,3,8,'2025-06-08',130),(9,4,9,'2025-06-09',140),(10,5,10,'2025-06-10',170),(11,1,11,'2025-06-11',160),(12,2,12,'2025-06-12',180),(13,3,13,'2025-06-13',150),(14,4,14,'2025-06-14',200),(15,5,15,'2025-06-15',220),(16,1,16,'2025-06-16',250),(17,2,17,'2025-06-17',230),(18,3,18,'2025-06-18',190),(19,4,19,'2025-06-19',170),(20,5,20,'2025-06-20',210),(21,1,1,'2025-06-01',100),(22,2,2,'2025-06-02',150),(23,3,3,'2025-06-03',200),(24,4,4,'2025-06-04',120),(25,5,5,'2025-06-05',80),(26,1,6,'2025-06-06',90),(27,2,7,'2025-06-07',110),(28,3,8,'2025-06-08',130),(29,4,9,'2025-06-09',140),(30,5,10,'2025-06-10',170),(31,1,11,'2025-06-11',160),(32,2,12,'2025-06-12',180),(33,3,13,'2025-06-13',150),(34,4,14,'2025-06-14',200),(35,5,15,'2025-06-15',220),(36,1,16,'2025-06-16',250),(37,2,17,'2025-06-17',230),(38,3,18,'2025-06-18',190),(39,4,19,'2025-06-19',170),(40,5,20,'2025-06-20',210);
/*!40000 ALTER TABLE `producao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `id_produtos` int NOT NULL AUTO_INCREMENT,
  `nome_produto` varchar(40) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id_produtos`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'Caderno','Caderno espiral de 100 folhas, capa dura'),(2,'Caneta','Caneta esferográfica azul com tinta de alta qualidade'),(3,'Lápis','Lápis grafite 2B, ideal para escrita e desenhos'),(4,'Mochila','Mochila de nylon com compartimentos para laptop'),(5,'Camiseta','Camiseta de algodão, disponível em várias cores'),(6,'Fones de ouvido','Fones de ouvido sem fio, com cancelamento de ruído'),(7,'Computador','Desktop com processador i7, 16GB de RAM e 512GB SSD'),(8,'Monitor','Monitor LED de 24 polegadas, resolução 1080p'),(9,'Impressora','Impressora jato de tinta, multifuncional com Wi-Fi'),(10,'Mouse','Mouse ergonômico com cabo e botão extra'),(11,'Teclado','Teclado mecânico, retroiluminado, com switches táteis'),(12,'Cafeteira','Cafeteira elétrica, capacidade para 10 xícaras'),(13,'Batedeira','Batedeira elétrica com 5 velocidades e tigela de 3L'),(14,'Ar condicionado','Ar condicionado Split, 12000 BTUs, econômico'),(15,'Geladeira','Geladeira duplex, frost free, capacidade de 380L'),(16,'Micro-ondas','Micro-ondas 20L, com 10 funções preprogramadas'),(17,'Secador de cabelo','Secador de cabelo com 2 velocidades e 3 temperaturas'),(18,'Luminária','Luminária de mesa LED com ajuste de intensidade'),(19,'Tênis','Tênis de corrida, confortável e leve, ideal para atividades físicas'),(20,'Relógio','Relógio de pulso digital, resistente à água, com cronômetro'),(21,'Caderno','Caderno espiral de 100 folhas, capa dura'),(22,'Caneta','Caneta esferográfica azul com tinta de alta qualidade'),(23,'Lápis','Lápis grafite 2B, ideal para escrita e desenhos'),(24,'Mochila','Mochila de nylon com compartimentos para laptop'),(25,'Camiseta','Camiseta de algodão, disponível em várias cores'),(26,'Fones de ouvido','Fones de ouvido sem fio, com cancelamento de ruído'),(27,'Computador','Desktop com processador i7, 16GB de RAM e 512GB SSD'),(28,'Monitor','Monitor LED de 24 polegadas, resolução 1080p'),(29,'Impressora','Impressora jato de tinta, multifuncional com Wi-Fi'),(30,'Mouse','Mouse ergonômico com cabo e botão extra'),(31,'Teclado','Teclado mecânico, retroiluminado, com switches táteis'),(32,'Cafeteira','Cafeteira elétrica, capacidade para 10 xícaras'),(33,'Batedeira','Batedeira elétrica com 5 velocidades e tigela de 3L'),(34,'Ar condicionado','Ar condicionado Split, 12000 BTUs, econômico'),(35,'Geladeira','Geladeira duplex, frost free, capacidade de 380L'),(36,'Micro-ondas','Micro-ondas 20L, com 10 funções preprogramadas'),(37,'Secador de cabelo','Secador de cabelo com 2 velocidades e 3 temperaturas'),(38,'Luminária','Luminária de mesa LED com ajuste de intensidade'),(39,'Tênis','Tênis de corrida, confortável e leve, ideal para atividades físicas'),(40,'Relógio','Relógio de pulso digital, resistente à água, com cronômetro');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setor`
--

DROP TABLE IF EXISTS `setor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setor` (
  `id_setor` int NOT NULL AUTO_INCREMENT,
  `nome_setor` varchar(40) NOT NULL,
  `responsavel` text,
  PRIMARY KEY (`id_setor`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setor`
--

LOCK TABLES `setor` WRITE;
/*!40000 ALTER TABLE `setor` DISABLE KEYS */;
INSERT INTO `setor` VALUES (1,'Logística','Roberto'),(2,'Recursos Humanos','Fernanda'),(3,'Tecnologia','Carlos'),(4,'Financeiro','Juliana'),(5,'Marketing','Lucas'),(6,'Logística','Roberto'),(7,'Recursos Humanos','Fernanda'),(8,'Tecnologia','Carlos'),(9,'Financeiro','Juliana'),(10,'Marketing','Lucas');
/*!40000 ALTER TABLE `setor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-14 21:17:09
