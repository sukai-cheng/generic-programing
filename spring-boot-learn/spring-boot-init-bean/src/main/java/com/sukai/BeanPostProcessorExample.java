package com.sukai;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorExample  implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {

        System.out.println("BeanPostProcessor 调用 " + " postProcessBeforeinitialization 方法，参数 【" + bean.getClass ().getSimpleName()+ s);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        System.out.println("BeanPostProcessor 调用 " + " postProcessAfterinitialization 方法，参数 【" + bean.getClass ().getSimpleName()+ s);
        return bean;
    }
}