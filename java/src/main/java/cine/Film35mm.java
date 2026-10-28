package cine;

import java.util.logging.Logger;

public class Film35mm extends Media {
    private static final Logger log = ConsoleLogger.create("cine.film35mm");
    private final int numberOfProjections;


    public Film35mm(Movie movie, int numberOfProjections) {
        super(movie);
        this.numberOfProjections = numberOfProjections;
    }

    public int getNumberOfProjections() {
        return numberOfProjections;
    }

    public void printMediaInfo() {
        log.info(() -> String.format("%s (%d min) : copie 35 mm, %d projections",
                getMovie().getTitle(), getMovie().getDuration(),
                numberOfProjections));
    }
}
