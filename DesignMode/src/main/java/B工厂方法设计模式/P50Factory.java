package B工厂方法设计模式;

import A简单工厂设计模式.HuaweiPhone;
import A简单工厂设计模式.P50;

public class P50Factory implements Factory{
    @Override
    public HuaweiPhone product() {
        return new P50();
    }
}
