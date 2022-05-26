package sukai.desginpattern.decoratorpattern.caseI;

/**
 * @author chengsukai
 **/
public class ConcreteComponent extends Component{

    @Override
    public void Operation() {
        System.out.println("具体的对象操作");
    }
}