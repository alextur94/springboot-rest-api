CREATE TABLE users (
    username VARCHAR(255) NOT NULL
        CONSTRAINT users_pk
            PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN DEFAULT true NOT NULL
);

CREATE TABLE authorities (
    username  VARCHAR(255) NOT NULL
        CONSTRAINT authorities_users_username_fk
            REFERENCES users,
    authority VARCHAR(255) not null
);

CREATE UNIQUE INDEX username_auth_idx ON authorities (username, authority);