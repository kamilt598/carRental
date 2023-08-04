--PLACES
INSERT INTO places (id, city) VALUES (1, 'Białystok') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (2, 'Bydgoszcz') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (3, 'Gdańsk') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (4, 'Gorzów Wielkopolski') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (5, 'Katowice') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (6, 'Kielce') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (7, 'Kraków') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (8, 'Lublin') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (9, 'Łódź') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (10, 'Olsztyn') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (11, 'Opole') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (12, 'Poznań') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (13, 'Rzeszów') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (14, 'Szczecin') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (15, 'Toruń') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (16, 'Warszawa') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (17, 'Wrocław') ON CONFLICT (id) DO NOTHING;
INSERT INTO places (id, city) VALUES (18, 'Zielona Góra') ON CONFLICT (id) DO NOTHING;

--CARS
INSERT INTO cars (id, brand, model, type, production_year, engine, color, picture, price, place_id) VALUES (1, 'Mercedes', 'SLK AMG', 'Roadster', '2015', '5.5 / 421KM', 'Red', '/resources/images/car-1.jpg', 700.00, 16) ON CONFLICT (id) DO NOTHING;
INSERT INTO cars (id, brand, model, type, production_year, engine, color, picture, price, place_id) VALUES (2, 'Range Rover', 'Evoque', 'SUV', '2019', '2.0 / 300KM', 'White', '/resources/images/car-2.jpg', 650.00, 15) ON CONFLICT (id) DO NOTHING;
INSERT INTO cars (id, brand, model, type, production_year, engine, color, picture, price, place_id) VALUES (3, 'McLaren', '720S', 'Coupe', '2023', '4.0 / 720KM', 'Gray', '/resources/images/car-3.jpg', 1000.00, 14) ON CONFLICT (id) DO NOTHING;
INSERT INTO cars (id, brand, model, type, production_year, engine, color, picture, price, place_id) VALUES (4, 'Ford', 'Mustang GT', 'Coupe', '2014', '5.0 / 418KM', 'Black', '/resources/images/car-4.jpg', 500.00, 13) ON CONFLICT (id) DO NOTHING;
INSERT INTO cars (id, brand, model, type, production_year, engine, color, picture, price, place_id) VALUES (5, 'BMW', 'F30 GT', 'Gran Turismo', '2016', '3.0 / 306KM', 'Blue', '/resources/images/car-5.jpg', 550.00, 12) ON CONFLICT (id) DO NOTHING;
INSERT INTO cars (id, brand, model, type, production_year, engine, color, picture, price, place_id) VALUES (6, 'Alfa Romeo', '4C', 'Coupe', '2017', '1.7 / 240KM', 'Red', '/resources/images/car-6.jpg', 800.00, 11) ON CONFLICT (id) DO NOTHING;
INSERT INTO cars (id, brand, model, type, production_year, engine, color, picture, price, place_id) VALUES (7, 'Mercedes', 'S65 AMG', 'Coupe', '2020', '6.0 / 630KM', 'Silver', '/resources/images/car-7.jpg', 800.00, 10) ON CONFLICT (id) DO NOTHING;
INSERT INTO cars (id, brand, model, type, production_year, engine, color, picture, price, place_id) VALUES (8, 'Jeep', 'WRANGLER RUBICON', 'SUV', '2018', '2.0 / 272KM', 'Red', '/resources/images/car-8.jpg', 500.00, 9) ON CONFLICT (id) DO NOTHING;
INSERT INTO cars (id, brand, model, type, production_year, engine, color, picture, price, place_id) VALUES (9, 'Mercedes', 'AMG GT S', 'Coupe', '2016', '4.0 / 585KM', 'Silver', '/resources/images/car-9.jpg', 900.00, 8) ON CONFLICT (id) DO NOTHING;
INSERT INTO cars (id, brand, model, type, production_year, engine, color, picture, price, place_id) VALUES (10, 'Mercedes', 'AMG GTR', 'Coupe', '2021', '4.0 / 730KM', 'Yellow', '/resources/images/car-10.jpg', 950.00, 7) ON CONFLICT (id) DO NOTHING;
INSERT INTO cars (id, brand, model, type, production_year, engine, color, picture, price, place_id) VALUES (11, 'Mercedes', 'A AMG', 'Hatchback', '2015', '2.0 / 360KM', 'Blue', '/resources/images/car-11.jpg', 550.00, 6) ON CONFLICT (id) DO NOTHING;
INSERT INTO cars (id, brand, model, type, production_year, engine, color, picture, price, place_id) VALUES (12, 'Audi', 'A1', 'Hatchback', '2015', '1.4 / 185KM', 'Black', '/resources/images/car-12.jpg', 400.00, 5) ON CONFLICT (id) DO NOTHING;

--ADMIN
INSERT INTO clients (id, first_name, last_name, phone_number, email, nick, password, roles, enable) VALUES (1, 'admin', 'admin', '123123123', 'admin@test.com', 'admin', '$2a$10$08Y9A88VL9OROhOBrIb9puJlrC9cYjM0hAMJ.JUVjMtc6f.5il8G2', 'ROLE_ADMIN', TRUE) ON CONFLICT (id) DO NOTHING;