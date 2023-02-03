package com.designpattern.observerpattern.caseIV;

public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState) {
        state = newState;
        System.out.println("主题状态：" + state);
        // 通知所有观察者
        this.notifyObserver();
    }

}
