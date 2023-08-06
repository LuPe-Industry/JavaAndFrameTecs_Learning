package project.javaThings.functionalInterfaceAndLambda;

import java.util.ArrayList;
import java.util.Comparator;

public class MyMain {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        AContainerWithFunctionalInterface<String> container = new AContainerWithFunctionalInterface<>();
        container.setList(list);
        container.NeedAFunctionalInterface(new LambdaInterface<String>() {
            //说明：5 这里写的内容其实是一种算法 交给容器底层去按规则操作数据的
            @Override
            public int function(String a, String b) {
                return 1;
            }
        });

//回顾（23.8.4）：此处想说明函数式接口只能有一个普通方法，但是可以有多个静态方法，多个默认方法
        LambdaInterface c = (a,b)->{
            System.out.println("yes");
            return 1;
        };
        c.function(1,2);
        c.defFunction();
        c.defFunction2();
        LambdaInterface.staticFunction();

//说明：4
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        System.out.println(list);

    }

}
