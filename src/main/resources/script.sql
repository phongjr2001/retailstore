CREATE TABLE users(
    username VARCHAR(50) Primary KEY ,
    password VARCHAR(500) NOT NULL ,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities(
    id SERIAL PRIMARY KEY ,
    username varchar(50) NOT NULL ,
    authority varchar(50) NOT NULL ,
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
);
CREATE TABLE customer(
    id SERIAL PRIMARY KEY ,
    username varchar(50) NOT NULL ,
    authority varchar(50) NOT NULL ,
    role varchar(50) NOT NULL
);