package sukai.bestjavapractice;

/**
 * @author chengsukai
 * @since 2022-12-20 19:22
 */
public class TryCatchTest {

    public static void main(String[] args) {
        System.out.println(tryCatch());
    }

    private static String tryCatch() {
        try {
            throw new Exception("this is exception");
        } catch (Exception e) {
            System.out.println("deal with exception");
            return "I have catch this exception";
        }

    }
}
