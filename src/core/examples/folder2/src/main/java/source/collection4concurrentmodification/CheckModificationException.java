package source.collection4concurrentmodification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Nosov Serzh created on 03.02.2019.
 */
public class CheckModificationException {

    public static void main(String[] args) {
        throwConcurrentModificationException();
        //modifyWithIterator();
    }

    private static void modifyWithIterator() {
        modifyWithIterator(Arrays.asList(1, 2, 3, 4, 5));
        modifyWithIterator(new ArrayList<>());
        modifyWithIterator(new LinkedList<>());
        modifyWithIterator(new CopyOnWriteArrayList<>());
    }

    private static void modifyWithIterator(List<Integer> list) {
        try {
            fill(list);

            ListIterator<Integer> iterator = list.listIterator();
            while (iterator.hasNext()) {
                Integer i = iterator.next();
                if (Objects.equals(i, 5)) {
                    iterator.remove();
                    iterator.add(0);

                    //что будет если выполнить в обратном порядке?
                    //iterator.add(0);
                    //iterator.remove();
                }
            }

            System.out.println(list.getClass().getName() + " works well");
            System.out.println(list);
        } catch (Exception e) {
            System.out.println(list.getClass().getName() + " throws " + e.toString()); //throw e;
        }
    }

    private static void throwConcurrentModificationException() {
        throwConcurrentModificationException(Arrays.asList(1, 2, 3, 4, 5));
        throwConcurrentModificationException(new ArrayList<>());
        throwConcurrentModificationException(new LinkedList<>());
        throwConcurrentModificationException(new CopyOnWriteArrayList<>());
    }

    private static void throwConcurrentModificationException(List<Integer> list) {
        try {
            fill(list);

            for (Integer i : list) {
                if (Objects.equals(i, 5)) {
                    list.add(0);
                    list.remove(new Integer(0)); //bad practice: complex is n^2, only for example exception
                    //list.remove(new Integer(0));
                }
            }

            System.out.println(list.getClass().getName() + " works well");
            System.out.println(list);
        } catch (Exception e) {
            System.out.println(list.getClass().getName() + " throws " + e.toString());
        }
    }

    private static void fill(List<Integer> list) {
        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }
    }
}
