-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.27-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for qlks_cnpm
CREATE DATABASE IF NOT EXISTS `qlks_cnpm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `qlks_cnpm`;

-- Dumping structure for table qlks_cnpm.chitietnhap
CREATE TABLE IF NOT EXISTS `chitietnhap` (
  `maPN` varchar(20) NOT NULL,
  `maDV` varchar(20) NOT NULL,
  `giaDVNhap` int(11) DEFAULT NULL,
  `soLuong` int(11) DEFAULT NULL,
  PRIMARY KEY (`maPN`,`maDV`),
  KEY `maDV` (`maDV`),
  CONSTRAINT `chitietnhap_ibfk_1` FOREIGN KEY (`maPN`) REFERENCES `phieunhap` (`maPN`),
  CONSTRAINT `chitietnhap_ibfk_2` FOREIGN KEY (`maDV`) REFERENCES `dichvu` (`maDV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.chitietnhap: ~1 rows (approximately)
INSERT INTO `chitietnhap` (`maPN`, `maDV`, `giaDVNhap`, `soLuong`) VALUES
	('#PN1312230001', 'DVTD00002', 0, 15);

-- Dumping structure for table qlks_cnpm.chitietthue
CREATE TABLE IF NOT EXISTS `chitietthue` (
  `maCTT` varchar(20) NOT NULL,
  `maKH` varchar(20) DEFAULT NULL,
  `maNV` varchar(20) DEFAULT NULL,
  `ngayLapPhieu` datetime DEFAULT NULL,
  `tienDatCoc` int(11) DEFAULT NULL,
  `tinhTrangXuLy` int(11) DEFAULT NULL,
  `xuLy` int(11) DEFAULT NULL,
  PRIMARY KEY (`maCTT`),
  KEY `maKH` (`maKH`),
  KEY `maNV` (`maNV`),
  CONSTRAINT `chitietthue_ibfk_1` FOREIGN KEY (`maKH`) REFERENCES `khachhang` (`maKH`),
  CONSTRAINT `chitietthue_ibfk_2` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`maNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.chitietthue: ~8 rows (approximately)
INSERT INTO `chitietthue` (`maCTT`, `maKH`, `maNV`, `ngayLapPhieu`, `tienDatCoc`, `tinhTrangXuLy`, `xuLy`) VALUES
	('CTT10122300003', 'KH02701030003', 'NV01411230001', '2023-12-10 22:32:19', 0, 1, 0),
	('CTT10122300004', 'KH02701030003', 'NV01411230001', '2023-12-10 22:50:53', 0, 1, 0),
	('CTT10122300005', 'KH02701030003', 'NV01411230001', '2023-12-10 22:52:43', 0, 1, 0),
	('CTT13122300006', 'KH01405990004', 'NV01411230001', '2023-12-13 12:16:16', 0, 1, 0),
	('CTT13122300007', 'KH01405990004', 'NV01411230001', '2023-12-13 16:53:06', 0, 1, 0),
	('CTT14112300001', 'KH00111030001', 'NV01411230001', '2023-11-14 14:54:28', 100000, 1, 0),
	('CTT19112300002', 'KH10111030002', 'NV01411230001', '2023-11-19 21:51:00', 100000, 1, 0),
	('CTT23022400008', 'KH01405990004', 'NV01411230001', '2024-02-23 20:17:30', 0, 0, 0);

-- Dumping structure for table qlks_cnpm.chitietthuedichvu
CREATE TABLE IF NOT EXISTS `chitietthuedichvu` (
  `maCTT` varchar(20) NOT NULL,
  `maDV` varchar(20) NOT NULL,
  `ngaySuDung` datetime NOT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `giaDV` int(11) DEFAULT NULL,
  PRIMARY KEY (`maCTT`,`maDV`,`ngaySuDung`),
  KEY `maDV` (`maDV`),
  CONSTRAINT `chitietthuedichvu_ibfk_1` FOREIGN KEY (`maCTT`) REFERENCES `chitietthue` (`maCTT`),
  CONSTRAINT `chitietthuedichvu_ibfk_2` FOREIGN KEY (`maDV`) REFERENCES `dichvu` (`maDV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.chitietthuedichvu: ~0 rows (approximately)

-- Dumping structure for table qlks_cnpm.chitietthuephong
CREATE TABLE IF NOT EXISTS `chitietthuephong` (
  `maCTT` varchar(20) NOT NULL,
  `maP` varchar(20) NOT NULL,
  `ngayThue` datetime NOT NULL,
  `ngayTra` datetime DEFAULT NULL,
  `ngayCheckOut` datetime DEFAULT NULL,
  `loaiHinhThue` int(11) DEFAULT NULL,
  `giaThue` int(11) DEFAULT NULL,
  `tinhTrang` int(11) DEFAULT NULL,
  PRIMARY KEY (`maCTT`,`maP`,`ngayThue`),
  KEY `maP` (`maP`),
  CONSTRAINT `chitietthuephong_ibfk_1` FOREIGN KEY (`maCTT`) REFERENCES `chitietthue` (`maCTT`),
  CONSTRAINT `chitietthuephong_ibfk_2` FOREIGN KEY (`maP`) REFERENCES `phong` (`maP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.chitietthuephong: ~6 rows (approximately)
INSERT INTO `chitietthuephong` (`maCTT`, `maP`, `ngayThue`, `ngayTra`, `ngayCheckOut`, `loaiHinhThue`, `giaThue`, `tinhTrang`) VALUES
	('CTT10122300003', 'P1911230004', '2023-12-11 05:00:00', '2023-12-10 22:33:16', '2023-12-10 22:33:16', 2, 700000, 2),
	('CTT10122300004', 'P1911230003', '2023-12-11 05:00:00', '2023-12-10 22:51:14', '2023-12-10 22:51:14', 2, 500000, 2),
	('CTT10122300005', 'P1911230003', '2023-12-11 05:00:00', '2023-12-13 12:33:33', '2023-12-13 12:33:33', 2, 1250000, 2),
	('CTT13122300006', 'P1911230004', '2023-12-14 05:00:00', '2023-12-13 12:16:46', '2023-12-13 12:16:46', 2, 700000, 2),
	('CTT13122300007', 'P1911230004', '2023-12-14 05:00:00', '2023-12-15 07:00:00', '2023-12-13 16:54:33', 0, 700000, 2),
	('CTT23022400008', 'P1911230003', '2024-02-28 04:58:00', '2024-02-29 06:58:00', '2024-02-23 20:18:10', 0, 500000, 2);

-- Dumping structure for table qlks_cnpm.chitiettienich
CREATE TABLE IF NOT EXISTS `chitiettienich` (
  `maP` varchar(20) NOT NULL,
  `maTI` varchar(20) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  PRIMARY KEY (`maP`,`maTI`),
  KEY `maTI` (`maTI`),
  CONSTRAINT `chitiettienich_ibfk_1` FOREIGN KEY (`maP`) REFERENCES `phong` (`maP`),
  CONSTRAINT `chitiettienich_ibfk_2` FOREIGN KEY (`maTI`) REFERENCES `tienich` (`maTI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.chitiettienich: ~12 rows (approximately)
INSERT INTO `chitiettienich` (`maP`, `maTI`, `soLuong`) VALUES
	('P081223005', 'TI00001', 1),
	('P081223005', 'TI00002', 1),
	('P081223005', 'TI00003', 1),
	('P1411230001', 'TI00001', 0),
	('P1411230001', 'TI00002', 0),
	('P1911230002', 'TI00001', 1),
	('P1911230002', 'TI00002', 1),
	('P1911230003', 'TI00001', 1),
	('P1911230003', 'TI00002', 1),
	('P1911230004', 'TI00001', 2),
	('P1911230004', 'TI00002', 1),
	('P1911230004', 'TI00003', 1);

-- Dumping structure for table qlks_cnpm.dichvu
CREATE TABLE IF NOT EXISTS `dichvu` (
  `maDV` varchar(20) NOT NULL,
  `tenDV` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `loaiDV` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `giaDV` int(11) DEFAULT NULL,
  `hinhAnh` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `xuLy` int(11) DEFAULT NULL,
  PRIMARY KEY (`maDV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.dichvu: ~3 rows (approximately)
INSERT INTO `dichvu` (`maDV`, `tenDV`, `loaiDV`, `soLuong`, `giaDV`, `hinhAnh`, `xuLy`) VALUES
	('DVAU00001', 'buffer', 'Ăn uống', 0, 10000, 'C:\\Users\\duong\\eclipse-workspace\\QuanLyKSFinal\\src\\GUI\\assets\\IconUpdate.png', 0),
	('DVSD00003', 'spa', 'Chăm sóc sắc đẹp', 0, 1000000, 'C:\\Users\\duong\\eclipse-workspace\\QuanLyKSFinal\\src\\GUI\\assets\\coKhach.png', 0),
	('DVTD00002', 'coca', 'Thức ăn đồ uống', 6, 20000, 'C:\\Users\\duong\\eclipse-workspace\\QuanLyKSFinal\\src\\GUI\\assets\\ImgThanhToan.png', 0);

-- Dumping structure for table qlks_cnpm.hoadon
CREATE TABLE IF NOT EXISTS `hoadon` (
  `maHD` varchar(20) NOT NULL,
  `maCTT` varchar(20) DEFAULT NULL,
  `tienP` int(11) DEFAULT NULL,
  `tienDV` int(11) DEFAULT NULL,
  `giamGia` int(11) DEFAULT NULL,
  `phuThu` int(11) DEFAULT NULL,
  `tongTien` int(11) DEFAULT NULL,
  `ngayThanhToan` datetime DEFAULT NULL,
  `phuongThucThanhToan` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `xuLy` int(11) DEFAULT NULL,
  PRIMARY KEY (`maHD`),
  KEY `maCTT` (`maCTT`),
  CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`maCTT`) REFERENCES `chitietthue` (`maCTT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.hoadon: ~5 rows (approximately)
INSERT INTO `hoadon` (`maHD`, `maCTT`, `tienP`, `tienDV`, `giamGia`, `phuThu`, `tongTien`, `ngayThanhToan`, `phuongThucThanhToan`, `xuLy`) VALUES
	('HD1012230001', 'CTT10122300003', 700000, 0, 0, 5, 735000, '2023-12-10 22:33:21', 'Credit Card', 0),
	('HD1012230002', 'CTT10122300004', 500000, 0, 0, 0, 500000, '2023-12-10 22:51:17', 'Tiền mặt', 0),
	('HD1312230003', 'CTT13122300006', 700000, 0, 0, 10, 770000, '2023-12-13 12:16:51', 'Tiền mặt', 0),
	('HD1312230004', 'CTT10122300005', 1250000, 0, 0, 0, 1250000, '2023-12-13 12:33:37', 'Tiền mặt', 0),
	('HD1312230005', 'CTT13122300007', 700000, 0, 0, 0, 700000, '2023-12-13 16:54:38', 'Tiền mặt', 0);

-- Dumping structure for table qlks_cnpm.khachhang
CREATE TABLE IF NOT EXISTS `khachhang` (
  `maKH` varchar(20) NOT NULL,
  `tenKH` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CMND` char(20) DEFAULT NULL,
  `gioiTinh` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sDT` char(20) DEFAULT NULL,
  `queQuan` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `quocTich` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngaySinh` datetime DEFAULT NULL,
  `xuLy` int(11) DEFAULT NULL,
  PRIMARY KEY (`maKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.khachhang: ~4 rows (approximately)
INSERT INTO `khachhang` (`maKH`, `tenKH`, `CMND`, `gioiTinh`, `sDT`, `queQuan`, `quocTich`, `ngaySinh`, `xuLy`) VALUES
	('KH00111030001', 'Nguyen Van B', '5345223434', 'Nam', '5343535433', 'Cà Mau', 'Việt Nam', '2003-11-01 00:00:00', 0),
	('KH01405990004', 'Chu Bin', '1234567890', 'Nam', '0123456789', 'Hải Phòng', 'Việt Nam', '1999-05-14 00:00:00', 0),
	('KH02701030003', 'Dương Thành Trưởng', '123456789000', 'Nam', '1234567890', 'Phú Yên', 'Việt Nam', '2003-01-27 00:00:00', 0),
	('KH10111030002', 'Trần Thị B', '343243243', 'Nữ', '5747645643', 'Lào Cai', 'Việt Nam', '2003-11-01 00:00:00', 0);

-- Dumping structure for table qlks_cnpm.nhanvien
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `maNV` varchar(20) NOT NULL,
  `tenNV` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gioiTinh` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `soNgayPhep` smallint(6) DEFAULT NULL,
  `chucVu` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngaySinh` datetime DEFAULT NULL,
  `ngayVaoLam` datetime DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `luong1Ngay` int(11) DEFAULT NULL,
  `xuLy` int(11) DEFAULT NULL,
  PRIMARY KEY (`maNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.nhanvien: ~4 rows (approximately)
INSERT INTO `nhanvien` (`maNV`, `tenNV`, `gioiTinh`, `soNgayPhep`, `chucVu`, `ngaySinh`, `ngayVaoLam`, `email`, `luong1Ngay`, `xuLy`) VALUES
	('NV01111230001', 'Trần Văn Bánh', 'Nam', 4, 'Quản lý', '2005-11-11 00:00:00', '2023-11-11 00:00:00', 'truongnopro1111@gmail.com', 500000, 0),
	('NV01111230002', 'a', 'Nam', 1, 'admin', '2001-05-04 15:49:19', '2024-05-04 15:49:21', 'truongnopro1111@gmail.com', 2000000, 0),
	('NV01312230001', 'Lý Tiểu Long', 'Nam', 5, 'Lễ tân', '2003-01-27 00:00:00', '2023-12-13 00:00:00', 'truongnopro1111@gmail.com', 1000000, 0),
	('NV01411230001', 'Nguyễn Văn A', 'Nam', 2, 'Quản lý', '2003-11-14 00:00:00', '2023-11-14 00:00:00', 'truongnopro1111@gmail.com', 100000, 0);

-- Dumping structure for table qlks_cnpm.phieunhap
CREATE TABLE IF NOT EXISTS `phieunhap` (
  `maPN` varchar(20) NOT NULL,
  `maNV` varchar(20) DEFAULT NULL,
  `ngayLap` datetime DEFAULT NULL,
  `tinhTrangXuLy` int(11) DEFAULT NULL,
  `xuLy` int(11) DEFAULT NULL,
  PRIMARY KEY (`maPN`),
  KEY `maNV` (`maNV`),
  CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`maNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.phieunhap: ~1 rows (approximately)
INSERT INTO `phieunhap` (`maPN`, `maNV`, `ngayLap`, `tinhTrangXuLy`, `xuLy`) VALUES
	('#PN1312230001', 'NV01111230001', '2023-12-13 12:08:59', 0, 0);

-- Dumping structure for table qlks_cnpm.phong
CREATE TABLE IF NOT EXISTS `phong` (
  `maP` varchar(20) NOT NULL,
  `tenP` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `loaiP` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `giaP` int(11) DEFAULT NULL,
  `chiTietLoaiP` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tinhTrang` int(11) DEFAULT NULL,
  `hienTrang` int(11) DEFAULT NULL,
  `xuLy` int(11) DEFAULT NULL,
  PRIMARY KEY (`maP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.phong: ~5 rows (approximately)
INSERT INTO `phong` (`maP`, `tenP`, `loaiP`, `giaP`, `chiTietLoaiP`, `tinhTrang`, `hienTrang`, `xuLy`) VALUES
	('P081223005', 'Phòng đôi', 'Thường', 1000000, 'Phòng đôi', 0, 0, 0),
	('P1411230001', 'Phòng vip 102', 'vip', 500000, 'gia đình', 2, 0, 1),
	('P1911230002', 'Phòng thường 102', 'Thường', 300000, 'Phòng đôi', 2, 0, 1),
	('P1911230003', 'Phòng vip 101', 'VIP', 500000, 'Phòng đơn', 2, 0, 0),
	('P1911230004', 'Phòng gia đình 103', 'Thường', 700000, 'Phòng gia đình', 2, 0, 0);

-- Dumping structure for table qlks_cnpm.taikhoan
CREATE TABLE IF NOT EXISTS `taikhoan` (
  `taiKhoan` varchar(20) NOT NULL,
  `maNV` varchar(20) DEFAULT NULL,
  `matKhau` varbinary(512) DEFAULT NULL,
  `tinhTrang` int(11) DEFAULT NULL,
  `vaiTro` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`taiKhoan`),
  KEY `maNV` (`maNV`),
  CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`maNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.taikhoan: ~4 rows (approximately)
INSERT INTO `taikhoan` (`taiKhoan`, `maNV`, `matKhau`, `tinhTrang`, `vaiTro`) VALUES
	('admin', 'NV01111230002', _binary 0x3627909a29c31381a071ec27f7c9ca97726182aed29a7ddd2e54353322cfb30abb9e3a6df2ac2c20fe23436311d678564d0c8d305930575f60e2d3d048184d79, 0, 'Admin'),
	('BanhBanh', 'NV01111230001', _binary 0x3627909a29c31381a071ec27f7c9ca97726182aed29a7ddd2e54353322cfb30abb9e3a6df2ac2c20fe23436311d678564d0c8d305930575f60e2d3d048184d79, 0, 'Manager'),
	('longQuyen', 'NV01312230001', _binary 0x340a1267cbb20fc5bc2430f63cd0fb6988c3bdaf2a34236bffb3ad3226ae36c2627c93fa54675195a2894e1077dfd19f54cd5196aec5502db2d980211f9733c7, 0, 'Manager'),
	('vana', 'NV01411230001', _binary 0x3627909a29c31381a071ec27f7c9ca97726182aed29a7ddd2e54353322cfb30abb9e3a6df2ac2c20fe23436311d678564d0c8d305930575f60e2d3d048184d79, 0, 'Receptionist');

-- Dumping structure for table qlks_cnpm.tienich
CREATE TABLE IF NOT EXISTS `tienich` (
  `maTI` varchar(20) NOT NULL,
  `tenTI` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `soLuong` smallint(6) DEFAULT NULL,
  `xuLy` int(11) DEFAULT NULL,
  PRIMARY KEY (`maTI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlks_cnpm.tienich: ~3 rows (approximately)
INSERT INTO `tienich` (`maTI`, `tenTI`, `soLuong`, `xuLy`) VALUES
	('TI00001', 'Tivi mini', 602, 0),
	('TI00002', 'Tủ lạnh', 96, 0),
	('TI00003', 'Máy quạt hơi nước', 22, 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
