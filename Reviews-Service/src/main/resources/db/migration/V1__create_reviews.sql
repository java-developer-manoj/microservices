CREATE TABLE IF NOT EXISTS reviews
(
    id
    SERIAL
    PRIMARY
    KEY,
    comment
    VARCHAR
(
    100
), rating DECIMAL
(
    10,
    2
) ,user_id INTEGER NOT NULL, product_id INTEGER NOT NULL );


INSERT INTO reviews (comment, rating, user_id, product_id)
VALUES ('Excellent phone', 4.50, 1, 1),
       ('Very good battery life', 4.20, 2, 1),
       ('Average camera quality', 3.50, 3, 1),
       ('Good performance', 4.00, 1, 2),
       ('Not worth the price', 2.80, 4, 2)




