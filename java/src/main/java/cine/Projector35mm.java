package cine;

public class Projector35mm extends Projector {
    
    public Projector35mm(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public String getType() {
        return "argentique";
    }

    @Override
    public boolean isDigital() {
        return false;
    }
}
