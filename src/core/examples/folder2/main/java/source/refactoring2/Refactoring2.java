package source.refactoring2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Serzh Nosov created on 22.10.2018.
 */
public class Refactoring2 {

    public static void refactoring2() {
        List<String> logins1 = Arrays.asList("B", "A", "C", "D", "E");
        List<User> users1 = createUsers(logins1);

        List<String> logins2 = Arrays.asList("B", "D", "F", "G", "G"); //note если оригинальный лист имеет дублирующиеся элементы
        List<User> users2 = createUsers(logins2);

        List<User> merge2 = Merge.merge2(users1, users2);
        List<User> merge3 = Merge.merge3(users1, users2);
        List<User> merge4 = Merge.merge4(users1, users2);

        List<User> mergeOld = Merge.mergeOld(users1, users2); //должен быть последним так как меняет коллекцию по ссылке

        System.out.println("Users contains " + Arrays.deepToString(users1.toArray()));
        System.out.println("Users2 contains " + Arrays.deepToString(users2.toArray()));

        System.out.println("merge 2 contains  " + Arrays.deepToString(merge2.toArray()));
        System.out.println("merge 3 contains  " + Arrays.deepToString(merge3.toArray()));
        System.out.println("merge 4 contains  " + Arrays.deepToString(merge4.toArray()));
        System.out.println("mergeOld contains " + Arrays.deepToString(mergeOld.toArray()));
    }

    private static List<User> createUsers(List<String> logins) {
        return logins.stream().map(User::new).collect(Collectors.toList());
    }
}
