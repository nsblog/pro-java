package source.collection2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * links
 * https://stackoverflow.com/questions/19275975/insertion-in-the-middle-of-arraylist-vs-linkedlist
 * https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java?page=1&tab=votes#tab-top
 * <p>
 * Created by Nosov Serzh on 02.11.2018
 */
public class Loops2 {

    public static void run(boolean isArrayList) {

        int size = (int) Math.pow(2.0, 3);
        System.out.println("Size of list is " + size);

        List<String> list = isArrayList ? new ArrayList<>() : new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(UUID.randomUUID().toString());
        }

        long start = System.currentTimeMillis();
        list.add((int) size / 2, "HELLO");
        System.out.print(list.getClass().getSimpleName() + " - public void add(int index, E element): ");
        System.out.println(System.currentTimeMillis() - start);

/*
        final int[] sum = {0};

        int index = 0;

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if(index == (int)(pow/2)){
                list.add(UUID.randomUUID().toString());
            }
            index++;
        }
        System.out.print(list.getClass().getSimpleName() + " - явный интератор + while: ");


        start = System.currentTimeMillis();
        iter = list.iterator();
        for (; iter.hasNext(); ) {
            String s = iter.next();
            sum[0] += s.length();
        }
        System.out.print(list.getClass().getSimpleName() + " - явный интератор + for: ");
        System.out.println(System.currentTimeMillis() - start);


        start = System.currentTimeMillis();
        for (String s : list) {
            sum[0] += s.length();
        }
        System.out.print(list.getClass().getSimpleName() + " - неявный интератор: ");
        System.out.println(System.currentTimeMillis() - start);


        start = System.currentTimeMillis();
        list.forEach(e -> {
            sum[0] += e.length();
        });
        System.out.print(list.getClass().getSimpleName() + " - forEach java 8: ");
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            sum[0] += s.length();
        }
        System.out.print(list.getClass().getSimpleName() + " - loop C++: ");
        System.out.println(System.currentTimeMillis() - start);*/
    }
}
