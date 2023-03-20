package A简单工厂设计模式;

public class mainThread {
    public static void main(String[] args) {
        HuaWeiPhoneFactory huaWeiPhoneFactory = new HuaWeiPhoneFactory();
        HuaweiPhone p50 = huaWeiPhoneFactory.AProduct("P50");
        p50.call();
    }
}
