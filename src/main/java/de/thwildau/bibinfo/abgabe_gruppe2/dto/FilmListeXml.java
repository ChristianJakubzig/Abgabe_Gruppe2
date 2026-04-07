package de.thwildau.bibinfo.abgabe_gruppe2.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;
import java.util.List;

/**
 * Wrapper-DTO für die XML-Darstellung einer Liste von Filmen.
 * Repräsentiert das Wurzelelement "filme" in der XML-Ausgabe.
 */
@XmlRootElement(name = "filme")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmListeXml {

    /**
     * Liste aller Filme.
     */
    @XmlElement(name = "film")
    private List<FilmXml> filme;
}