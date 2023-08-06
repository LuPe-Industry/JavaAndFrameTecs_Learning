package project.springThings.springAnnotation.Component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
*
* 注意这边spring扫描的是编译过后的字节码文件 myClass.class 不是现在编写的类
*
*用注解生成的bean没有指定beanName的话,默认为名字为myClass
* 如果用xml,没有指定名称,那么默认为全限定名加编号 比如crazylupe.project.project.springAnnotation.Component.myClass#0 但我不想用xml真滴麻烦
*
* */
@Component //这里也可以加名字@Component("myClass111")
@Scope //这个注解用来控制作用范围  默认是singleton 回头要去好好学习一下设计模式
public class myClass {

}
