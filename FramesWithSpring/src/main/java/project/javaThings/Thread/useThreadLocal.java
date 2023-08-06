package project.javaThings.Thread;

import java.util.HashMap;

public class useThreadLocal {
    public final static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    public final static ThreadLocal<Integer> intThreadLocal = new ThreadLocal<>();

    public final static ThreadLocal<HashMap<String,String>> hashMapThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        stringThreadLocal.set("fine");
        intThreadLocal.set(1);

        String s = stringThreadLocal.get();
        System.out.println(s);


    }
}
