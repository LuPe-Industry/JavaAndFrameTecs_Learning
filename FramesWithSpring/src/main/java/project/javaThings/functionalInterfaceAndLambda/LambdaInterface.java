package project.javaThings.functionalInterfaceAndLambda;

@FunctionalInterface
public interface LambdaInterface<T> {
    int function(T a,T b);
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
