CREATE TABLE if not exists route_stop (
                            id bigint generated always as identity primary key,
                            route_id BIGINT,
                            station_id BIGINT,
                            arrival_time TIME NOT NULL,
                            departure_time TIME NOT NULL,
                            stop_order INT NOT NULL,
                            CONSTRAINT fk_route_stop_route FOREIGN KEY (route_id) REFERENCES route(id),
                            CONSTRAINT fk_route_stop_station FOREIGN KEY (station_id) REFERENCES station(id)
);
