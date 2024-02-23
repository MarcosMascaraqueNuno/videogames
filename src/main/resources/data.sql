-- Inserción de categorías
INSERT INTO Category (uuid, category_name, multiplayer)
VALUES (UUID(), 'Shooter', 'Yes');

INSERT INTO Category (uuid, category_name, multiplayer)
VALUES (UUID(), 'Sports', 'Yes');

INSERT INTO Category (uuid, category_name, multiplayer)
VALUES (UUID(), 'Adventure', 'No'); -- Corregido a 'Adventure'

-- Inserción de juegos con más columnas y referencias a categorías
INSERT INTO Game (uuid, title, platform, launch, rating, description, price, category_id)
VALUES (UUID(), 'Fortnite', 'Multiplataforma', '21 Julio 2017', 74, 'Es un shooter gratuito', 'Free', 1); -- 1 es el ID de la categoría 'Shooter'

INSERT INTO Game (uuid, title, platform, launch, rating, description, price, category_id)
VALUES (UUID(), 'EA FC 24', 'Multiplataforma', '29 Septiembre 2023', 78, 'Juego de futbol de toda la vida', 79.99, 2); -- 2 es el ID de la categoría 'Sports'

INSERT INTO Game (uuid, title, platform, launch, rating, description, price, category_id)
VALUES (UUID(), 'God Of War Ragnarok', 'Multiplataforma', '9 Noviembre 2022', 98, 'Juego de aventuras', 79.99, 3); -- 3 es el ID de la categoría 'Adventure'
