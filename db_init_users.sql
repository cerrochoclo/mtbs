
CREATE DATABASE users;
\c users
ALTER ROLE app_user CREATEDB CREATEROLE;
GRANT ALL PRIVILEGES ON DATABASE users TO app_user;
CREATE TABLE role
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE mtbsuser
(
    username VARCHAR(100) PRIMARY KEY,
    name     VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(100),
    role_id INT REFERENCES role (id)
);
INSERT INTO role(id,name)
VALUES (1,'USER');
INSERT INTO role(id,name)
VALUES (2,'ADMIN');
INSERT INTO mtbsuser(username,name, email, password,role_id)
VALUES ('moshe.cohen','Moshe Cohen', 'moshe.cohen@zmail.com', '123456',1);
INSERT INTO mtbsuser(username,name, email, password,role_id)
VALUES ('avi.levi','Avi Levi', 'avi.levi@zmail.com', 'aabbccdd',1);
INSERT INTO mtbsuser(username,name, email, password,role_id)
VALUES ('yigal.boss','Yigal Boss', 'yigal.boss@theatre.com', '000000',2);

