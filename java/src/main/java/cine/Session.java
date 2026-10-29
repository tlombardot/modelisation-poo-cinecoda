package cine;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
/**
 * Session
 */
public class Session {
    private static final Logger log = ConsoleLogger.create("cine.session");
    

    private final Room room;
    private final Media media;
    private final LocalDate dateTime;
    private final List<Ticket> tickets;
    private final double basePrice;

    public Session(Room room, Media media, LocalDate dateTime, double basePrice) {
        this.room = room;
        this.media = media;
        this.dateTime = dateTime;
        this.basePrice = basePrice;
        this.tickets = new ArrayList<>();
    }

    public void sellTicket(Ticket ticket) {
        if(tickets.size() >= room.getCapacity()) {
            throw new IllegalStateException("Vente refusée : la séance est complète (" + room.getCapacity() + " places)");
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
            revenue += ticket.getPrice(basePrice);
        }
        return revenue;
    }

    public void start() {
        if (room.getState() != RoomState.READY) {
            String motif = (room.getState() == RoomState.IN_CLEANING) ? "NETTOYAGE" : "EN SÉANCE";
            throw new IllegalStateException("Démarrage refusé : la " + room.getName()
                    + " n'est pas libre (état : " + motif + ")");
        }
        media.validateForStart(room.getProjectorType(), dateTime);
        room.startSession();
    }

    public void end() {
        room.endSession();
        media.onSessionEnded();
    }

    public void printSelling() {
        for (Ticket ticket : tickets) {
            double price = ticket.getPrice(basePrice);
            log.info(() -> String.format(Locale.FRANCE, "Billet %s vendu : %.2f €", ticket.getLabel(), price));
        }
    }

    public void printSeatRemaining() {
        log.info(() -> "Places restantes : " + getRemainingSeats());
    }
    
    public void printRevenue() {
        log.info(() -> String.format(Locale.FRANCE, "Recette : %.2f €", getRevenue()));
    }

    public void printOccupancyRate() {
        log.info(() -> String.format("Taux de remplissage : %.0f %%", getOccupancyRate() * 100));
    }

    public Room getRoom() {
        return room;
    }

    public Media getMedia() {
        return media;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

}
