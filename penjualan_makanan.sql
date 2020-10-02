-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versi server:                 5.6.21 - MySQL Community Server (GPL)
-- OS Server:                    Win32
-- HeidiSQL Versi:               11.0.0.6097
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Membuang struktur basisdata untuk penjualan_makanan
CREATE DATABASE IF NOT EXISTS `penjualan_makanan` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `penjualan_makanan`;

-- membuang struktur untuk table penjualan_makanan.barang
CREATE TABLE IF NOT EXISTS `barang` (
  `id` varchar(50) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Membuang data untuk tabel penjualan_makanan.barang: ~5 rows (lebih kurang)
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
INSERT INTO `barang` (`id`, `nama`, `stok`, `harga`) VALUES
	('BR001', 'Keripik_Maicih', 2, 20000),
	('BR002', 'Keripik_Karuhun', 3, 15000),
	('BR003', 'Sus_Kering_Coklat', 12, 60000),
	('BR004', 'Sus_Kering_Strawberry', 8, 60000),
	('BR005', 'Sus_Kering_Nanas', 5, 60000);
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;

-- membuang struktur untuk table penjualan_makanan.detail_transaksi
CREATE TABLE IF NOT EXISTS `detail_transaksi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jml_barang` int(11) NOT NULL,
  `id_barang` varchar(50) DEFAULT NULL,
  `id_transaksi` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_transaksi` (`id_transaksi`),
  KEY `id_barang` (`id_barang`),
  KEY `id_barang_2` (`id_barang`),
  KEY `id_transaksi_2` (`id_transaksi`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Membuang data untuk tabel penjualan_makanan.detail_transaksi: 2 rows
/*!40000 ALTER TABLE `detail_transaksi` DISABLE KEYS */;
INSERT INTO `detail_transaksi` (`id`, `jml_barang`, `id_barang`, `id_transaksi`) VALUES
	(1, 4, 'BR002', 'TR001'),
	(2, 6, 'BR004', 'TR001');
/*!40000 ALTER TABLE `detail_transaksi` ENABLE KEYS */;

-- membuang struktur untuk table penjualan_makanan.transaksi
CREATE TABLE IF NOT EXISTS `transaksi` (
  `id` varchar(50) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Membuang data untuk tabel penjualan_makanan.transaksi: 1 rows
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
INSERT INTO `transaksi` (`id`, `tgl_transaksi`) VALUES
	('TR001', '2020-09-03');
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;

-- membuang struktur untuk trigger penjualan_makanan.penjualan
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
DELIMITER //
CREATE TRIGGER `penjualan` AFTER INSERT ON `detail_transaksi` FOR EACH ROW BEGIN
UPDATE barang SET stok=stok-new.jml_barang
WHERE Id=new.id_barang;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
