package source.map1;

import java.util.HashMap;

/**
 * Created by Nosov Serzh on 19.11.2018
 */
public class Map1 {

    public static void findBucket() {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");


        //map.
    }

    public static void defineBucketByKeys() {
        defineBucketByKey(-20);
        defineBucketByKey(-19);
        defineBucketByKey(-18);
        defineBucketByKey(-17);
        defineBucketByKey(-16);
        defineBucketByKey(-15);
        defineBucketByKey(-14);
        defineBucketByKey(-13);
        defineBucketByKey(-12);
        defineBucketByKey(-11);
        defineBucketByKey(-10);
        defineBucketByKey(-9);
        defineBucketByKey(-8);
        defineBucketByKey(-7);
        defineBucketByKey(-6);
        defineBucketByKey(-5);
        defineBucketByKey(-4);
        defineBucketByKey(-3);
        defineBucketByKey(-2);
        defineBucketByKey(-1);
        defineBucketByKey(0);
        defineBucketByKey(1);
        defineBucketByKey(2);
        defineBucketByKey(3);
        defineBucketByKey(4);
        defineBucketByKey(5);
        defineBucketByKey(6);
        defineBucketByKey(7);
        defineBucketByKey(8);
        defineBucketByKey(9);
        defineBucketByKey(10);
        defineBucketByKey(11);
        defineBucketByKey(12);
        defineBucketByKey(13);
        defineBucketByKey(14);
        defineBucketByKey(15);
        defineBucketByKey(16);
        defineBucketByKey(17);
        defineBucketByKey(18);
        defineBucketByKey(19);
        defineBucketByKey(20);
    }

    public static void defineBucketByKey(Object key) {
        int hash = hash(key);

        int n = 16; //Всего корзин
        //Определить корзину
        int i = (n - 1) & hash;
        System.out.println(String.format("Key is %s, hash is %s, number of bucket is %s", key, hash, i));
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
