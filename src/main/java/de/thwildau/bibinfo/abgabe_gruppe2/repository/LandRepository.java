package de.thwildau.bibinfo.abgabe_gruppe2.repository;

import java.util.Optional;

import de.thwildau.bibinfo.abgabe_gruppe2.model.Land;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository für den Datenbankzugriff auf Land-Entitäten.
 */
@Repository
public interface LandRepository extends JpaRepository<Land, Long> {

    /**
     * Sucht ein Land anhand seines Namens.
     *
     * @param name der Name des Landes
     * @return das gefundene Land oder leer wenn nicht vorhanden
     */
    Optional<Land> findByName(String name);
}