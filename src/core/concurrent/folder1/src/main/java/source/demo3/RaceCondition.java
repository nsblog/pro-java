package source.demo3;

/**
 * @author Nosov Serzh created on 16.01.2019.
 */
public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {
        //Account account = new Account(100000);
        Account account = new SynchronizedAccount(100000);

        System.out.println("Start balance is " + account.getBalance());

        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                account.deposit(1);
            }
        });

        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                account.withdraw(1);
            }
        });

        depositThread.start();
        withdrawThread.start();

        depositThread.join();
        withdrawThread.join();

        System.out.println("End balance is " + account.getBalance());
    }
}
