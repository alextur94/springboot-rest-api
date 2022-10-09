password varchar(80),
    email varchar(50) UNIQUE,
    primary key (user_id)
);

create table roles (
                       role_id serial,
                       name varchar(50) not null,
                       primary key (role_id)
);

create table users_roles (
                             user_id bigint not null,
                             role_id int not null,
                             primary key (user_id, role_id),
                             foreign key (user_id) references users (user_id),
                             foreign key (role_id) references roles (role_id)
);

insert into roles (name)
values ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, email)
values ('user', '$2a$12$KUISH5Wi8Kl184.zwmq7L.aQSKTJ8Wl54jJzBC6d/SmDF2Vi/m2ei', 'user@mail.ru');


insert into users_roles (user_id, role_id) values (1,1);