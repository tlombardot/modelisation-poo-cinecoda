package cine;

public class Child implements Ticket {


    public Child(double price) {
    }
    
    @Override
    public double getPrice(double basePrice) {
        return 5; // Fixed price of 5€ for children
    }
}
