package cine;

public class FullPrice implements Ticket {
    private final double price;

    public FullPrice(double price) {
        this.price = price;
    }

    @Override
    public String getLabel() {
        return "plein tarif";
    }

    @Override
    public double getPrice() {
        return price;
    }
}
