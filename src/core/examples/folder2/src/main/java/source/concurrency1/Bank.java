package source.concurrency1;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Serzh Nosov created on 12.12.2018.
 */
public class Bank {

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        startParallelOperations(bank);
    }

    public static void startParallelOperations(Bank bank) throws InterruptedException {
        ConcurrentHashMap<String, Integer> accounts = bank.accounts;

        accounts.put("test", 1_000_000);
        Integer value = accounts.get("test");
        System.out.println("START VALUE IS " + value);

        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                bank.deposit("test", 1);
            }
        });

        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                bank.withdraw("test", 1);
            }
        });

        depositThread.start();
        withdrawThread.start();

        depositThread.join();
        withdrawThread.join();

        value = accounts.get("test");
        System.out.println("FINISH VALUE IS " + value);
    }

    protected ConcurrentHashMap<String, Integer> accounts = new ConcurrentHashMap<>();

    public void withdraw(String account, Integer amount) {
        Integer funds = accounts.get(account);
        if (funds < amount) throw new IllegalStateException("The founds are not enough.");
        accounts.put(account, funds - amount);
    }

    public void deposit(String account, Integer amount) {
        accounts.put(account, accounts.get(account) + amount);
    }
}
