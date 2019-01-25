package source.concurrency1.refactored2;

/**
 * @author Serzh Nosov created on 25.01.2019.
 */
public class SynchronizedAccount implements Account{

    private int funds;

    public SynchronizedAccount() {
    }

    public SynchronizedAccount(int funds) {
        this.funds = funds;
    }

    public synchronized int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    public synchronized void withdraw(Integer amount) {
        if (funds < amount) throw new IllegalStateException("The founds are not enough.");
        funds -= amount;
    }

    public synchronized void deposit(Integer amount) {
        funds += amount;
    }
}
