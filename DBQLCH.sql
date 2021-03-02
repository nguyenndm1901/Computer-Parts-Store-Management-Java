use [master]
GO

create database DBQLCH
GO

use DBQLCH
GO

create table [dbo].[DangNhap]
(
	userid varchar(30),
	userpassword varchar(30)
)

create table [dbo].[KhachHang]
(	
	ngayMua date not null,
	maHD varchar(10) not null,
	tenKH nvarchar(50) not null,
	sdt char(15) not null
)



create table [dbo].[SanPham]
(
	maSP varchar(10) primary key not null,
	tenSP nvarchar(50) not null,
	giaTien int not null,
	dvt nchar(10) not null,
	thoiGianBH int not null,
)

create table [dbo].[NhanVien]
(
	maNV varchar(5) not null,
	tenNV nvarchar(50) not null,
	doanhThu int not null
)

create table [dbo].[HoaDon]
(
	maHD varchar(10) primary key not null,
	ngayXuatHD date not null,
	tongTien int not null,
	tenKH nvarchar(50) not null,
	tenNV nvarchar(50) not null,
)	

create table [dbo].[ThongKe]
(	
	ngay date,
	maHD varchar(10) NULL,
	tenKH nvarchar(50) NULL,
	tenSP nvarchar(50) NULL,
	donGia int NULL,
	soLuong int NULL,
	dvt nchar(10) NULL,
	thanhTien int NULL
)

create table [dbo].[GioHang]
(
	ngay date,
	maHD varchar(10),
	tenSP nvarchar(50) not null,
	giaTien int not null,
	soLuong int not null,
	dvt nchar(10) not null,
	thoiGianBH int not null,
	thanhTien int not null
)

INSERT INTO [dbo].[NhanVien] ([maNV],[tenNV],[doanhThu]) VALUES('NV001',N'Nhân Viên 1',0)
INSERT INTO [dbo].[NhanVien] ([maNV],[tenNV],[doanhThu]) VALUES('NV002',N'Nhân Viên 2',0)
INSERT INTO [dbo].[NhanVien] ([maNV],[tenNV],[doanhThu]) VALUES('NV003',N'Nhân Viên 3',0)
INSERT INTO [dbo].[NhanVien] ([maNV],[tenNV],[doanhThu]) VALUES('NV004',N'Nhân Viên 4',0)
INSERT INTO [dbo].[NhanVien] ([maNV],[tenNV],[doanhThu]) VALUES('NV005',N'Nhân Viên 5',0)


INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP001','Asus Vivobook X407MA',7200000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP002','Acer Aspire A315-53',7490000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP003','Asus Vivobook X507MA',6390000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP004','Acer Aspire E5-476',9990000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP005','Acer Aspire A315-54K',9999000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP006','Lenovo Ideapad 330S',11000000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP007','Lenovo V330 15IKB',11390000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP008','HP Pavilion 15 CS3010TU',13490000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP009','Dell Inspiron 5593',13990000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP010','Acer Aspire A515-53G',14790000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP011','AMD Athlon 200GE 3.2GHz',1460000,N'cái',36)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP012','AMD Ryzen 3 2200G 3.5 GHz',2450000,N'cái',36)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP013','AMD Ryzen 3 3200G 3.6GHz',2590000,N'cái',36)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP014','AMD Ryzen 5 2400G 3.6 GHz',3950000,N'cái',36)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP015','AMD Ryzen 5 3400G 3.7GHz',4090000,N'cái',36)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP016','AMD Ryzen 5 3600 3.6GHz',5390000,N'cái',36)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP017','AMD Ryzen 5 3600x 3.8GHz',6490000,N'cái',36)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP018','AMD Ryzen 7 3700x 3.6GHz',8690000,N'cái',36)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP019','AMD Ryzen 7 3800x 3.9GHz',10290000,N'cái',36)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP020','AMD Ryzen 9 3900x 3.8GHz',13090000,N'cái',36)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP021','Dell E2216H 22" TN',2370000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP022','LG 22MK430H-B 22" IPS',2550000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP023','Asus VP228NE 22" TN',2650000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP024','Viewsonic VA2456-H 24" IPS',2790000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP025','ASUS VA24EHE 24" IPS',3290000,N'cái',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP026','RAM Geil 4GB 2666',550000,N'bộ',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP027','RAM Corsair 4GB 2666',770000,N'bộ',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP028','RAM Crucial 8GB 2400',850000,N'bộ',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP029','GSKILL TRIDENT 8GB 3000',1000000,N'bộ',24)
INSERT INTO [dbo].[SanPham] ([maSP],[tenSP],[giaTien],[dvt],[thoiGianBH]) VALUES ('SP030','RAM APACER 8GB 3200',1490000,N'bộ',24)

INSERT INTO [dbo].[DangNhap] ([userid],[userpassword]) VALUES('userid','password')
INSERT INTO [dbo].[DangNhap] ([userid],[userpassword]) VALUES('testid','testpassword')
INSERT INTO [dbo].[DangNhap] ([userid],[userpassword]) VALUES('minhnguyen','password')
INSERT INTO [dbo].[DangNhap] ([userid],[userpassword]) VALUES('minhduy','password')
