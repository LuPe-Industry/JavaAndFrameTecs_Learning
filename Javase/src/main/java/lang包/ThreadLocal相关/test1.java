package lang包.ThreadLocal相关;

import java.util.HashMap;

public class test1 {

    /*
    * 面向线程提供服务，为每个独立的线程提供一个储藏柜，并且其他线程不可访问
    *
    *
    * */

    public static ThreadLocal<Object> ioThreadLocal = new ThreadLocal<>();

//两个线程 都注入了map，但是互不影响
//    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("main1","1");
//        map.put("main2","2");
//        map.put("main3","3");
//        ioThreadLocal.set(map);
//        new Thread(()->{
//            HashMap<String, String> map1 = new HashMap<>();
//            map1.put("thread1","1");
//            map1.put("thread2","2");
//            map1.put("thread3","3");
//            ioThreadLocal.set(map1);
//            System.out.println("=====NotThreadMain====");
//            System.out.println(ioThreadLocal.get());
//            System.out.println("=====NotThreadMain====");
//        }).start();
//
//        System.out.println("=====ThreadMain====");
//        System.out.println(ioThreadLocal.get());
//        System.out.println("=====ThreadMain====");
//
//
//    }

    public static void main(String[] args) {
        Functions.function1();
    }




}
