package sukai.algorithm.recurision;

/**
 * @author chengsukai
 **/
public class Hannuota {
    public static void main(String[] args) {
        hanoi("a", "b", "c", 2);
    }

    public static void hanoi(String a, String b, String c, int N) {
        if (N == 1) {
            System.out.println(a + " -> " + c);
        } else {
            hanoi(a, c, b, N - 1);
            System.out.println(a + " -> " + c);
            hanoi(b, a, c, N - 1);
        }
    }
}