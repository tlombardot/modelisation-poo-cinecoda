package cine;

public class FullPrice implements Ticket {

    public FullPrice() {
        //** Constructor for FullPrice ticket */
    }

    @Override
    public String getLabel() {
        return "plein tarif";
    }

    @Override
    public double getPrice(double basePrice) {
        return basePrice;
    }
}
