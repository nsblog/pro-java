package source.collection2;

/**
 * Created by Nosov Serzh on 02.11.2018
 */
public class Collection2 {

    public static void insertInMiddleOfList() {
        InsertInMiddleOfList.insert1(true);
        InsertInMiddleOfList.insert1(false);
    }

    public static void insertWithConcurrentModificationException(){
        InsertInMiddleOfList.insertInMiddleWithConcurrentModificationException(true);
        InsertInMiddleOfList.insertInMiddleWithConcurrentModificationException(false);
    }

    public static void insertInMiddleWithListIterator(){
        InsertInMiddleOfList.insertInMiddleWithListIterator(true);
        InsertInMiddleOfList.insertInMiddleWithListIterator(false);
    }

    public static void insertInMiddleWithListIterator2(){
        InsertInMiddleOfList.insertInMiddleWithListIterator2(true);
        InsertInMiddleOfList.insertInMiddleWithListIterator2(false);
    }

}
