CREATE DATABASE IF NOT EXISTS ec;
USE ec

CREATE TABLE IF NOT EXISTS ADMIN_TABLE(
-- 管理者ID
admin_id varchar(16) not null primary key,
-- 管理者パスワード
admin_pass varchar(16) not null,
-- 管理者名
admin_name varchar(50) not null
);
-- 管理者データの登録（10月生）
insert into ADMIN_TABLE(admin_id,admin_pass,admin_name) values ("12345678","commando","ジョンメイトリックス");

CREATE TABLE IF NOT EXISTS ITEM_TABLE(
-- 商品ID
item_id int not null primary key auto_increment,
-- 商品名
item_name varchar(255) not null,
-- 価格
item_price int not null default "1",
-- 在庫
item_stock int not null default "0",
-- 画像パス
item_img varchar(255) not null default "img/noimage.jpg"
);

INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('獺祭', 2790, 27, 'img/liquor1.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img)  
VALUES ('鍋島', 2980, 12, 'img/liquor10.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img)  
VALUES ('久保田', 3900, 4, 'img/liquor2.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img)  
VALUES ('八海山', 2490, 39, 'img/liquor3.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('黒龍', 2790, 13, 'img/liquor4.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('古都', 2590, 27, 'img/liquor5.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('菊水の辛口', 2980, 12, 'img/liquor6.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('上喜元', 1900, 24, 'img/liquor7.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('十四代', 4900, 19, 'img/liquor8.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('翠玉', 2790, 13, 'img/liquor9.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img)
VALUES ('雪中梅', 2790, 15, 'img/liquor11.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('福寿', 2980, 52, 'img/liquor12.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('菊姫', 1900, 43, 'img/liquor13.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('出羽桜', 490, 18, 'img/liquor14.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('立山', 2790, 33, 'img/liquor15.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('高千代', 2790, 17, 'img/liquor16.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('八甲田', 2980, 19, 'img/liquor17.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('雪鶴', 1900, 14, 'img/liquor18.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('端鷹', 490, 20, 'img/liquor19.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock, item_img) 
VALUES ('春夏秋雪', 2790, 31, 'img/liquor20.jpg');
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('北寳', 2790, 27);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('熊古露里', 2980, 12);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('蓬莱泉', 1900, 4);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('愛宕の松', 490, 89);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('阿部勘', 2790, 13);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('朝乃舞', 2790, 27);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('高麗王', 2980, 12);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('長命泉', 1900, 24);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('金婚正宗', 490, 89);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('白笹つづみ', 2790, 13);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('越後鶴亀', 2790, 17);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('巻機', 2980, 16);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('蜃気楼', 1900, 21);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('華燭', 490, 39);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('笑亀', 2790, 15);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('高原郷', 2790, 27);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('葵天下', 2980, 32);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('朝日嶽', 1900, 14);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('妙の華', 490, 89);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('奥琵琶湖', 2790, 13);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('聚楽第', 2790, 27);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('蒼雫', 2980, 12);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('松花鶴', 1900, 4);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('純米吟醸', 490, 89);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('富貴', 2790, 13);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('梅乃宿', 2790, 27);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('高野山', 2980, 12);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('大和鏡', 1900, 21);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('真壽鏡', 490, 49);
INSERT INTO  ITEM_TABLE (item_name, item_price, item_stock) 
VALUES ('金剛', 2790, 13);

CREATE TABLE IF NOT EXISTS ORDER_TABLE(
-- 注文ID
order_id int not null primary key auto_increment,
-- 商品ID
item_id int not null,
-- 注文数
order_count int not null default "0",
-- 購入者
order_customer varchar(50) not null,
-- 郵便番号
order_post varchar(7) not null,
-- 電話番号
order_phone varchar(11) not null,
-- Eメールアドレス
order_mail varchar(255) not null,
-- 届け先
order_destination varchar(255) not null,
-- 購入日
order_day datetime not null default current_timestamp
);

-- 注文情報データの登録（10月生
INSERT INTO ORDER_TABLE(item_id,order_count,order_customer,order_post,order_phone,order_mail,order_destination) 
values (1,2,"カービィ","1234567","00012345678","commando@ne.jp","愛知県");
INSERT INTO ORDER_TABLE(item_id,order_count,order_customer,order_post,order_phone,order_mail,order_destination) 
values (2,4,"ジャクソン","1234567","00012345678","commando@ne.jp","静岡県");
INSERT INTO ORDER_TABLE(item_id,order_count,order_customer,order_post,order_phone,order_mail,order_destination) 
values (3,6,"サリー","1234567","00012345678","commando@ne.jp","岐阜県");
INSERT INTO ORDER_TABLE(item_id,order_count,order_customer,order_post,order_phone,order_mail,order_destination) 
values (4,1,"エンリスケ","1234567","00012345678","commando@ne.jp","三重県");
INSERT INTO ORDER_TABLE(item_id,order_count,order_customer,order_post,order_phone,order_mail,order_destination) 
values (5,8,"ベネット","1234567","00012345678","commando@ne.jp","福井県");
INSERT INTO ORDER_TABLE(item_id,order_count,order_customer,order_post,order_phone,order_mail,order_destination) 
values (6,30,"ハリス","1234567","00012345678","commando@ne.jp","富山県");
INSERT INTO ORDER_TABLE(item_id,order_count,order_customer,order_post,order_phone,order_mail,order_destination) 
values (7,12,"ローソン","1234567","00012345678","commando@ne.jp","新潟県");
INSERT INTO ORDER_TABLE(item_id,order_count,order_customer,order_post,order_phone,order_mail,order_destination) 
values (8,25,"フォレスタス","1234567","00012345678","commando@ne.jp","石川県");
INSERT INTO ORDER_TABLE(item_id,order_count,order_customer,order_post,order_phone,order_mail,order_destination) 
values (9,27,"クック","1234567","00012345678","commando@ne.jp","長野県");
INSERT INTO ORDER_TABLE(item_id,order_count,order_customer,order_post,order_phone,order_mail,order_destination) 
values (10,10,"シンディ","1234567","00012345678","commando@ne.jp","山梨県"
);