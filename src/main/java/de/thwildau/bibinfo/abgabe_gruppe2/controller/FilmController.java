package de.thwildau.bibinfo.abgabe_gruppe2.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.thwildau.bibinfo.abgabe_gruppe2.model.Film;
import de.thwildau.bibinfo.abgabe_gruppe2.model.Genre;
import de.thwildau.bibinfo.abgabe_gruppe2.model.Land;
import de.thwildau.bibinfo.abgabe_gruppe2.model.Regisseur;
import de.thwildau.bibinfo.abgabe_gruppe2.repository.FilmRepository;
import de.thwildau.bibinfo.abgabe_gruppe2.repository.GenreRepository;
import de.thwildau.bibinfo.abgabe_gruppe2.repository.LandRepository;
import de.thwildau.bibinfo.abgabe_gruppe2.repository.RegisseurRepository;

import java.util.Comparator;
import java.util.List;

/**
 * Controller für die Verwaltung von Filmen.
 * Verarbeitet Anfragen für die Filmeingabe und -anzeige.
 */
@Controller
public class FilmController {

    private final FilmRepository filmRepository;
    private final GenreRepository genreRepository;
    private final LandRepository landRepository;
    private final RegisseurRepository regisseurRepository;

    /**
     * Konstruktor mit Dependency Injection der benötigten Repositories.
     *
     * @param filmRepository Repository für Filmzugriffe
     * @param genreRepository Repository für Genrezugriffe
     * @param landRepository Repository für Landzugriffe
     * @param regisseurRepository Repository für Regisseurzugriffe
     */
    public FilmController(FilmRepository filmRepository,
                          GenreRepository genreRepository,
                          LandRepository landRepository,
                          RegisseurRepository regisseurRepository) {
        this.filmRepository = filmRepository;
        this.genreRepository = genreRepository;
        this.landRepository = landRepository;
        this.regisseurRepository = regisseurRepository;
    }

    /**
     * Zeigt die Übersicht aller gespeicherten Filme an.
     * Die Liste kann nach Titel, Jahr, Genre oder Regie sortiert werden.
     * Unterstützt Freitextsuche über Titel, Originaltitel, Grenre, Regie und Land.
     *
     * @param sortierung Sortierkriterium (titel, jahr, genre, regie), Standard: titel.
     * @param suche Freitextsuche, optional.
     * @param model das Model zur Übergabe von Daten an die View.
     * @return Name des Thymeleaf-Templates für die Filmübersicht.
     */
    @GetMapping("/filme")
    public String zeigeFilmListe(
            @RequestParam(defaultValue = "titel") String sortierung,
            @RequestParam(defaultValue = "") String suche, Model model) {

        List<Film> alleFilme = filmRepository.suche(suche);

        if (sortierung.equals("jahr")) {
            alleFilme.sort(Comparator.comparingInt(Film::getJahr));
        } else if (sortierung.equals("genre")) {
            alleFilme.sort(Comparator.comparing(f ->
                    f.getGenres().isEmpty() ? "" :
                            f.getGenres().iterator().next().getName()));
        } else if (sortierung.equals("regie")) {
            alleFilme.sort(Comparator.comparing(f ->
                    f.getRegisseure().isEmpty() ? "" :
                            f.getRegisseure().iterator().next().getNachname()));
        } else {
            alleFilme.sort(Comparator.comparing(Film::getTitel));
        }

        model.addAttribute("alleFilme", alleFilme);
        model.addAttribute("sortierung", sortierung);
        model.addAttribute("suche", suche);
        return "film-liste";
    }

    /**
     * Zeigt das Formular zur Eingabe eines neuen Films an.
     *
     * @param model das Model zur Übergabe von Daten an die View
     * @return Name des Thymeleaf-Templates
     */
    @GetMapping("/filme/neu")
    public String zeigeFormular(Model model) {
        model.addAttribute("film", new Film());
        return "film-formular";
    }

    /**
     * Verarbeitet das ausgefüllte Formular und speichert den Film in der Datenbank.
     *
     * @param film das ausgefüllte Film-Objekt aus dem Formular
     * @param result enthält eventuelle Validierungsfehler
     * @param genreEingabe kommaseparierte Genres als Freitext
     * @param landEingabe kommaseparierte Länder als Freitext
     * @param regisseurEingabe kommaseparierte Regisseure als Freitext
     * @param model das Model zur Übergabe von Daten an die View
     * @return Weiterleitung zur Übersicht oder zurück zum Formular bei Fehler
     */
    @PostMapping("/filme/neu")
    public String speichereFilm(@Valid @ModelAttribute("film") Film film,
                                BindingResult result,
                                @RequestParam(defaultValue = "") String genreEingabe,
                                @RequestParam(defaultValue = "") String landEingabe,
                                @RequestParam(defaultValue = "") String regisseurEingabe,
                                Model model) {
        // Pflichtfeld-Validierung für Freitexteingaben
        if (genreEingabe.isBlank()) {
            result.rejectValue("genres", "error.genres", "Genre darf nicht leer sein");
        }
        if (landEingabe.isBlank()) {
            result.rejectValue("laender", "error.laender", "Land darf nicht leer sein");
        }
        if (regisseurEingabe.isBlank()) {
            result.rejectValue("regisseure", "error.regisseure", "Regisseur darf nicht leer sein");
        }

        if (result.hasErrors()) {
            return "film-formular";
        }

        // Genres verarbeiten
        for (String genreNameRaw : genreEingabe.split(",")) {
            String genreName = genreNameRaw.trim();
            if (!genreName.isBlank()) {
                Genre genre = genreRepository.findByName(genreName)
                                             .orElseGet(() -> genreRepository.save(
                                                 Genre.builder().name(genreName).build()
                                                                                  ));
                film.getGenres().add(genre);
            }
        }

        // Länder verarbeiten
        for (String landNameRaw : landEingabe.split(",")) {
            String landName = landNameRaw.trim();
            if (!landName.isBlank()) {
                Land land = landRepository.findByName(landName)
                                          .orElseGet(() -> landRepository.save(
                                              Land.builder().name(landName).build()
                                                                              ));
                film.getLaender().add(land);
            }
        }

        // Regisseure verarbeiten (Format: "Vorname Nachname")
        for (String regisseurNameRaw : regisseurEingabe.split(",")) {
            String regisseurName = regisseurNameRaw.trim();
            String[] teile = regisseurName.split(" ");
            if (teile.length >= 2) {
                String vorname = teile[0];
                String nachname = teile[1];
                Regisseur regisseur = regisseurRepository.findByVornameAndNachname(vorname, nachname)                                                                                                                                                                                        .orElseGet(() -> regisseurRepository.save(
                    Regisseur.builder().vorname(vorname).nachname(nachname).build()
                                                                                                                                                                                                                                                                                                                                      ));                                                                                                                                               film.getRegisseure().add(regisseur);
            } else {
                result.rejectValue("regisseure", "error.regisseure",
                                   "Regisseur muss als 'Vorname Nachname' angegeben werden");
                return "film-formular";
            }
        }

        filmRepository.save(film);
        return "redirect:/filme";
    }
}