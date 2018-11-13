package source.collection3;


/**
 * @author Serzh Nosov created on 13.11.2018.
 */
public class Collection3 {

    private static int b = 4; //'b' is either 4 or 8 for 32 or 64 bit systems

    public static void memory() {

    }

    private static int arrayListMemory(int n) {

        //ArrayList object header = 8 + 4 + 4
        //size integer = + b
        //modCount integer
        //array reference
        //(array oject header + b * n)
        //MOD(array oject, 8) + MOD(ArrayList object, 8) ==
        return 8 + 4 + 4 + b + (12 + b * n) + ((12 + b * n) % 8) + (8 + 4 + 4 + b + (12 + b * n) + ((12 + b * n) % 8) % 8);
    }
}
