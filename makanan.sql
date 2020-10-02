-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Waktu pembuatan: 02 Okt 2020 pada 04.02
-- Versi server: 5.7.31
-- Versi PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `makanan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

DROP TABLE IF EXISTS `barang`;
CREATE TABLE IF NOT EXISTS `barang` (
  `Id` varchar(50) NOT NULL,
  `Nama` varchar(100) DEFAULT NULL,
  `Stok` int(11) DEFAULT NULL,
  `Harga` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`Id`, `Nama`, `Stok`, `Harga`) VALUES
('K01', 'Keripik_Maicih', 2, 20000),
('K02', 'Keripik_Karuhun', 7, 15000),
('S01', 'Sus_Kering_Coklat', 12, 60000),
('S02', 'Sus_Kering_Strawberry', 14, 60000),
('S03', 'Sus_Kering_Nanas', 5, 60000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_transaksi`
--

DROP TABLE IF EXISTS `detail_transaksi`;
CREATE TABLE IF NOT EXISTS `detail_transaksi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jml_barang` int(30) NOT NULL,
  `id_barang` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id`, `jml_barang`, `id_barang`) VALUES
(1, 1, 'K01'),
(2, 1, 'K01'),
(3, 2, 'K01');

--
-- Trigger `detail_transaksi`
--
DROP TRIGGER IF EXISTS `penjualan`;
DELIMITER $$
CREATE TRIGGER `penjualan` AFTER INSERT ON `detail_transaksi` FOR EACH ROW BEGIN
UPDATE barang SET stok=stok-new.jml_barang
WHERE Id=new.id_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE IF NOT EXISTS `transaksi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tgl_transaksi` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
