CREATE DATABASE  IF NOT EXISTS `db_projet7_OC` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `db_projet7_OC`;
-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: db_projet7_OC
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `author` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'ÇA, tome 1','Enfants, dans leur petite ville de Derry, Ben, Eddie, Richie et la petite bande du « Club des ratés », comme ils se désignaient, ont été confrontés à l’horreur absolue : ça, cette chose épouvantable, tapie dans les égouts et capable de déchiqueter vif un garçonnet de six ans…\nVingt-sept ans plus tard, l’appel de l’un d’entre eux les réunit sur les lieux de leur enfance. Car l’horreur, de nouveau, se déchaîne, comme si elle devait de façon cyclique et régulière frapper la petite cité.\nEntre le passé et le présent, l’enfance et l’âge adulte, l’oubli des terreurs et leur insoutenable retour, l’auteur de Sac d’os nous convie à un fascinant voyage vers le Mal, avec une de ses œuvres les plus amples et les plus fortes.','Stephen King','/images/ca_stephenKing.jpg'),(12,'Les Prodiges de l\'empire - Tome 2 : Shiang','Si les pierres pouvaient parler... elles appelleraient à la guerre.\n\nLe jeune roi de Shiang maintient l\'ordre d\'une main de fer, et ses redoutables guerriers Mazer surveillent chaque carrefour, à l\'affût du moindre signe de rébellion. Tenu à la gorge, le peuple vit dans une tension permanente.\n\nMais un événement inattendu va bouleverser un équilibre vieux de plusieurs siècles dans une explosion de violence. Une menace sans nom émerge des ténèbres et s\'abat sur la cité.\n\nLoin à l\'ouest, quatre maîtres-lames de Shiang approchent des murailles de Darien. Le saint des lames et ses trois compagnons ont traversé un continent pour retrouver un vieil homme et le punir de ses crimes. Rien ne les arrêtera. Pas même une armée.\n\nDeux cités millénaires. Une guerre ultime.','Iggulden','/images/iggulden.png'),(13,'Game Of Thrones, Le trône de fer - Tome 2 : L\'intégrale','Le royaume des sept couronnes est sur le point de connaître son plus terrible hiver : par-delà le mur qui garde sa frontière nord, une armée de ténèbres se lève, menaçant de tout détruire sur son passage.\nMais il en faut plus pour refroidir les ardeurs des rois, des reines, des chevaliers et des renégats qui se disputent le trône de fer. Tous les coups sont permis, et seuls les plus forts, ou les plus retors, s\'en sortiront indemnes.','George R.R. Martin','/images/georgeMartin.png'),(14,'Voyage en Terre du Milieu','Pour la première fois en France, la BnF célèbre J.R.R. Tolkien à l\'occasion d\'une grande exposition événement. Dialoguant avec les collections de la BnF, les manuscrits, dessins, cartes et photographies de l\'honorable professeur d\'Oxford reproduites dans le catalogue permettent d\'arpenter et de mieux comprendre le monde imaginaire forgé par l\'auteur du Seigneur des Anneaux.','Tolkien','/images/tolkien.png'),(19,'Les Légions Brisées','Amenés au bord de la destruction sur Isstvan V, les Iron Hands veulent désormais venger la mort de leur primarque Ferrus Manus. Ils ont embarqué avec les rescapés de la Raven Guard et des Salamanders à bord de tous les vaisseaux capables de parcourir le warp, et ces Légions Brisées livrent depuis une guerre d\'usure aux forces renégates à travers la galaxie ? une campagne orchestrée par le fameux chef de guerre Shadrak Meduson. Ce recueil Horus Heresy contient dix nouvelles par Dan Abnett, Chris Wraight, John French et de nombreux autres auteurs. De plus, dans le roman court Le Septième Serpent, Graham McNeill remet en scène l\'équipage disparate de l\'astronef Sisypheum, qui mène une guerre tout en subterfuges contre l\'Alpha Legion.','Laurie J. Goulding','/images/laurieJ.png'),(20,'Le Siège de Terra: Les Égarés et les Damnés','Au treizième jour de Secundus commença le bombardement de Terra? Une fois les défenses solaires neutralisées par la force dévastatrice de l\'armada des félons et la puissance du Warp, Horus lance pour de bon l\'assaut contre le Monde-trône. Après un pilonnage orbital d\'envergure, une immense guerre terrestre commence hors du Palais et chaque pouce de terrain se paie par des milliards de vies. La ligne de front est un cauchemar où l\'air lui-même n\'est que sang et poison. Sous l\'afflux de chair à canon, les redoutes extérieures ne pourront tenir longtemps, même avec le renfort des primarques loyalistes, car Horus dispose de ses propres généraux? Entre les armes pestiférées de Mortarion et la fureur d\'Angron, les défenseurs partent perdants.','Guy Haley','/images/guyHaley.png'),(21,'La foret sombre','Après le succès du «Problème à trois corps »(prix Hugo du meilleur roman 2015), Liu Cixin revient avec une suite magistrale et haletante.\n','Liu Cixin','/images/liuCixin.png'),(22,'Lait et miel','\" lait et miel est un recueil poétique que toutes les femmes devraient avoir sur leur table de nuit ou la table basse de leur salon. Accompagnés de ses propres dessins, ses poèmes, d\'une honnêteté et d\'une authenticité rares, se lisent comme les expériences collectives et quotidiennes d\'une femme du XXIe siècle. \" Erin Spencer –?Huffington Post','Rupi Kaur ','/images/rupiKaur.png'),(23,'Paroles','Le cancreil dit non avec la têtemais il dit oui avec le cœuril dit oui à ce qu\'il aimeil dit non au professeuril est debouton le questionneet tous les problèmes sont poséssoudain le fou rire le prendet il efface toutles chiffres et les motsles dates et les nomsles phrases et les piègeset malgré les menaces du maîtresous les huées des enfants prodigesavec des craies de toutes les couleurssur le tableau noir du malheuril dessine le visage du bonheur\n\n','Jacques Prévert','/images/jacquesPrevert.png'),(24,'Aimer, rimer','La présente anthologie vous invite à voyager dans l histoire littéraire - et amoureuse - du XIVe au XXIe siècle grâce à une sélection de cent cinquante poèmes de langue française. Bonheur, souffrance, jalousie, folie, inconstance, joie, deuil, espoir : Amour et Poésie dialoguent sur tous les tons.','Jérémie Pinguet ','/images/jeremie.png'),(25,'Les langoliers','Dans un avion, des passagers endormis découvrent à leur réveil qu\'ils sont plus ou moins seuls à bord, ceux qui étaient éveillés ayant mystérieusement disparu, pilotes compris. Il semblerait même que, à terre, tout le monde ait également disparu...','Stephen King','/images/langoliers.png'),(30,'Par accident','Il y a quinze ans, la vie de Nap Dumas a basculé : son frère jumeau et la petite amie de celui-ci ont été retrouvés morts sur la voie ferrée. Double suicide d\'amoureux ? Nap n\'y a jamais cru.','Harlan Coben','/images/harlanCober.png'),(31,'Toutes blessent, la dernière tue','Tama est une esclave. Elle n\'a quasiment connu que la servitude. Prisonnière de bourreaux qui ignorent la pitié, elle sait pourtant rêver, aimer, espérer. Une rencontre va peut-être changer son destin...\n\nGabriel est un homme qui vit à l\'écart du monde, avec pour seule compagnie ses démons et ses profondes meurtrissures. Un homme dangereux. Un matin, il découvre une inconnue qui a trouvé refuge chez lui. Une jeune femme blessée et amnésique. Qui est-elle ? D\'où vient-elle ?','Karine Giebel','/images/karineGiebel.png'),(32,'Les voeux secrets des soeurs McBride','Dans la région enneigée des Highlands d\'Écosse, Suzanne McBride est impatiente que ses trois filles adoptives la rejoignent pour fêter Noël. Hannah, elle, se passerait bien de ces festivités familiales  : elle croule sous le travail et, surtout, sous le poids du secret qui va bientôt changer sa vie. Beth, quant à elle, est en pleine crise existentielle et tout ce que la mère de famille souhaite pour l’instant c’est du temps pour elle et du calme afin de décider si elle est prête à reprendre le travail.','Sarah Morgan','/images/sarahMorgan.png'),(33,'Embarquement immédiat pour relation agitée','Lucile est une incorrigible romantique, et une fan inconditionnelle de Noël  ! Cette année, elle l’aurait volontiers passé en pyjama avec une tasse de chocolat chaud et son sapin croulant sous les guirlandes lumineuses. Sauf que sa boss tyrannique a encore frappé  : résultat, la voilà obligée de rejoindre en catastrophe la croisière «  Miracle Love Boat  », le tout dernier concept de leur agence pour sauver les couples à la dérive. Si, d’habitude, c’est elle qui aide les autres à trouver l’amour, peut-être que cette fois-ci l’amour la trouvera  !','Deborah Guérand','/images/deborah.png'),(34,'L\'axe du loup','Pendant huit mois, Sylvain Tesson a refait le long voyage de la Sibérie au golfe du Bengale qu\'effectuaient naguère les évadés du goulag. Pour rendre hommage à ceux dont la soif de liberté a triomphé des obstacles les plus grands, seul, il a franchi les taïgas, la steppe mongole, le désert de Gobi, les Hauts Plateaux tibétains, la chaîne himalayenne, la forêt humide jusqu\'à la montagne de Darjeeling. À pied, à cheval, à vélo, sur six mille kilomètres, il a connu ce qu\'il a cherché de plein gré : le froid, la faim, la solitude extrême. La splendeur de la haute Asie l\'a récompensé, comme les mots d\'une très ancienne déportée heureuse de se confier à lui : «On a le droit de se souvenir.»','Sylvain Tesson','/images/sylvainTesson.png');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_categories`
--

DROP TABLE IF EXISTS `book_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book_categories` (
  `book_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`,`category_id`),
  KEY `fk_category_id_idx` (`category_id`),
  CONSTRAINT `fk_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_categories`
--

LOCK TABLES `book_categories` WRITE;
/*!40000 ALTER TABLE `book_categories` DISABLE KEYS */;
INSERT INTO `book_categories` VALUES (12,1),(13,1),(14,1),(19,2),(20,2),(21,2),(32,3),(33,3),(22,4),(23,4),(24,4),(30,5),(31,5),(34,6),(1,7),(25,7);
/*!40000 ALTER TABLE `book_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Fantasy'),(2,'Science Fiction'),(3,'Romance'),(4,'Littérature'),(5,'Thrillers'),(6,'Action & Aventure'),(7,'Horreur');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copy`
--

