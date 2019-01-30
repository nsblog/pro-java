package source.concurrencymap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nosov Serzh created on 30.01.2019.
 */
public class MainClass {
    public static void main(String[] args) {
        Map<Object, Object> conMap = new ConcurrentHashMap<>();
        //Map<Object, Object> hashMap = new HashMap<>();
        //Map<Object, Object> conMap = Collections.synchronizedMap(hashMap);

        for (int i = 0; i < 100; i++) {
            MapHelper mapHelper1 = new MapHelper(conMap, i);
        }

        for (Map.Entry<Object, Object> e : conMap.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }

    }
}
