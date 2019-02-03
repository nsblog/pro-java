package source.collection3unmodifiable;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nosov Serzh created on 03.02.2019.
 */
public class CheckUnmodifiable {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Map<Object, Object> map = new HashMap<>();
        map.put(1, 1);

        Map<Object, Object> unmodifiableMap = Collections.unmodifiableMap(map);
        System.out.println("UnmodifiableMap has values: " + unmodifiableMap);

        Field f = unmodifiableMap.getClass().getDeclaredField("m");
        f.setAccessible(true);
        Map map2 = (Map) f.get(unmodifiableMap);
        map2.put(2, 2);

        System.out.println("UnmodifiableMap has values: " + unmodifiableMap);
    }

}
