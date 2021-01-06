package pl.sda.demo.logic;

public class InterestsCalculator {

    MonthlyRateCalculation monthlyRateCalculation = new MonthlyRateCalculation();

    private double capitalLeft;
    private double monthlyRate;
    private double monthyIntrest;
    private double montlyCapital;
    private double sumOfIntrests;
    private double sumOfCapitalRates;

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public double getSumOfIntrests() {
        return sumOfIntrests;
    }

    public void calculateCredit(double creditValue, int years, double monthlyIntrestRate) {
        monthlyRate = monthlyRateCalculation.calculateMonthlyRate(creditValue, years, monthlyIntrestRate);
        capitalLeft = creditValue;
        sumOfIntrests = 0;
        sumOfCapitalRates = 0;
        for (int i = 0; i < years * 12; i++) {

            // odsetki miesięcznie
            monthyIntrest = monthlyRateCalculation.calculateMonthlyIntrest(capitalLeft, monthlyIntrestRate);
            sumOfIntrests += monthyIntrest;

            // kapitał miesięcznie
            montlyCapital = monthlyRateCalculation.calculateMonthlyCapital(capitalLeft, creditValue, years, monthlyIntrestRate);
            sumOfCapitalRates += montlyCapital;

            capitalLeft -= montlyCapital;
//            System.out.println("pozostały kapitał " + capitalLeft);

//            System.out.println((i + 1) + " Kapitał " + montlyCapital + " Odsetki "
//                    + monthyIntrest + " miesięcnza rata " + monthlyRate);

        }
    }
    public void printInfo(){
        System.out.println("Wysokość miesięcznej raty: " + monthlyRate);
        System.out.println("Suma odsetek: " + sumOfIntrests);
    }

    public double getSumOfCapitalRates() {
        return sumOfCapitalRates;
    }
}
