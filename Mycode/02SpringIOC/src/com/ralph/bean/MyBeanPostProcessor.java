package com.ralph.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【"+beanName+"】将要调用初始化方法了..BeforeInitialization..这个bean是这样的：+【"+bean+"】");
        return bean;

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【"+beanName+"】初始化方法调用完了..AfterInitialization..这个bean是这样的：+【"+bean+"】");
        return bean;
    }
}
