package source.concurrency1.refactored2;

import source.concurrency1.Bank;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Serzh Nosov created on 12.12.2018.
 */
public class BankRefactored2 extends Bank {

    private static ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Account account = new SynchronizedAccount(1_000_000);
        startParallelOperationsWithAccount(account);
    }

    public static void startParallelOperationsWithAccount(Account account) throws InterruptedException {
        accounts.put("test", account);

        System.out.println("START VALUE IS " + account.getFunds());

        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                account.deposit(1);
            }
        });

        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                account.withdraw(1);
            }
        });

        depositThread.start();
        withdrawThread.start();

        depositThread.join();
        withdrawThread.join();

        System.out.println("FINISH VALUE IS " + account.getFunds());
    }
}
