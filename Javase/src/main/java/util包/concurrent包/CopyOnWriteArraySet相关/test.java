package util包.concurrent包.CopyOnWriteArraySet相关;


import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*
* 唉没什么好说的 到时候问一问chatGPT吧太简单了
*
* */

public class test {

    public static void main(String[] args) {
        CopyOnWriteArraySet<Object> set = new CopyOnWriteArraySet<>();
        set.add("1");
        set.add("2");
        set.add("3");

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

    }

}
