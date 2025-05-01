CREATE TABLE if not exists station  (
                         id bigint generated always as identity primary key,
                         name VARCHAR(255) NOT NULL,
                         code VARCHAR(100) NOT NULL,
                         city VARCHAR(255) NOT NULL
);
