package project.springLifecycle._23_2_23.api.impl;

import project.springLifecycle._23_2_23.api.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ClassPathXmlApplicationContext implements ApplicationContext , Resource {

    /*
    *
    * 注意 我这里仅仅处理一个对象, 把这个对象放进容器中,走一个创建bean工厂的流程 对象为D
    *
    *
    * */

    ConcurrentHashMap<String,Object> beanFactory;
    //beanFactoryPostProcessor是用于容器实例化后操作bean的定义属性的(此时bean还没创建呢)
    ConcurrentHashMap<String, BeanFactoryPostProcessor> beanFactoryPostProcessors = new ConcurrentHashMap<>(64);
    ConcurrentHashMap<String, BeanPostProcessor> beanPostProcessors = new ConcurrentHashMap<>(64);
    private Properties beanDefinitions = new Properties();

//构造
    public ClassPathXmlApplicationContext(String config) {
        InputStream inputStream = readXML(config);
        try {
            //加载bean元数据
            beanDefinitions.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        refresh();

    }

    private void refresh() {
        //1.准备环境
        prepareRefresh();

        //2.创建bean池
        beanFactory = new ConcurrentHashMap<>(64);

        //3.准备工作
        prepareBeanFactory(beanFactoryPostProcessors);//先把我要预处理的beanFactoryPostProcessor们放进去
        try{
            //调整?后置beanFactory加载器 我不知道这一步干啥的,就默认啥也不干吧
            postProcessBeanFactory(beanFactory);
            //bean工厂已经好了 执行元数据后置处理器
            invokeBeanFactoryPostProcesser(beanFactoryPostProcessors);
            //注册所有的BeanPostProcessors
            registerBeanFactoryProcessors(beanFactory);
            //完成实例化
            finishBeanFactoryInitialization(beanFactory);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void finishBeanFactoryInitialization(ConcurrentHashMap<String, Object> beanFactory) {
        for(Map.Entry<Object,Object> entry : beanDefinitions.entrySet()){
            String className = (String) entry.getValue();
            Constructor<?> declaredConstructor = null;
            try {
                //1.创建
                Class<?> aClass = Class.forName(className);
                declaredConstructor = aClass.getDeclaredConstructor();
                Object instance = declaredConstructor.newInstance();
                //2.依赖注入,属性填充(复杂 不写了)
                //3.init
                    //查看是否实现了ApplicationContextAware接口,如果实现了,把本上下文直接赋予
                if(aClass.isAssignableFrom(ApplicationContextAware.class)){//isAssignableFrom用于查看是否实现某接口
                    ApplicationContextAware applicationContextAware = (ApplicationContextAware) instance;
                    applicationContextAware.setApplicationContext(this);
                }//这就是为什么我之前实现这个aware接口可以获得上下文的原因


                //beforeInit初始化前操作
                for(Map.Entry<String , BeanPostProcessor> entry1 :beanPostProcessors.entrySet()){
                    entry1.getValue().beforeInitialization(instance);
                }
                //init
                if(aClass.isAssignableFrom(init.class)){
                    init init = (init) instance;
                    init.init();
                }

                //afterInit初始化后操作 巴拉巴拉的
                for(Map.Entry<String , BeanPostProcessor> entry1 :beanPostProcessors.entrySet()){
                    entry1.getValue().afterInitialization(instance);
                }

                beanFactory.put((String) entry.getKey(), instance);

            } catch (NoSuchMethodException|ClassNotFoundException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }

    private void registerBeanFactoryProcessors(ConcurrentHashMap<String, Object> beanFactory) {
        //注册类的BeanPostProcessor
        for (Map.Entry<Object,Object> entry : beanDefinitions.entrySet()){
            try {
                Object instance = Class.forName((String) entry.getValue()).getDeclaredConstructor().newInstance();
                beanPostProcessors.put((String) entry.getKey(),(BeanPostProcessor)instance);
            } catch (NoSuchMethodException|ClassNotFoundException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                e.printStackTrace();
            }

        }

    }

    private void invokeBeanFactoryPostProcesser(ConcurrentHashMap<String, BeanFactoryPostProcessor> beanFactoryPostProcessors) {
        //1.找到所有的beanFactoryPostProcessor
        for(Map.Entry<String ,BeanFactoryPostProcessor> entry : beanFactoryPostProcessors.entrySet()){
            //2.开始操作 比如bean定义
            entry.getValue().BeanFactoryPostProcessor(beanFactory);
        }
    }

    private void postProcessBeanFactory(ConcurrentHashMap<String, Object> beanFactory) {
    }
/*
* 此方法可以留给程序员自己去实现 往bean工厂注入
* */
    private void prepareBeanFactory(ConcurrentHashMap<String, BeanFactoryPostProcessor> beanFactoryPostProcessors) {
        beanFactoryPostProcessors.put("d的元数据预处理processor",new ConfigBeanFactoryPostProcessor());
    }

    private void prepareRefresh() {
        System.out.println("对环境进一步检查,日志的配置,看看环境是不是适合配置bean");
    }

    @Override
    public Object getBean(String name) {
        return beanFactory.get(name);
    }
/*
* 这边很生疏 不会技术 得多琢磨
* */
    @Override
    public InputStream readXML(String config) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(config);
    }
}
