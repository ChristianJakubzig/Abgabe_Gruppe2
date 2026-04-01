package de.thwildau.bibinfo.abgabe_gruppe2.repository;

import java.util.Optional;

import de.thwildau.bibinfo.abgabe_gruppe2.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository für den Datenbankzugriff auf Genre-Entitäten.
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    /**
     * Sucht ein Genre anhand seines Namens.
     *
     * @param name der Name des Genres
     * @return das gefundene Genre oder leer wenn nicht vorhanden
     */
    Optional<Genre> findByName(String name);
}