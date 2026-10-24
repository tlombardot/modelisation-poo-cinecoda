package cine;

public class DCP extends Media {
    private final String keyExpirationDate;

    public DCP(Movie movie, String keyExpirationDate) {
        super(movie);
        this.keyExpirationDate = keyExpirationDate;
    }
    
    public String getKeyExpirationDate() {
        return keyExpirationDate;
    }
}
