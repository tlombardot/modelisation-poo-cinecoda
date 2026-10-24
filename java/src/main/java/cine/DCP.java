package cine;

import java.time.LocalDate;

public class DCP extends Media {
    private final LocalDate keyExpirationDate;

    public DCP(Movie movie, LocalDate keyExpirationDate) {
        super(movie);
        this.keyExpirationDate = keyExpirationDate;
    }
    
    public LocalDate getKeyExpirationDate() {
        return keyExpirationDate;
    }
}
