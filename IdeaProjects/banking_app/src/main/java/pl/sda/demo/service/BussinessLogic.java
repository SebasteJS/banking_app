package pl.sda.demo.service;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class BussinessLogic {

    //interests = CreditAmount*Procentage*DaysInMonth/DaysInYear


    private static Double CreditAmount;
    private static float Procentage = 0.05f;
    private static int DaysInMonth = DaysInMonth();
    private static final int DaysInYear = 365;
    private static Double rates = 400D;


    public static int DaysInMonth() {
        Calendar cal = Calendar.getInstance();
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days;
    }







    public static Integer CreditAmountCounting(Double CreditAmount) {
        if (CreditAmount == 0) {
            return 0;
        } else {
            return CreditAmountCounting(CreditAmount - rates);
        }
    }


    public static TreeMap<Integer, Double> listaWynikowKredytu() {
        TreeMap<Integer, Double> mapa = new TreeMap<>();
//        mapa.put()

        return null;
    }


    public static void main(String[] args) {


        System.out.println(CreditAmountCounting(4000D));

    }
}




//public static int silnia(int s) {
//        if (s == 1) {
//            return s;
//
//        } else {
//            return s * silnia(s - 1);
//        }
//    }
//


//    public static int Fibbonaci(int f) {
//        if (f <= 2) {
//            return 1;
//        } else {
//            return Fibbonaci(f - 1) + Fibbonaci(f - 2);
//        }
//    }
//



//    public static int potega(int p, int w) {
//        if (w == 0) {
//            return 1;
//        } else {
//            return p * potega(p, w - 1);
//        }
//    }
