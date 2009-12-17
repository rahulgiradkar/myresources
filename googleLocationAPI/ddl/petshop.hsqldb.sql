--  Tabelas
--
-- bannerdata
-- categorydetails
-- item
-- product
-- supplier
-- orders
-- lineitem
-- productdetails
-- useraccount
-- 
-- 

DROP TABLE IF EXISTS bannerdata;
CREATE TABLE bannerdata (
  favcategory varchar(80)  NOT NULL ,
  bannername varchar(80) NOT NULL ,
  PRIMARY KEY  (favcategory)
) 


DROP TABLE IF EXISTS categorydetails;
CREATE TABLE categorydetails (
  catid varchar(10) NOT NULL,
  name varchar(80) NOT NULL,
  PRIMARY KEY  (catid)
);


DROP TABLE IF EXISTS product;
CREATE TABLE product (
  productid varchar(10) NOT NULL ,
  catid varchar(10) NOT NULL ,
  image varchar(255) default NULL,
  PRIMARY KEY  (productid)  
);
CREATE INDEX cat_ind ON product (catid);
ALTER TABLE product  ADD  FOREIGN KEY (catid) REFERENCES categorydetails (catid);

DROP TABLE IF EXISTS supplier;
CREATE TABLE supplier (
  suppid int NOT NULL ,
  name varchar(80) NOT NULL ,
  status char(2) default NULL,
  addr1 varchar(80) default NULL,
  addr2 varchar(80) default NULL,
  city varchar(80) default NULL,
  state varchar(80) default NULL,
  zip varchar(5) default NULL,
  phone varchar(80) default NULL,
  PRIMARY KEY  (suppid)
);

DROP TABLE IF EXISTS item;
CREATE TABLE item (
  itemid varchar(10) NOT NULL ,
  productid varchar(10) NOT NULL,
  listprice decimal NOT NULL ,
  unitcost decimal NOT NULL ,
  suppid int NOT NULL,
  qty int NOT NULL,
  PRIMARY KEY  (itemid)  
);
CREATE  INDEX prod_ind ON item (productid);
CREATE  INDEX supp_ind ON item (suppid);
ALTER TABLE item ADD  FOREIGN KEY (productid) REFERENCES product (productid)
ALTER TABLE item ADD  FOREIGN KEY (suppid) REFERENCES supplier(suppid)

DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
  orderid varchar(36) NOT NULL,
  userid varchar(80) NOT NULL,
  orderdate timestamp NOT NULL,
  shiptofirstname varchar(80) NOT NULL,
  shiptolastname varchar(80) NOT NULL,
  shiptoaddress1 varchar(80) NOT NULL,
  shiptoaddress2 varchar(80) NOT NULL,
  shiptocity varchar(80) NOT NULL,
  shiptostate varchar(80) default NULL,
  shiptozip varchar(20) NOT NULL,
  shiptocountry varchar(80) NOT NULL,
  shiptophonenumber varchar(80) default NULL,
  billtofirstname varchar(80) NOT NULL,
  billtolastname varchar(80) default NULL,
  billtoaddress1 varchar(80) default NULL,
  billtoaddress2 varchar(80) default NULL,
  billtocity varchar(80) default NULL,
  billtostate varchar(80) default NULL,
  billtopostalcode varchar(20) NOT NULL,
  billtocountry varchar(80) NOT NULL,
  billtophonenumber varchar(80) default NULL,
  totalprice decimal default NULL,
  cardtype varchar(20) NOT NULL,
  cardnumber varchar(80) NOT NULL,
  cardexpiremonth LONGVARCHAR NOT NULL,
  cardexpireyear LONGVARCHAR NOT NULL,
  locale LONGVARCHAR NOT NULL,
  PRIMARY KEY  (orderid)  
) ;
CREATE INDEX userid_ind ON orders (userid);
ALTER TABLE orders  ADD FOREIGN KEY (userid) REFERENCES useraccount (userid);


DROP TABLE IF EXISTS lineitem;
CREATE TABLE lineitem (
  orderid varchar(36) NOT NULL ,
  linenum int NOT NULL ,
  itemid varchar(10) NOT NULL ,
  quantity int NOT NULL ,
  unitprice decimal NOT NULL ,
  PRIMARY KEY  (linenum,orderid)  
) ;
CREATE INDEX order_ind ON lineitem (orderid);
CREATE INDEX item_ind ON lineitem (itemid);
ALTER TABLE lineitem ADD FOREIGN KEY (orderid) REFERENCES orders (orderid);
ALTER TABLE lineitem ADD FOREIGN KEY (itemid) REFERENCES item (itemid);


