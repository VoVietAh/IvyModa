
USE IVYMODA

CREATE TABLE VaiTro (
    MaVaiTro NVARCHAR(5) PRIMARY KEY NOT NULL,
    TenVaiTro NVARCHAR(50) NOT NULL
);

SELECT * FROM ChiTietGioHang
SELECT * FROM GioHang 
SELECT * FROM SanPhamTonKho 
SELECT * FROM KhachHang
SELECT * FROM SanPham
SELECT * FROM LoaiSanPham
SELECT * FROM LoaiMau

SELECT top 1 MaSanPham FROM SanPham ORDER BY MaSanPham DESC ;





CREATE TABLE NhanVien (
    MaNV NVARCHAR(5) PRIMARY KEY NOT NULL,
    TenNV NVARCHAR(50) NOT NULL,
    Pass NVARCHAR(15) NOT NULL,
    MaVaiTro NVARCHAR(5) NOT NULL,
	Sdt NVARCHAR(11) unique,
    FOREIGN KEY (MaVaiTro) REFERENCES VaiTro(MaVaiTro)
);
CREATE TABLE KhachHang (
    MaKH NVARCHAR(10) PRIMARY KEY NOT NULL,
    TenKH NVARCHAR(50) NOT NULL,
    Email NVARCHAR(50) UNIQUE NULL,
    SDT NVARCHAR(12) UNIQUE NOT NULL,
    Pass NVARCHAR(15) NOT NULL,
    DiaChi NVARCHAR(100) NULL,
	isDelete bit,
    NgaySinh DATE NULL
);


CREATE TABLE LoaiSanPham (
    MaLoai NVARCHAR(5) PRIMARY KEY NOT NULL,
    TenLoai NVARCHAR(50) NOT NULL
);

CREATE TABLE LoaiMau (
    MaMau NVARCHAR(5) PRIMARY KEY NOT NULL,
    TenMau NVARCHAR(20) NOT NULL,
	HinhAnh NVARCHAR(255)
);

CREATE TABLE SanPham (
    MaSanPham NVARCHAR(10) PRIMARY KEY NOT NULL,
    MaLoai NVARCHAR(5) NOT NULL,
	TenSanPham NVARCHAR(255),
	HinhAnh NVARCHAR(255),
	GiaCa INT,
	isdelete bit,
	GioiTinh bit,
    FOREIGN KEY (MaLoai) REFERENCES LoaiSanPham(MaLoai)
);


--ALTER TABLE SanPham
--ADD TenSanPham NVARCHAR(50) NOT NULL;



CREATE TABLE SanPhamTonKho (
    MaSanPham NVARCHAR(10) NOT NULL,
    MaMau NVARCHAR(5) NOT NULL,
    SizeSanPham NVARCHAR(5) NOT NULL,
    SoLuong INT NOT NULL,
    PRIMARY KEY (MaSanPham, MaMau, SizeSanPham),
    FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham),
    FOREIGN KEY (MaMau) REFERENCES LoaiMau(MaMau)
);
CREATE TABLE GioHang (
    MaKH NVARCHAR(10) PRIMARY KEY NOT NULL,
    TongThanhTien INT NOT NULL,
    FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)
);
CREATE TABLE ChiTietGioHang (
    MaKH NVARCHAR(10) NOT NULL,
    MaSanPham NVARCHAR(10) NOT NULL,
    MaMau NVARCHAR(5) NOT NULL,
    SizeSanPham NVARCHAR(5) NOT NULL,
    SoLuong INT NOT NULL,
    PRIMARY KEY (MaKH, MaSanPham, MaMau, SizeSanPham),
    FOREIGN KEY (MaKH) REFERENCES GioHang(MaKH),
    FOREIGN KEY (MaSanPham, MaMau, SizeSanPham) REFERENCES SanPhamTonKho(MaSanPham, MaMau, SizeSanPham)
);


CREATE TABLE HoaDon (
    MaHoaDon NVARCHAR(10) PRIMARY KEY NOT NULL,
    MaNV NVARCHAR(5) NOT NULL,
    MaKH NVARCHAR(10) NOT NULL,
    NgayXuatHD DATE NOT NULL,
    TongThanhTien INT NOT NULL,
    TrangThaiThanhToan NVARCHAR(20) NOT NULL,
    TrangThaiDonHang NVARCHAR(255) NOT NULL,
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
    FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)
);