DROP TABLE IF EXISTS `copy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `copy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reference_number` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `book_id` int(11) NOT NULL,
  `is_available` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id_fk_idx` (`book_id`),
  CONSTRAINT `book_id_fk` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copy`
--

LOCK TABLES `copy` WRITE;
/*!40000 ALTER TABLE `copy` DISABLE KEYS */;
INSERT INTO `copy` VALUES (1,'12345',1,0),(2,'54321',1,1),(3,'32134',12,1),(4,'87846',12,1),(5,'12753',13,1),(6,'43242',13,1),(7,'08785',14,1),(8,'43588',19,1),(9,'13795',20,0),(10,'34234',20,1),(11,'43242',21,1),(12,'97674',21,0),(13,'43258',21,1),(14,'87665',22,1),(15,'64532',23,1),(16,'12343',23,0),(17,'76575',24,1),(18,'21321',24,1),(19,'33333',25,1),(20,'55555',25,1),(21,'11111',30,1),(22,'22334',31,1),(23,'22223',32,1),(24,'99999',32,1),(25,'19283',33,1),(26,'23455',33,1),(27,'45545',34,1);
/*!40000 ALTER TABLE `copy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `loan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `is_second` tinyint(4) NOT NULL,
  `copy_id` int(11) NOT NULL,
  `is_second_loan` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `copy_id_idx` (`copy_id`),
  CONSTRAINT `copy_id_fk` FOREIGN KEY (`copy_id`) REFERENCES `copy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` VALUES (1,'2019-08-28',1,1,NULL),(3,'2019-10-04',0,2,NULL),(14,'2019-11-22',0,12,NULL),(15,'2019-11-30',1,16,NULL),(16,'2019-11-15',1,9,NULL);
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lastname` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_admin` tinyint(4) NOT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `password_UNIQUE` (`password`),
  UNIQUE KEY `firstname_UNIQUE` (`firstname`),
  UNIQUE KEY `lastname_UNIQUE` (`lastname`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (3,'Malcolm','Noname','t.varadarasuu@gmail.com','$2a$12$FJWa8zbij3ON2nrBSRuUkuCc3hxL1CD49eXd3U1RC3iMbo5xdQBv2',0,NULL),(14,'test','test','test@test.com','$2a$12$PWKtAC4UZ2BtjM2X/3oB1.8UTSeNHKUiXtS0xHPES3Mcg3Slrez3i',0,NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_borrow`
--

DROP TABLE IF EXISTS `person_borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `person_borrow` (
  `person_id` int(11) NOT NULL,
  `loan_id` int(11) NOT NULL,
  PRIMARY KEY (`person_id`,`loan_id`),
  KEY `loan_id_fk_idx` (`loan_id`),
  CONSTRAINT `loan_id_fk` FOREIGN KEY (`loan_id`) REFERENCES `loan` (`id`),
  CONSTRAINT `person_id_fk` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_borrow`
--

LOCK TABLES `person_borrow` WRITE;
/*!40000 ALTER TABLE `person_borrow` DISABLE KEYS */;
INSERT INTO `person_borrow` VALUES (3,1),(3,3),(14,14),(14,15),(14,16);
/*!40000 ALTER TABLE `person_borrow` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-01  1:12:05
