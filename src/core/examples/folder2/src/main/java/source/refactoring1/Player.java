package source.refactoring1;

/**
 * @author Serzh Nosov created on 16.10.2018
 */
public class Player {

    public Weapon weapon;

    public Player(Weapon weapon) {
        this.weapon = weapon;
    }

    public void action() {
        switch (weapon.type) {
            case "knife":
                System.out.println("knife");
                break;
            case "bomb":
                System.out.println("bomb");
                break;
            default:
                System.out.println("default action");
                break;
        }
    }
}