CREATE TABLE if not exists route (
                       id bigint generated always as identity primary key,
                       from_station_id BIGINT NOT NULL,
                       to_station_id BIGINT NOT NULL,
                       duration_minutes INT NOT NULL,
                       CONSTRAINT fk_route_from_station FOREIGN KEY (from_station_id) REFERENCES station(id),
                       CONSTRAINT fk_route_to_station FOREIGN KEY (to_station_id) REFERENCES station(id)
);
