package source.bank1;

import java.util.concurrent.ConcurrentHashMap;

/**
 * How to refactor this code?
 *
 * @author Serzh Nosov created on 12.12.2018.
 */
public class Bank {

    private ConcurrentHashMap<String, Integer> accounts = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        String account = "John";
        bank.accounts.put(account, 1_000_000);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                bank.withdraw(account, 1);
                logFinish(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                bank.deposit(account, 1);
                logFinish(i);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        Integer value = bank.accounts.get(account);
        System.out.println("Value is " + value);
    }

    private static void logFinish(int i) {
        if (i == 999999) System.out.println("FINISH");
    }

    private void withdraw(String account, Integer amount) {
        Integer funds = accounts.get(account);
        if (funds < amount) throw new IllegalStateException("The founds are not enough.");
        accounts.put(account, funds - amount);
    }

    private void deposit(String account, Integer amount) {
        accounts.put(account, accounts.get(account) + amount);
    }
}
