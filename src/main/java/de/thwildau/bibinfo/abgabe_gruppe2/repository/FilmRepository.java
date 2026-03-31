package de.thwildau.bibinfo.abgabe_gruppe2.repository;

import de.thwildau.bibinfo.abgabe_gruppe2.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository für den Datenbankzugriff auf Film-Entitäten.
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
}