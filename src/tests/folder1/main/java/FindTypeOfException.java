import java.net.ConnectException;

/**
 * Created by Nosov Serzh on 04.11.2018
 */
public class FindTypeOfException {

    public static void main(String[] args) {
        B b = new B();

        System.out.println(findType(b, A.class));
    }

    private static boolean findType(B b, Class<A> aClass) {
        return aClass.isInstance(b);
    }
}

class A {

}

class B extends A {

}

/*private String handleMessage(Exception ex) {
    if (getInstance(ex, JDBCConnectionException.class) != null || getInstance(ex, ConnectException.class) != null) {
        return "Connection is not available";
    } else if (getInstance(ex, ObsoleteException.class) != null) {
        return hiddenPrefixAndPostfix(getInstance(ex, ObsoleteException.class).getMessage());
    } else {
        return "Something went wrong";
    }
}

private Throwable getInstance(Throwable ex, Class clazz) {
    if (clazz.isInstance(ex)) {
        return ex;
    } else if (ex.getCause() != null) {
        return getInstance(ex.getCause(), clazz);
    } else {
        return null;
    }
}*/
