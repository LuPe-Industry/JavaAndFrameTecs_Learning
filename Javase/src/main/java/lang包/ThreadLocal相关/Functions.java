package lang包.ThreadLocal相关;

import static lang包.ThreadLocal相关.test1.ioThreadLocal;

public class Functions {

    public static void function1(){
        ioThreadLocal.set("name");
        System.out.println("function1 use name");
        function2();
    }


    private static void function2(){
        System.out.println("function2");
        function3();

    }

    private static void function3(){
        System.out.println("function3");
        function4();
    }

    private static void function4(){
        System.out.println("function4");
        function5();
    }


    private static void function5(){
        System.out.println(ioThreadLocal.get());
    }


}
