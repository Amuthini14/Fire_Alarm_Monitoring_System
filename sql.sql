-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.31-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db
CREATE DATABASE IF NOT EXISTS `db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db`;

-- Dumping structure for table db.sensors
CREATE TABLE IF NOT EXISTS `sensors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `floor_no` varchar(20) NOT NULL,
  `sensor_name` varchar(50) DEFAULT NULL,
  `room_no` int(11) NOT NULL,
  `co2_level` int(11) DEFAULT '0',
  `smoke_level` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table db.sensors: ~6 rows (approximately)
DELETE FROM `sensors`;
/*!40000 ALTER TABLE `sensors` DISABLE KEYS */;
INSERT INTO `sensors` (`id`, `floor_no`, `sensor_name`, `room_no`, `co2_level`, `smoke_level`) VALUES
	(1, 'floor-01', 'sensor-01', 5, 3, 2),
	(2, 'floor-02', 'sensor-02', 5, 2, 2),
	(7, 'Floor-03', 'sensor-02', 5, 8, 9),
	(8, 'Floor-04', 'sensor-06', 6, 4, 2),
	(9, 'foolr-06', 'sensor-07', 6, 9, 5),
	(10, 'Floor-08', 'sensor-03', 7, 3, 4);
/*!40000 ALTER TABLE `sensors` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
