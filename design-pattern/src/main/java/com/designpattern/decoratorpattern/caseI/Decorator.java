package com.designpattern.decoratorpattern.caseI;

/**
 * @author chengsukai
 **/
public abstract class Decorator extends Component{
    protected Component component;

    public void setComponent(Component component){
        this.component = component;
    }

    @Override
    public void Operation() {
        component.Operation();
    }
}