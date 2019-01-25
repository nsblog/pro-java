package source.concurrency1.refactored1;

import source.concurrency1.Bank;

/**
 * @author Serzh Nosov created on 12.12.2018.
 */
public class BankRefactored1 extends Bank {

    public static void main(String[] args) throws InterruptedException {
        BankRefactored1 bankRefactored1 = new BankRefactored1();
        startParallelOperations(bankRefactored1);
    }

    public synchronized void withdraw(String account, Integer amount) {
        Integer funds = accounts.get(account);
        if (funds < amount) throw new IllegalStateException("The founds are not enough.");
        accounts.put(account, funds - amount);
    }

    public synchronized void deposit(String account, Integer amount) {
        accounts.put(account, accounts.get(account) + amount);
    }
}
