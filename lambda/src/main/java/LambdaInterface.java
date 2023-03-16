import org.omg.CORBA.PUBLIC_MEMBER;

@FunctionalInterface
public interface LambdaInterface {
    public void function(Integer a,Integer b);
    public default void defFunction(){
        System.out.println("defFunction is Moving");
    }

    public default void defFunction2(){
        System.out.println("defFunction2 is Moving");
    }

    public static void staticFunction(){
        System.out.println("staticFunction is Moving");
    }

    public static void staticFunction2(){
        System.out.println("staticFunction2 is Moving");
    }

}
