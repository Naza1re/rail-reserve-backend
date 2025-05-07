CREATE TABLE IF NOT EXISTS wagon (
                       id bigint generated always as identity primary key,
                       number INT NOT NULL,
                       type VARCHAR(255) NOT NULL,
                       seat_count INT NOT NULL,
                       train_id BIGINT,
                       CONSTRAINT fk_wagon_train FOREIGN KEY (train_id) REFERENCES train(id)
);
