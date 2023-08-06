package project.springThings.springEventListen;

import org.springframework.context.ApplicationEvent;

import java.util.List;


public class AEvent<T> extends ApplicationEvent {

    private T o;

    public AEvent(Object source) {
        super(source);
        this.o = (T)source;
    }

    public void Event1(){
        System.out.println("监听器执行AEvent中的方法Event1");
    }

    public void Event2(){
        System.out.println("监听器执行AEvent中的方法Event2");
    }



}
