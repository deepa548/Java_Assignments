package exercise1;

abstract class Insurance {

    String insuranceType;
    double monthlyCost;

    public abstract void setInsuranceCost();

    public abstract void displayInfo();

    public String getInsuranceType() {
        return insuranceType;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

}//end class
