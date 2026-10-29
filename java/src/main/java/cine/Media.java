package cine;

import java.time.LocalDate;

abstract class Media {
    private final Movie movie;

    protected Media(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public abstract void validateForStart(Projector projector, LocalDate sessionDate);

    public void onSessionEnded() {
    }
}