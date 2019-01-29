set names utf8;
set foreign_key_checks = 0;

drop database if exists ShoppingSite;
create database if not exists ShoppingSite;
use ShoppingSite;



/*
 *		AddressList
 *
 *	ユーザーの登録住所テーブル
 *
 */
drop table if exists addressList;
create table addressList(
	id int not null primary key auto_increment,
	user_id int not null,
	address VARCHAR(255) NOT NULL
);


/*
 * 		Carts
 * 
 * 	ユーザーのカートに入っている商品テーブル
 * 
 */
drop table if exists carts;
create table carts(
	user_id int not null,
	item_id int not null,
	item_count int not null
);



/*
 * 		Items
 * 
 * 	現在販売中の商品テーブル
 * 
 */
drop table if exists items;
create table items(
	id int not null primary key auto_increment,
	item_name varchar(255),
	item_price int,
	item_count int,
	description text,
	seller int not null,
	image_num int not null DEFAULT 0,
	insert_date datetime DEFAULT CURRENT_TIMESTAMP,
	last_add_date datetime DEFAULT CURRENT_TIMESTAMP,
	last_sell_date datetime
);
insert into items(item_name, item_price, item_count, description, seller, image_num) VALUES
	("鉛筆", 108, 5261, "すらすら書ける鉛筆", 1, 3),
	("消しゴム", 108, 2485, "なんでもスラスラ消せる消しゴムです。", 2, 2),
	("ノート", 216, 482, "さらさら書けるノートです！。", 1, 3),
	("お茶", 128, 2128, "お茶です。", 3, 0),
	("パソコン", 103145, 241, "パソコン", 4, 0),
	("マウス", 3210, 513, "最新マウス", 4, 0);



/*
 * 		Item_Review
 * 
 * 	商品のレビューテーブル
 * 
 */
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



/*
 * 		PurchaseHistorys
 * 
 * 	商品の購入履歴テーブル
 * 
 */
drop table if exists purchaseHistorys;
create table purchaseHistorys(
	id int not null primary key auto_increment,
	item_id int not null,
	quantity int not null,
	user_id int not null,
	address VARCHAR(255) NOT NULL,
	phoneNumber VARCHAR(255) NOT NULL,
	shipmentState int NOT NULL,
	insert_date datetime DEFAULT CURRENT_TIMESTAMP,
	request_date datetime
);



/*
 * 		Sales
 * 
 * 	各アイテムの売り上げテーブル
 * 
 */
