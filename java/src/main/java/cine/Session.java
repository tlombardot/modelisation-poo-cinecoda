package cine;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Session
 */
public class Session {
    private final Room room;
    private final Media media;
    private final LocalDate dateTime;
    private final double basePrice;
    private final List<Ticket> tickets;

    public Session(Room room, Media media, LocalDate dateTime, double basePrice) {
        this.room = room;
        this.media = media;
        this.dateTime = dateTime;
        this.basePrice = basePrice;
        this.tickets = new ArrayList<>();
    }

    public void sellTicket(Ticket ticket) {
        if(tickets.size() >= room.getCapacity()) {
            throw new IllegalStateException("No more tickets available for this session");
        }
        tickets.add(ticket);
    }

    public int getRemainingSeats() {
        return room.getCapacity() - tickets.size();
    }

    public double getOccupancyRate() {
        return (double) tickets.size() / room.getCapacity();
    }

    public double getRevenue() {
        double revenue = 0.0;
        for (Ticket ticket : tickets) {
            revenue += ticket.getPrice(this.basePrice);
        }
        return revenue;
    }

}
