package project.springThings.springLifecycle._23_2_23.api.client;

import project.springThings.springLifecycle._23_2_23.api.impl.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        //加载properties为我的容器
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("properties/beans.properties");
        Object d = app.getBean("d");
        System.out.println("我的d对象:"+d);

    }
}
