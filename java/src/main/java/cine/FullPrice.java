package cine;

public class FullPrice implements Ticket {
    private final double price;

    public FullPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice(double basePrice) {
        return price;
    }
}
