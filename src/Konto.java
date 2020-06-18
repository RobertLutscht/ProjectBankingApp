public class Konto {

    private int kontoinhaber;
    private String bic;
    private String iban;

    private int kontostand;
    private int umsätze;
    private boolean gedeckt;

    public Konto(int kontoinhaber, String bic, String iban){
        this.kontoinhaber = kontoinhaber;
        this.bic = bic;
        this.iban = iban;
    }

    //Methode um Geld auf das Konto einzuzahlen
    public void einzahlen(int betrag){
        kontostand += betrag;
    }

    //Methode um Geld vom Konto abzuheben
    public void auszahlen(int betrag){
        if(kontostand - betrag >= 0){
            kontostand -= betrag;
            return;
        } else {
            System.out.println("Du hast nicht genug Geld auf deinem Konto");
            return;
        }
    }

    //getter Methoden für alle Variablen
    public int getKontoinhaber() {
        return kontoinhaber;
    }

    public String getBic() {
        return bic;
    }

    public String getIban() {
        return iban;
    }

    public int getKontostand() {
        return kontostand;
    }

    public int getUmsätze() {
        return umsätze;
    }

    public boolean isGedeckt() {
        return gedeckt;
    }
}
