package de.thwildau.bibinfo.abgabe_gruppe2.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entität für einen Regisseur eines Films.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Regisseur {

    /**
     * Eindeutige ID des Regisseurs.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regisseurId;

    /**
     * Vorname des Regisseurs.
     */
    @Column(nullable = false)
    private String vorname;

    /**
     * Nachname des Regisseurs.
     */
    @Column(nullable = false)
    private String nachname;
}