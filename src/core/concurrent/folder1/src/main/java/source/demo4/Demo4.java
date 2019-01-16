package source.demo4;

/**
 * @author Nosov Serzh created on 16.01.2019.
 */
public class Demo4 {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);
        System.out.println("Start balance is " + account.getBalance());

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                account.deposit(1);
            }
        });

        System.out.println("Start");
        thread.start();

        System.out.println("Start wait");
        account.waitAndWithdraw(50_000);

        thread.join();

        System.out.println("End balance is " + account.getBalance());
    }
}
