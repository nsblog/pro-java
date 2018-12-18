package source;

import org.junit.Test;
import source.concurrency2.Count;

import static org.junit.Assert.assertEquals;


/**
 * @author Serzh Nosov created on 18.12.2018.
 */
public class Concurrency1 {

    private class ThreadCount extends Thread {
        private final Count count;

        private ThreadCount(final Count count) {
            this.count = count;
        }

        public void run() {
            this.count.increment();
        }
    }

    @Test
    public void run() throws InterruptedException {
        final Count count = new Count();

        //Создаем нити
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);

        //Запускаем нити
        first.start();
        second.start();

        //Заставляем главную нить долждаться выполнения нитей
        first.join();
        second.join();

        assertEquals(count.get(), 2);
    }
}
