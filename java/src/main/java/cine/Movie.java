package cine;

public class Movie {
    private final String title;
    private final int duration; // Duration in minutes

    public Movie(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}