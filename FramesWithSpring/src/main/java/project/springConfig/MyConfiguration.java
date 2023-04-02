package project.springConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;


/*
* 1.注意在 @Configuration 注解的类里面使用@Bean 那么本类中Bean之间可以相互注入
*   但是如果没有@Configuration Bean之间就不能相互注入 只能通过参数使用@qualifier注解标注一个参数让spring找bean来注入
*
* */
@Configuration
public class MyConfiguration {
    //springboot一启动, spring直接扫描 直接创造myCar这个Bean
    @Bean("myCar")
    public Car car(){
        return new Car();
    }

    //如上述备注1所述 如果没有@Configuration 就只能通过这种方式注入
    @Bean("myDog")
    public Dog dog(@Qualifier("myCar") Car car){
        System.out.println("=================================");
        System.out.println(car);
        Dog dog = new Dog();
        List<Car> list = new LinkedList<>();
        list.add(car);
        dog.setList(list);
        return dog;
    }


}
