package sukai.currency.chapter01;

/**
 * @author chengsukai
 * @since 2022-08-17 15:35
 */
public class TemplateMethod {
    public final void print(String msg) {
        System.out.println("##################");
        wrapPrint(msg);
        System.out.println("##################");
    }

    protected void wrapPrint(String msg) {

    }

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String msg) {
                System.out.println("*" + msg + "*");
            }
        };
        t1.print("Hello Thread");
        TemplateMethod t2 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String msg) {
                System.out.println("+" + msg + "+");
            }
        };
        t2.print("Hello Thread");
    }
}

