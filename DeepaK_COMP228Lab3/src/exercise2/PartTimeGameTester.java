package exercise2;

public class PartTimeGameTester extends GameTester {

    private static final int HOURLY_RATE = 20;
    private int hoursWorked;

    public PartTimeGameTester(String name, int hoursWorked) {
        super(name, false);
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public int determineSalary() {
        return HOURLY_RATE * hoursWorked;
    }

}//end class
