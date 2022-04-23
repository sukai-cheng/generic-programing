package sukai.functional.caseI;

/**
 * @description
 *
 * @author chengsukai
 *
 * @create 2022-04-04 21:52
 **/
public class MyFunctionTest {
    public static void main(String[] args) {
        String text = "Functional Interface";
        printString(text,System.out :: println);
    }

    private static void printString(String text, MyFunction myfunction){
        myfunction.print(text);
    }
}