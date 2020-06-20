package org.prog.BankingApp;

import org.prog.BankingApp.account.*;

import java.math.BigInteger;

public class Iban {
//    private String ibanrechner;
//
//    public String ibanrechner (){
//    Account.iba
//
//        ibanrechner = "DE XX 18718769 XXXXXXXXXXX";
//        return ibanrechner;
//    }
public static String knr;
public static String blz;

    public static String convertKnrBlzToIBAN(Account acc){
        knr = String.valueOf(acc.getAccountID());
        blz = "18718769";
        // zehnstellige Kontonummer
        if(knr.length() < 10){
            int anz = 10 - knr.length();
            for (int i = 0; i < anz; i++) {
                knr = "0" + knr;
            }
        }

        // Pruefziffer
        // die 1314 steht fuer DE und die 00 fuer die fehlenden Prueffziffern
        String checkIBAN = blz + knr + "131400";

        // String in eine Zahl konvertieren
        BigInteger checkIBANSum;
        checkIBANSum = new BigInteger(checkIBAN);

        // Modulo rechnen
        BigInteger faktor = new BigInteger("97");
        long div = checkIBANSum.remainder(faktor).longValue();
        // Differenz zu 98
        long pZiffer = 98 - div;

        // IBAN Regeln einhalten (22 Stellen)
        String IBAN = "";
        if(pZiffer < 10){
            IBAN = "DE0" + pZiffer + blz + knr;
        }else{
            IBAN = "DE" + pZiffer + blz + knr;
        }

        return IBAN;
    }
}
