package source.concurrency1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Serzh Nosov created on 12.12.2018.
 */
public class Account {

    private String login;

    private AtomicInteger funds;

    public void withdraw(Integer amount) {
        int previousValue = funds.getAndAdd(-amount);
        if (previousValue < amount) throw new IllegalStateException("The founds are not enough.");
    }

    public void deposit(Integer amount) {
        funds.addAndGet(amount);
    }
}
