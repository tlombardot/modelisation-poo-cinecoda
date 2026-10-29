package cine;

public class ProjectorDigital extends Projector {
    
    public ProjectorDigital(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public String getType() {
        return "numérique";
    }

    @Override
    public boolean isDigital() {
        return true;
    }
}
