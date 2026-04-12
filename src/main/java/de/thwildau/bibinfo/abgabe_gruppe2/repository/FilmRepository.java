package de.thwildau.bibinfo.abgabe_gruppe2.repository;

import de.thwildau.bibinfo.abgabe_gruppe2.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Repository für den Datenbankzugriff auf Film-Entitäten.
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    /**
     * JPQL sucht Filme in Titel, Originaltitel, Genre, Land sowie
     * Vor- und Nachname des Regisseurs.
     *
     * @param suche der Suchbegriff
     * @return Liste der passenden Filme
     */
    @Query("SELECT DISTINCT f FROM Film f " +
            "LEFT JOIN f.genres g " +
            "LEFT JOIN f.laender l " +
            "LEFT JOIN f.regisseure r " +
            "WHERE :suche = '' OR " +
            "LOWER(f.titel) LIKE LOWER(CONCAT('%', :suche, '%')) OR " +
            "LOWER(f.originaltitel) LIKE LOWER(CONCAT('%', :suche, '%')) OR " +
            "LOWER(g.name) LIKE LOWER(CONCAT('%', :suche, '%')) OR " +
            "LOWER(l.name) LIKE LOWER(CONCAT('%', :suche, '%')) OR " +
            "LOWER(r.nachname) LIKE LOWER(CONCAT('%', :suche, '%')) OR " +
            "LOWER(r.vorname) LIKE LOWER(CONCAT('%', :suche, '%'))")
    List<Film> suche(@Param("suche") String suche);
}