DROP TABLE IF EXISTS productdetails;
CREATE TABLE productdetails (
  productid varchar(10) NOT NULL ,
  name varchar(80) NOT NULL ,
  descn varchar(255) NOT NULL ,
  PRIMARY KEY  (productid)  
) ;

CREATE INDEX product_ind ON productdetails (productid);
ALTER TABLE productdetails ADD FOREIGN KEY (productid) REFERENCES product (productid);


DROP TABLE IF EXISTS useraccount;
CREATE TABLE useraccount (
  userid varchar(80) NOT NULL,
  pwd varchar(25) default NULL,
  email varchar(80) default NULL,
  firstname varchar(80) default NULL,
  lastname varchar(80) default NULL,
  status char(2) default NULL,
  addr1 varchar(80) default NULL,
  addr2 varchar(40) default NULL,
  city varchar(80) default NULL,
  state varchar(80) default NULL,
  zip varchar(20) default NULL,
  country varchar(20) default NULL,
  phone varchar(80) default NULL,
  langpref varchar(80) default NULL,
  favcategory varchar(80) default NULL,
  mylistopt int default NULL,
  banneropt int default NULL,
  PRIMARY KEY (userid)  
);
CREATE INDEX favcategory_ind ON useraccount (favcategory);
ALTER TABLE useraccount ADD FOREIGN KEY (favcategory) REFERENCES bannerdata (favcategory);


DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
   id int not null,
   nome VARCHAR(80) not null,
   papel VARCHAR(80) not null,
   userid VARCHAR(80) not null,
   PRIMARY KEY (id)
);
ALTER TABLE roles ADD FOREIGN KEY (userid) REFERENCES useraccount (userid);


INSERT INTO bannerdata VALUES ('BIRDS','banner_birds.gif');
INSERT INTO bannerdata VALUES ('CATS','banner_cats.gif');
INSERT INTO bannerdata VALUES ('DOGS','banner_dogs.gif');
INSERT INTO bannerdata VALUES ('FISH','banner_fish.gif');
INSERT INTO bannerdata VALUES ('REPTILES','banner_reptiles.gif');

INSERT INTO categorydetails VALUES ('BIRDS','Birds');
INSERT INTO categorydetails VALUES ('CATS','Cats');
INSERT INTO categorydetails VALUES ('DOGS','Dogs');
INSERT INTO categorydetails VALUES ('FISH','Fish');
INSERT INTO categorydetails VALUES ('REPTILES','Reptiles');

INSERT INTO product VALUES ('AV-CB-01','BIRDS','bird4.gif');
INSERT INTO product VALUES ('AV-SB-02','BIRDS','bird2.gif');
INSERT INTO product VALUES ('FI-FW-01','FISH','fish3.gif');
INSERT INTO product VALUES ('FI-FW-02','FISH','fish2.gif');
INSERT INTO product VALUES ('FI-SW-01','FISH','fish1.gif');
INSERT INTO product VALUES ('FI-SW-02','FISH','fish4.gif');
INSERT INTO product VALUES ('FL-DLH-02','CATS','cat1.gif');
INSERT INTO product VALUES ('FL-DSH-01','CATS','cat3.gif');
INSERT INTO product VALUES ('K9-CW-01','DOGS','dog4.gif');
INSERT INTO product VALUES ('K9-DL-01','DOGS','dog6.gif');
INSERT INTO product VALUES ('K9-PO-02','DOGS','dog3.gif');
INSERT INTO product VALUES ('K9-RT-01','DOGS','dog1.gif');
INSERT INTO product VALUES ('K9-RT-02','DOGS','dog5.gif');
INSERT INTO product VALUES ('RP-LI-02','REPTILES','lizard1.gif');
INSERT INTO product VALUES ('RP-SN-01','REPTILES','snake1.gif');

INSERT INTO supplier VALUES (1,'XYZ Pets','AC','600 Avon Way',NULL,'Los Angeles','CA','94024','212-947-0797');
INSERT INTO supplier VALUES (2,'ABC Pets','AC','700 Abalone Way',NULL,'San Francisco','CA','94024','415-947-0797');

