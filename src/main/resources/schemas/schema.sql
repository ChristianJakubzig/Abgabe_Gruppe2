-- =========================================================================
-- Filmdatenbank Schema
-- =========================================================================

-- Tabelle: GENRE
CREATE TABLE IF NOT EXISTS GENRE (
    genre_id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL UNIQUE
);

-- Tabelle: LAND
CREATE TABLE IF NOT EXISTS LAND (
    land_id     BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL UNIQUE
);

-- Tabelle: REGISSEUR
CREATE TABLE IF NOT EXISTS REGISSEUR (
    regisseur_id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    vorname         VARCHAR(100) NOT NULL,
    nachname        VARCHAR(100) NOT NULL
);

-- Tabelle: FILM
CREATE TABLE IF NOT EXISTS FILM (
    film_id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    titel           VARCHAR(200) NOT NULL,
    originaltitel   VARCHAR(200),
    jahr            INT NOT NULL,
    inhalt          VARCHAR(2000) NOT NULL,
    laenge          INT NOT NULL,
    bild_url        VARCHAR(500)
);

-- Tabelle: FILM_GENRE
CREATE TABLE IF NOT EXISTS FILM_GENRE (
    film_id     BIGINT NOT NULL,
    genre_id    BIGINT NOT NULL,
    PRIMARY KEY (film_id, genre_id),
    CONSTRAINT fk_filmgenre_film
        FOREIGN KEY (film_id) REFERENCES FILM(film_id) ON DELETE CASCADE,
    CONSTRAINT fk_filmgenre_genre
        FOREIGN KEY (genre_id) REFERENCES GENRE(genre_id) ON DELETE CASCADE
);

-- Tabelle: FILM_LAND
CREATE TABLE IF NOT EXISTS FILM_LAND (
    film_id     BIGINT NOT NULL,
    land_id     BIGINT NOT NULL,
    PRIMARY KEY (film_id, land_id),
    CONSTRAINT fk_filmland_film
        FOREIGN KEY (film_id) REFERENCES FILM(film_id) ON DELETE CASCADE,
    CONSTRAINT fk_filmland_land
        FOREIGN KEY (land_id) REFERENCES LAND(land_id) ON DELETE CASCADE
);

-- Tabelle: FILM_REGIE
CREATE TABLE IF NOT EXISTS FILM_REGIE (
    film_id         BIGINT NOT NULL,
    regisseur_id    BIGINT NOT NULL,
    PRIMARY KEY (film_id, regisseur_id),
    CONSTRAINT fk_filmregie_film
        FOREIGN KEY (film_id) REFERENCES FILM(film_id) ON DELETE CASCADE,
    CONSTRAINT fk_filmregie_regisseur
        FOREIGN KEY (regisseur_id) REFERENCES REGISSEUR(regisseur_id) ON DELETE CASCADE
);

-- =========================================================================
-- Indizes für häufige Suchanfragen
-- =========================================================================

-- Suche nach Filmtitel
CREATE INDEX IF NOT EXISTS idx_film_titel
    ON FILM(titel);

-- Suche nach Originaltitel
CREATE INDEX IF NOT EXISTS idx_film_originaltitel
    ON FILM(originaltitel);

-- Suche nach Jahr
CREATE INDEX IF NOT EXISTS idx_film_jahr
    ON FILM(jahr);

-- Suche nach Genre
CREATE INDEX IF NOT EXISTS idx_genre_name
    ON GENRE(name);

-- Suche nach Regisseur (Nachname)
CREATE INDEX IF NOT EXISTS idx_regisseur_nachname
    ON REGISSEUR(nachname);

-- Suche nach Land
CREATE INDEX IF NOT EXISTS idx_land_name
    ON LAND(name);