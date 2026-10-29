package cine;

public enum RoomState {
    READY("LIBRE"),
    IN_SESSION("EN SÉANCE"),
    IN_CLEANING("NETTOYAGE");

    private final String label;

    RoomState(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
