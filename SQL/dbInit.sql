DROP TABLE IF EXISTS ordersmaterials;
CREATE TABLE ordersmaterials
(
	materialsorderID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quantity INT NOT NULL,
	FOREIGN KEY (orderID) REFERENCES Orders(orderID),
    FOREIGN KEY (materialID) REFERENCES Material(materialID)
);

