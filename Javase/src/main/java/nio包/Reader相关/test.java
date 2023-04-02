package nio包.Reader相关;

import java.io.IOException;
import java.io.StringReader;

public class test {
    public static void main(String[] args) {
        StringReader reader = new StringReader("1234567890");
        char[] chars = new char[1024];
        try {
            reader.read(chars, 0, 1024);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(chars);


    }
}
