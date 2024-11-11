CREATE TABLE stores(
	id int auto_increment primary key,
    store_code char(30),
    store_name char(30),
	address char(100),
    created_date datetime default current_timestamp,
    modified_date datetime default null on update current_timestamp
    );
    
CREATE TABLE categories(
	id int auto_increment primary key,
    category_code char(30),
    category_name char(30),
    descript char(100),
    created_date datetime default current_timestamp,
    modified_date datetime default null on update current_timestamp
    );
    
CREATE TABLE products(
	id int not null auto_increment primary key,
    price int not null,
    product_code char(30),
    category int,
    store int,
	product_name char(30),
    descript char(100),
    image_link char(100) default null,
    val_amount int,
    sold_amount int,
    created_date datetime default current_timestamp,
    modified_date datetime default null on update current_timestamp,
    foreign key(category) references categories(id),
    foreign key(store) references stores(id)
	);

INSERT INTO stores(store_code, store_name, address)
VALUES ('k1', 'Kho Hà Nội', 'Hà Nội'),
('k2', 'Kho Đà Nẵng', 'Đà Nẵng'),
('k3', 'Kho Hồ Chí Minh', 'Hồ Chí Minh'),
('k4', 'Kho Huế', 'Huế'),
('k5', 'Kho Hải Phòng', 'Hải Phòng');

-- UPDATE stores
-- SET 
-- store_name = 'Kho TP Hồ Chí Minh',
-- address = 'TP Hồ Chí Minh'
-- WHERE id = 3;

-- DELETE FROM stores
-- where id = 5;

INSERT INTO categories(category_code, category_name, descript)
VALUES ('DM1', 'SamSung', 'Rất là sịn'),
('DM2', 'Apple', 'Đẳng cấp'),
('DM3', 'Asus', 'Rẻ mà ngon'),
('DM4', 'Xiaomi', 'Đoán xem'),
('DM5', 'Oppo', 'Sky ơi'); 

-- UPDATE categories
-- SET 
-- descript = 'Skyyy'
-- where id = 5;

-- DELETE FROM categories
-- WHERE id = 4; 

INSERT INTO products(product_code, category, store, product_name, descript, val_amount, sold_amount, price)
VALUES ('SP1', 1, 1, 'Điện thoại Samsung fold', 'abccba', 50, 20, 50000000),
('SP2', 2, 2, 'Điện thoại Iphone 13 Promax', 'Đây là mô tả', 100, 70, 46000000),
('SPA', 2, 4, 'Điện thoại Iphone 11', 'Đây là mô tả', 100, 70, 30000000),
('SP3', 3, 3, 'Laptop asus', 'Đây là laptop', 40, 30, 23000000),
('SP4', 1, 2, 'Điện thoại SamSung galaxy S13', 'abcxyz', 30, 10, 35000000),
('SP5', 2, 1, 'Macbook', 'Mạc bục', 60, 30, 45000000);

INSERT INTO products(product_code, category, store, product_name, descript, val_amount, sold_amount, price)
VALUES ('SP6', 3, 4, 'Điện thoại Samsung Galaxy Note', 'abccba', 50, 20, 28000000),
('SP7', 3, 2, 'Điện thoại Selfie', 'Đây là mô tả', 100, 70, 5000000),
('SP8', 4, 4, 'Laptop cảm ứng', 'Đây là laptop', 40, 30, 15000000),
('SP9', 1, 4, 'Chuột', 'abcxyz', 30, 10, 1000000),
('SP10', 2, 3, 'Tai nghe', 'Mạc bục', 60, 30, 600000);

INSERT INTO products(product_code, category, store, product_name, descript, val_amount, sold_amount, price)
VALUES ('SP11', 3, 4, 'Điện thoại Samsung Galaxy2', 'abccba', 50, 20, 28000000),
('SP12', 3, 2, 'Điện thoại Selfie2', 'Đây là mô tả', 100, 70, 5000000),
('SP13', 4, 4, 'Laptop cảm ứng2', 'Đây là laptop', 40, 30, 15000000),
('SP14', 1, 4, 'Chuột2', 'abcxyz', 30, 10, 1000000),
('SP15', 2, 3, 'Tai nghe2', 'Mạc bục', 60, 30, 600000);

-- UPDATE products
-- SET
-- val_amount = 60,
-- sold_amount = 35
-- WHERE id = 1;

-- DELETE FROM SanPham
-- WHERE id = 4; 

SELECT *
FROM products P INNER JOIN categories C 
ON P.category = C.id
where C.category_name = 'Apple'
AND P.product_name LIKE '%Điện thoại%';

Select C.*, sum(P.val_amount) as amount
FROM products P RIGHT JOIN categories C
ON P.category = C.id
GROUP BY C.id
ORDER BY val_amount DESC;

SELECT * from products where category = 3;

-- START TRANSACTION;
-- DELETE FROM SanPham WHERE danhmuc = 3;
-- DELETE FROM LoaiDanhMuc WHERE id = 3;
-- COMMIT;

DELIMITER //
CREATE PROCEDURE getTopSell (IN k INT)
BEGIN
	SELECT * FROM products 
    ORDER BY sold_amount DESC
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
	DELETE FROM products WHERE category = _id;
	DELETE FROM categories WHERE id = _id;
	    IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
END //
DELIMITER ;

CALL getTopSell(3);

CALL deleteTran(4);

CREATE TABLE products_in_stores(
	id int auto_increment primary key,
    store int,
    product_num int,
	created_date datetime default current_timestamp
    )
