
create database online_ordering;
use online_ordering;

CREATE TABLE `user`(
   `user_id` INT UNIQUE NOT NULL AUTO_INCREMENT,
   `username` VARCHAR(200) NOT NULL,
   `password` VARCHAR(200) NOT NULL,
   `truename` VARCHAR(200),
   `email` VARCHAR(200),
   `phone` VARCHAR(200) NOT NULL,
   `address` VARCHAR(200) NOT NULL,
   PRIMARY KEY ( `user_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `meal`(
   `meal_id` INT UNIQUE NOT NULL AUTO_INCREMENT,
   `series_id` int NOT NULL,
   `meal_name` VARCHAR(200) NOT NULL,
   `meal_description` VARCHAR(200),
   `meal_price` DECIMAL(8,2) NOT NULL,
   `meal_image` VARCHAR(200) NOT NULL,
   PRIMARY KEY ( `meal_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `meal`(meal_id,series_id,meal_name,meal_description,meal_price,meal_image)
    values(1,2,'红烧鱼','烧了七七四十九天',36.00,'/upload/01.jpg');
insert into `meal`(meal_id,series_id,meal_name,meal_description,meal_price,meal_image)
    values(2,5,'焖羊肉卷','',38.00,'/upload/02.jpg');
insert into `meal`(meal_id,series_id,meal_name,meal_description,meal_price,meal_image)
    values(3,2,'蟹肉沙漠','',42.00,'/upload/03.jpg');
insert into `meal`(meal_id,series_id,meal_name,meal_description,meal_price,meal_image)
    values(4,1,'豆角肉丝','',12.00,'/upload/04.jpg');
insert into `meal`(meal_id,series_id,meal_name,meal_description,meal_price,meal_image)
    values(5,6,'鸭舌杂烩','',24.00,'/upload/05.jpg');
insert into `meal`(meal_id,series_id,meal_name,meal_description,meal_price,meal_image)
    values(6,4,'辣子鸡丁','',26.00,'/upload/06.jpg');


CREATE TABLE `meal_series`(
      `series_id` INT UNIQUE NOT NULL AUTO_INCREMENT,
      `series_name` VARCHAR(200) NOT NULL,
      PRIMARY KEY ( `series_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `meal_series`(series_id,series_name) values(1,'湘菜');
insert into `meal_series`(series_id,series_name) values(2,'川菜');
insert into `meal_series`(series_id,series_name) values(3,'鲁菜');
insert into `meal_series`(series_id,series_name) values(4,'粤菜');
insert into `meal_series`(series_id,series_name) values(5,'闽菜');
insert into `meal_series`(series_id,series_name) values(6,'浙菜');

CREATE TABLE `cart`(
       `cart_id` INT UNIQUE NOT NULL AUTO_INCREMENT,
       `user_id` int NOT NULL,
       `meal_id` int NOT NULL,
       `price` DECIMAL(8,2) NOT NULL,
       `count` int NOT NULL,
       PRIMARY KEY ( `cart_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order`(
        `order_id` INT UNIQUE NOT NULL AUTO_INCREMENT,
        `user_id` int NOT NULL,
        `order_time` DATETIME NOT NULL,
        `order_address` VARCHAR(200) NOT NULL,
        `order_phone` VARCHAR(200) NOT NULL,
        `order_name` VARCHAR(200) NOT NULL,
        `order_state` VARCHAR(200),
        `order_price` DECIMAL(8,2) NOT NULL,
        PRIMARY KEY ( `order_id` )
)ENGINE=InnoDB AUTO_INCREMENT = 2021042101 CHARSET=utf8;


