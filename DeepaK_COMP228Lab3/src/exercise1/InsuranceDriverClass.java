package exercise1;
import java.util.Scanner;


public class InsuranceDriverClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Insurance[] insurance = new Insurance[2];

            String selection;
            System.out.println(" Please enter the type of insurance [Health / Life]: ");
            selection = input.next();

        for (int i = 0; i < insurance.length; i++) {

            if (selection.equalsIgnoreCase("health")) {
                insurance[i] = new Health();
            }
            else if (selection.equalsIgnoreCase("life")) {
                    insurance[i] = new Life();
            }
            else {
                System.out.println("Incorrect choice. Please enter either 'health' or 'life'.");
                i--;
            }//end if

        }//end for loop


        for (int j = 0; j < 1; j++) {
            insurance[j].setInsuranceCost();
            insurance[j].displayInfo();
        }//end for loop



    }//end Main


}//end class
