package source.concurrency1.refactoring3;

import source.concurrency1.refactored2.Account;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Serzh Nosov created on 25.01.2019.
 */
public class AtomicAccount implements Account {

    private AtomicInteger funds = new AtomicInteger();

    public AtomicAccount(int funds) {
        setFunds(funds);
    }

    public int getFunds() {
        return funds.get();
    }

    public void setFunds(int funds) {
        this.funds.set(funds);
    }

    public void withdraw(Integer amount) {
        funds.updateAndGet(value -> {
            if (value < amount) throw new IllegalStateException("The founds are not enough.");
            value -= amount;
            return value;
        });
    }

    public void deposit(Integer amount) {
        funds.updateAndGet(value -> {
            value += amount;
            return value;
        });
    }
}
