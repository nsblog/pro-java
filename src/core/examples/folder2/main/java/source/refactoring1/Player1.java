package source.refactoring1;

/**
 * @author Serzh Nosov created on 16.10.2018
 */
public class Player1 {

    public Weapon1 weapon;

    public Player1(Weapon1 weapon) {
        this.weapon = weapon;
    }

    public void action() {
        weapon.action();
    }
}