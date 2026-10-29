package cine;

import java.time.LocalDate;
import java.util.logging.Logger;

public class Film35mm extends Media {
    private static final Logger log = ConsoleLogger.create("cine.film35mm");
    private int numberOfProjections;


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

    public void incrementNumberOfProjections() {
        this.numberOfProjections++;
    }

    @Override
    public void validateForStart(Projector projector, LocalDate sessionDate) {
        if (projector.isDigital()) {
            throw new IllegalStateException("Démarrage refusé : une copie 35 mm ne peut pas être lue par un projecteur numérique");
        }
        if (numberOfProjections >= 50) {
            throw new IllegalStateException("Démarrage refusé : la copie 35 mm de « " + getMovie().getTitle() + " » est usée (" + numberOfProjections + " projections)");
        }
    }

    @Override
    public void onSessionEnded() {
        incrementNumberOfProjections();
    }
}
