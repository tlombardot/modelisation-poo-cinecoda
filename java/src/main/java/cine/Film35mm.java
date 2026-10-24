package cine;

public class Film35mm extends Media {
    private final int numberOfProjections;


    public Film35mm(Movie movie, int numberOfProjections) {
        super(movie);
        this.numberOfProjections = numberOfProjections;
    }

    public int getNumberOfProjections() {
        return numberOfProjections;
    }
}
