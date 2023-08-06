package util包.Scanner相关;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        BufferedReader bis =null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            bis = new BufferedReader(isr);

            while (true) {
                System.out.println("请输入字符串：");
                String data;
                data = bis.readLine();
                if (data.equals("e") || data.equals("exit")) {
                    System.out.println("程序结束");
                    break;
                }
                String s = data.toUpperCase();
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (bis!=null) {
                    bis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
