DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders
(
    orderID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    length INT NOT NULL,
    width INT NOT NULL,
    userID INT NOT NULL,
    FOREIGN KEY (userID) REFERENCES Users(userID)
);

DROP TABLE IF EXISTS ordersmaterials;
CREATE TABLE ordersmaterials
(
    materialsorderID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quantity INT NOT NULL,
    orderID INT NOT NULL,
    materialID INT NOT NULL,
    FOREIGN KEY (orderID) REFERENCES Orders(orderID),
    FOREIGN KEY (materialID) REFERENCES Material(materialID)
);

DROP TABLE IF EXISTS Material;
CREATE TABLE Material
(
    materialID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type varchar(45) NOT NULL,
    name varchar(45) NOT NULL,
    price int NOT NULL,
    length int,
    width INT,
    height INT
);

