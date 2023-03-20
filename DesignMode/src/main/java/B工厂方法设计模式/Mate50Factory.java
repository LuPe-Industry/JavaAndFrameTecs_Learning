package B工厂方法设计模式;

import A简单工厂设计模式.HuaweiPhone;
import A简单工厂设计模式.Mate50;
import A简单工厂设计模式.P50;

public class Mate50Factory implements Factory{
    @Override
    public HuaweiPhone product() {
        return new Mate50();
    }
}
