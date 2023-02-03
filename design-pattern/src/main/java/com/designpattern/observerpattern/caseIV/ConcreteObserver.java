package com.designpattern.observerpattern.caseIV;

import lombok.Data;

@Data
public class ConcreteObserver implements Observer {

    private String observerState;

    @Override
    public void update(Subject subject) {
        observerState = ((ConcreteSubject) subject).getState();
        System.out.println("观察者状态为 : " + observerState);
    }
}
