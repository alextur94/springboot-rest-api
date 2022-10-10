create table users (
    user_id bigserial,
    username varchar(30) not null,
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
values ('ROLE_ADMIN'), ('ROLE_USER');

insert into users (username, password, email)
values ('admin', '$2a$12$.Z0Qy1WSQ.qFoKHhYgAvc.bo7kR2ydmNRyJGbzyJZ02HuYg0IQv.q', 'admin@mail.ru');   /* pass 1 */
insert into users (username, password, email)
values ('user', '$2a$12$3JWAVk5uu1Rrpq/QtSuBc.cy6xcbqJU40MXt1Cp8sG.XK4HuMiZEy', 'user@mail.ru');    /* pass 2 */

insert into users_roles (user_id, role_id) values (1,1);
insert into users_roles (user_id, role_id) values (2,2);