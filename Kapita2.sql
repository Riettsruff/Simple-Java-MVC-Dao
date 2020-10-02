-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for penjualan_makanan
CREATE DATABASE IF NOT EXISTS `penjualan_makanan` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `penjualan_makanan`;

-- Dumping structure for table penjualan_makanan.barang
CREATE TABLE IF NOT EXISTS `barang` (
  `Id` varchar(50) NOT NULL,
  `Nama` varchar(100) DEFAULT NULL,
  `Stok` int(11) DEFAULT NULL,
  `Harga` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table penjualan_makanan.barang: ~5 rows (approximately)
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
INSERT INTO `barang` (`Id`, `Nama`, `Stok`, `Harga`) VALUES
	('K01', 'Keripik_Maicih', 10, 20000),
	('K02', 'Keripik_Karuhun', 7, 15000),
	('S01', 'Sus_Kering_Coklat', 12, 60000),
	('S02', 'Sus_Kering_Strawberry', 14, 60000),
	('S03', 'Sus_Kering_Nanas', 5, 60000);
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;

-- Dumping structure for table penjualan_makanan.detail_transaksi
CREATE TABLE IF NOT EXISTS `detail_transaksi` (
  `Id` varchar(50) NOT NULL,
  `Jml_Barang` int(11) DEFAULT NULL,
  `Id_Transaksi` int(11) DEFAULT NULL,
  `Id_Barang` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_detail_transaksi_transaksi` (`Id_Transaksi`),
  KEY `FK_detail_transaksi_barang` (`Id_Barang`),
  CONSTRAINT `FK_detail_transaksi_barang` FOREIGN KEY (`Id_Barang`) REFERENCES `barang` (`Id`),
  CONSTRAINT `FK_detail_transaksi_transaksi` FOREIGN KEY (`Id_Transaksi`) REFERENCES `transaksi` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table penjualan_makanan.detail_transaksi: ~7 rows (approximately)
/*!40000 ALTER TABLE `detail_transaksi` DISABLE KEYS */;
INSERT INTO `detail_transaksi` (`Id`, `Jml_Barang`, `Id_Transaksi`, `Id_Barang`) VALUES
	('01', 5, 514, 'S01'),
	('02', 1, 501, 'K02'),
	('03', 6, 901, 'K01'),
	('04', 2, 901, 'S02'),
	('05', 3, 812, 'S03'),
	('06', 2, 917, 'K01'),
	('07', 4, 917, 'S01');
/*!40000 ALTER TABLE `detail_transaksi` ENABLE KEYS */;

-- Dumping structure for table penjualan_makanan.transaksi
CREATE TABLE IF NOT EXISTS `transaksi` (
  `Id` int(11) NOT NULL,
  `Tgl_Transaksi` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table penjualan_makanan.transaksi: ~6 rows (approximately)
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
INSERT INTO `transaksi` (`Id`, `Tgl_Transaksi`) VALUES
	(501, '2020-05-01'),
	(514, '2020-05-14'),
	(812, '2020-08-12'),
	(824, '2020-08-24'),
	(901, '2020-09-01'),
	(917, '2020-09-17');
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
