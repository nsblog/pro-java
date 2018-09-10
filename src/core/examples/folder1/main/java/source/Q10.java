package source;

import java.util.Objects;

/**
 * Created by Nosov Serzh on 10.09.2018
 */
public class Q10 {

    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(field);
    }
}
