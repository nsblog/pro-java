package source.refactoring3;

/**
 * Created by Nosov Serzh on 01.11.2018
 */
public class Refactoring3 {

    public static void refactoringOld() {
        Person person1 = new Person();
        person1.setFirstName("Serzh");
        person1.setLastName("Nosov");

        Person person2 = new Person();
        person2.setFirstName("serzh");
        person2.setLastName("nosov");

        Person person3 = new Person();
        person3.setFirstName("Serzh");
        person3.setLastName("Nosov");

        System.out.println("Compare person1 and person3");
        System.out.println("Equals: " + person1.equals(person3));
        System.out.println("HashCode: " + (person1.hashCode() == person3.hashCode()));

        System.out.println("Compare person1 and person2");
        System.out.println("Equals: " + person1.equals(person2));
        System.out.println("HashCode: " + (person1.hashCode() == person2.hashCode()));
    }

}
