import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Serzh Nosov (Serzh.Nosov@lanit-tercom.com) created on 10.09.2018 13:58.
 */
public class UtilsSerializable {

    public static <T extends Serializable> byte[] pickle(T obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        oos.close();
        return baos.toByteArray();
    }

    public static <T extends Serializable> T unpickle(byte[] b, Class<T> cl) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object o = ois.readObject();
        return cl.cast(o);
    }
}
