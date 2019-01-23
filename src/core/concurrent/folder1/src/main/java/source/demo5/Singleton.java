package source.demo5;

/**
 * @author Serzh Nosov created on 23.01.2019.
 */
public class Singleton {

    private int foo;
    private String bar;

    public Singleton() {
        this.foo = 5;
        this.bar = "hello";
    }

    private static Singleton instance;

    /** Верная ли синхронизация Singleton? */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
