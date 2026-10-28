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

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Session> getSessions() {
        return sessions;
    }
    

}
