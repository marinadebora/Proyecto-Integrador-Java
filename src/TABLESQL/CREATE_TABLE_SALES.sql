CREATE TABLE SALES(
id INT PRIMARY KEY AUTO_INCREMENT,
product_id INT,
price DOUBLE,
units INT,
date VARCHAR(50),
total DOUBLE
FOREIGN KEY (product_id) REFERENCES Products(id)
);