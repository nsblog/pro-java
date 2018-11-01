package source.task1;

/**
 * Created by Nosov Serzh on 01.11.2018
 */
public class Task1 {

    public static void task1() {
        System.out.println(setOldValue("Hello"));
    }

    public static String setOldValue(String ab) {
        ab = "oldValue";
        setNewValue(ab);
        return ab;
    }

    private static void setNewValue(String s) {
        s = "newValue";
    }
}
