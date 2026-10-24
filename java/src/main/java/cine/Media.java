package cine;

abstract class Media {
    private final Movie movie;

    protected Media(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}