package source.demo4;

/**
 * @author Nosov Serzh created on 16.01.2019.
 */
public class Account {

    private volatile long balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(long amount) {
        if (balance < amount) throw new IllegalArgumentException("Not enough money");
        balance -= amount;
    }

    public synchronized void deposit(long amount) {
        balance += amount;
        notifyAll();
    }

    public synchronized void waitAndWithdraw(long amount) throws InterruptedException {
        System.out.println("waitAndWithdraw");
        while (balance < amount) { //not if (balance < amount)
            wait();
            if (balance % 10000 == 0) System.out.println("Balance is " + balance);
        }
        balance -= amount;
        System.out.println("Withdraw. Balance is " + balance);
    }
}
