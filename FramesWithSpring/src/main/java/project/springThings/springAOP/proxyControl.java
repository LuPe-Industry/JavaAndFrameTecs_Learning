package project.springThings.springAOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class proxyControl {
    //定义切点（切点包含1个或者多个方法， 一个方法俗称为连接点）
    //这里没有使用@Pointcut 而是直接在Before中使用表达式 直接干活我喜欢
    @Before("execution(* project.springThings.springAOP.services.*.*())")
    private void someServices() {
        System.out.println("哥哥来了");
    }
}
