package de.thwildau.bibinfo.abgabe_gruppe2.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.thwildau.bibinfo.abgabe_gruppe2.model.Film;
import de.thwildau.bibinfo.abgabe_gruppe2.repository.FilmRepository;
import de.thwildau.bibinfo.abgabe_gruppe2.repository.GenreRepository;
import de.thwildau.bibinfo.abgabe_gruppe2.repository.LandRepository;
import de.thwildau.bibinfo.abgabe_gruppe2.repository.RegisseurRepository;

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
     *
     * @param model das Model zur Übergabe von Daten an die View
     * @return Name des Thymeleaf-Templates für die Filmübersicht
     */
    @GetMapping("/filme")
    public String zeigeFilmListe(Model model) {
        model.addAttribute("alleFilme", filmRepository.findAll());
        return "film-liste";
    }

    /**
     * Zeigt das Formular zur Eingabe eines neuen Films an.
     *
     * @param model das Model zur Übergabe von Daten an die View
     * @return Name des Thymeleaf-Templates
     */
    @GetMapping("/filme/neu")
    public String zeigFormulare(Model model) {
        model.addAttribute("film", new Film());
        model.addAttribute("alleGenres", genreRepository.findAll());
        model.addAttribute("alleLaender", landRepository.findAll());
        model.addAttribute("alleRegisseure", regisseurRepository.findAll());
        return "film-formular";
    }

    /**
     * Verarbeitet das ausgefüllte Formular und speichert den Film in der Datenbank.
     *
     * @param film das ausgefüllte Film-Objekt aus dem Formular
     * @param result enthält eventuelle Validierungsfehler
     * @param model das Model zur Übergabe von Daten an die View
     * @return Weiterleitung zur Übersicht oder zurück zum Formular bei Fehler
     */
    @PostMapping("/filme/neu")
    public String speichereFilm(@Valid @ModelAttribute("film") Film film,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("alleGenres", genreRepository.findAll());
            model.addAttribute("alleLaender", landRepository.findAll());
            model.addAttribute("alleRegisseure", regisseurRepository.findAll());
            return "film-formular";
        }
        filmRepository.save(film);
        return "redirect:/filme";
    }
}
