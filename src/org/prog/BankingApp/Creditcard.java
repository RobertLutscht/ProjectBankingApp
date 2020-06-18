package org.prog.BankingApp;

public class Creditcard extends Account {

    private boolean overdrawn;
    private int limit;

    //Konstruktor
    public Creditcard(String owner, int limit, String bic,String iban){
        super(bic, iban, owner);
        this.limit = limit;
    }

    @Override
    public void withdraw(int ammount) {
        System.out.println("Sie können nicht von Ihrer Kreditkarte Geld abheben.");
    }

    @Override
    public void transfer(int ammount, Account name) {
        if (getBalance() + limit - ammount >= 0) {
            Transactions transaction = new Transactions(ammount, "Von Konto abgehoben");
            setBalance(getBalance() - ammount);
            setList(transaction);
            return;
        } else {
            System.out.println("Du hast nicht genug Geld auf deinem Konto");
            return;
        }
    }

    //Setter für das Limit
    public void setLimit(int limit) {
        this.limit = limit;
    }

    //Getter aller Variablen
    public boolean isOverdrawn() {
        return overdrawn;
    }

    public int getLimit() {
        return limit;
    }
}
