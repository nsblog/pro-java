package source.collection3unmodifiable;

import java.util.Arrays;
import java.util.List;

/**
 * @author Nosov Serzh created on 03.02.2019.
 */
public class CheckArraysAsList {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        //List<Integer> integers = new ArrayList(Arrays.asList(1, 2, 3, 4));
        integers.add(5);
        System.out.println(integers);
    }
}
