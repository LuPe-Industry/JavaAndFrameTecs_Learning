package project.springThings.springEventListen;

import org.springframework.context.ApplicationEvent;


public class AEvent2<T> extends ApplicationEvent {

    private T o;

    public AEvent2(Object source) {
        super(source);
        this.o = (T)source;
    }

    public void Event1(){
        System.out.println("监听器执行AEvent2中的方法Event1");
    }

    public void Event2(){
        System.out.println("监听器执行AEvent2中的方法Event2");
    }



}
