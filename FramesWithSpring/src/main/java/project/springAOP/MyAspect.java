package project.springAOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspect {



    @Pointcut("execution(* project.springAOP.MyRunning2.*())")
    public void Pointcut1(){
    }

    @Before("Pointcut1()")
    public void before(){
        System.out.println("before running");
    }

    @After("Pointcut1()")
    public void after(){
        System.out.println("after running");
    }

}
