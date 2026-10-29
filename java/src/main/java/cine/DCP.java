package cine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class DCP extends Media {
    private static final Logger log = ConsoleLogger.create("cine.dcp");

    private final LocalDate keyExpirationDate;

    public DCP(Movie movie, LocalDate keyExpirationDate) {
        super(movie);
        this.keyExpirationDate = keyExpirationDate;
    }
    
    public void printMediaInfo() {
        log.info(() -> String.format("%s (%d min) : fichier numérique, clé valable jusqu'au %s",
                getMovie().getTitle(), getMovie().getDuration(),
                keyExpirationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }

    public LocalDate getKeyDate() {
        return keyExpirationDate;
    }

}
