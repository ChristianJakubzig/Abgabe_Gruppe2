package de.thwildau.bibinfo.abgabe_gruppe2.config;

import de.thwildau.bibinfo.abgabe_gruppe2.resource.FilmResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Konfigurationsklasse für Jersey JAX-RS.
 * Registriert alle JAX-RS Ressourcen als Servlet.
 */
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(FilmResource.class);
    }
}