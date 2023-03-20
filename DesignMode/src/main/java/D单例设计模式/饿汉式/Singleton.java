package D单例设计模式.饿汉式;

//饿汉式单例类.在类初始化时，已经自行实例化
public class Singleton {
    private Singleton() {}
    private static final Singleton single = new Singleton();
    //静态工厂方法
    public static Singleton getInstance() {
        return single;
    }
}
