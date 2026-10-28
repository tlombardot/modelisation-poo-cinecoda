package cine;

public class FullPrice implements Ticket {
    @Override
    public double getPrice(double basePrice) {
        return basePrice;
    }
}
