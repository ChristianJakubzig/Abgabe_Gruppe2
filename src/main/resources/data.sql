-- Regisseure
INSERT INTO REGISSEUR (vorname, nachname) VALUES ('Christopher', 'Nolan');
INSERT INTO REGISSEUR (vorname, nachname) VALUES ('Steven', 'Spielberg');
INSERT INTO REGISSEUR (vorname, nachname) VALUES ('Quentin', 'Tarantino');
INSERT INTO REGISSEUR (vorname, nachname) VALUES ('Peter', 'Jackson');
INSERT INTO REGISSEUR (vorname, nachname) VALUES ('Ridley', 'Scott');
INSERT INTO REGISSEUR (vorname, nachname) VALUES ('James', 'Cameron');
INSERT INTO REGISSEUR (vorname, nachname) VALUES ('David', 'Fincher');

-- Genres
INSERT INTO GENRE (name) VALUES ('Science-Fiction');
INSERT INTO GENRE (name) VALUES ('Thriller');
INSERT INTO GENRE (name) VALUES ('Drama');
INSERT INTO GENRE (name) VALUES ('Action');
INSERT INTO GENRE (name) VALUES ('Fantasy');
INSERT INTO GENRE (name) VALUES ('Crime');

-- Länder
INSERT INTO LAND (name) VALUES ('USA');
INSERT INTO LAND (name) VALUES ('Großbritannien');
INSERT INTO LAND (name) VALUES ('Neuseeland');
INSERT INTO LAND (name) VALUES ('Deutschland');

-- Filme
INSERT INTO FILM (titel, originaltitel, jahr, inhalt, laenge, bild_url) VALUES ('Inception', 'Inception', 2010, 'Ein Dieb, der Geheimnisse aus Träumen stiehlt, soll eine Idee in den Geist eines Managers pflanzen.', 148, 'https://image.tmdb.org/t/p/w500/xlaY2zyzMfkhk0HSC5VUwzoZPU1.jpg');
INSERT INTO FILM (titel, originaltitel, jahr, inhalt, laenge, bild_url) VALUES ('Interstellar', 'Interstellar', 2014, 'Astronauten reisen durch ein Wurmloch auf der Suche nach einem neuen Heimatplaneten für die Menschheit.', 169, 'https://image.tmdb.org/t/p/w500/yQvGrMoipbRoddT0ZR8tPoR7NfX.jpg');
INSERT INTO FILM (titel, originaltitel, jahr, inhalt, laenge, bild_url) VALUES ('Schindlers Liste', 'Schindler''s List', 1993, 'Oskar Schindler rettet während des Zweiten Weltkriegs über tausend jüdische Leben.', 195, 'https://image.tmdb.org/t/p/w500/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jpg');
INSERT INTO FILM (titel, originaltitel, jahr, inhalt, laenge, bild_url) VALUES ('Pulp Fiction', 'Pulp Fiction', 1994, 'Mehrere Kriminellen-Geschichten im Los Angeles der 1990er Jahre verflechten sich auf unerwartete Weise.', 154, 'https://image.tmdb.org/t/p/w500/vQWk5YBFWF4bZaofAbv0tShwBvQ.jpg');
INSERT INTO FILM (titel, originaltitel, jahr, inhalt, laenge, bild_url) VALUES ('Der Herr der Ringe: Die Gefährten', 'The Lord of the Rings: The Fellowship of the Ring', 2001, 'Der Hobbit Frodo bricht mit acht Gefährten auf, um den einen Ring zu vernichten.', 178, 'https://image.tmdb.org/t/p/w500/6oom5QYQ2yQTMJIbnvbkBL9cHo6.jpg');
INSERT INTO FILM (titel, originaltitel, jahr, inhalt, laenge, bild_url) VALUES ('Gladiator', 'Gladiator', 2000, 'Ein römischer General wird versklavt und kämpft als Gladiator um Rache und Ehre.', 155, 'https://image.tmdb.org/t/p/w500/wN2xWp1eIwCKOD0BHTcErTBv1Uq.jpg');
INSERT INTO FILM (titel, originaltitel, jahr, inhalt, laenge, bild_url) VALUES ('Titanic', 'Titanic', 1997, 'Eine Liebesgeschichte zwischen zwei Menschen unterschiedlicher Gesellschaftsschichten auf dem Unglücksschiff.', 194, 'https://image.tmdb.org/t/p/w500/9xjZS2rlVxm8SFx8kPC3aIGCOYQ.jpg');
INSERT INTO FILM (titel, originaltitel, jahr, inhalt, laenge, bild_url) VALUES ('Fight Club', 'Fight Club', 1999, 'Ein unzufriedener Angestellter gründet mit einem Seifenverkäufer einen geheimen Kampfclub.', 139, 'https://image.tmdb.org/t/p/w500/jSziioSwPVrOy9Yow3XhWIBDjq1.jpg');
INSERT INTO FILM (titel, originaltitel, jahr, inhalt, laenge, bild_url) VALUES ('Das Schweigen der Lämmer', 'The Silence of the Lambs', 1991, 'Eine FBI-Agentin bittet den inhaftierten Kannibalen Hannibal Lecter um Hilfe bei der Jagd auf einen Serienmörder.', 118, 'https://image.tmdb.org/t/p/w500/uS9m8OBk1A8eM9I042bx8XXpqAq.jpg');
INSERT INTO FILM (titel, originaltitel, jahr, inhalt, laenge, bild_url) VALUES ('Avatar', 'Avatar', 2009, 'Ein gelähmter Marine reist auf den Planeten Pandora und gerät zwischen die Fronten eines Konflikts.', 162, 'https://image.tmdb.org/t/p/w500/gKY6q7SjCkAU6FqvqWybDYgUKIF.jpg');

