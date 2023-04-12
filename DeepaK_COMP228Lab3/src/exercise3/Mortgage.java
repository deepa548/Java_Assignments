package exercise3;

import java.text.DecimalFormat;

public abstract class Mortgage implements MortgageConstants {
    private int mortgageNumber;
    private String customerName;
    private double mortgageAmount;
    private double interestRate;
    private int term;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Mortgage(int mortgageNumber, String customerName, double mortgageAmount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        if (mortgageAmount > MAXIMUM_MORTGAGE_AMOUNT) {
            System.out.println("Maximum Approved Amount:" + MAXIMUM_MORTGAGE_AMOUNT);
            this.mortgageAmount = MAXIMUM_MORTGAGE_AMOUNT;
        } else {
            this.mortgageAmount = mortgageAmount;
        }
        this.interestRate = interestRate;
        if (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) {
            this.term = term;
        } else {
            System.out.println("No mortgage term selected defaulting to Short term 1 Year");
            this.term = SHORT_TERM;
        }
    }

    public String calculateMonthlyPayment() {
        double monthlyInterestRate = this.interestRate / 1200;
        int totalPayments = this.term  * 12;
        double monthlyPayment = (this.mortgageAmount * monthlyInterestRate)  + (this.mortgageAmount/totalPayments);
        return  df.format(monthlyPayment);
    }

    public String calculateTotalAmountOwed() {
        double calcuatedMonthlyPay = Double.parseDouble(calculateMonthlyPayment());
        double totalAmountOwed =  calcuatedMonthlyPay * (this.term * 12);
        return  df.format(totalAmountOwed);
    }

    public String getMortgageInfo() {
        String info = "::::"+BANK_NAME+" Mortgage Information::::\n";
        info += "Mortgage Number: " + this.mortgageNumber + "\n";
        info += "Customer Name: " + this.customerName + "\n";
        info += "Mortgage Amount: $" + this.mortgageAmount + "\n";
        info += "Interest Rate: " + this.interestRate + "%\n";
        info += "Term: " + this.term + " years\n";
        info += "Monthly Payment: " + calculateMonthlyPayment() + "$\n";
        info += "Total Amount Owed: " + calculateTotalAmountOwed() + "$";
        return info;
    }

} //end class