package de.thwildau.bibinfo.abgabe_gruppe2.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;

/**
 * DTO für die XML-Darstellung eines Regisseurs.
 * Wird von JAXB als Kindelement innerhalb eines Films verwendet.
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisseurXml {

    /**
     * Vorname des Regisseurs.
     */
    @XmlElement
    private String vorname;

    /**
     * Nachname des Regisseurs.
     */
    @XmlElement
    private String nachname;
}