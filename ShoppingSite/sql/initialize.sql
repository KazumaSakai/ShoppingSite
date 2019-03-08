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
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
	(1, "酒井", "和馬", 0, "132-0022", "東京都江戸川区大杉 0-0-00 xxxxxxxx 101", "admin@xxx.com", "81---08000010001"),
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
		("鉛筆（2B）", 100, 1000, "鉛筆（2B）", 1, 1, 5),
		("鉛筆（H）", 100, 1000, "鉛筆（H）", 1, 1, 5),
		("消しゴム（小）", 100, 1000, "消しゴム（小）", 2, 2, 4),
		("消しゴム（大）", 200, 1000, "消しゴム（大）", 2, 2, 4),
		("ノート", 216, 100, "さらさら書けるノートです！。", 1, 5, 1),
		("液体のり", 500, 100, "液体のり", 4, 7, 2),
		("スティックのり", 500, 100, "スティックのり", 4, 7, 3),
		("はさみ", 500, 100, "はさみ", 4, 7, 1),
		("鉛筆削り", 500, 100, "鉛筆削り", 4, 7, 1),
		("油性ペン", 500, 100, "油性ペン", 4, 7, 1),
		("ボールペン（三色）", 500, 100, "ボールペン（三色）", 4, 7, 1),
		("ボールペン（黒）", 500, 100, "ボールペン（黒）", 4, 7, 1),
		("ボールペン（赤）", 500, 100, "ボールペン（赤）", 4, 7, 1),
		("ボールペン（青）", 500, 100, "ボールペン（青）", 4, 7, 1),
		("シャープペンシル", 500, 100, "シャープペンシル", 4, 7, 1),
		("シャープペンシルの芯（2B）", 500, 100, "シャープペンシルの芯（2B）", 4, 7, 1),
		("シャープペンシルの芯（H）", 500, 100, "シャープペンシルの芯（H）", 4, 7, 1),
		("デスクトップパソコン", 103145, 100, "デスクトップパソコン", 4, 7, 1),
		("ノートパソコン", 103145, 100, "ノ1ートパソコン", 4, 7, 1),
		("マウス", 500, 100, "最新マウス", 4, 7, 1),
		("カメラ", 500, 100, "カメラ", 4, 7, 1),
		("イヤホン", 500, 100, "イヤホン", 4, 7, 1),
		("ヘッドホン", 500, 100, "ヘッドホン", 4, 7, 1),
		("キーボード（黒）", 500, 100, "キーボード（黒）", 4, 7, 1),
		("キーボード（白）", 500, 100, "キーボード（白）", 4, 7, 1),
		("モニター 23インチ", 500, 100, "モニター 23インチ", 4, 7, 1),
		("モニター 27インチ", 500, 100, "モニター 27インチ", 4, 7, 1),
		("マイク", 500, 100, "マイク", 4, 7, 1),
		("プリンター", 500, 100, "プリンター", 4, 7, 1),
		("インク", 500, 100, "インク", 4, 7, 1),
		("無線LANルーター", 500, 100, "無線LANルーター", 4, 7, 1),
		("microSDカード", 500, 100, "microSDカード", 4, 7, 1),
		("SDカード", 500, 100, "SDカード", 4, 7, 1),
		("メモリースティック", 500, 100, "メモリースティック", 4, 7, 1),
		("USBメモリー", 500, 100, "USBメモリー", 4, 7, 1),
		("INTEL インテル CPU Corei9-9900K", 71444, 100, "INTEL インテル CPU Corei9-9900K", 4, 7, 1),
		("INTEL インテル CPU Corei7-9700K", 52680, 100, "INTEL インテル CPU Corei7-9700K", 4, 7, 1),
		("INTEL インテル CPU Corei7-8700K", 45780, 100, "INTEL インテル CPU Corei7-8700K", 4, 7, 1),
		("INTEL インテル CPU Corei5-9600K", 32940, 100, "INTEL インテル CPU Corei5-9600K", 4, 7, 1),
		("INTEL インテル CPU Corei5-8400", 26150, 100, "INTEL インテル CPU Corei5-8400", 4, 7, 1),
		("インテル Intel CPU Corei3-8100", 16999, 100, "インテル Intel CPU Corei3-8100", 4, 7, 1),
		("GeForce RTX 2080", 114410, 100, "GeForce RTX 2080", 4, 7, 1),
		("GeForce RTX 2070", 73692, 100, "GeForce RTX 2070", 4, 7, 1),
		("GeForce GTX 980", 30800, 100, "GeForce GTX 980", 4, 7, 1),
		("GeForce GTX 970", 30800, 100, "GeForce GTX 970", 4, 7, 1),
		("GeForce GTX 1060", 42890, 100, "GeForce GTX 1060", 4, 7, 1),
		("Z390-A", 13998, 100, "Z390-A", 4, 7, 1),
		("H370-A", 11029, 100, "H370-A", 4, 7, 1),
		("メモリ DDR3", 10800, 100, "メモリ DDR3", 4, 7, 1),
		("メモリ DDR4", 11990, 100, "メモリ DDR4", 4, 7, 1),
		("ハードディスク 500GB", 5157, 100, "ハードディスク 500GB", 4, 7, 1),
		("ハードディスク 1TB", 4880, 100, "ハードディスク 1TB", 4, 7, 1),
		("SSD 250GB", 4480, 100, "SSD 250GB", 4, 7, 1),
		("電源 750W", 7344, 100, "電源 750W", 4, 7, 1),
		("電源 500W", 4611, 100, "電源 500W", 4, 7, 1),
		("リンゴ", 500, 100, "リンゴ", 4, 7, 1),
		("バナナ", 500, 100, "バナナ", 4, 7, 1),
		("イチゴ", 500, 100, "イチゴ", 4, 7, 1),
		("メロン", 500, 100, "メロン", 4, 7, 1),
		("レモン", 500, 100, "レモン", 4, 7, 1),
		("パイナップル", 500, 100, "パイナップル", 4, 7, 1),
		("ねぎ", 500, 100, "ねぎ", 4, 7, 1),
		("白菜", 500, 100, "白菜", 4, 7, 1),
		("ほうれん草", 500, 100, "ほうれん草", 4, 7, 1),
		("大根", 500, 100, "大根", 4, 7, 1),
		("人参", 500, 100, "人参", 4, 7, 1),
		("トマト", 500, 100, "トマト", 4, 7, 1),
		("玉ねぎ", 500, 100, "玉ねぎ", 4, 7, 1),
		("きゅうり", 500, 100, "きゅうり", 4, 7, 1),
		("豚ロース 100g", 500, 100, "豚ロース 100g", 4, 7, 1),
		("豚バラ 100g", 500, 100, "豚バラ 100g", 4, 7, 1),
		("牛バラ 100g", 500, 100, "牛バラ 100g", 4, 7, 1),
		("牛すじ 100g", 500, 100, "牛すじ 100g", 4, 7, 1),
		("鶏もも肉 100g", 500, 100, "鶏もも肉 100g", 4, 7, 1),
		("鶏むね肉 100g", 500, 100, "鶏むね肉 100g", 4, 7, 1),
		("羊肉 100g", 500, 100, "羊肉 100g", 4, 7, 1),
		("馬肉 100g", 500, 100, "馬肉 100g", 4, 7, 1),
		("ベーコン", 500, 100, "ベーコン", 4, 7, 1),
		("ハム", 500, 100, "ハム", 4, 7, 1),
		("ソーセージ", 500, 100, "ソーセージ", 4, 7, 1),
		("ショートケーキ", 500, 100, "ショートケーキ", 4, 7, 1),
		("チョコレートケーキ", 500, 100, "チョコレートケーキ", 4, 7, 1),
		("チーズケーキ", 500, 100, "チーズケーキ", 4, 7, 1),
		("モンブラン", 500, 100, "モンブラン", 4, 7, 1),
		("チョコレート", 500, 100, "チョコレート", 4, 7, 1),
		("ポテトチップス（うすしお）", 500, 100, "ポテトチップス（うすしお）", 4, 7, 1),
		("ポテトチップス（のりしお）", 500, 100, "ポテトチップス（のりしお）", 4, 7, 1),
		("ポテトチップス（コンソメ）", 500, 100, "ポテトチップス（コンソメ）", 4, 7, 1),
		("あめ", 500, 100, "あめ", 4, 7, 1),
		("プリン", 500, 100, "プリン", 4, 7, 1),
		("ゼリー", 500, 100, "ゼリー", 4, 7, 1),
		("ドーナツ", 500, 100, "ドーナツ", 4, 7, 1),
		("ビスケット", 500, 100, "ビスケット", 4, 7, 1),
		("煎餅", 500, 100, "煎餅", 4, 7, 1),
		("醤油", 500, 100, "醤油", 4, 7, 1),
		("味噌", 500, 100, "味噌", 4, 7, 1),
		("みりん", 500, 100, "みりん", 4, 7, 1),
		("お酢", 500, 100, "お酢", 4, 7, 1),
		("ポン酢", 500, 100, "ポン酢", 4, 7, 1),
		("コショウ", 500, 100, "コショウ", 4, 7, 1),
		("塩", 500, 100, "塩", 4, 7, 1),
		("ダシ", 500, 100, "ダシ", 4, 7, 1),
		("小麦粉", 500, 100, "小麦粉", 4, 7, 1),
		("片栗粉", 500, 100, "片栗粉", 4, 7, 1),
		("パン粉", 500, 100, "パン粉", 4, 7, 1),
		("米", 500, 100, "米", 4, 7, 1),
		("お茶", 128, 2128, "お茶です。", 3, 6, 1),
		("コーラ", 500, 100, "コーラ", 4, 7, 1),
		("オレンジジュース", 500, 100, "オレンジジュース", 4, 7, 1),
		("グレープジュース", 500, 100, "グレープジュース", 4, 7, 1),
		("天然水", 500, 100, "天然水", 4, 7, 1),
		("麦茶", 500, 100, "麦茶", 4, 7, 1),
		("スポーツドリンク", 500, 100, "スポーツドリンク", 4, 7, 1),
		("栄養ドリンク", 500, 100, "栄養ドリンク", 4, 7, 1),
		("ビール", 500, 100, "ビール", 4, 7, 1),
		("焼酎", 500, 100, "焼酎", 4, 7, 1),
		("日本酒", 500, 100, "日本酒", 4, 7, 1),
		("ワイン", 500, 100, "ワイン", 4, 7, 1),
		("チューハイ", 500, 100, "チューハイ", 4, 7, 1),
		("梅酒", 500, 100, "梅酒", 4, 7, 1),
		("電気ケトル", 500, 100, "電気ケトル", 4, 7, 1),
		("冷蔵庫", 500, 100, "冷蔵庫", 4, 7, 1),
		("テレビ", 500, 100, "テレビ", 4, 7, 1),
		("電子レンジ", 500, 100, "電子レンジ", 4, 7, 1),
		("ドライヤー", 500, 100, "ドライヤー", 4, 7, 1),
		("空気清浄機", 500, 100, "空気清浄機", 4, 7, 1),
		("炊飯器", 500, 100, "炊飯器", 4, 7, 1),
		("掃除機", 500, 100, "掃除機", 4, 7, 1),
		("エアコン", 500, 100, "エアコン", 4, 7, 1),
		("高圧洗浄機", 500, 100, "高圧洗浄機", 4, 7, 1),
		("ミシン", 500, 100, "ミシン", 4, 7, 1),
		("アイロン", 500, 100, "アイロン", 4, 7, 1),
		("布団", 500, 100, "布団", 4, 7, 1),
		("枕", 500, 100, "枕", 4, 7, 1),
		("ソファー", 500, 100, "ソファー", 4, 7, 1),
		("ベッド", 500, 100, "ベッド", 4, 7, 1),
		("自転車", 500, 100, "自転車", 4, 7, 1),
		("お皿", 500, 100, "お皿", 4, 7, 1),
		("お箸", 500, 100, "お箸", 4, 7, 1),
		("スプーン", 500, 100, "スプーン", 4, 7, 1),
		("フォーク", 500, 100, "フォーク", 4, 7, 1),
		("ナイフ", 500, 100, "ナイフ", 4, 7, 1),
		("コップ", 500, 100, "コップ", 4, 7, 1),
		("グラス", 500, 100, "グラス", 4, 7, 1),
		("ジョッキ", 500, 100, "ジョッキ", 4, 7, 1),
		("電子ピアノ", 500, 100, "電子ピアノ", 4, 7, 1),
		("鍵盤ハーモニカ", 500, 100, "鍵盤ハーモニカ", 4, 7, 1),
		("エレキギター", 500, 100, "エレキギター", 4, 7, 1),
		("アコースティックギター", 500, 100, "アコースティックギター", 4, 7, 1),
		("エレアコギター", 500, 100, "エレアコギター", 4, 7, 1),
		("電子ドラム", 500, 100, "電子ドラム", 4, 7, 1),
		("カスタネット", 500, 100, "カスタネット", 4, 7, 1),
		("クラリネット", 500, 100, "クラリネット", 4, 7, 1),
		("シンバル", 500, 100, "シンバル", 4, 7, 1),
		("小太鼓", 500, 100, "小太鼓", 4, 7, 1),
		("大太鼓", 500, 100, "大太鼓", 4, 7, 1),
		("トランペット", 500, 100, "トランペット", 4, 7, 1),
		("チューバ", 500, 100, "チューバ", 4, 7, 1),
		("トロンボーン", 500, 100, "トロンボーン", 4, 7, 1),
		("ユーフォニアム", 500, 100, "ユーフォニアム", 4, 7, 1),
		("フルート", 500, 100, "フルート", 4, 7, 1),
		("ピッコロ", 500, 100, "ピッコロ", 4, 7, 1),
		("サクソフォン", 500, 100, "サクソフォン", 4, 7, 1),
		("オーボエ", 500, 100, "オーボエ", 4, 7, 1),
		("ファゴット", 500, 100, "ファゴット", 4, 7, 1),
		("ホルン", 500, 100, "ホルン", 4, 7, 1),
		("リコーダー", 500, 100, "リコーダー", 4, 7, 1),
		("リーダブルコード", 500, 100, "リーダブルコード", 4, 7, 1),
		("すごいHaskellたのしく学ぼう！", 500, 100, "すごいHaskellたのしく学ぼう！", 4, 7, 1),
		("新・明解C++入門", 500, 100, "新・明解C++入門", 4, 7, 1),	
		("数学ガール／乱択アルゴリズム", 500, 100, "数学ガール／乱択アルゴリズム", 4, 7, 1),
		("新装版 達人プログラマー 職人から名匠への道", 500, 100, "新装版 達人プログラマー 職人から名匠への道", 4, 7, 1),
		("ゲームを作りながら楽しく学べるPythonプログラミング", 1620, 100, "ゲームを作りながら楽しく学べるPythonプログラミング", 4, 7, 1),
		("プログラミング超初心者が初心者になるためのPython入門", 250, 100, "プログラミング超初心者が初心者になるためのPython入門", 4, 7, 1),
		("独学プログラマー Python言語の基本から仕事のやり方まで", 2376, 100, "独学プログラマー Python言語の基本から仕事のやり方まで", 4, 7, 1),
		("JavaScriptエンジニアのためのNode.js入門", 350, 100, "JavaScriptエンジニアのためのNode.js入門", 4, 7, 1),
		("ゼロから作るDeep Learning", 3672, 100, "ゼロから作るDeep Learning", 4, 7, 1),
		("入門者のExcel VBA", 1058, 100, "入門者のExcel VBA", 4, 7, 1),
		("スッキリわかるJava入門", 2808, 100, "スッキリわかるJava入門", 4, 7, 1),
		("退屈なことはPythonにやらせよう", 3996, 100, "退屈なことはPythonにやらせよう", 4, 7, 1),
		("JavaScriptエンジニアが手っ取り早くReactの基礎を理解するための「超」入門書", 280, 100, "JavaScriptエンジニアが手っ取り早くReactの基礎を理解するための「超」入門書", 4, 7, 1),
		("Unity5の教科書", 2786, 100, "Unity5の教科書", 4, 7, 1),
		("速習TypeScript: altJSのデファクトスタンダートを素早く学ぶ", 490, 100, "速習TypeScript: altJSのデファクトスタンダートを素早く学ぶ", 4, 7, 1);



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
DROP TABLE IF EXISTS PurchaseHistoryTable;
CREATE TABLE PurchaseHistoryTable
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
	(1, 0, "admin","3f74691ad7292c5f0ee29cc8fba0b03463e3b1c4a1d368838dbe11b925d244c4", "admin@internousdev.com", "管理者", 1),
	(0, 0, "user001","password", "user001@internousdev.com", "ユーザー001", 1),
	(0, 0, "user002","password", "user002@internousdev.com", "ユーザー002", 1),
	(0, 0, "user003","password", "user003@internousdev.com", "ユーザー003", 1),
	(0, 0, "user004","password", "user004@internousdev.com", "ユーザー004", 1),
	(0, 0, "user005","password", "user005@internousdev.com", "ユーザー005", 1),
	(0, 0, "user006","password", "user006@internousdev.com", "ユーザー006", 1),
	(0, 0, "user007","password", "user007@internousdev.com", "ユーザー007", 1),
	(0, 0, "user008","password", "user008@internousdev.com", "ユーザー008", 1),
	(0, 0, "user009","password", "user009@internousdev.com", "ユーザー009", 1),
	(0, 0, "user010","password", "user010@internousdev.com", "ユーザー010", 1),
	(0, 0, "user011","password", "user011@internousdev.com", "ユーザー011", 1),
	(0, 0, "user012","password", "user012@internousdev.com", "ユーザー012", 1),
	(0, 0, "user013","password", "user013@internousdev.com", "ユーザー013", 1),
	(0, 0, "user014","password", "user014@internousdev.com", "ユーザー014", 1),
	(0, 0, "user015","password", "user015@internousdev.com", "ユーザー015", 1);
