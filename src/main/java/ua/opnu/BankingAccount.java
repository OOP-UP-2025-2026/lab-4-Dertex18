package ua.opnu;

public class BankingAccount {
    private int balance;

    public BankingAccount(Startup s) {
        this.balance = s.getInitial();
    }

    public void debit(Debit d) {
        balance += d.getAmount();
    }

    public void credit(Credit c) {
        balance += c.getAmount();
    }

    public int getBalance() {
        return balance;
    }
}