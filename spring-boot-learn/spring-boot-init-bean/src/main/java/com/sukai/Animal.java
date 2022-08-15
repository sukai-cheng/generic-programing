package com.sukai;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component // 根据注解找到相对应的类
@Data // 设置set/get方法
public class Animal implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private String name;
    private Integer age;
    private String cry;

    public void setBeanName(String name) {
        System.out.println("【" + this.getClass().getSimpleName() + " 】" + " 调用 beanFactoryAware 的 setBeanName ");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Animal被工厂创建了出来：" + beanFactory.getClass().getName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("加载容器环境中：" + applicationContext.getClass().getName());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】注解@PreDestroy定义的自定义销毁方法");
    }

    @PostConstruct
    public void init() {
        System.out.println("【" + this.getClass().getSimpleName() + "】 注解PostConstruct定义的自定义初始化方法");

    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println(this.getClass().getSimpleName() + "调用 initializingBean的 afterPropertiesSet 方法");
    }
}
