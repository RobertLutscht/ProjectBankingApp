package org.prog.BankingApp;

import java.math.BigInteger;

public class checkUtility {


    public static boolean ibancheck(String iban) {

        boolean check = false;

        iban = iban.replaceAll(" ", "");

        if (iban.length() > 24) {
            check = false;

        }
        String laenderkennung = iban.substring(0, 1);
        String pruefziffer = iban.substring(2, 4);
        String bankleitzahl = iban.substring(4, 11);
        String kontonummer = iban.substring(12, iban.length());
        String langezahl = iban.substring(4, 22);


        String plus = "131400";
        String langlangezahl = langezahl + plus;

        BigInteger ziffer = new BigInteger(pruefziffer);


        BigInteger valid = new BigInteger(langlangezahl);

        BigInteger pruefen = valid.mod(new BigInteger("97"));
        String u = "98";
        BigInteger j = new BigInteger(u);
        BigInteger l = j.subtract(pruefen);
        //= l == ziffer;

        if (l.equals(ziffer)) {
            check = true;
        }
        return check;


    }
}

