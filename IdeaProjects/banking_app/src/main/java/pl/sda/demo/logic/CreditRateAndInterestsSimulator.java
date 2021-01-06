package pl.sda.demo.logic;

import pl.sda.demo.model.Credit;

public class CreditRateAndInterestsSimulator {

    InterestsCalculator interestsCalculator = new InterestsCalculator();

    public int term1;
    public int term2;
    public int term3;

    public double monthlyRate1;
    public double monthlyRate2;
    public double monthlyRate3;

    public double totalInterest1;
    public double totalInterest2;
    public double totalInterest3;

    public void showInfo() {
        System.out.println(term1 + "; " + monthlyRate1 + "; " + totalInterest1);
        System.out.println(term2 + "; " + monthlyRate2 + "; " + totalInterest2);
        System.out.println(term3 + "; " + monthlyRate3 + "; " + totalInterest3);
    }

    public void calculateAll(Credit credit) {
        setTerm(credit);
        setMonthlyRates(credit);
        setTotalInterests(credit);

    }

    public void setTotalInterests(Credit credit) {
        calculateInterest1(credit);
        calculateInterest2(credit);
        calculateInterest3(credit);
    }

    public double calculateInterest1(Credit credit) {
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm1(credit), credit.getInterestRate());
        return totalInterest1 = interestsCalculator.getSumOfIntrests();
    }

    public double calculateInterest2(Credit credit) {
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm2(credit), credit.getInterestRate());
        return totalInterest2 = interestsCalculator.getSumOfIntrests();
    }

    public double calculateInterest3(Credit credit) {
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm3(credit), credit.getInterestRate());
        return totalInterest3 = interestsCalculator.getSumOfIntrests();
    }


    public void setMonthlyRates(Credit credit) {
        term1MonthlyRate(credit);
        term2MonthlyRate(credit);
        term3MonthlyRate(credit);
    }

    public double term1MonthlyRate(Credit credit) {
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm1(credit), credit.getInterestRate());
        return monthlyRate1 = interestsCalculator.getMonthlyRate();
    }

    public double term2MonthlyRate(Credit credit) {
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm2(credit), credit.getInterestRate());
        return monthlyRate2 = interestsCalculator.getMonthlyRate();
    }

    public double term3MonthlyRate(Credit credit) {
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm2(credit), credit.getInterestRate());
        return monthlyRate3 = interestsCalculator.getMonthlyRate();
    }

//    public void calculateCredit1(Credit credit) {
//        System.out.println(credit.getLoanAmmount() + " zł na okres " + setTerm1(credit) + " lat");
//        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm1(credit), credit.getInterestRate());
//        interestsCalculator.printInfo();
//        System.out.println("");
//    }
//
//    public void calculateCredit2(Credit credit) {
//        System.out.println(credit.getLoanAmmount() + " zł na okres " + setTerm2(credit) + " lat");
//        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm2(credit), credit.getInterestRate());
//        interestsCalculator.printInfo();
//        System.out.println("");
//    }
//
//    public void calculateCredit3(Credit credit) {
//        System.out.println(credit.getLoanAmmount() + " zł na okres " + setTerm3(credit) + " lat");
//        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm3(credit), credit.getInterestRate());
//        interestsCalculator.printInfo();
//        System.out.println("");
//    }

    public void setTerm(Credit credit) {
        setTerm1(credit);
        setTerm2(credit);
        setTerm3(credit);
    }

    private int setTerm1(Credit credit) {
        term1 = credit.getCreditPeriod();
        return term1;
    }

    private int setTerm2(Credit credit) {
        if (term1 >= 10)
            return term2 = term1 - 5;
        else
            return term2 = term1 + 10;
    }

    private int setTerm3(Credit credit) {
        if (term1 <= 25)
            return term3 = term1 + 5;
        else
            return term1 - 10;
    }


}
