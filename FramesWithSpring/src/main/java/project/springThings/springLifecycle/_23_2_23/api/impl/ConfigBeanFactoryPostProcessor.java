package project.springThings.springLifecycle._23_2_23.api.impl;

import project.springThings.springLifecycle._23_2_23.api.BeanFactoryPostProcessor;

import java.util.concurrent.ConcurrentHashMap;

public class ConfigBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void BeanFactoryPostProcessor(ConcurrentHashMap beanFactory) {
        System.out.println("开始config");
    }
}
