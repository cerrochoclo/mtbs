CREATE TABLE mtbsuser
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(100)
);
CREATE TABLE role
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE userroles
(
    user_id INT REFERENCES mtbsuser (id) ON DELETE CASCADE,
    role_id INT REFERENCES role (id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);
INSERT INTO mtbsuser(id,name, email, password)
VALUES (1,'Moshe Cohen', 'moshe.cohen@zmail.com', '123456');
INSERT INTO mtbsuser(id,name, email, password)
VALUES (2,'Avi Levi', 'avi.levi@zmail.com', 'aabbccdd');
INSERT INTO mtbsuser(id,name, email, password)
VALUES (3,'Yigal Boss', 'yigal.boss@theatre.com', '000000');
INSERT INTO role(id,name)
VALUES (1,'user');
INSERT INTO role(id,name)
VALUES (2,'admin');
INSERT INTO userroles(user_id,role_id)
VALUES(1,1);
INSERT INTO userroles(user_id,role_id)
VALUES(2,1);
INSERT INTO userroles(user_id,role_id)
VALUES(3,2);