package source.concurrency1.refactored0;

import source.concurrency1.Bank;

/**
 * @author Nosov Serzh created on 01.02.2019.
 */
public class AtomicBank extends Bank {

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new AtomicBank();
        startParallelOperations(bank);
    }

    @Override
    public void withdraw(String account, Integer amount) {
        accounts.compute(account, (key, funds) -> {
            if (funds < amount) throw new IllegalStateException("The founds are not enough.");
            return funds - amount;
        });
    }

    @Override
    public void deposit(String account, Integer amount) {
        accounts.compute(account, (key, funds) -> funds + amount);
    }
}
