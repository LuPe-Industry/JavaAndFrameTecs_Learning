package project.springThings.springLifecycle._23_2_23.api.client;

import project.springThings.springLifecycle._23_2_23.api.ApplicationContext;
import project.springThings.springLifecycle._23_2_23.api.ApplicationContextAware;
import project.springThings.springLifecycle._23_2_23.api.BeanFactoryPostProcessor;
import project.springThings.springLifecycle._23_2_23.api.BeanPostProcessor;

import java.util.concurrent.ConcurrentHashMap;

public class D implements ApplicationContextAware, BeanFactoryPostProcessor, BeanPostProcessor {
    public D() {
        System.out.println("D 已构造");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("赋予D以上下文权力");
    }

    @Override
    public void BeanFactoryPostProcessor(ConcurrentHashMap beanFactory) {
        System.out.println("处理D相关的元数据");
    }

    @Override
    public void beforeInitialization(Object bean) {
        System.out.println("实例D后初始化前对D实例进行操作");
    }

    @Override
    public void afterInitialization(Object bean) {
        System.out.println("实例D后初始化后对D实例进行操作");
    }
}
