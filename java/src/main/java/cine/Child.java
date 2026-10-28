package cine;

public class Child implements Ticket {
    @Override
    public double getPrice(double basePrice) {
        return 5; // Fixed price of 5€ for children
    }
}
