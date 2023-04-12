package exercise3;

import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double currentInterestRate;
        System.out.print("\n:::CityToronto Bank - Mortgage Entry::::");
        System.out.print("\n:::---------------------------------::::\n");
        System.out.print("Enter the current interest rate: ");
        currentInterestRate = scanner.nextDouble();

        Mortgage[] mortgages = new Mortgage[3];
        int i = 0;
        while (true) {
            System.out.print("\nEnter mortgage type Number ([1] business, [2] personal): ");
            int mortgageType = scanner.nextInt();
            System.out.print("Enter mortgage number: ");
            int mortgageNumber = scanner.nextInt();
            System.out.print("Enter customer name: ");
            String customerName = scanner.next();
            System.out.print("Enter mortgage amount: ");
            double mortgageAmount = scanner.nextDouble();
            System.out.print("Enter mortgage term in Years (short-term [1] Year, medium-term [3] Years, long-term [5] Years): ");
            int mortgageTerm = scanner.nextInt();
            System.out.println(" ");
            System.out.print("Enter [1] for Next Entry or [0] for Display All Mortgage Data): ");
            int displayData = scanner.nextInt();

            if (mortgageType == 1) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, mortgageAmount, currentInterestRate, mortgageTerm);
                i++;
            } else if (mortgageType == 2) {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, mortgageAmount, currentInterestRate, mortgageTerm);
                i++;
            } else {
                System.out.println("Invalid mortgage type, defaulting to business mortgage.");
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, mortgageAmount, currentInterestRate, mortgageTerm);
                i++;
            }
            if (displayData == 1) {
                continue;
            }else if(displayData == 0) {
                for (Mortgage mortgage : mortgages) {
                    if (mortgage != null) {
                        System.out.println(" ");
                        System.out.println(mortgage.getMortgageInfo());
                    }
                }
                break;
            }
            else{
                System.out.println("Wrong Choice, defaulting to [0]");
                for (Mortgage mortgage : mortgages) {
                    if (mortgage != null) {
                        System.out.println(" ");
                        System.out.println(mortgage.getMortgageInfo());
                    }
                }
                break;
            }
        }//end while

    } // end main
}// end class
