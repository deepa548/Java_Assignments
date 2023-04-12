package exercise1;

public class Health extends Insurance{

    public Health() {
        insuranceType="Health Insurance";
    }

    public void setInsuranceCost() {

        monthlyCost = 150.0;
    }

    //implementing displayInfo method
    public void displayInfo() {
        System.out.println("Insurance type: " + getInsuranceType());
        System.out.println("Monthly cost: $" + getMonthlyCost());
    }


}//end class
