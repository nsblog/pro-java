package source.collection2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

/**
 * links
 * https://stackoverflow.com/questions/19275975/insertion-in-the-middle-of-arraylist-vs-linkedlist
 * https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java?page=1&tab=votes#tab-top
 * <p>
 * Created by Nosov Serzh on 02.11.2018
 */
public class InsertInMiddleOfList {

    private static final String NEW_ELEMENT = "NEW_ELEMENT";

    public static void insert1(boolean isArrayList) {

        List<String> list = fillArray(isArrayList);

        long start = System.currentTimeMillis();
        list.add((int) list.size() / 2, NEW_ELEMENT);
        System.out.print(list.getClass().getSimpleName() + " - public void add(int index, E element): ");
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void insertInMiddleWithConcurrentModificationException(boolean isArrayList) {

        List<String> list = fillArray(isArrayList);

        try {
            int index = 0;
            Iterator<String> iter = list.iterator();
            while (iter.hasNext()) {
                iter.next(); //обязательно должен быть в цикле, чтоб перещелкивать элемент
                if (index == (list.size() / 2)) {
                    list.add(NEW_ELEMENT);
                }
                index++;
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(list.getClass().getSimpleName() + " - явный Iterator + while -> throws ConcurrentModificationException");
        }


        try {
            int index = 0;
            list = fillArray(isArrayList);
            Iterator<String> iter = list.iterator();
            for (; iter.hasNext(); ) {
                iter.next();
                if (index == (list.size() / 2)) {
                    list.add(NEW_ELEMENT);
                }
                index++;
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(list.getClass().getSimpleName() + " - явный Iterator + for -> throws ConcurrentModificationException");
        }

        try {
            int index = 0;
            Iterator<String> iter = list.listIterator();
            while (iter.hasNext()) {
                iter.next();
                if (index == (list.size() / 2)) {
                    list.add(NEW_ELEMENT);
                }
                index++;
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(list.getClass().getSimpleName() + " - явный ListIterator + while -> throws ConcurrentModificationException");
        }


        try {
            int index = 0;
            list = fillArray(isArrayList);
            for (String s : list) {
                if (index == (list.size() / 2)) {
                    list.add(NEW_ELEMENT);
                }
                index++;
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(list.getClass().getSimpleName() + " - неявный интератор 'for (String s : list)' -> throws ConcurrentModificationException");
        }


        try {
            final int[] index = {0}; //forEach java8 :)
            list = fillArray(isArrayList);
            List<String> finalList = list; //forEach java8 :)
            list.forEach(e -> {
                if (index[0] == (finalList.size() / 2)) {
                    finalList.add(NEW_ELEMENT);
                }
                index[0]++;
            });
        } catch (ConcurrentModificationException e) {
            System.out.println(list.getClass().getSimpleName() + " - forEach java 8 -> throws ConcurrentModificationException");
        }

        try {
            final int[] index = {0}; //forEach java8 :)
            list = fillArray(isArrayList);
            List<String> finalList = list; //forEach java8 :)
            list.parallelStream().forEach(e -> {
                if (index[0] == (finalList.size() / 2)) {
                    finalList.add(NEW_ELEMENT);
                }
                index[0]++;
            });
            System.out.println(list.getClass().getSimpleName() + " - parallelStream forEach java 8 -> SUCCESS");
        } catch (ConcurrentModificationException e) {
            System.out.println(list.getClass().getSimpleName() + " - parallelStream forEach java 8 -> throws ConcurrentModificationException");
        }


        list = fillArray(isArrayList);
        for (int i = 0; i < list.size(); i++) {
            if (i == (list.size() / 2)) {
                list.add(NEW_ELEMENT);
            }
        }
        System.out.println(list.getClass().getSimpleName() + " - loop C++ -> SUCCESS");
    }

    public static void insertInMiddleWithListIterator(boolean isArrayList) {
        List<String> list = fillArray(isArrayList);

        System.out.println(list.getClass().getSimpleName() + " - ListIterator.add() use case 1 -> START");
        ListIterator<String> iter = list.listIterator(list.size() / 2);
        iter.add(NEW_ELEMENT);
        System.out.println(list.getClass().getSimpleName() + " - ListIterator.add() use case 1 -> END");
    }

    public static void insertInMiddleWithListIterator2(boolean isArrayList) {
        List<String> list = fillArray(isArrayList);

        ListIterator<String> iter;
        System.out.println(list.getClass().getSimpleName() + " - ListIterator.add() use case 2 -> START" + br());
        int index = 0;
        iter = list.listIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
            if (index == list.size() / 2 - 1)
                iter.add(NEW_ELEMENT);
            index++;
        }
        System.out.println(br() + "RESULT IS " + Arrays.deepToString(list.toArray()) + br());
        System.out.println(list.getClass().getSimpleName() + " - ListIterator.add() use case 2 -> END" + br());
    }

    private static String br() {
        return "\n\r";
    }

    private static List<String> fillArray(boolean isArrayList) {
        int size = (int) Math.pow(2.0, 20);
        //System.out.println("Size of list is " + size);

        List<String> list = isArrayList ? new ArrayList<>() : new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(UUID.randomUUID().toString());
        }
        return list;
    }
}
