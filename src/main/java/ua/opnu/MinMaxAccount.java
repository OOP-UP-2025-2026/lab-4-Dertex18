package ua.opnu;

public class MinMaxAccount extends BankingAccount {
    private int min;
    private int max;

    public MinMaxAccount(Startup s) {
        super(s);
        this.min = getBalance();
        this.max = getBalance();
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);   // збільшує баланс
        update();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);  // додає amount як є (негативні – зменшують)
        update();
    }

    private void update() {
        int b = getBalance();
        if (b < min) min = b;
        if (b > max) max = b;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}