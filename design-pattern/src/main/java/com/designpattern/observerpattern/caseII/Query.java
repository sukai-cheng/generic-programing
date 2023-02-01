package com.designpattern.observerpattern.caseII;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author chengsukai
 **/
public class Query implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("变化的对象为：" + evt.getSource());
        System.out.println();//空一行
        System.out.println("变化的情况为：" + evt.getPropertyName());
        System.out.println("变化前的内容：" + evt.getOldValue());
        System.out.println("变化后的内容：" + evt.getNewValue());
        System.out.println();//空一行
    }
}