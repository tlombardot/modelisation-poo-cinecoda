package cine;

import java.util.logging.Logger;

public class Room{
    private static final Logger log = ConsoleLogger.create("room.scenario");

    private final int id;
    private final int capacity;
    private final Projector projectorType;
    private final String name;
    private RoomState state;
    
    public Room(int id,String name, int capacity, Projector projectorType) {
        this.id = id;
        this.capacity = capacity;
        this.projectorType = projectorType;
        this.name = name;
        this.state = RoomState.READY;
    }

    public void printRoomInfo() {
        if (projectorType instanceof ProjectorDigital) {
            log.info(() -> String.format("%s : %d places, projecteur numérique", name, capacity));
        } else if (projectorType instanceof Projector35mm) {
            log.info(() -> String.format("%s : %d places, projecteur argentique", name, capacity));
        }
    }

    
}
