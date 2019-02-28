SET names utf8;
SET foreign_key_checks = 0;

DROP DATABASE IF EXISTS ShoppingSite;
CREATE DATABASE IF NOT EXISTS ShoppingSite;
USE ShoppingSite;

/*
 *		DestinationTable
 *
 *		宛先テーブル
 *
 */
DROP TABLE IF EXISTS DestinationTable;
CREATE TABLE DestinationTable
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '宛先ID',
	userId INT NOT NULL COMMENT 'ユーザーID',
	familyName VARCHAR(255) NOT NULL COMMENT '姓',
	firstName VARCHAR(255) NOT NULL COMMENT '名',
	gender INT NOT NULL COMMENT '性別 (0: 男性, 1: 女性, 2: その他)',
	postalCode VARCHAR(8) NOT NULL COMMENT '郵便番号',
	address TEXT NOT NULL COMMENT '住所',
	email VARCHAR(255) NOT NULL COMMENT 'メールアドレス',
	phoneNumber VARCHAR(16) NOT NULL COMMENT '電話番号',
	registeredDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時'
) COMMENT '宛先テーブル';
INSERT INTO DestinationTable(userId, familyName, firstName, gender, postalCode, address, email, phoneNumber) VALUES
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@internousdev.com", "81---08000010001"),
	(2, "土地所有者姓2", "土地所有者名2", 0, "160-0022", "東京都 新宿区新宿 0-0-00 xxxxxxxx 101", "mail@aaa.com", "81---00300010002"),
	(3, "土地所有者姓3", "土地所有者名3", 0, "102-0075", "東京都 千代田区三番町 0-0-00 xxxxxxxx", "mail@bbb.com", "81---00300010003"),
	(4, "土地所有者姓4", "土地所有者名4", 0, "100-0001", "東京都 千代田区千代田  0-0-00 xxxxxxxx", "mail@ccc.com", "81---00300010004"),
	(5, "土地所有者姓5", "土地所有者名5", 0, "100-0001", "東京都 千代田区千代田  0-0-00 xxxxxxxx", "mail@ddd.com", "81---00300010005"),
	(6, "土地所有者姓6", "土地所有者名6", 0, "100-0001", "東京都 千代田区千代田  0-0-00 xxxxxxxx", "mail@eee.com", "81---00300010006"),
	(7, "土地所有者姓7", "土地所有者名7", 0, "100-0001", "東京都 千代田区千代田  0-0-00 xxxxxxxx", "mail@fff.com", "81---00300010007"),
	(8, "土地所有者姓8", "土地所有者名8", 0, "100-0001", "東京都 千代田区千代田  0-0-00 xxxxxxxx", "mail@ggg.com", "81---00300010008");


/*
 * 		CartTable
 *
 * 		カートテーブル
 *
 */
DROP TABLE IF EXISTS CartTable;
CREATE TABLE CartTable
(
	userId INT NOT NULL COMMENT 'ユーザーID',
	productId INT NOT NULL COMMENT '商品ID',
	productQuantity INT NOT NULL COMMENT '商品数',
	PRIMARY KEY(userId, productId)
) COMMENT 'カートテーブル';



/*
 * 		ProductTable
 *
 * 		商品情報テーブル
 *
 */
DROP TABLE IF EXISTS ProductTable;
CREATE TABLE ProductTable
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '商品ID',
	productName VARCHAR(255) COMMENT '商品名',
	productPrice INT NOT NULL COMMENT '商品価格',
	productQuantity INT NOT NULL COMMENT '商品個数',
	productDescription TEXT COMMENT '商品詳細',
	salesCompanyId INT NOT NULL COMMENT '販売会社',
	productionCompanyId INT NOT NULL COMMENT '製造会社',
	imageQuantity INT NOT NULL DEFAULT 1 COMMENT '画像数',
	releasedDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '販売開始日時',
	lastEditDate DATETIME COMMENT '最終編集日時',
	lastReplenishmentDate DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '最終在庫補充日時',
	lastSalesDate DATETIME COMMENT '最終販売日時'
) COMMENT '商品情報テーブル';
INSERT INTO ProductTable(productName, productPrice, productQuantity, productDescription, salesCompanyId, productionCompanyId, imageQuantity) VALUES
		("鉛筆", 108, 5261, "すらすら書ける鉛筆", 1, 5, 3),
		("消しゴム", 108, 2485, "なんでもスラスラ消せる消しゴムです。", 2, 5, 2),
		("ノート", 216, 482, "さらさら書けるノートです！。", 1, 5, 3),
		("お茶", 128, 2128, "お茶です。", 3, 6, 1),
		("パソコン", 103145, 241, "パソコン", 4, 7, 1),
		("マウス", 3210, 513, "最新マウス", 4, 7, 1);



/*
 * 		ProductReviewTable
 *
 * 		商品レビューテーブル
 *
 */
DROP TABLE IF EXISTS ProductReviewTable;
CREATE TABLE ProductReviewTable
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '商品レビューID',
	productId INT NOT NULL COMMENT '商品ID',
	userId INT NOT NULL COMMENT 'ユーザーID',
	reviewTitle VARCHAR(255) NOT NULL COMMENT 'レビュータイトル',
	reviewPoint INT NOT NULL COMMENT 'レビューポイント',
	reviewComment TEXT COMMENT 'レビューコメント',
	postedDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '投稿日時',
	lastEditDate DATETIME COMMENT '最終編集日時'
) COMMENT '商品レビューテーブル';



/*
 * 		PurchaseHistoryTable
 *
 * 		商品購入履歴テーブル
 *
 */
