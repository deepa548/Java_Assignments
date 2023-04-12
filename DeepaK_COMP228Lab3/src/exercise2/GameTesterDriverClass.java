package exercise2;
import java.util.Scanner;

public class GameTesterDriverClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GameTester tester;
        String name;
        int choiceInput;
        int hoursWorked;

        System.out.print("Enter the name of the game tester: ");
        name = input.nextLine();

        System.out.println("Choose the type of game tester: ");
        System.out.println("1. Full-time");
        System.out.println("2. Part-time");
        System.out.print("Enter your choice: ");
        choiceInput = input.nextInt();

        if (choiceInput == 1) {
            tester = new FullTimeGameTester(name);
        } else if (choiceInput == 2) {
            System.out.print("Enter the number of hours worked: ");
            hoursWorked = input.nextInt();
            tester = new PartTimeGameTester(name, hoursWorked);
        } else {
            System.out.println("Invalid choice. Please enter either 1 or 2.");
            return;
        }

        System.out.println("\nGame Tester Information");
        System.out.println("Name: " + tester.getName());
        System.out.println("Type: " + (tester.gameStatus() ? "Full-time" : "Part-time"));
        System.out.println("Salary: $" + tester.determineSalary());
    } //End main

}// End Class
