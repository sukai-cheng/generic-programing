package sukai.desginpattern.decoratorpattern.caseI;

/**
 * @author chengsukai
 **/
public class ConcreteDecoratorB extends Decorator {
    private String adddedState;

    @Override
    public void Operation() {
        super.Operation();
        System.out.println("具体装饰对象B的操作");
    }

    private void AddedBehavior() {

    }
}