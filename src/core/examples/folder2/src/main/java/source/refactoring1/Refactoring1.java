package source.refactoring1;

/**
 * @author Serzh Nosov created on 22.10.2018.
 */
public class Refactoring1 {

    public static void refactoring1Old() {
        Weapon weapon = new Weapon();
        weapon.type = "knife";

        Player player = new Player(weapon);
        player.action();

        weapon.type = "bomb";
        player.weapon = weapon;
        player.action();
    }

    public static void refactoring1New() {
        Weapon1 weapon = new Knife();
        Player1 player = new Player1(weapon);
        player.action();

        weapon = new Bomb();
        player.weapon = weapon;
        player.action();
    }
}
