package com.designpattern.templatepattern.caseI;

public abstract class AbstractTemplate {

    /**
     * 模板方法
     */
    public void templateMethod() {
        abstractMethod();
        doHookMethod();
        concreteMethod();
    }

    protected abstract void abstractMethod();

    /**
     * 钩子方法(默认是空实现默认用do开头)
     */
    protected void doHookMethod() {
    }

    ;


    /**
     * 具体方法（抽象类已经实现）
     */
    private final void concreteMethod() {

    }
}
