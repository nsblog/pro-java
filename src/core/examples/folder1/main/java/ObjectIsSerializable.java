import java.io.Serializable;

/**
 * @author Serzh Nosov (Serzh.Nosov@lanit-tercom.com) created on 10.09.2018 13:39.
 */
public class ObjectIsSerializable implements Serializable {

    private String f1;
    private volatile String f2;
    private transient String f3;

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

    @Override
    public String toString() {
        return "ObjectIsSerializable{" +
                "f1='" + f1 + '\'' +
                ", f2='" + f2 + '\'' +
                ", f3='" + f3 + '\'' +
                '}';
    }
}
