package cine;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private final String name;
    private final List<Session> sessions;
    private final List<Room> rooms;


    public Cinema(String name) {
        this.name = name;
        this.sessions = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public void scheduleSessions(Room room, Media media, LocalDate dateTime, double basePrice) {
        Session session = new Session(room, media, dateTime, basePrice);
        sessions.add(session);
    }

    public void addRoom(int id, String name, int capacity, Projector projector) {
        Room room = new Room(id, name, capacity, projector);
        rooms.add(room);
    }
    

}
