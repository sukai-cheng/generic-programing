package sukai.selfannotation.caseV;

/**
 * @author chengsukai
 * @since 2022-06-20 08:59
 */
public class ServiceA {

    @SimpleInject
    ServiceB serviceB;

    public void callB(){
        serviceB.action();
    }
}
