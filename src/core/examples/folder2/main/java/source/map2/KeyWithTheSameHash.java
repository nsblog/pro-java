package source.map2;

import java.util.Objects;

/**
 * @author Serzh Nosov created on 27.11.2018.
 */
public class KeyWithTheSameHash {

    private String key;

    public KeyWithTheSameHash(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return -5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyWithTheSameHash that = (KeyWithTheSameHash) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public String toString() {
        return "KeyWithTheSameHash{" +
                "key='" + key + '\'' +
                "hashCode='" + hashCode() + '\'' +
                '}';
    }
}
