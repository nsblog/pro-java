package source.collection1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nosov Serzh on 02.11.2018
 */
public class Collection1 {

    public static void run() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        ArrayList arrayList = new ArrayList(integers);
        LinkedList linkedList = new LinkedList<>(integers);

        linkedList.remove(3);
        arrayList.remove(3);

        System.out.println("ArrayList:  " + Arrays.deepToString(arrayList.toArray()));
        System.out.println("LinkedList: " + Arrays.deepToString(linkedList.toArray()));
    }
}
