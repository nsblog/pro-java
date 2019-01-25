package source.concurrency1.refactoring3;

import source.concurrency1.refactored2.Account;
import source.concurrency1.refactored2.BankRefactored2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Serzh Nosov created on 12.12.2018.
 */
public class BankRefactored3 extends BankRefactored2 {

    private static ConcurrentHashMap<String, AtomicAccount> accounts = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Account account = new AtomicAccount(1_000_000);
        startParallelOperationsWithAccount(account);
    }
}
