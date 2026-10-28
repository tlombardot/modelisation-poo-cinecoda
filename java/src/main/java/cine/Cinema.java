package cine;
import java.time.LocalDateTime;

public class Cinema {

    private final String name;


    public Cinema(String name) {
        this.name = name;
    }

    public Session scheduleSessions(Room room, Media media, LocalDateTime dateTime, double basePrice) {
        // Implementation for scheduling sessions
        return new Session(room, media, dateTime, basePrice);
    }
    

}
