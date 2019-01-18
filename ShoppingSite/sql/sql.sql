set names utf8;
set foreign_key_checks = 0;
drop database if exists ShoppingSite;

create database if not exists ShoppingSite;
use ShoppingSite;

drop table if exists users;

create table users(
	id int not null primary key auto_increment,
	login_id varchar(16) unique,
	login_pass varchar(255),
	user_name varchar(60),
	insert_date datetime DEFAULT CURRENT_TIMESTAMP
);

insert into users(login_id, login_pass, user_name) VALUES("admin","2e7d01869cd65058cb884c7c039b804bc76d2a259f6143e84a86980e7cdfe23a", "管理者");

drop table if exists items;

create table items(
	id int not null primary key auto_increment,
	item_name varchar(255),
	item_price int,
	item_count int,
	insert_date datetime DEFAULT CURRENT_TIMESTAMP,
	last_add_date datetime DEFAULT CURRENT_TIMESTAMP,
	last_sell_date datetime
);

insert into items(item_name, item_price, item_count) VALUES("鉛筆", 120, 59);

drop table if exists carts;

create table carts(
	user_id int not null,
	item_id int not null,
	item_count int not null
);

drop table if exists item_description;

create table description(
	id int not null primary key,
	description text,
	seller int not null,
	image_num int not null DEFAULT 0
);
INSERT INTO `description`(`id`, `description`, `seller`, `image_num`) VALUES (1, "すらすら書ける鉛筆", 0, 3);

drop table if exists item_review;

create table item_review(
	id int not null primary key auto_increment,
	item_id int not null,
	user_id int not null,
	title VARCHAR(255) not null,
	point int not null,
	comment text,
	insert_date datetime DEFAULT CURRENT_TIMESTAMP
);

drop table if exists sellers;

create table sellers(
	id int not null primary key auto_increment,
	name VARCHAR(255) not null
)