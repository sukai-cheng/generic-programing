package com.designpattern.observerpattern.caseIII;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    /**
     * 用来保存注册的观察者对象
     */
    private final List<Observer> list = new ArrayList<Observer>();

    /**
     * 新增观察者对象
     *
     * @param observer 观察者对象
     */
    public void attach(Observer observer) {
        list.add(observer);
    }

    ;

    /**
     * 删除观察者对象
     *
     * @param observer 观察者对象
     */
    public void detach(Observer observer) {
        list.remove(observer);
    }

    ;

    /**
     * 通知所有注册的观察者对象
     *
     * @param newState 观察者对象
     */
    public void notifyObserver(String newState) {
        for (Observer observer : list) {
            observer.update(newState);
        }
    }
}
