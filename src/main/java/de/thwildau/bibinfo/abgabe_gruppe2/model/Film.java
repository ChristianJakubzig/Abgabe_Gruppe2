package de.thwildau.bibinfo.abgabe_gruppe2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entität für einen Film in der Filmdatenbank.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {

    /**
     * Eindeutige ID des Films.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmId;

    /**
     * Deutscher Titel des Films.
     */
    @NotBlank(message = "Titel darf nicht leer sein")
    @Size(max = 200, message = "Titel darf maximal 200 Zeichen lang sein")
    @Column(nullable = false)
    private String titel;

    /**
     * Originaltitel des Films – optional.
     */
    @Size(max = 200, message = "Originaltitel darf maximal 200 Zeichen lang sein")
    private String originaltitel;

    /**
     * Erscheinungsjahr des Films. Muss 1888 oder später sein.
     */
    @Min(value = 1888, message = "Jahr muss 1888 oder später sein")
    @Column(nullable = false)
    private int jahr;

    /**
     * Inhaltsbeschreibung des Films.
     */
    @Size(min = 10, message = "Inhalt muss mindestens 10 Zeichen lang sein")
    @Size(max = 2000, message = "Inhalt darf maximal 2000 Zeichen lang sein")
    @Column(nullable = false, length = 2000)
    private String inhalt;

    /**
     * Länge des Films in Minuten.
     */
    @Min(value = 1, message = "Länge muss mindestens 1 Minute sein")
    @Max(value = 600, message = "Länge darf maximal 600 Minuten sein")
    @Column(nullable = false)
    private int laenge;

    /**
     * Genres des Films. Ein Film kann mehrere Genres haben.
     */
    @ManyToMany
    @JoinTable(
        name = "film_genre",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    /**
     * Produktionsländer des Films. Ein Film kann aus mehreren Ländern stammen.
     */
    @ManyToMany
    @JoinTable(
        name = "film_land",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "land_id")
    )
    private Set<Land> laender = new HashSet<>();

    /**
     * Regisseure des Films. Ein Film kann mehrere Regisseure haben.
     */
    @ManyToMany
    @JoinTable(
        name = "film_regie",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "regisseur_id")
    )
    private Set<Regisseur> regisseure = new HashSet<>();

    /**
     * URL zum Coverbild des Films – optional.
     */
    @Size(max = 500, message = "URL darf maximal 500 Zeichen lang sein")
    private String bildUrl;
}