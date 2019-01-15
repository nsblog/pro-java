package source.demo1;

/**
 * @author Serzh Nosov created on 15.01.2019.
 */
public class Start1 {

    public static void main(String[] args) {
        //run1();
        //run2();
        //run3();
        //run4();
        run5();
    }

    private static void run1() {
        for (int i = 0; i < 10; i++) {
            new HelloThread().start();
        }

        System.out.println("Hello from main thread");
    }

    private static void run2() {
        for (int i = 0; i < 10; i++) {
            new Thread(new HelloRunnable()).start();
        }

        System.out.println("Hello from main thread");
    }

    private static void run3() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println("Lambda: Hello from  " + Thread.currentThread().getName())).start();
        }

        System.out.println("Hello from main thread");
    }

    private static void run4() {
        //Единственный экземпляр HelloRunnable на все потоки. Нужно следить на состоянием объекта!
        HelloRunnable helloRunnable = new HelloRunnable();
        for (int i = 0; i < 10; i++) {
            new Thread(helloRunnable).start();
        }

        System.out.println("Hello from main thread");
    }

    private static void run5() {
        //Нужно использовать метод start(). Например, в данном случае все будет выполнено последовательно в главном потоке,
        //так как вызван метод run()
        HelloRunnable helloRunnable = new HelloRunnable();
        for (int i = 0; i < 10; i++) {
            new Thread(helloRunnable).run();
        }

        System.out.println("Hello from main thread");
    }

    /** INNER CLASSES **/

    private static class HelloThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + getName());
        }
    }

    private static class HelloRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }
}
