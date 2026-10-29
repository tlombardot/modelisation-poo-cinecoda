package cine;

public class Child implements Ticket {


    public Child(double price) {
    }
    
    @Override
    public String getLabel() {
        return "enfant";
    }

    @Override
    public double getPrice() {
        return 5; // Fixed price of 5€ for children
    }
}
