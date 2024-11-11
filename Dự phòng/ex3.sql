CREATE TABLE Kho(
	Id int not null auto_increment primary key,
    makho char(30),
    ten char(30),
    diadiem char(100),
    ngaytao datetime default current_timestamp,
    ngaysua datetime default null on update current_timestamp
    );
    
CREATE TABLE LoaiDanhMuc(
	Id int not null auto_increment primary key,
    maloaidanhmuc char(30),
    ten char(30),
    mota char(100),
    ngaytao datetime default current_timestamp,
    ngaysua datetime default null on update current_timestamp
    );

CREATE  TABLE SanPham(
	Id int not null auto_increment primary key,
    masanpham char(30),
    danhmuc int,
    kho int,
	ten char(30),
    motasanpham char(100),
    duongdananh char(100) default null,
    soluongsanpham int,
    soluongban int,
    ngaytao datetime default current_timestamp,
    ngaysua datetime default null on update current_timestamp,
    foreign key(danhmuc) references LoaiDanhMuc(Id),
    foreign key(kho) references Kho(Id)
	);

INSERT INTO Kho(makho, ten, diadiem)
VALUES ('k1', 'Kho Hà Nội', 'Hà Nội'),
('k2', 'Kho Đà Nẵng', 'Đà Nẵng'),
('k3', 'Kho Hồ Chí Minh', 'Hồ Chí Minh'),
('k4', 'Kho Huế', 'Huế'),
('k5', 'Kho Hải Phòng', 'Hải Phòng');

UPDATE Kho
SET 
ten = 'Kho TP Hồ Chí Minh',
diadiem = 'TP Hồ Chí Minh'
WHERE Id = 3;

DELETE FROM Kho
where Id = 5;

INSERT INTO LoaiDanhMuc(maloaidanhmuc, ten, mota)
VALUES ('DM1', 'SamSung', 'Rất là sịn'),
('DM2', 'Apple', 'Đẳng cấp'),
('DM3', 'Asus', 'Rẻ mà ngon'),
('DM4', 'Xiaomi', 'Đoán xem'),
('DM5', 'Oppo', 'Sky ơi'); 

UPDATE LoaiDanhMuc
SET 
mota = 'Skyyy'
where Id = 5;

DELETE FROM LoaiDanhMuc
WHERE Id = 4; 

INSERT INTO SanPham(masanpham, danhmuc, kho, ten, motasanpham, soluongsanpham, soluongban)
VALUES ('SP1', 1, 1, 'Điện thoại Samsung fold', 'abccba', 50, 20),
('SP2', 2, 2, 'Điện thoại Iphone 13 Promax', 'Đây là mô tả', 100, 70),
('SP3', 3, 3, 'Laptop asus', 'Đây là laptop', 40, 30),
('SP4', 1, 2, 'Điện thoại SamSung galaxy S13', 'abcxyz', 30, 10),
('SP5', 2, 1, 'Macbook', 'Mạc bục', 60, 30);

UPDATE SanPham
SET
soluongsanpham = 60,
soluongban = 35
WHERE Id = 1;

DELETE FROM SanPham
WHERE Id = 4; 

INSERT INTO SanPham(masanpham, danhmuc, kho, ten, motasanpham, soluongsanpham, soluongban)
VALUES ('SP6', 2, 2, 'Macbook', 'Mạc bục', 70, 40);

SELECT *
FROM SanPham SP INNER JOIN LoaiDanhMuc DM 
ON SP.danhmuc = DM.Id
where DM.ten = 'Apple'
AND SP.ten LIKE '%Điện thoại%';

Select DM.*, sum(SP.soluongsanpham) as soluong
FROM SanPham SP RIGHT JOIN LoaiDanhMuc DM
ON SP.danhmuc = DM.Id
GROUP BY DM.Id
ORDER BY soluong DESC;

INSERT INTO SanPham(masanpham, danhmuc, kho, ten, motasanpham, soluongsanpham, soluongban)
VALUES ('SP3', 3, 3, 'Laptop asus', 'Đây là laptop', 40, 30);

SELECT * from SanPham where danhmuc = 3;

START TRANSACTION;
DELETE FROM SanPham WHERE danhmuc = 3;
DELETE FROM LoaiDanhMuc WHERE id = 3;
COMMIT;

DELIMITER //
CREATE PROCEDURE getTopSell (IN k INT)
BEGIN
	SELECT * FROM SanPham 
    ORDER BY soluongban DESC
    LIMIT k;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE deleteTran (IN _id INT)
BEGIN
    DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
--     DEClARE EXIT HANDLER FOR sqlexception ROLLBACK
	START TRANSACTION;
	DELETE FROM SanPham WHERE danhmuc = _id;
	DELETE FROM LoaiDanhMuc WHERE id = _id;
	    IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
END //
DELIMITER ;

CALL getTopSell(3);