INSERT INTO item VALUES ('EST-1','FI-SW-01',16.50,10.00,1,10000);
INSERT INTO item VALUES ('EST-10','K9-DL-01',18.50,12.00,1,10000);
INSERT INTO item VALUES ('EST-11','RP-SN-01',18.50,12.00,1,10000);
INSERT INTO item VALUES ('EST-12','RP-SN-01',18.50,12.00,1,10000);
INSERT INTO item VALUES ('EST-13','RP-LI-02',18.50,12.00,1,10000);
INSERT INTO item VALUES ('EST-14','FL-DSH-01',58.50,12.00,1,10000);
INSERT INTO item VALUES ('EST-15','FL-DSH-01',23.50,12.00,1,10000);
INSERT INTO item VALUES ('EST-16','FL-DLH-02',93.50,12.00,1,10000);
INSERT INTO item VALUES ('EST-17','FL-DLH-02',93.50,12.00,1,10000);
INSERT INTO item VALUES ('EST-18','AV-CB-01',193.50,92.00,1,10000);
INSERT INTO item VALUES ('EST-19','AV-SB-02',15.50,2.00,1,10000);
INSERT INTO item VALUES ('EST-2','FI-SW-01',16.50,10.00,1,10000);
INSERT INTO item VALUES ('EST-20','FI-FW-02',5.50,2.00,1,10000);
INSERT INTO item VALUES ('EST-21','FI-FW-02',5.29,1.00,1,10000);
INSERT INTO item VALUES ('EST-22','K9-RT-02',135.50,1.00,1,10000);
INSERT INTO item VALUES ('EST-23','K9-RT-02',145.49,1.00,1,10000);
INSERT INTO item VALUES ('EST-24','K9-RT-02',255.50,92.00,1,10000);
INSERT INTO item VALUES ('EST-25','K9-RT-02',325.29,90.00,1,10000);
INSERT INTO item VALUES ('EST-26','K9-CW-01',125.50,92.00,1,10000);
INSERT INTO item VALUES ('EST-27','K9-CW-01',155.29,90.00,1,10000);
INSERT INTO item VALUES ('EST-28','K9-RT-01',155.29,90.00,1,10000);
INSERT INTO item VALUES ('EST-3','FI-SW-02',18.50,12.00,1,10000);
INSERT INTO item VALUES ('EST-4','FI-FW-01',18.50,12.00,1,10000);
INSERT INTO item VALUES ('EST-5','FI-FW-01',18.50,12.00,1,10000);
INSERT INTO item VALUES ('EST-8','K9-PO-02',18.50,12.00,1,10000);
INSERT INTO item VALUES ('EST-9','K9-DL-01',18.50,12.00,1,10000);

INSERT INTO useraccount VALUES ('j2ee','j2ee','yourname@yourdomain.com','ABC','XYX','OK','901 San Antonio Road','UCUP02-666','Palo Alto','CA','94303','USA','555-555-5555','en_US','DOGS',1,1);

INSERT INTO productdetails VALUES ('AV-CB-01','Amazon Parrot','Great companion for up to 75 years');
INSERT INTO productdetails VALUES ('AV-SB-02','Finch','Great stress reliever');
INSERT INTO productdetails VALUES ('FI-FW-01','Koi','Fresh Water Fish from Japan');
INSERT INTO productdetails VALUES ('FI-FW-02','Golden Fish','Fresh Water Fish from China');
INSERT INTO productdetails VALUES ('FI-SW-01','Angel Fish','Salt Water Fish from Australia');
INSERT INTO productdetails VALUES ('FI-SW-02','Tiger Shark','Salt Water Fish from Australia');
INSERT INTO productdetails VALUES ('FL-DLH-02','Persian','Friendly house cat, doubles as a princess');
INSERT INTO productdetails VALUES ('FL-DSH-01','Manx','Great for reducing mouse populations');
INSERT INTO productdetails VALUES ('K9-CW-01','Chihuahua','Great companion dog');
INSERT INTO productdetails VALUES ('K9-DL-01','Dalmation','Great dog for a Fire Station');
INSERT INTO productdetails VALUES ('K9-PO-02','Poodle','Cute dog from France');
INSERT INTO productdetails VALUES ('K9-RT-01','Golden Retriever','Great family dog');
INSERT INTO productdetails VALUES ('K9-RT-02','Labrador Retriever','Great hunting dog');
INSERT INTO productdetails VALUES ('RP-LI-02','Iguana','Friendly green friend');
INSERT INTO productdetails VALUES ('RP-SN-01','Rattlesnake','Doubles as a watch dog');
