drop database QLKS_CNPM

create database QLKS_CNPM
go

use QLKS_CNPM
go

create table NHANVIEN
(
	maNV varchar(20) primary key,
	tenNV nvarchar(50),
	gioiTinh nvarchar(5),
	soNgayPhep smallint,
	chucVu nvarchar(20),
	ngaySinh datetime,
	ngayVaoLam datetime,
	email varchar(100),
	luong1Ngay int,
	xuLy int
)

create table PHONG
(
	maP varchar(20) primary key,
	tenP nvarchar(20),
	loaiP nvarchar(20),
	giaP int,
	chiTietLoaiP nvarchar(20),
	tinhTrang int,
	hienTrang int,
	xuLy int
)

create table TIENICH
(
	maTI varchar(20) primary key,
	tenTI nvarchar(30),
	soLuong smallint,
	xuLy int
)

create table CHITIETTIENICH
(
	maP varchar(20) foreign key references PHONG(maP),
	maTI varchar(20) foreign key references TIENICH(maTI),
	soLuong int,
	constraint PK_CHITIETTIENICH primary key (maP,maTI)
)

create table KHACHHANG
(
	maKH varchar(20) primary key,
	tenKH nvarchar(50),
	CMND varchar(20),
	gioiTinh nvarchar(5),
	sDT varchar(20),
	queQuan nvarchar(100),
	quocTich nvarchar(100),
	ngaySinh datetime,
	xuLy int,
)

create table DICHVU
(
	maDV varchar(20) primary key,
	tenDV nvarchar(100),
	loaiDV nvarchar(100),
	soLuong int,
	giaDV int,
	hinhAnh nvarchar(500),
	xuLy int
)

create table CHITIETTHUE
(
	maCTT varchar(20) primary key,
	maKH varchar(20) foreign key references KHACHHANG(maKH),
	maNV varchar(20) foreign key references NHANVIEN(maNV),
	ngayLapPhieu datetime,
	tienDatCoc int,
	tinhTrangXuLy int,
	xuLy int
)

create table CHITIETTHUEPHONG
(
	maCTT varchar(20) foreign key references CHITIETTHUE(maCTT),
	maP varchar(20) foreign key references PHONG(maP),
	ngayThue datetime,
	ngayTra datetime,
	ngayCheckOut datetime,
	loaiHinhThue int,
	giaThue int,
	tinhTrang int,
	constraint PK_CHITIETTHUEPHONG primary key (maCTT, maP, ngayThue),
)

create table CHITIETTHUEDICHVU
(
	maCTT varchar(20) foreign key references CHITIETTHUE(maCTT),
	maDV varchar(20) foreign key references DICHVU(maDV),
	ngaySuDung datetime,
	SoLuong int,
	giaDV int,
	constraint PK_CHITIETHUEDICHVU primary key (maCTT, maDV, ngaySuDung)
)

create table HOADON 
(
	maHD varchar(20) primary key,
	maCTT varchar(20) foreign key references CHITIETTHUE(maCTT),
	tienP int,
	tienDV int,
	giamGia int,
	phuThu int,
	tongTien int,
	ngayThanhToan datetime,
	phuongThucThanhToan nvarchar(100),
	xuLy int,
)

create table TAIKHOAN
(
	taiKhoan varchar(20) primary key,
	maNV varchar(20) foreign key references NHANVIEN(maNV),
	matKhau varbinary(512),
	tinhTrang int,
	vaiTro nvarchar(20),
)

create table PHIEUNHAP
(
	maPN varchar(20) primary key,
	maNV varchar(20) foreign key references NHANVIEN(maNV),
	ngayLap datetime,
	tinhTrangXuLy int,
	xuLy int
)

create table CHITIETNHAP
(
	maPN varchar(20) foreign key references PHIEUNHAP,
	maDV varchar(20) foreign key references DICHVU,
	giaDVNhap int ,
	soLuong int,
	constraint PK_CHITIETNHAP primary key (maPN,maDV)
)
---them nhan vien mac dinh
insert into NHANVIEN values ('NV01111230001',N'Trần Văn Bánh',N'Nam',4,N'Quản lý','2005-11-11','2023-11-11','banhbanh@gamil.com',500000,0)
---tai khoan admin, mat khau admin
insert into TAIKHOAN values ('admin',null,0xC7AD44CBAD762A5DA0A452F9E854FDC1E0E7A52A38015F23F3EAB1D80B931DD472634DFAC71CD34EBC35D16AB7FB8A90C81F975113D6C7538DC69DD8DE9077EC,0,'Admin')
---tai khoan quan ly BanhBanh, mat khau 11112005
insert into TAIKHOAN values ('BanhBanh','NV01111230001',0x6EC17753E5FFBE46EDC9F2BF8F836844B8902EA8FA6E88D3AC6A31D9968F0FD13D654819D89314E86EC441BF3C331DA646E4EE12399FA1DDF84C5F5F30DE4203,0,'Manager')