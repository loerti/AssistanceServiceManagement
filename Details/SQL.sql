
DROP TABLE Customer;
DROP TABLE Personnel;
DROP TABLE RepairSheet;
DROP TABLE Product;

CREATE TABLE Customer 
(
customerId INT AUTO_INCREMENT,
customerName VARCHAR (100) NOT NULL,
customerSurname VARCHAR(100) NOT NULL,
customerEmail VARCHAR(100) NOT NULL UNIQUE,
customerPhoneNumber VARCHAR(25) NOT NULL UNIQUE,
customerPassword VARCHAR(30) NOT NULL,
customerAddress VARCHAR (256) NOT NULL,
PRIMARY KEY (customerId)
);
INSERT INTO Customer (customerName,customerSurname,customerEmail,customerPhoneNumber,customerPassword,customerAddress) VALUES("Loerti","Shahini","loerti.shahini@gmail.com",0675204072,"loerti12345","Shijak Durres Albania");
INSERT INTO Customer (customerName,customerSurname,customerEmail,customerPhoneNumber,customerPassword,customerAddress) VALUES("Elisa","Shahini","elisa.shahini@gmail.com",06752040722,"elisa12345","Shijak Durres Albania");
INSERT INTO Customer (customerName,customerSurname,customerEmail,customerPhoneNumber,customerPassword,customerAddress) VALUES("Ajla","Shahini","ajla.shahini@gmail.com",067522,"ajla12345","Shijak Durres Albania");
INSERT INTO Customer (customerName,customerSurname,customerEmail,customerPhoneNumber,customerPassword,customerAddress) VALUES("Skerdi","Tepshi","skerdi.tepshi@gmail.com",0695222323,"skerdi12345","Durres Albania");


CREATE TABLE Personnel
(
personnelId INT AUTO_INCREMENT,
personnelClassification VARCHAR(100) NOT NULL,
personnelEmail VARCHAR(200) NOT NULL UNIQUE,
personnelPassword VARCHAR(30) NOT NULL,
customerId INT NOT NULL,
PRIMARY KEY (personnelId),
FOREIGN KEY (customerId) REFERENCES Customer(customerId)
);
INSERT INTO Personnel (personnelClassification, personnelEmail, personnelPassword, customerId) VALUES ("Operator","operator1@gmailcom","operator123445",1);
INSERT INTO Personnel (personnelClassification, personnelEmail, personnelPassword, customerId) VALUES ("Technician","technic1@gmailcom","technic12345",2);
INSERT INTO Personnel (personnelClassification, personnelEmail, personnelPassword, customerId) VALUES ("Technician","technic2@gmailcom","technic123456",1);
INSERT INTO Personnel (personnelClassification, personnelEmail, personnelPassword, customerId) VALUES ("Technician","technic3@gmailcom","technicefef123456",4);

CREATE TABLE Product
(
productSerialNumber INT AUTO_INCREMENT,
brand VARCHAR(150) NOT NULL,
dateOfPurchase TIMESTAMP NOT NULL DEFAULT(now()),
warrantyExpiryDate TIMESTAMP NOT NULL DEFAULT(now()),
PRIMARY KEY (productSerialNumber)
);
INSERT INTO Product (brand) VALUES ("Dell");
INSERT INTO Product (brand, warrantyExpiryDate) VALUES ("HP","2022-05-03 12:25:31");
INSERT INTO Product (brand, warrantyExpiryDate, dateOfPurchase) VALUES ("Lenovo","2022-01-03 12:25:31", "2021-02-03 12:25:31");
INSERT INTO Product (brand, warrantyExpiryDate, dateOfPurchase) VALUES ("Apple","2026-02-03 12:25:31", "2022-02-03 12:25:31");
INSERT INTO Product (brand, warrantyExpiryDate, dateOfPurchase) VALUES ("Huawei","2020-02-03 12:25:31", "2019-02-03 12:25:31");

CREATE TABLE RepairSheet
( 
fileId INT AUTO_INCREMENT,
price DOUBLE NOT NULL,
repairStatus VARCHAR(20) NOT NULL,
problemDescription VARCHAR (256),
dateCreated TIMESTAMP NOT NULL DEFAULT(now()),
personnelId INT NOT NULL,
productId INT NOT NULL UNIQUE,
PRIMARY KEY (fileId),
FOREIGN KEY (personnelId) REFERENCES Personnel(personnelId),
FOREIGN KEY (productId) REFERENCES Product(productSerialNumber)
);
INSERT INTO RepairSheet (price, repairStatus, problemDescription, dateCreated, personnelId, productId) VALUES (200,"Rejected","Broken screen","2022-01-01 12:25:31",1,1);
INSERT INTO RepairSheet (price, repairStatus, problemDescription, dateCreated, personnelId, productId) VALUES (150,"Completed","Broken keyboard","2022-02-02 12:25:31",1,2);
INSERT INTO RepairSheet (price, repairStatus, problemDescription, dateCreated, personnelId, productId) VALUES (100,"Completed","Broken keyboard","2022-03-03 12:25:31",2,3);
INSERT INTO RepairSheet (price, repairStatus, problemDescription, personnelId, productId) VALUES (250,"Rejected","Total Mulfuction",3,4);
INSERT INTO RepairSheet (price, repairStatus, problemDescription, personnelId, productId) VALUES (250,"Rejected","TouchScreen not working",3,5);
