package cine;

public class Student implements Ticket {
    private final double price;
    
    public Student(double price) {
        this.price = price;
    }
    @Override
    public double getPrice(double basePrice) {
        return price * 0.75; // 25% discount for students
    }
}
