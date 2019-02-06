package source;

import source.aspect.Loggable;

/**
 * @author Serzh Nosov created on 06.02.2019.
 */
public class HelloAspect {

    @Loggable
    public void test() {
        test1();
    }

    @Loggable
    public void test1() {
        test2();
    }

    @Loggable
    private void test2() {
        System.out.println("Some operations...");
    }
}
