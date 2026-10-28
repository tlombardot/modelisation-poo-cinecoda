package cine;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Session
 */
public class Session {
    private final Room room;
    private final Media media;
    private final LocalDateTime dateTime;
    private final double basePrice;
    private final List<Ticket> tickets;

    public Session(Room room, Media media, LocalDateTime dateTime, double basePrice) {
        this.room = room;
        this.media = media;
        this.dateTime = dateTime;
        this.basePrice = basePrice;
        this.tickets = new ArrayList<>();
    }



}
