package source.refactoring1;

/**
 * @author Serzh Nosov created on 16.10.2018.
 */
public class Bomb implements Weapon1 {
    @Override
    public void action() {
        System.out.println("bomb");
    }
}
