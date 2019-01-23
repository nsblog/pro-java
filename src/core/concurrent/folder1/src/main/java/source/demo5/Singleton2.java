package source.demo5;

/**
 * @author Serzh Nosov created on 23.01.2019.
 */
public class Singleton2 {

    private int foo;
    private String bar;

    public Singleton2() {
        this.foo = 5;
        this.bar = "hello";
    }

    private static Singleton2 instance;

    /** Верная ли синхронизация Singleton? */
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }

        }
        return instance;
    }
}
