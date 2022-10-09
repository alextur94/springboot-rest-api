create table products
(
    product_id  serial
        constraint products_pk
            primary key,
    title       VARCHAR(255) not null,
    description TEXT,
    price       DECIMAL(10, 2) default 0.00,
    photo       VARCHAR(255),
    shop_id     int,
    category_id int
);

INSERT INTO products VALUES (1, 'iPhone 13', 'description 123', 800.00, 'url photo', 1, 2);
INSERT INTO products VALUES (2, 'iPhone 11', 'description 234', 700.00, 'url photo', 1, 2);
INSERT INTO products VALUES (3, 'iPhone 12', 'description 345', 600.00, 'url photo', 1, 2);
INSERT INTO products VALUES (4, 'iPhone 14', 'description 456', 500.00, 'url photo', 1, 2);
INSERT INTO products VALUES (5, 'Samsung', 'description 789', 400.00, 'url photo', 1, 2);
