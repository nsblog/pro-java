package source.concurrencymap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nosov Serzh created on 28.01.2019.
 */
public class ConcurrencyMap {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("START");

        //Map<Object, Object> hashMap = new HashMap<>();
        //Map<Object, Object> map = Collections.synchronizedMap(hashMap);
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();

        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                map.put(i, i);
            }
            System.out.println("WRITER HAS FINISHED");
        });

        Thread readerThread1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                map.get(i);
            }
            System.out.println("READER 1 HAS FINISHED");
        });

        Thread readerThread2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                map.get(i);
            }

            System.out.println("READER 2 HAS FINISHED");
        });

        writerThread.start();
        readerThread1.start();
        readerThread2.start();

        writerThread.join();
        readerThread1.join();
        readerThread2.join();

        System.out.println("FINISH");
    }
}
