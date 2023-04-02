package lang包.String相关;

/*
* 输入：ohW era uoy ? I ma xelA.
* 输出：Who are you ? I am Alex.
* */

import java.io.UnsupportedEncodingException;

public class StringItSelf {
    public static void main(String[] args) throws UnsupportedEncodingException {

        StringBuilder BBuilder = new StringBuilder();
        String myString = "ohW era uoy ? I ma xelA.";
        String[] split = myString.split(" ");
        for (String s : split){
            StringBuilder ABuilder = new StringBuilder(s);//正常反转
            StringBuilder temp = new StringBuilder();//反转带.的
            if(!s.contains(".")){
                BBuilder.append(ABuilder.reverse());
                BBuilder.append(" ");
            }else {
                String substring = s.substring(0,s.length() - 1);
                BBuilder.append(temp.append(substring).reverse());
                BBuilder.append(".");
            }


        }
        String last = BBuilder.toString();
        System.out.println(last);

    }
}
