package 特性包.函数式接口;

import java.lang.annotation.Annotation;

public class test {

    static int testNumber2 = 100;


    public static void main(String[] args) {
        useFunctionalInterface uf = new useFunctionalInterface(1,2);

        Integer c = 100;
        Integer d = 29;
        final int testNumber = 100;


        uf.use(new functionalInterface(){
            @Override
            public void onlyFunction(Integer a, Integer b) {
                if(a>b){
                    System.out.println(new Numbers(a,b).toString());
                }else {
                    System.out.println("b>a");
                }

                testNumber2 = 200;

            }
        });



    }








}

class useFunctionalInterface {

    private Integer a;
    private Integer b;
    public void use(functionalInterface fi) {
        fi.onlyFunction(a,b);
    }

    public useFunctionalInterface(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public useFunctionalInterface() {
    }
}

class Numbers{
    private Integer number1;
    private Integer number2;

    public Numbers(Integer number1, Integer number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                '}';
    }
}

