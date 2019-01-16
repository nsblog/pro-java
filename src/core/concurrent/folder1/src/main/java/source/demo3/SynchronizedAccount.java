package source.demo3;

/**
 * @author Nosov Serzh created on 16.01.2019.
 */
public class SynchronizedAccount extends Account {

    public SynchronizedAccount(int balance) {
        super(balance);
    }

    @Override
    public synchronized void withdraw(long amount) {
        super.withdraw(amount);
    }

    @Override
    public synchronized void deposit(long amount) {
        super.deposit(amount);
    }
}
