package cine;

/**
 * abstract class for projectors
 */
abstract class Projector {

    private final String serialNumber;

    protected Projector(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

}
