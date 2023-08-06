package project.javaThings.functionalInterfaceAndLambda;

import java.util.ArrayList;

public class AContainerWithFunctionalInterface<T> {
    ArrayList<T> list;

    public AContainerWithFunctionalInterface(ArrayList<T> list) {
        this.list = list;
    }

    public AContainerWithFunctionalInterface() {
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }

    //我并不知道接收到这个函数接口该怎么操作它 看了sort（）源码 就是是在最底层用来操作list容器的算法
    public void NeedAFunctionalInterface(LambdaInterface<? extends T> lambdaInterface){
        System.out.println("收到了LambdaInterface:"+lambdaInterface);
    }
}
