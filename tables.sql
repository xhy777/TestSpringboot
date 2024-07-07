-- --------------------------------------------------------
-- 主机:                           localhost
-- Server version:               5.5.42 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL 版本:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for tables
CREATE DATABASE IF NOT EXISTS `tables` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tables`;

-- Dumping structure for table tables.build
CREATE TABLE IF NOT EXISTS `build` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bunit` int(11) DEFAULT NULL,
  `bfloor` int(11) DEFAULT NULL,
  `bnumber` int(11) DEFAULT NULL,
  `barea` int(11) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table tables.build: ~2 rows (approximately)
/*!40000 ALTER TABLE `build` DISABLE KEYS */;
INSERT INTO `build` (`bid`, `bunit`, `bfloor`, `bnumber`, `barea`) VALUES
	(1, 1, 1, 1, 150),
	(2, 2, 2, 2, 100);
/*!40000 ALTER TABLE `build` ENABLE KEYS */;

-- Dumping structure for table tables.employment
CREATE TABLE IF NOT EXISTS `employment` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(50) DEFAULT NULL,
  `eage` int(11) DEFAULT NULL,
  `idcard` varchar(50) DEFAULT NULL,
  `eaddr` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table tables.employment: ~7 rows (approximately)
/*!40000 ALTER TABLE `employment` DISABLE KEYS */;
INSERT INTO `employment` (`eid`, `ename`, `eage`, `idcard`, `eaddr`, `sex`) VALUES
	(1, '张三', 21, '2021109001', '135681559564', '男'),
	(2, '李四', 21, '2021109003', '132569265562', '男'),
	(3, '钱五', 23, '2021109004', '132569265562', '女'),
	(4, '赵六', 22, '2021109005', '132569265562', '女'),
	(5, '薛七', 23, '2021109005', '132569265562', '男'),
	(6, '许八', 24, '2021109005', '132569265562', '女'),
	(7, '许七', 21, '2021109007', '132569265562', '男');
/*!40000 ALTER TABLE `employment` ENABLE KEYS */;

-- Dumping structure for table tables.owner
CREATE TABLE IF NOT EXISTS `owner` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) DEFAULT NULL,
  `phone` varchar(11) NOT NULL DEFAULT '0',
  `pnumber` int(11) NOT NULL DEFAULT '0',
  `pwhether` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table tables.owner: ~2 rows (approximately)
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` (`pid`, `pname`, `phone`, `pnumber`, `pwhether`) VALUES
	(1, 'admin', '1', 1, '是'),
	(2, '张三', '13565498915', 6, '是');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;

-- Dumping structure for table tables.s_menu
CREATE TABLE IF NOT EXISTS `s_menu` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(50) DEFAULT NULL,
  `mlevele` varchar(50) DEFAULT NULL,
  `mtype` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table tables.s_menu: ~1 rows (approximately)
/*!40000 ALTER TABLE `s_menu` DISABLE KEYS */;
INSERT INTO `s_menu` (`mid`, `mname`, `mlevele`, `mtype`) VALUES
	(1, 'admin', 'admin', '1');
/*!40000 ALTER TABLE `s_menu` ENABLE KEYS */;

-- Dumping structure for table tables.s_user
CREATE TABLE IF NOT EXISTS `s_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) DEFAULT NULL,
  `uloginname` varchar(50) DEFAULT NULL,
  `upassword` varchar(50) DEFAULT NULL,
  `utype` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table tables.s_user: ~1 rows (approximately)
/*!40000 ALTER TABLE `s_user` DISABLE KEYS */;
INSERT INTO `s_user` (`uid`, `uname`, `uloginname`, `upassword`, `utype`) VALUES
	(1, 'admin', 'admin', 'admin', 'admin');
/*!40000 ALTER TABLE `s_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
