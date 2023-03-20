package D单例设计模式.懒汉式;

//注意：即便是单例化也可以通过类名直接反射出私有构造器 并加以使用


//懒汉式单例类.在第一次调用的时候实例化自己
public class Singleton {
    //构造器私有即可
    private Singleton() {}
    //内存中将存在唯一实例
    private static Singleton single=null;
    //静态工厂方法
    public static Singleton getInstance() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }

//考虑到上述线程安全问题 可以给本类加上重锁
    public static Singleton getInstance2() {
        if (single == null) {
            synchronized (Singleton.class) {
                if (single == null) {
                    single = new Singleton();
                }
            }
        }
        return single;
    }
}
