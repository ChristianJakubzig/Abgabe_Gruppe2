package de.thwildau.bibinfo.abgabe_gruppe2.repository;

import de.thwildau.bibinfo.abgabe_gruppe2.model.Regisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository für den Datenbankzugriff auf Regisseur-Entitäten.
 */
@Repository
public interface RegisseurRepository extends JpaRepository<Regisseur, Long> {
}