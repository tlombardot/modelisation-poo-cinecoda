package cine;

public class Student implements Ticket {

    public Student() {
        //** Constructor for Student ticket */
    }

    @Override
    public String getLabel() {
        return "étudiant";
    }

    @Override
    public double getPrice(double basePrice) {
        return basePrice * 0.75; // 25% discount for students
    }
}
