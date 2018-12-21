package source.concurrency3;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nosov Serzh created on 20.12.2018.
 */
public class ConcurrentMap {

	public static void run(){
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

		for (int i = 0; i < 10; i++) {
			map.put(i, i);
		}
	}
}