CREATE TABLE ChiTietHoaDon (
    MaHoaDon NVARCHAR(10) NOT NULL,
    MaSanPham NVARCHAR(10) NOT NULL,
    MaMau NVARCHAR(5) NOT NULL,
    SizeSanPham NVARCHAR(5) NOT NULL,
    SoLuong INT NOT NULL,
    PRIMARY KEY (MaHoaDon, MaSanPham, MaMau, SizeSanPham),
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaSanPham, MaMau, SizeSanPham) 
        REFERENCES SanPhamTonKho(MaSanPham, MaMau, SizeSanPham)
);

INSERT INTO SanPham (MaSanPham,TenSanPham, MaLoai,HinhAnh,giaca,isDelete,GioiTinh)
VALUES 
('SPA00001',N'Áo Hoodie thời trang nam', 'A01','anh.pgn','500000','false','true'),
('SPA00002',N'Áo Phông nam mùa hè', 'A02','anh.pgn','400000','false','true'),
('SPA00003',N'Quần Tây nam hàn quốc Baggy', 'Q01','anh.pgn','450000','false','true'),
('SPA00004',N'Quần Jean Nam ống rộng', 'Q02','anh.pgn','700000','false','true'),
('SPA00005', N'Áo Sơ Mi nam dài tay', 'A03', 'aosomi.jpg', '600000', 'false', 'true'),
('SPA00006', N'Áo Vest nam lịch lãm', 'A04', 'aovest.jpg', '1200000', 'false', 'true'),
('SPA00007', N'Quần Kaki nam thời trang', 'Q03', 'quankaki.jpg', '550000', 'false', 'true'),
('SPA00008', N'Quần Short nam thể thao', 'Q04', 'quanshort.jpg', '300000', 'false', 'true'),
('SPA00009', N'Áo Polo nam cao cấp', 'A05', 'aopolo.jpg', '450000', 'false', 'true'),
('SPA00010', N'Áo Khoác nam bomber', 'A06', 'aokhoac.jpg', '800000', 'false', 'true'),
('SPA00011', N'Áo Thun nam basic', 'A07', 'aothun.jpg', '350000', 'false', 'true'),
('SPA00012', N'Áo Gile nam thời trang', 'A08', 'aogile.jpg', '500000', 'false', 'true'),
('SPA00013', N'Quần Jogger nam thể thao', 'Q05', 'quanjogger.jpg', '450000', 'false', 'true'),
('SPA00014', N'Quần Jean nam slimfit', 'Q06', 'quanjeanslim.jpg', '750000', 'false', 'true'),
('SPA00015', N'Áo Hoodie nam nữ unisex', 'A09', 'hoodieunisex.jpg', '550000', 'false', 'true'),
('SPA00016', N'Áo Sơ Mi nam kẻ caro', 'A10', 'aosomikaro.jpg', '650000', 'false', 'true'),
('SPA00017', N'Áo Blazer nam sang trọng', 'A10', 'aoblazer.jpg', '1300000', 'false', 'true'),
('SPA00018', N'Quần Âu nam công sở', 'Q07', 'quannau.jpg', '700000', 'false', 'true'),
('SPA00019', N'Quần Lửng nam phong cách', 'Q08', 'quanlung.jpg', '400000', 'false', 'true'),
('SPA00020', N'Áo Khoác Dạ nam mùa đông', 'A10', 'aokhoacda.jpg', '900000', 'false', 'true'),
('SPA00021', N'Áo Tanktop nam tập gym', 'A10', 'aotanktop.jpg', '320000', 'false', 'true'),
('SPA00022', N'Áo Len nam cổ lọ', 'A10', 'aolencolo.jpg', '700000', 'false', 'true'),
('SPA00023', N'Quần Thể Thao nam có khóa', 'Q09', 'quanthethao.jpg', '480000', 'false', 'true'),
('SPA00024', N'Áo Phao nam chống nước', 'A10', 'aophaonam.jpg', '950000', 'false', 'true'),
('SPA00025', N'Váy Maxi nữ mùa hè', 'Q09', 'vaymaxi.jpg', '850000', 'false', 'false'),
('SPA00026', N'Đầm Công Sở nữ thanh lịch', 'Q09', 'damcongso.jpg', '750000', 'false', 'false'),
('SPA00027', N'Quần Jeans nữ dáng ôm', 'Q09', 'quanjeans.jpg', '650000', 'false', 'false'),
('SPA00028', N'Áo Thun nữ phong cách', 'Q09', 'aothunnu.jpg', '350000', 'false', 'false'),
('SPA00029', N'Chân Váy Xếp Ly nữ', 'Q09', 'chanvayxeply.jpg', '450000', 'false', 'false'),
('SPA00030', N'Áo Len nữ cổ tròn', 'Q09', 'aolencotron.jpg', '500000', 'false', 'false'),
('SPA00031', N'Áo Sơ Mi nữ công sở', 'Q09', 'aosominu.jpg', '550000', 'false', 'false'),
('SPA00032', N'Váy Bodycon nữ dự tiệc', 'Q09', 'vaybodycon.jpg', '890000', 'false', 'false'),
('SPA00033', N'Áo Hoodie nữ oversize', 'Q09', 'ahoodeinu.jpg', '620000', 'false', 'false'),
('SPA00034', N'Quần Legging nữ tập gym', 'Q09', 'quanlegging.jpg', '390000', 'false', 'false');



