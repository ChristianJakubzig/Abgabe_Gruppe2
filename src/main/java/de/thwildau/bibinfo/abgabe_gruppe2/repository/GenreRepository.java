package de.thwildau.bibinfo.abgabe_gruppe2.repository;

import de.thwildau.bibinfo.abgabe_gruppe2.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository für den Datenbankzugriff auf Genre-Entitäten.
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}