DROP TABLE IF EXISTS purchaseHistoryTable;
CREATE TABLE purchaseHistoryTable
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '商品購入履歴ID',
	productId INT NOT NULL COMMENT '商品ID',
	productQuantity INT NOT NULL COMMENT '商品購入個数',
	userId INT NOT NULL COMMENT 'ユーザーID',
	destinationId INT NOT NULL COMMENT '宛先ID',
	shipmentState INT NOT NULL COMMENT '配達状況',
	purchasedDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品購入日時',
	requestDeliveryDate DATETIME COMMENT '要求配達日時'
) COMMENT '商品購入履歴テーブル';



/*
 * 		ProductSalesTable
 *
 * 		商品売り上げテーブル
 *
 */
DROP TABLE IF EXISTS ProductSalesTable;
CREATE TABLE ProductSalesTable
(
	productId INT NOT NULL COMMENT '商品ID',
	salesQuantity INT NOT NULL COMMENT '売上個数',
	totalSales INT NOT NULL COMMENT '売上高',
	totalRevenue INT NOT NULL COMMENT '利益',
	salesYear INT NOT NULL COMMENT '対象年',
	salesMonth INT NOT NULL COMMENT '対象月',
	PRIMARY KEY(productId, salesYear, salesMonth)
) COMMENT '商品売り上げテーブル';
INSERT INTO ProductSalesTable(productId, salesQuantity, totalSales, totalRevenue, salesYear, salesMonth) VALUES
		(1, 140, 14000, 3000, 2018, 1),
		(1, 213, 2425, 2414, 2018, 2),
		(1, 313, 2426, 64363, 2018, 3),
		(1, 313, 23425, 5252, 2018, 4),
		(1, 41, 7455, 4267, 2018, 5),
		(1, 52, 146, 525235, 2018, 6),
		(1, 4242, 75, 523525, 2018, 7),
		(1, 424, 42646, 5225, 2018, 8),
		(1, 244, 4242, 5252, 2018, 9),
		(1, 245, 42, 6363, 2018, 10),
		(1, 1340, 42342, 63636, 2018, 11),
		(1, 242, 42342, 5252, 2018, 12),
		(1, 426, 2422, 414, 2019, 1),
		(1, 140, 14000, 42141, 2019, 2),
		(2, 313, 4151, 3000, 2018, 1),
		(2, 525, 51414, 2414, 2018, 2),
		(2, 4141, 14414, 64363, 2018, 3),
		(2, 6353, 523424, 5252, 2018, 4),
		(2, 2342, 4141, 4267, 2018, 5),
		(2, 5113, 24424, 525235, 2018, 6),
		(2, 4131, 2424, 523525, 2018, 7),
		(2, 414, 535, 5225, 2018, 8),
		(2, 131, 4141, 5252, 2018, 9),
		(2, 151, 5252, 6363, 2018, 10),
		(2, 3131, 525, 63636, 2018, 11),
		(2, 313, 4141, 5252, 2018, 12),
		(2, 413, 4114, 414, 2019, 1),
		(2, 4141, 41, 42141, 2019, 2);

/*
 * 		CompanyTable
 *
 * 		会社情報テーブル
 *
 */
DROP TABLE IF EXISTS CompanyTable;
CREATE TABLE CompanyTable
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '会社ID',
	userId INT NOT NULL COMMENT 'ユーザーID',
	destinationId INT NOT NULL COMMENT '宛先ID',
	companyName VARCHAR(255) NOT NULL COMMENT '会社名',
	companyDescription VARCHAR(255) NOT NULL COMMENT '会社詳細'
) COMMENT '会社情報テーブル';
INSERT INTO CompanyTable(userId, destinationId, companyName, companyDescription) VALUES
	(2, 2, "ABC通信販売", "ABC通信販売です。よろしくお願い致します。"),
	(3, 3, "いろは文具", "いろは文具です。文具を扱っています。"),
	(4, 4, "大阪飲料販売", "大阪飲料販売です。よろしくお願い致します。"),
	(5, 5, "Computer", "コンピューター関連の商品を取り扱っています"),
	(4, 4, "大阪飲料販売", "大阪飲料販売です。よろしくお願い致します。"),
	(5, 5, "販売会社A", "販売会社Aです。よろしくお願い致します。"),
	(6, 6, "販売会社B", "販売会社Bです。よろしくお願い致します。"),
	(7, 7, "販売会社C", "販売会社Cです。よろしくお願い致します。"),
	(8, 8, "販売会社D", "販売会社Dです。よろしくお願い致します。");


/*
 * 		UserTable
 *
 * 		ユーザー情報テーブル
 *
 */
DROP TABLE IF EXISTS UserTable;
CREATE TABLE UserTable
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'ユーザーID',
	isAdmin TINYINT NOT NULL DEFAULT 0 COMMENT '管理者フラグ',
	isOauthUser TINYINT NOT NULL DEFAULT 0 COMMENT '認証登録ユーザー',
	loginId VARCHAR(60) NOT NULL UNIQUE COMMENT 'ログインID',
	loginPass VARCHAR(255) NOT NULL COMMENT 'ログインパスワード',
	email VARCHAR(60) NOT NULL UNIQUE COMMENT 'メールアドレス',
	userName VARCHAR(60) NOT NULL COMMENT 'ユーザー名',
	destinationId INT NOT NULL COMMENT '宛先ID',
	registeredDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
	lastEditDate DATETIME COMMENT '最終編集日時'
) COMMENT 'ユーザー情報テーブル';
INSERT INTO UserTable(isAdmin, isOauthUser, loginId, loginPass, email, userName, destinationId) VALUES
	(1, 0, "admin","3f74691ad7292c5f0ee29cc8fba0b03463e3b1c4a1d368838dbe11b925d244c4", "admin@internousdev.com", "管理者", 1);
