create table categories
(
    category_id  serial
        constraint categories_pk
            primary key,
    category       VARCHAR(255) not null
);

create table shops
(
    shop_id  serial
        constraint shops_pk
            primary key,
    shop       VARCHAR(255) not null,
    address       VARCHAR(255) not null
);

create table smartphone
(
    smartphone_id serial
        constraint smartphones_pk
            primary key,
    title       VARCHAR(255) not null,
    description TEXT,
    photo       VARCHAR(255),
    price       DECIMAL(10,2) default 0.00,
    brand       VARCHAR(255) not null,
    model       VARCHAR(255) not null,
    memory      int,
    category_id int
        constraint smartphones_categories_category_id_fk
            references categories,
    shop_id     int
        constraint smartphones_shops_shop_id_fk
            references shops
);

INSERT INTO categories VALUES (1, 'Smartphones');
INSERT INTO categories VALUES (2, 'Notebooks');

INSERT INTO shops VALUES (1, 'Abc 01', 'Minsk');
INSERT INTO shops VALUES (2, 'Abc 02', 'Brest');
INSERT INTO shops VALUES (3, 'Abc 03', 'Vitebsk');
INSERT INTO shops VALUES (4, 'Bca 01', 'Grodno');
INSERT INTO shops VALUES (5, 'Bca 02', 'Moskva');

INSERT INTO smartphone VALUES (1, 'Phone iPhone 14', 'description 123', 'url photo', 800.00, 'Apple', '14', 256, 1, 1);
INSERT INTO smartphone VALUES (2, 'Phone iPhone 13', 'description 234', 'url photo', 700.00, 'Apple', '13', 128, 1, 2);
INSERT INTO smartphone VALUES (3, 'Phone iPhone 13', 'description 345', 'url photo',600.00, 'Apple', '13', 128, 1, 1);
INSERT INTO smartphone VALUES (4, 'Phone iPhone 11', 'description 456', 'url photo',500.00, 'Apple', '11', 512, 1, 3);
INSERT INTO smartphone VALUES (5, 'Phone Samsung A20', 'description 789', 'url photo',400.00, 'Samsung', 'A20', 64, 1, 4);