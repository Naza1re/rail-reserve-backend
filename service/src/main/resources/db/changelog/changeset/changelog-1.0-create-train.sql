CREATE TABLE IF NOT EXISTS train (
                       id bigint generated always as identity primary key,
                       name VARCHAR(255) NOT NULL,
                       type VARCHAR(255) NOT NULL
);
