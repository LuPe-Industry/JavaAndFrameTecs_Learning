package util包.concurrent包.Lock相关;

import java.util.concurrent.locks.ReentrantLock;

public class test {
    public static ReentrantLock lock =  new ReentrantLock();




    /*
    * 1.在我看来ReentrantLock主要用来锁定代码逻辑的
    * 2.相对于synchronized是这样的，而synchronized主要是针对资源的锁定
    *
    * */

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            LockTest2();


        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LockTest2();
            }
        });

        thread1.start();
        thread2.start();
        System.out.println("主线程运行完毕");

    }

    public static void LockTest1(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+":LockTest1");

        lock.unlock();
    }


    public static void LockTest2(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+":LockTest2");
    }

    //一个产生1-10的随机数数组的方法
    public static int[] getArray(){
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int)(Math.random()*10+1);
        }
        return array;
    }








}
