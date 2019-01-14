package source.concurrency1.refactored;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Serzh Nosov created on 12.12.2018.
 */
public class BankRefactored {

    private ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();

    public void withdraw(String login, Integer amount) {
        Account account = accounts.get(login);
        account.withdraw(amount);
    }

    public void deposit(String login, Integer amount) {
        Account account = accounts.get(login);
        account.deposit(amount);
    }
}
