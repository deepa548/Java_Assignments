package exercise1;

public class Life extends Insurance {

    public Life() {
        insuranceType="Life Insurance";
    }

    public void setInsuranceCost() {

        monthlyCost = 250.0;
    }

    public void displayInfo() {

        System.out.println("Insurance type: " + getInsuranceType());
        System.out.println("Monthly cost: $" + getMonthlyCost());
    }

}//end class
