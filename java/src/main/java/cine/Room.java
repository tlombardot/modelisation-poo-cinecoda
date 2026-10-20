package cine;

public class Room{
    private final int id;
    private final int capacity;
    private final Projector projectorType;
    private RoomState state;
    
    public Room(int id, int capacity, Projector projectorType) {
        this.id = id;
        this.capacity = capacity;
        this.projectorType = projectorType;
    }

    
}
