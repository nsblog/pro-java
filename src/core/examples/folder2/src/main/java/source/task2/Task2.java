package source.task2;

/**
 * Created by Nosov Serzh on 02.11.2018
 */
public class Task2 {

    /**
     * Диапазон byte (2^8) от -128 до 127
     * Переполнение +2. 1ое число -128, 2ое -127
     */
    public static void run() {
        System.out.println((byte) 129);
    }
}
