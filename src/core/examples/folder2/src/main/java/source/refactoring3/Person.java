package source.refactoring3;

import java.util.Objects;

/**
 * Created by Nosov Serzh on 01.11.2018
 */
public class Person {

    private String lastName;
    private String firstName;
    private String givenName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;

        return Objects.equals(that.firstName, firstName) &&
                Objects.equals(that.lastName, lastName) &&
                Objects.equals(that.givenName, givenName);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", givenName='" + givenName + '\'' +
                '}';
    }
}