INSERT INTO SanPhamTonKho (MaSanPham, MaMau, SizeSanPham, SoLuong)
VALUES 
-- Áo Hoodie nam (SPA00001)
('SPA00001', 'R01', 'S', 10),
('SPA00001', 'R01', 'M', 8),

-- Áo Phông nam (SPA00002)
('SPA00002', 'B01', 'M', 12),
('SPA00002', 'B01', 'L', 15),

-- Quần Tây nam (SPA00003)
('SPA00003', 'B03', 'S', 10),
('SPA00003', 'B03', 'M', 12),

-- Quần Jean nam (SPA00004)
('SPA00004', 'B04', 'M', 14),
('SPA00004', 'B04', 'L', 10),

-- Áo Vest nam (SPA00005)
('SPA00005', 'R02', 'M', 6),
('SPA00005', 'R02', 'L', 8),

-- Quần Kaki nam (SPA00006)
('SPA00006', 'B03', 'S', 10),
('SPA00006', 'B03', 'M', 9),

-- Áo Khoác nam (SPA00007)
('SPA00007', 'B04', 'M', 12),
('SPA00007', 'B04', 'L', 10),

-- Áo Blazer nam (SPA00010)
('SPA00010', 'R02', 'S', 5),
('SPA00010', 'R02', 'M', 7),

-- Áo Hoodie nữ (SPA00011)
('SPA00011', 'R01', 'S', 10),
('SPA00011', 'R01', 'M', 9),

-- Váy Công Sở nữ (SPA00013)
('SPA00013', 'B02', 'M', 15),
('SPA00013', 'B02', 'L', 12),

-- Quần Jean nữ (SPA00020)
('SPA00020', 'B01', 'M', 14),
('SPA00020', 'B01', 'L', 10),

-- Váy Maxi nữ mùa hè
('SPA00025', 'R01', 'S', 10),
('SPA00025', 'B01', 'M', 15),

-- Đầm Công Sở nữ thanh lịch
('SPA00026', 'B03', 'M', 12),
('SPA00026', 'B05', 'L', 18),

-- Quần Jeans nữ dáng ôm
('SPA00027', 'B01', 'S', 20),
('SPA00027', 'B04', 'M', 14),

-- Áo Thun nữ phong cách
('SPA00028', 'B05', 'M', 25),
('SPA00028', 'R02', 'L', 30),

-- Chân Váy Xếp Ly nữ
('SPA00029', 'R01', 'S', 17),
('SPA00029', 'B02', 'M', 22),

-- Áo Len nữ cổ tròn
('SPA00030', 'B04', 'M', 10),
('SPA00030', 'B03', 'L', 13),

-- Áo Sơ Mi nữ công sở
('SPA00031', 'B05', 'S', 16),
('SPA00031', 'B01', 'M', 19),

-- Váy Bodycon nữ dự tiệc
('SPA00032', 'R02', 'M', 14),
('SPA00032', 'B05', 'L', 12),

