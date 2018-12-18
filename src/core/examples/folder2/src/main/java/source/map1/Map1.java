package source.map1;

import java.util.HashMap;

import static source.map1.HashMapMethods.defineBucketByKeyLikeHashMap;


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
    }

    public static void defineBucketByKeys() {
        for (int i = -40; i <= 40; i++) {
            defineBucketByKeyLikeHashMap(i);
            //defineBucketByKeyEasyWay(i);
        }
    }

    private static void defineBucketByKeyEasyWay(int hash) {
        int i = hash % 16;
        int abs = Math.abs(i);
        System.out.println(String.format("Hash is %s, after mod result is %s, after abs is %s", hash, i, abs));
    }

    public static void simpleExample(){
        int n = 16;
        for (int i = -1; i <= 1 ; i++) {
            System.out.println(String.format("i=%s, n=%s, Math.abs(i mod n)=%s", i, n, Math.abs(i % n)));
            System.out.println(String.format("i=%s, n=%s,           i&(n-1)=%s", i, n, i & (n - 1)));
        }
    }

    public static void simpleExample2(){
        System.out.println("-5 & 15 = " + (-5 & 15));
        System.out.println("Math.abs(-5 % 16) = " + Math.abs(-5 % 16));

        System.out.println("16 & 15 = " + (16 & 15));
        System.out.println("Math.abs(16 % 16) = " + Math.abs(16 % 16));

        System.out.println("5 & 15 = " + (5 & 15));
        System.out.println("Math.abs(5 % 16) = " + Math.abs(5 % 16));
    }
}
