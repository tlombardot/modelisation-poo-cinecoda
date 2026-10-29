package cine;

public class Student implements Ticket {
    private final double price;

    public Student(double price) {
        this.price = price;
    }

    @Override
    public String getLabel() {
        return "étudiant";
    }

    @Override
    public double getPrice() {
        return price * 0.75; // 25% discount for students
    }
}
