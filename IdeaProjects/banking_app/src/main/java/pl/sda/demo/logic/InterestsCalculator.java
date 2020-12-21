package pl.sda.demo.logic;

public class InterestsCalculator {

    MonthlyRateCalculation monthlyRateCalculation = new MonthlyRateCalculation();

    double capitalLeft;
    double monthlyRate;
    double monthyIntrest;
    double montlyCapital;
    double sumOfIntrests;
    double sumOfCapitalRates;

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
}
