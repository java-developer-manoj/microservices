CREATE TABLE products(
    id SERIAL PRIMARY KEY ,
    product_name VARCHAR (100),
    description VARCHAR (100),
    price DECIMAL(10,2),
    stock_quantity INTEGER,
    image_url VARCHAR (100),
    category VARCHAR (100)
);
INSERT INTO products
(product_name, description, price, stock_quantity, image_url, category)
VALUES (
           'One Plus',
           'One Plus Nord 4',
           320000.00,
           10,
           'http://oneplus.png',
           'MOBILE_PHONES'
       );