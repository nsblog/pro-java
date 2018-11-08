package source.collection1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Сравниваем скоросто работы различных циклов.
 * Задача перебрать коллекцию ArrayList или LinkedList.
 *
 * Created by Nosov Serzh on 02.11.2018
 */
public class Loops {

    public static void run(boolean isArrayList) {

        List<String> list = isArrayList ? new ArrayList<>() : new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(UUID.randomUUID().toString());
        }

        final int[] sum = {0};

        long start = System.currentTimeMillis();
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            sum[0] += s.length();
        }
        System.out.print(list.getClass().getSimpleName() + " - явный интератор + while: ");
        System.out.println(System.currentTimeMillis() - start);

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
        list.parallelStream().forEach(e -> {
            sum[0] += e.length();
        });
        System.out.print(list.getClass().getSimpleName() + " - parallelStream forEach java 8: ");
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            sum[0] += s.length();
        }
        System.out.print(list.getClass().getSimpleName() + " - loop C++: ");
        System.out.println(System.currentTimeMillis() - start);
    }
}
