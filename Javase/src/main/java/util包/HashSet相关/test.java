package util包.HashSet相关;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class test {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.remove("1");
        Iterator<String> iterator = set.iterator();
        System.out.println(set);

        set.clear();
        System.out.println(set);

    }
}
