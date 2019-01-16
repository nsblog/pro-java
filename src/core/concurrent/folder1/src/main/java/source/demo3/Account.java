package source.demo3;

/**
 * @author Nosov Serzh created on 16.01.2019.
 */
public class Account {

    private long balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void withdraw(long amount) {
        if (balance < amount) throw new IllegalArgumentException("not enough money");
        balance -= amount;
    }

    public void deposit(long amount) {
        balance += amount;
    }
}
