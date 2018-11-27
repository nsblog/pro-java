package source.map2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Serzh Nosov created on 27.11.2018.
 */
public class Map2 {

    public static void fillMapKeyWithSameHashCode() {

        Map<KeyWithTheSameHash, String> map = new HashMap<>();
        for (int i = 0; i < 2 << 4; i++) {
            KeyWithTheSameHash keyWithTheSameHash = new KeyWithTheSameHash("" + i);
            System.out.println(keyWithTheSameHash);
            map.put(keyWithTheSameHash, "SOME VALUE_" + i);
        }
    }
}
