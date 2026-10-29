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
        log.info(() -> String.format("%s : %d places, projecteur %s", name, capacity, projectorType.getType()));
    }
    
    public String getName() {
        return name;
    }
    
    public RoomState getState() {
        return state;
    }
    
    public void startSession() {
        this.state = RoomState.IN_SESSION;
    }

    public void endSession() {
        this.state = RoomState.IN_CLEANING;
    }

    public void finishCleaning() {
        if (state != RoomState.IN_CLEANING) {
            throw new IllegalStateException("Nettoyage refusé : la " + name + " n'est pas en nettoyage");
        }
        this.state = RoomState.READY;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public Projector getProjectorType() {
        return projectorType;
    }
}
