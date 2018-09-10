import java.io.IOException;

public class Test1 {

    public static void main(String[] args) throws Throwable {
        q2();
    }

    private static void q0() {
        /*
          Можно ли использовать пакет java.core.example.test?

          Нельзя. Java (javax) as a package name is prohibited.
         */
    }

    private static void q1() throws InterruptedException {
        /*
         * Which Thread class method begins new thread execution?
         * - Thread.execute()
         * - Thread.run()
         * - Thread.join()
         * - Thread.invoke()
         * - Thread.start()
         *
         * Гарантированно запустит поток метод start();
         * Если в поток не передать Runnable, то при вызове метода run() ничего не произойдет.
         */

        Thread thread = new Thread(() -> {
            System.out.println("Thread is running");
        });
        //thread.execute(); - Не существует
        thread.run(); // Запустит Runnable target, который передали в потоке thread.target.run();
        thread.join(); // todo
        //thread.invoke(); - Не существует
        thread.start(); //Запустит два потока, один из который thread.target.run();


    }

    private static void q2() throws IOException, ClassNotFoundException {
        /*
         * How do you prevent field from being serialized?
         * - Mark it as transient
         * - That's impossible
         * - Mark it as private
         * - Mark it as volatile
         *
         * Output
         * Real object isObjectIsSerializable{f1='1', f2='2', f3='3'}
         * Serializable object isObjectIsSerializable{f1='1', f2='2', f3='null'}
         *
         * Отметить поле как transient
         *
         * Доп. вопрос как сериализовать и десерилизовать объект в java?
         */

        ObjectIsSerializable q2 = new ObjectIsSerializable();
        q2.setF1("1");
        q2.setF2("2");
        q2.setF3("3");


        System.out.println("Real object is" + q2);
        byte[] pickle = UtilsSerializable.pickle(q2);
        ObjectIsSerializable unpickle = UtilsSerializable.unpickle(pickle, ObjectIsSerializable.class);
        System.out.println("Serializable object is" + unpickle);
    }
}
