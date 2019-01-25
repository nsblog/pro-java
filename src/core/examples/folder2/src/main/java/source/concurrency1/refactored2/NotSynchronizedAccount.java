package source.concurrency1.refactored2;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @author Serzh Nosov created on 25.01.2019.
 */
@ThreadSafe
public class NotSynchronizedAccount {

    private String login;

    @GuardedBy("this")
    private int funds;

    public void withdraw(Integer amount) {
        if (funds < amount) throw new IllegalStateException("The founds are not enough.");
        funds -= amount;
    }

    public void deposit(Integer amount) {
        funds += amount;
    }
}
