import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class MyMain {
    public static void main(String[] args) {
        LambdaInterface c = (a,b)->{
            System.out.println(a+b);
        };
        c.function(1,2);
        c.defFunction();
        c.defFunction2();
        LambdaInterface.staticFunction();

//说明：4
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        System.out.println(list);

    }

}
