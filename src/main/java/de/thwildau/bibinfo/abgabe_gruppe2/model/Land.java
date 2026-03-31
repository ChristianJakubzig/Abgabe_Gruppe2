package de.thwildau.bibinfo.abgabe_gruppe2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entität für ein Produktionsland eines Films.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Land {

    /**
     * Eindeutige ID des Landes.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long landId;

    /**
     * Name des Landes.
     */
    @Column(nullable = false)
    private String name;
}