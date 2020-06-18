import java.util.List;

public class Account {

    private int owner;
    private String bic;
    private String iban;

    private int balance;
    private boolean covered;
    private intList transactions;

    public void add(int transaction){
        add()
    }


    //ein Default und ein spezifischer Konstruktor
    public Account(){ }

    public Account(int owner, String bic, String iban){
        this.owner = owner;
        this.bic = bic;
        this.iban = iban;
    }

    //Methode um Geld auf das Konto einzuzahlen
    public void deposit(int ammount){
        balance += ammount;
    }

    //Methode um Geld vom Konto abzuheben
    public void withdraw(int ammount){
        if(balance - ammount >= 0){
            balance -= ammount;
            return;
        } else {
            System.out.println("Du hast nicht genug Geld auf deinem Konto");
            return;
        }
    }

    //getter Methoden für alle Variablen
    public int getOwner() {
        return owner;
    }

    public String getBic() {
        return bic;
    }

    public String getIban() {
        return iban;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isCovered() {
        return covered;
    }
}
