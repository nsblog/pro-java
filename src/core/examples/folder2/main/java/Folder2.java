import source.refactoring1.Refactoring1;
import source.refactoring2.Refactoring2;

public class Folder2 {

    public static void main(String[] args) {

    }

    private static void old() {
        /*int i = (15) & -65532;
        i = (15) & -5;
        System.out.println(i);

        //System.out.println(-5 % 16);
        test();*/

        //System.out.println((byte) 129); //как работает переполнение
        //test();
    }

    public static void refactoring1() {
        Refactoring1.refactoring1Old();
        Refactoring1.refactoring1New();
    }

    public static void refactoring2() {
        Refactoring2.refactoring2();
    }
}
