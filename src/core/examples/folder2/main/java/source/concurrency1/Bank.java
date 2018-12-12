package source.concurrency1;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Serzh Nosov created on 12.12.2018.
 */
public class Bank {

    private ConcurrentHashMap<String, Integer> accounts = new ConcurrentHashMap<>();

    public void withdraw(String account, Integer amount) {
        Integer funds = accounts.get(account);
        if (funds < amount) throw new IllegalStateException("The founds are not enough.");
        accounts.put(account, funds - amount);
    }

    public void deposit(String account, Integer amount) {
        accounts.put(account, accounts.get(account) + amount);
    }
}
