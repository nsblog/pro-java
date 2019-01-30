package source.concurrencymap;

import java.util.Map;

/**
 * @author Nosov Serzh created on 30.01.2019.
 */
public class MapHelper implements Runnable {
    Map<Object, Object> map;
    private Object value;

    public MapHelper(Map<Object, Object> map, Object value) {
        this.map = map;
        this.value = value;
        new Thread(this, "THREAD WITH VALUE (" + value + ")").start();
    }

    public void run() {
        map.put(value, value);
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}