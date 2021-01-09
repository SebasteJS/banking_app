package pl.sda.demo.logic;
import lombok.Data;
import pl.sda.demo.model.Credit;

@Data
public class CreditRateAndInterestsSimulator {

    InterestsCalculator interestsCalculator = new InterestsCalculator();

    private int term1;
    private int term2;
    private int term3;

    private double monthlyRate1;
    private double monthlyRate2;
    private double monthlyRate3;

    private double totalInterest1;
    private double totalInterest2;
    private double totalInterest3;

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

    private void setMonthlyRates(Credit credit) {
        term1MonthlyRate(credit);
        term2MonthlyRate(credit);
        term3MonthlyRate(credit);
    }

    private void term1MonthlyRate(Credit credit) {
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm1(credit), credit.getInterestRate());
        monthlyRate1 = interestsCalculator.getMonthlyRate();
    }

    private void term2MonthlyRate(Credit credit) {
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm2(credit), credit.getInterestRate());
        monthlyRate2 = interestsCalculator.getMonthlyRate();
    }

    private void term3MonthlyRate(Credit credit) {
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm3(credit), credit.getInterestRate());
        monthlyRate3 = interestsCalculator.getMonthlyRate();
    }

    private void setTotalInterests(Credit credit) {
        calculateInterest1(credit);
        calculateInterest2(credit);
        calculateInterest3(credit);
    }

    private void calculateInterest1(Credit credit) {
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm1(credit), credit.getInterestRate());
        totalInterest1 = interestsCalculator.getSumOfIntrests();
    }

    private void calculateInterest2(Credit credit) {
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm2(credit), credit.getInterestRate());
        totalInterest2 = interestsCalculator.getSumOfIntrests();
    }

    private void calculateInterest3(Credit credit) {
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm3(credit), credit.getInterestRate());
        totalInterest3 = interestsCalculator.getSumOfIntrests();
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

    private void setTerm(Credit credit) {
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
            return term3 = term1 - 10;
    }


}
