package cine;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
/**
 * Session
 */
public class Session {
    private static final Logger log = ConsoleLogger.create("cine.session");
    

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

    public void start() {
        if (media instanceof DCP dcp && dateTime.isAfter(dcp.getKeyDate())) {
            String expirationDate = dcp.getKeyDate().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            throw new IllegalStateException("Démarrage refusé : la clé de lecture de « " + dcp.getMovie().getTitle()
                    + " » a expiré le " + expirationDate);
        }
        if (media instanceof DCP && room.getProjectorType() instanceof Projector35mm) {
            throw new IllegalStateException("Démarrage refusé : une copie numérique ne peut pas être lue par un projecteur 35 mm");
        }
        if (media instanceof Film35mm && room.getProjectorType() instanceof ProjectorDigital) {
            throw new IllegalStateException("Démarrage refusé : une copie 35 mm ne peut pas être lue par un projecteur numérique");
        }
        if (room.getState() == RoomState.READY) {
            room.setState(RoomState.IN_SESSION);
        } else {
            throw new IllegalStateException("Démarrage refusé : la "+ room.getName()
             + " n'est pas libre (état : " + room.getState() + ")");
        }
    }

    public void printSelling() {
        for (Ticket ticket : tickets) {
            double price = ticket.getPrice(basePrice);
            String ticketType = ticket.getClass().getSimpleName().toLowerCase();
            String label;
            if (ticketType.contains("student")) {
                label = "étudiant";
            } else if (ticketType.contains("child")) {
                label = "enfant";
            } else if (price == basePrice) {
                label = "plein tarif";
            } else {
                label = "billet";
            }
            log.info(() -> String.format("Billet %s vendu : %.2f €", label, price));
        }
    }

    public void printSeatRemaining() {
        log.info(() -> "Places restantes : " + getRemainingSeats());
    }
    
    public void printRevenue() {
        log.info(() -> String.format("Recette : %.2f €", getRevenue()));
    }

    public void printOccupancyRate() {
        log.info(() -> String.format("Taux de remplissage : %.0f %%", getOccupancyRate() * 100));
    }

}
