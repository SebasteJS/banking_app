package pl.sda.demo.logic;

public class MonthlyRateCalculation {

    private final int MONTHS_COUNT = 12;

    public double calculateMonthlyCapital(double capitalLeft, double creditValue, int years, double intrestRate){
        return calculateMonthlyRate(creditValue, years, intrestRate) - calculateMonthlyIntrest(capitalLeft, intrestRate);
    }

    public double calculateMonthlyIntrest(double capitalLeft, double intrestRate){
        double monthlyIntrestRate = setMonthlyInterestRate(intrestRate);
        return capitalLeft * monthlyIntrestRate;
    }

    public double calculateMonthlyRate(double creditValue, int years, double intrestRate) {
        double monthlyIntrestRate = setMonthlyInterestRate(intrestRate);

        return creditValue * monthlyIntrestRate *
                Math.pow((monthlyIntrestRate + 1), (years * MONTHS_COUNT)) /
                (Math.pow((monthlyIntrestRate + 1), years * MONTHS_COUNT) - 1);
    }

    private double setMonthlyInterestRate(double interestRate){
        double monthlyInterestRate = interestRate / 100 / MONTHS_COUNT;
        return monthlyInterestRate;
    }
}
