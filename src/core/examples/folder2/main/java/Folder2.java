import source.collection1.Collection1;
import source.collection2.Collection2;
import source.refactoring1.Refactoring1;
import source.refactoring2.Refactoring2;
import source.refactoring3.Refactoring3;
import source.task1.Task1;
import source.task2.Task2;

public class Folder2 {

    public static void main(String[] args) {
        Collection2.insertInMiddleOfList();
    }

    public static void refactoring1() {
        Refactoring1.refactoring1Old();
        Refactoring1.refactoring1New();
    }

    public static void refactoring2() {
        Refactoring2.refactoring2();
    }

    public static void refactoring3() {
        Refactoring3.refactoringOld();
    }

    public static void task1() {
        Task1.run();
    }

    public static void task2() {
        Task2.run();
    }

    public static void collection1() {
        //Collection1.removeByIndex();
        Collection1.compareLoop(); //compare loop which is faster?
    }

    public static void collection2() {
        //Collection2.insertWithConcurrentModificationException();
        //Collection2.insertInMiddleOfList();
        //Collection2.insertInMiddleWithListIterator();
        Collection2.insertInMiddleWithListIterator2();
    }
}
