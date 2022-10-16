create table smartphones
(
    product_id  serial
        constraint products_pk
            primary key,
    brand       VARCHAR(255) not null,
    model       VARCHAR(255) not null,
    description TEXT,
    price       DECIMAL(10, 2) default 0.00,
    photo       VARCHAR(255),
    shop_id     int,
    category_id int
);

create table categories
(
    category_id  serial
        constraint categories_pk
            primary key,
    category       VARCHAR(255) not null,
);

INSERT INTO smartphones VALUES (1, 'iPhone', '14', 'description 123', 800.00, 'url photo', 1, 2);
INSERT INTO smartphones VALUES (2, 'iPhone', '13', 'description 234', 700.00, 'url photo', 1, 2);
INSERT INTO smartphones VALUES (3, 'iPhone', '13', 'description 345', 600.00, 'url photo', 1, 2);
INSERT INTO smartphones VALUES (4, 'iPhone', '11', 'description 456', 500.00, 'url photo', 1, 2);
INSERT INTO smartphones VALUES (5, 'Samsung', 'A20', 'description 789', 400.00, 'url photo', 1, 2);

INSERT INTO categories VALUES (1, 'Smartphones');
INSERT INTO categories VALUES (2, 'Notebooks');