drop table if exists sales;
create table sales(
	item_id int not null,
	year int not null,
	month int not null,
	quantity int not null,
	price int not null
);
INSERT INTO sales(item_id, year, month, quantity, price) VALUES
	(1, 2018, 1, 140, 14000),
	(1, 2018, 2, 213, 21300),
	(1, 2018, 3, 245, 24500),
	(1, 2018, 4, 312, 33696),
	(1, 2018, 5, 513, 60534),
	(1, 2018, 6, 434, 46872),
	(1, 2018, 7, 456, 49248),
	(1, 2018, 8, 436, 47088),
	(1, 2018, 9, 460, 49680),
	(1, 2018, 10, 501, 54108),
	(1, 2018, 11, 431, 46548),
	(1, 2018, 12, 321, 34668),
	(1, 2019, 1, 421, 45468),
	(1, 2019, 2, 457, 49356),
	(2, 2018, 1, 140, 15120),
	(2, 2018, 2, 213, 23004),
	(2, 2018, 3, 245, 26460),
	(2, 2018, 4, 312, 33696),
	(2, 2018, 5, 513, 60534),
	(2, 2018, 6, 434, 46872),
	(2, 2018, 7, 456, 49248),
	(2, 2018, 8, 436, 47088),
	(2, 2018, 9, 460, 49680),
	(2, 2018, 10, 501, 54108),
	(2, 2018, 11, 431, 46548),
	(2, 2018, 12, 321, 34668),
	(2, 2019, 1, 421, 45468),
	(2, 2019, 2, 457, 49356),
	(3, 2018, 1, 140, 15120),
	(3, 2018, 2, 213, 23004),
	(3, 2018, 3, 245, 26460),
	(3, 2018, 4, 312, 33696),
	(3, 2018, 5, 513, 60534),
	(3, 2018, 6, 434, 46872),
	(3, 2018, 7, 456, 49248),
	(3, 2018, 8, 436, 47088),
	(3, 2018, 9, 460, 49680),
	(3, 2018, 10, 501, 108216),
	(3, 2018, 11, 431, 93096),
	(3, 2018, 12, 321, 69336),
	(3, 2019, 1, 421, 90936),
	(3, 2019, 2, 457, 98712),
	(4, 2018, 1, 140, 15120),
	(4, 2018, 2, 213, 23004),
	(4, 2018, 3, 245, 26460),
	(4, 2018, 4, 312, 33696),
	(4, 2018, 5, 513, 60534),
	(4, 2018, 6, 434, 46872),
	(4, 2018, 7, 456, 49248),
	(4, 2018, 8, 436, 47088),
	(4, 2018, 9, 460, 49680),
	(4, 2018, 10, 501, 54108),
	(4, 2018, 11, 431, 46548),
	(4, 2018, 12, 321, 34668),
	(4, 2019, 1, 421, 45468),
	(4, 2019, 2, 457, 49356),
	(5, 2018, 1, 3, 309435),
	(5, 2018, 2, 2, 206290),
	(5, 2018, 3, 1, 103145 ),
	(5, 2018, 4, 3, 309435),
	(5, 2018, 5, 2, 206290),
	(5, 2018, 6, 4, 412580),
	(5, 2018, 7, 1, 103145 ),
	(5, 2018, 8, 0, 0),
	(5, 2018, 9, 1, 103145 ),
	(5, 2018, 10, 3, 54108),
	(5, 2018, 11, 0, 0),
	(5, 2018, 12, 5, 515725),
	(5, 2019, 1, 6, 618870),
	(5, 2019, 2, 3, 309435),
	(6, 2018, 1, 1, 3210),
	(6, 2018, 2, 4, 12840),
	(6, 2018, 3, 3, 9630 ),
	(6, 2018, 4, 7, 22470),
	(6, 2018, 5, 2, 6420),
	(6, 2018, 6, 4, 12840),
	(6, 2018, 7, 3, 9630 ),
	(6, 2018, 8, 7, 22470),
	(6, 2018, 9, 4, 12840 ),
	(6, 2018, 10, 3, 9630),
	(6, 2018, 11, 6, 19260),
	(6, 2018, 12, 7, 22470),
	(6, 2019, 1, 6, 19260),
	(6, 2019, 2, 4, 12840);

/*
 * 		Sellers
 * 
 * 	販売業者テーブル
 * 
 */
drop table if exists sellers;
create table sellers(
	id int not null primary key auto_increment,
	name VARCHAR(255) not null,
	address VARCHAR(255) not null,
	email VARCHAR(255) not null,
	phone VARCHAR(255) not null,
	description VARCHAR(255) not null
);
INSERT INTO sellers(name, address, email, phone, description) VALUES 
	("ABC通信販売", "東京都港区XXX1-1-1 YYYビル", "mail@abc.com", "0312345561", "ABC通信販売です。よろしくお願い致します。"),
	("いろは文具", "東京都江東区XXX1-1-1 YYYビル", "mail@iroha.co.jp", "0316821682", "いろは文具です。文具を扱っています。"),
	("大阪飲料販売", "大阪府大阪市XXX1-1-1 YYYビル", "mail@osakadrink.osaka.jp", "0313125931", "大阪飲料販売です。よろしくお願い致します。"),
	("Computer", "東京都港区XXX1-1-1 YYYビル", "mail@computer.com", "0331245678", "コンピューター関連の商品を取り扱っています");


/*
 * 		Users
 * 
 * 	ユーザーテーブル
 * 
 */
drop table if exists users;
create table users(
	id int not null primary key auto_increment,
	admin tinyint not null DEFAULT 0,
	oauthUser tinyint not null DEFAULT 0,
	login_id varchar(255) not null unique,
	email varchar(255) not null unique,
	login_pass varchar(255) not null,
	user_name varchar(60) not null,
	insert_date datetime DEFAULT CURRENT_TIMESTAMP
);
insert into users(admin, oauthUser, login_id, login_pass, email, user_name) VALUES(1, 0, "admin","2e7d01869cd65058cb884c7c039b804bc76d2a259f6143e84a86980e7cdfe23a", "admin@internousdev.com", "管理者");
