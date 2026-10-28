package cine;

public class Student implements Ticket {
    @Override
    public double getPrice(double basePrice) {
        return basePrice * 0.75; // 25% discount for students
    }
}
