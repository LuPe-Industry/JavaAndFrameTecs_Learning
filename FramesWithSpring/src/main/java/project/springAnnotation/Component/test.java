package project.springAnnotation.Component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
    public static void main(String[] args) {
        //通过配置类来获取上下文 应该是扫描的这个包下的所有配置类 然后生成所有bean
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext("crazylupe.project.project.springAnnotation.Component");
        Object myClass = app.getBean("myClass");
        System.out.println(myClass);

    }
}
