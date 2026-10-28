package cine;

public class Room{
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

    
}
