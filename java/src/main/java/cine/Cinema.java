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
        sessions.add(session);
    }

    public void addRoom(Room room) {
        rooms.add(room);
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


    

}
