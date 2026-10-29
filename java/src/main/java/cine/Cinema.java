package cine;
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
    
    public void scheduleSession(Session session) {
        if (!rooms.contains(session.getRoom())) {
            throw new IllegalStateException("Programmation refusée : le cinéma CinéCoda n'a pas de " + session.getRoom().getName().toLowerCase());
        }
        sessions.add(session);
    }
    
    public void addRoom(Room room) {
        rooms.add(room);
    }
    
    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Room> getReadyRooms() {
        return rooms.stream()
                .filter(room -> room.getState() == RoomState.READY)
                .toList();
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void startSession(Session session) {
        if (sessions.contains(session)) {
            session.start();
        }
    }

    public void endSession(Session session) {
        if (sessions.contains(session)) {
            session.end();
        }
    }

	public void sellTicket(Session session, Ticket ticket) {
        if (sessions.contains(session)) {
            session.sellTicket(ticket);
        }
    }

    public void cleanRoom(Room room) {
        if (rooms.contains(room) && room.getState() == RoomState.IN_CLEANING) {
            room.setState(RoomState.READY);
        }
    }


    

}
