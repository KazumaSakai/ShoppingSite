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

insert into users(login_id, login_pass, user_name) VALUES("admin","pass", "管理者");

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