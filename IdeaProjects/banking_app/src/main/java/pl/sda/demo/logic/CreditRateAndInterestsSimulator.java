package pl.sda.demo.logic;

import pl.sda.demo.dto.CreditDto;
import pl.sda.demo.model.Credit;

public class CreditRateAndInterestsSimulator {

    Credit credit;

    InterestsCalculator interestsCalculator = new InterestsCalculator();

    private int term1;
    private int term2;
    private int term3;

    public void calculateCredit1(Credit credit) {
        System.out.println(credit.getLoanAmmount() + " zł na okres " + setTerm1(credit) + " lat");
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm1(credit), credit.getInterestRate());
        interestsCalculator.printInfo();
        System.out.println("");
    }
    public void calculateCredit2(Credit credit) {
        System.out.println(credit.getLoanAmmount() + " zł na okres " + setTerm2(credit) + " lat");
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm2(credit), credit.getInterestRate());
        interestsCalculator.printInfo();
        System.out.println("");
    }
    public void calculateCredit3(Credit credit) {
        System.out.println(credit.getLoanAmmount() + " zł na okres " + setTerm3(credit) + " lat");
        interestsCalculator.calculateCredit(credit.getLoanAmmount(), setTerm3(credit), credit.getInterestRate());
        interestsCalculator.printInfo();
        System.out.println("");
    }

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