-- Film ↔ Regisseur
INSERT INTO FILM_REGIE (film_id, regisseur_id) VALUES (1, 1); -- Inception → Nolan
INSERT INTO FILM_REGIE (film_id, regisseur_id) VALUES (2, 1); -- Interstellar → Nolan
INSERT INTO FILM_REGIE (film_id, regisseur_id) VALUES (3, 2); -- Schindlers Liste → Spielberg
INSERT INTO FILM_REGIE (film_id, regisseur_id) VALUES (4, 3); -- Pulp Fiction → Tarantino
INSERT INTO FILM_REGIE (film_id, regisseur_id) VALUES (5, 4); -- HdR → Jackson
INSERT INTO FILM_REGIE (film_id, regisseur_id) VALUES (6, 5); -- Gladiator → Scott
INSERT INTO FILM_REGIE (film_id, regisseur_id) VALUES (7, 6); -- Titanic → Cameron
INSERT INTO FILM_REGIE (film_id, regisseur_id) VALUES (8, 7); -- Fight Club → Fincher
INSERT INTO FILM_REGIE (film_id, regisseur_id) VALUES (9, 7); -- Schweigen der Lämmer → Fincher
INSERT INTO FILM_REGIE (film_id, regisseur_id) VALUES (10, 6); -- Avatar → Cameron

-- Film ↔ Genre
INSERT INTO FILM_GENRE (film_id, genre_id) VALUES (1, 1); -- Inception → Science-Fiction
INSERT INTO FILM_GENRE (film_id, genre_id) VALUES (1, 2); -- Inception → Thriller
INSERT INTO FILM_GENRE (film_id, genre_id) VALUES (2, 1); -- Interstellar → Science-Fiction
INSERT INTO FILM_GENRE (film_id, genre_id) VALUES (2, 3); -- Interstellar → Drama
INSERT INTO FILM_GENRE (film_id, genre_id) VALUES (3, 3); -- Schindlers Liste → Drama
INSERT INTO FILM_GENRE (film_id, genre_id) VALUES (4, 6); -- Pulp Fiction → Crime
INSERT INTO FILM_GENRE (film_id, genre_id) VALUES (5, 5); -- HdR → Fantasy
INSERT INTO FILM_GENRE (film_id, genre_id) VALUES (6, 4); -- Gladiator → Action
INSERT INTO FILM_GENRE (film_id, genre_id) VALUES (7, 3); -- Titanic → Drama
INSERT INTO FILM_GENRE (film_id, genre_id) VALUES (8, 2); -- Fight Club → Thriller
INSERT INTO FILM_GENRE (film_id, genre_id) VALUES (9, 2); -- Schweigen der Lämmer → Thriller
INSERT INTO FILM_GENRE (film_id, genre_id) VALUES (10, 1); -- Avatar → Science-Fiction

-- Film ↔ Land
INSERT INTO FILM_LAND (film_id, land_id) VALUES (1, 1);  -- Inception → USA
INSERT INTO FILM_LAND (film_id, land_id) VALUES (1, 2);  -- Inception → GB
INSERT INTO FILM_LAND (film_id, land_id) VALUES (2, 1);  -- Interstellar → USA
INSERT INTO FILM_LAND (film_id, land_id) VALUES (3, 1);  -- Schindlers Liste → USA
INSERT INTO FILM_LAND (film_id, land_id) VALUES (4, 1);  -- Pulp Fiction → USA
INSERT INTO FILM_LAND (film_id, land_id) VALUES (5, 3);  -- HdR → Neuseeland
INSERT INTO FILM_LAND (film_id, land_id) VALUES (6, 1);  -- Gladiator → USA
INSERT INTO FILM_LAND (film_id, land_id) VALUES (7, 1);  -- Titanic → USA
INSERT INTO FILM_LAND (film_id, land_id) VALUES (8, 1);  -- Fight Club → USA
INSERT INTO FILM_LAND (film_id, land_id) VALUES (9, 1);  -- Schweigen der Lämmer → USA
INSERT INTO FILM_LAND (film_id, land_id) VALUES (10, 1); -- Avatar → USA