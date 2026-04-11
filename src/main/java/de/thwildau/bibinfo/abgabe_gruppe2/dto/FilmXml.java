package de.thwildau.bibinfo.abgabe_gruppe2.dto;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

import lombok.*;

/**
 * DTO für die XML-Darstellung eines Films.
 * Wird von JAXB für die Serialisierung in XML verwendet.
 */
@XmlRootElement(name = "film")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmXml {

    /**
     * Eindeutige ID des Films.
     */
    @XmlElement
    private Long filmId;

    /**
     * Deutscher Titel des Films.
     */
    @XmlElement
    private String titel;

    /**
     * Originaltitel des Films.
     */
    @XmlElement
    private String originaltitel;

    /**
     * Erscheinungsjahr des Films.
     */
    @XmlElement
    private int jahr;

    /**
     * Inhaltsbeschreibung des Films.
     */
    @XmlElement
    private String inhalt;

    /**
     * Länge des Films in Minuten.
     */
    @XmlElement
    private int laenge;

    /**
     * Genres des Films.
     */
    @XmlElement
    private List<String> genres;

    /**
     * Produktionsländer des Films.
     */
    @XmlElement
    private List<String> laender;

    /**
     * Regisseure des Films.
     */
    @XmlElement
    private List<RegisseurXml> regisseure;

}
