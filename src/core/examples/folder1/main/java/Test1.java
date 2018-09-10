import source.MyClass;
import source.ObjectIsSerializable;
import source.UtilsSerializable;

import java.io.IOException;

public class Test1 {

    public static void main(String[] args) throws Throwable {
        q10();
    }

    /**
     * Можно ли использовать пакет java.core.example.test?
     * <p>
     * Нельзя. Java (javax) as a package name is prohibited.
     */
    private static void q0() {
    }

    /**
     * Which Thread class method begins new thread execution?
     * - Thread.execute()
     * - Thread.run()
     * - Thread.join()
     * - Thread.invoke()
     * - Thread.start()
     * <p>
     * Гарантированно запустит поток метод start();
     * Если в поток не передать Runnable, то при вызове метода run() ничего не произойдет.
     */
    private static void q1() throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("Thread is running");
        });
        //thread.execute(); - Не существует
        thread.run(); // Запустит Runnable target, который передали в потоке thread.target.run();
        thread.join(); // todo
        //thread.invoke(); - Не существует
        thread.start(); //Запустит два потока, один из который thread.target.run();
    }

    /**
     * How do you prevent field from being serialized?
     * - Mark it as transient
     * - That's impossible
     * - Mark it as private
     * - Mark it as volatile
     * <p>
     * Output
     * Real object isObjectIsSerializable{f1='1', f2='2', f3='3'}
     * Serializable object isObjectIsSerializable{f1='1', f2='2', f3='null'}
     * <p>
     * Отметить поле как transient
     * <p>
     * Доп. вопрос как сериализовать и десерилизовать объект в java?
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void q2() throws IOException, ClassNotFoundException {

        ObjectIsSerializable q2 = new ObjectIsSerializable();
        q2.setF1("1");
        q2.setF2("2");
        q2.setF3("3");

        System.out.println("Real object is" + q2);
        byte[] pickle = UtilsSerializable.pickle(q2);
        ObjectIsSerializable unpickle = UtilsSerializable.unpickle(pickle, ObjectIsSerializable.class);
        System.out.println("Serializable object is" + unpickle);
    }

    /**
     * Final variable "value" contains String "weather". How to change it's value to "feather";
     * - value.replace("t", "w")
     * - That's impossible
     * - value.setValue("feather")
     * - value.toCharArray()[0] = 't'
     * - value.setCharAt(0, 'f')
     * - value.setText("feather")
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void q3() throws IOException, ClassNotFoundException {
        final String value = "weather";

        String replace = value.replace("w", "t"); //Создает новый объект String

        //value.setValue("feather"); - Не существует метода

        value.toCharArray()[0] = 't'; //Создает новый массив чаров
        char[] chars = value.toCharArray();
        chars[0] = 't';

        //value.setCharAt(0, 'f'); - Не существует метода
        //value.setText("feather"); - Не существует метода

        System.out.println(value);
        System.out.println(replace);
        System.out.println(chars);
    }

    /**
     * Which package is "automatically imported" at compile time?
     * - com.sun.*
     * - java.util.*
     * - jdk.internal.*
     * - java.lang.*
     * <p>
     * Автоматически импортируется java.lang.*, его не нужно импортировать.
     * Например, когда пишем System.out.println("sdf") используется класс java.lang.System.
     * Но если вручную добавить import java.lang.System, то ошибки не будет.
     */
    private static void q4() {
    }

    /**
     * What is time complexity of QuickSort in worst case?
     * - O(1)
     * - O(log(n))
     * - O(n)
     * - O(n*log(n))
     * - O(n*n)
     * <p>
     * Худщее время O(n*n),
     * Среднее время O(n*log(n))
     */
    private static void q5() {
    }

    /**
     * What would following method return and print?
     * - Compilation error would happen
     * - Print 'finally" and return 0
     * - Print 'finally" and return 1
     * - Print nothing and return 0
     * - Print nothing and return 1
     * - RuntimeException would happen
     * <p>
     * Output is..
     * finally
     * 1
     */
    private static void q6() {
        System.out.println(methodQ6());
    }

    private static int methodQ6() {
        try {
            return 0;
        } finally {
            System.out.println("finally");
            return 1;
        }
    }

    /**
     * What does -Xmx64m flag mean?
     * - Delay program start to 64 minutes
     * - Minimum heap size should be 64 megabytes
     * - Terminate program after 64 minutes
     * - Maximum heap size should be 64 megabytes
     * <p>
     * Maximum heap size should be 64 megabytes
     */
    private static void q7() {
    }

    /**
     * How many there are kilobits in kilobyte?
     * - 1
     * - 2
     * - 8
     * - 1024
     * <p>
     * 8 kilobits in one kilobyte
     */
    private static void q8() {
    }

    /**
     * How to destruct myObject variable referencing MyClass?
     * - myObject = null
     * - That's impossible
     * - myObject.~MyClass()
     * - delete myObject
     * - myObject.finalize()
     * <p>
     * That's impossible
     */
    private static void q9() throws Throwable {
        MyClass myObject = new MyClass();
        //myObject = null;
        //myObject.~MyClass();
        //delete myObject;
        //myObject.finalize(); //нелязя вызвать нужно переопределять
    }

    /**
     * Given: obj1.hashCode() = obj2.hashCode(). Which of following statement is true?
     * - obj1.equals(obj2)
     * - !obj1.equals(obj2)
     * - obj1 == obj2
     * - None of these
     * <p>
     * None of these
     */
    private static void q10() {
    }

    /**
     * Which of the following data structures implements FIFO(first in, first out) principle?
     * - Red-Black tree
     * - Binary search tree
     * - Queue
     * - Stack
     * <p>
     * FIFO принцип первым пришел, первым ушел в java это очередь Queue.
     * За исключением PriorityQueue and PriorityBlockingQueue
     */
    private static void q11() {
    }
}
