package de.thwildau.bibinfo.abgabe_gruppe2.resource;

import jakarta.ws.rs.GET;                                                                                                                                                                                                           import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import de.thwildau.bibinfo.abgabe_gruppe2.dto.FilmListeXml;
import de.thwildau.bibinfo.abgabe_gruppe2.dto.FilmXml;
import de.thwildau.bibinfo.abgabe_gruppe2.dto.RegisseurXml;                                                                                                                                                                         import de.thwildau.bibinfo.abgabe_gruppe2.model.Film;
import de.thwildau.bibinfo.abgabe_gruppe2.model.Genre;
import de.thwildau.bibinfo.abgabe_gruppe2.model.Land;
import de.thwildau.bibinfo.abgabe_gruppe2.model.Regisseur;
import de.thwildau.bibinfo.abgabe_gruppe2.repository.FilmRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
/**
 * JAX-RS Ressource für den Zugriff auf Filmdaten.
 * Stellt einen REST-Endpunkt zur Verfügung der alle Filme als XML zurückgibt.
 */
@Path("/filme")
@Component                                                                                                                                                                                                                          public class FilmResource {

    private final FilmRepository filmRepository;

    /**
     * Konstruktor mit FilmRepository.
     *
     * @param filmRepository Repository für den Datenbankzugriff auf Filme
     */
    public FilmResource(FilmRepository filmRepository) {                                                                                                                                                                                    this.filmRepository = filmRepository;
    }

    /**
     * Gibt alle in der Datenbank gespeicherten Filme als XML zurück.
     *
     * @return Liste aller Filme als XML
     *  @throws Exception bei Datenbankfehlern
     */                                                                                                                                                                                                                                 @GET
    @Produces(MediaType.APPLICATION_XML)
    @Transactional
    public Response alleFilme() {
        try {
            List<FilmXml> filmXmlListe = new ArrayList<>();

            for (Film film : filmRepository.findAll()) {                                                                                                                                                                                            List<String> genres = new ArrayList<>();
                for (Genre g : film.getGenres()) {
                    genres.add(g.getName());
                }

                List<String> laender = new ArrayList<>();                                                                                                                                                                                           for (Land l : film.getLaender()) {
                    laender.add(l.getName());
                }

                List<RegisseurXml> regisseure = new ArrayList<>();
                for (Regisseur r : film.getRegisseure()) {
                    regisseure.add(RegisseurXml.builder()                                                                                                                                                                                                                          .vorname(r.getVorname())
                                               .nachname(r.getNachname())
                                               .build());
                }

                filmXmlListe.add(FilmXml.builder()                                                                                                                                                                                                                          .filmId(film.getFilmId())
                                        .titel(film.getTitel())
                                        .originaltitel(film.getOriginaltitel())
                                        .jahr(film.getJahr())
                                        .inhalt(film.getInhalt())                                                                                                                                                                                                           .laenge(film.getLaenge())
                                        .bildUrl(film.getBildUrl())
                                        .genres(genres)
                                        .laender(laender)
                                        .regisseure(regisseure)                                                                                                                                                                                                             .build());
            }

            return Response.ok(FilmListeXml.builder().filme(filmXmlListe).build()).build();

        } catch (Exception e) {
            return Response.serverError()
                           .entity("Fehler beim Laden der Filme")                                                                                                                                                                                              .build();
        }
    }
}
