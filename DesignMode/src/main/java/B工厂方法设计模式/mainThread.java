package B工厂方法设计模式;

import A简单工厂设计模式.HuaweiPhone;

public class mainThread {
    public static void main(String[] args) {
        Mate50Factory mate50Factory = new Mate50Factory();
        HuaweiPhone mate50 = mate50Factory.product();
        mate50.call();

    }
}
