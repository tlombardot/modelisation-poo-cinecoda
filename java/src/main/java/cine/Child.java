package cine;

public class Child implements Ticket {

    public Child() {
        //** Constructor for Child ticket */
    }
    
    @Override
    public String getLabel() {
        return "enfant";
    }

    @Override
    public double getPrice(double basePrice) {
        return 5; // Fixed price of 5€ for children
    }
}
