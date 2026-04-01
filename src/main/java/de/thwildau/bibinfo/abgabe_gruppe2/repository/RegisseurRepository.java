package de.thwildau.bibinfo.abgabe_gruppe2.repository;

import java.util.Optional;

import de.thwildau.bibinfo.abgabe_gruppe2.model.Regisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository für den Datenbankzugriff auf Regisseur-Entitäten.
 */
@Repository
public interface RegisseurRepository extends JpaRepository<Regisseur, Long> {

    /**
     * Sucht einen Regisseur anhand von Vor- und Nachname.
     *
     * @param vorname der Vorname des Regisseurs
     * @param nachname der Nachname des Regisseurs
     * @return der gefundene Regisseur oder leer wenn nicht vorhanden
     */
    Optional<Regisseur> findByVornameAndNachname(String vorname, String nachname);
}