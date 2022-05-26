package sukai.desginpattern.decoratorpattern.caseI;

/**
 * @author chengsukai
 **/
public class ConcreteDecoratorA extends Decorator {
    private  String adddedState;

    @Override
    public void Operation() {
        super.Operation();
        adddedState = "New State";
        System.out.println("具体装饰对象A的操作 " + adddedState);
    }
}