-- Áo Hoodie nữ oversize
('SPA00033', 'B03', 'L', 20),
('SPA00033', 'B04', 'XL', 18),

-- Quần Legging nữ tập gym
('SPA00034', 'B05', 'M', 25),
('SPA00034', 'B02', 'L', 28);


INSERT INTO VaiTro (MaVaiTro, TenVaiTro)
VALUES 
('NVTD', N'Nhân viên trực đơn'),
('NVK', N'Nhân viên kho'),
('AD', N'ADMIN'),
('SHIP', N'Shipper');


INSERT INTO NhanVien (MaNV, TenNV, Pass, MaVaiTro,sdt)
VALUES 
('NV001', N'Trần Quốc Cường', '123456', 'NVTD','0123123123'),
('NV002', N'Nguyễn Văn A', '123456', 'NVK','0123456789'),
('NV003', N'Lê Văn B', '123456', 'SHIP','0987654321'),
('NV002', N'Trần Quốc Cườn', '123456', 'AD','0901383098');


INSERT INTO HoaDon (MaHoaDon, MaNV, MaKH, NgayXuatHD, TongThanhTien, TrangThaiThanhToan, TrangThaiDonHang)
VALUES 
('HD00001', 'NV001', 'KH00001', '2025-01-01', 450000, 'COD', N'Đợi xác nhận'),
('HD00002', 'NV002', 'KH00002', '2025-01-02', 700000, N'Chuyển khoản', N'Đã nhận đơn chuẩn bị vận chuyển');


INSERT INTO ChiTietHoaDon (MaHoaDon, MaSanPham, MaMau, SizeSanPham, SoLuong)
VALUES 
('HD00001', 'SPA00001', 'R01', 'S', 2),
('HD00001', 'SPA00001', 'R01', 'M', 1),
('HD00002', 'SPA00002', 'B01', 'L', 3);



INSERT INTO LoaiSanPham (MaLoai, TenLoai)
VALUES 
('A01', N'Áo Hoodie'),
('A02', N'Áo Phông'),
('A03', N'Áo Sơ Mi'),
('A04', N'Áo Vest'),
('A05', N'Áo Polo'),
('A06', N'Áo Khoác'),
('A07', N'Áo Len'),
('A08', N'Áo Blazer'),
('A09', N'Áo Dạ'),
('A10', N'Áo Tanktop'),
('Q01', N'Quần Tây'),
('Q02', N'Quần Jean'),
('Q03', N'Quần Kaki'),
('Q04', N'Quần Short'),
('Q05', N'Quần Jogger'),
('Q06', N'Quần Lửng'),
('Q07', N'Quần Thể Thao'),
('Q08', N'Váy Công Sở'),
('Q09', N'Chân Váy'),
('Q10', N'Quần Yếm');


INSERT INTO LoaiMau (MaMau, TenMau)
VALUES 
('R01', N'Đỏ Tươi'),
('R02', N'Đỏ Đô'),
('B01', N'Xanh Dương'),
('B02', N'Xanh Lá'),
('B03', N'Be'),
('B04', N'Nâu Đất'),
('B05', N'Trắng'),
;



INSERT INTO KhachHang (MaKH, TenKH, Email, SDT, Pass, DiaChi, NgaySinh)
VALUES 
('KH00001', N'Nguyễn Thị Hoa', 'hoa123@gmail.com', '0987654321', 'abc123', N'123 Đường A, Quận B', '1990-05-20'),
('KH00002', N'Trần Văn C', NULL, '0934567890', '123abc', N'456 Đường C, Quận D', '1995-10-15'),
('KH00003', N'Phạm Minh D', 'minhd123@gmail.com', '0901122334', 'xyz123', N'789 Đường E, Quận F', NULL);

INSERT INTO GioHang (MaKH, TongThanhTien)
VALUES 
('KH00001', 450000),
('KH00002', 700000);

INSERT INTO ChiTietGioHang (MaKH, MaSanPham, SoLuong)
VALUES 
('KH00001', 'SPA00001', 2),
('KH00001', 'SPA00002', 1),
('KH00002', 'SPA00003', 1),
('KH00002', 'SPA00004', 3);


