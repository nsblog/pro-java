package source.refactoring2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Links:
 * Merging two arrayLists into a new arrayList, with no duplicates and in order, in Java (https://stackoverflow.com/questions/9917787/merging-two-arraylists-into-a-new-arraylist-with-no-duplicates-and-in-order-in/9917821)
 * How to merge two ArrayLists without duplicates? [duplicate] (https://stackoverflow.com/questions/16520046/how-to-merge-two-arraylists-without-duplicates)
 * How to merge two ArrayLists in Java (https://howtodoinjava.com/java/collections/arraylist/merge-arraylists/)
 *
 * @author Serzh Nosov created on 22.10.2018.
 */
public class Merge {

    public static List<User> mergeOld(List<User> list1, List<User> list2) {
        list1.removeAll(list2);
        List<User> merge = new ArrayList<>();
        merge.addAll(list1);
        merge.addAll(list2);

        merge.sort(Comparator.comparing(User::getLogin)); //для наглядности
        return merge;
    }

    public static List<User> merge2(List<User> list1, List<User> list2) {
        List<User> merge = new ArrayList<>(list1);
        merge.removeAll(list2);
        merge.addAll(list2);

        merge.sort(Comparator.comparing(User::getLogin)); //для наглядности
        return merge;
    }

    public static List<User> merge3(List<User> list1, List<User> list2) {
        Set<User> set = new LinkedHashSet<>(list1);
        set.addAll(list2);
        List<User> merge = new ArrayList<>(set);

        merge.sort(Comparator.comparing(User::getLogin)); //для наглядности
        return merge;
    }

    public static List<User> merge4(List<User> list1, List<User> list2) {
        return Stream.of(list1, list2)
                .flatMap(Collection::stream)
                .distinct()
                .sorted(Comparator.comparing(User::getLogin))
                .collect(Collectors.toList());
    }
}

