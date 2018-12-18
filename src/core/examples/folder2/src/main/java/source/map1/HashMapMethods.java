package source.map1;

/**
 * Created by Nosov Serzh on 21.11.2018
 */
public class HashMapMethods {

    public static void defineBucketByKeyLikeHashMap(Object key) {
        int hash = hash(key);

        int i = defineBucket(hash);
        int simpleHash = key.hashCode();
        int i2 = defineBucket(simpleHash);
        System.out.println(String.format("Key is %s, hash is %s, number of bucket is %s, simple hash is %s, simple number of bucket 2 is %s", key, hash, i, simpleHash, i2));
    }

    private static int defineBucket(int hash) {
        int n = 16; //Всего корзин
        return (n - 1) & hash;
    }

    /**
     * Дубликат метода HashMap.hash
     * Как будто возвращает улучшенный hash ключа
     *
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
