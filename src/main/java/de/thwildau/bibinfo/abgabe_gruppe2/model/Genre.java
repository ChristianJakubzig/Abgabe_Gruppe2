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
 * Entität für ein Filmgenre.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {

    /**
     * Eindeutige ID des Genres.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long genreId;

    /**
     * Name des Genres.
     */
    @Column(nullable = false)
    private String name;
}
