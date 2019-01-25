package source.concurrency1.refactored2;

/**
 * @author Serzh Nosov created on 25.01.2019.
 */
public interface Account {

    public int getFunds();

    public void setFunds(int funds);

    public void withdraw(Integer amount);

    public void deposit(Integer amount);
}
