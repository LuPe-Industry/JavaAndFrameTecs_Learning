package io.Stream;

import io.File.FileUsing;
import io.object.User;

import java.io.*;

public class StringUsing {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


//        Function02();

//        Function3();
        Function4();


    }


    /*
    * 输入流试玩
    * */
    public void Function01(){
        try{
            FileInputStream fileInputStream = new FileInputStream("src\\main\\resources\\txts\\file2.txt");
            int read;
            while ((read = fileInputStream.read())!=-1){
                System.out.println(read + " ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    *
    * 输出流试玩
    *
    * */
    public static void Function02(){
        try{
            InputStream inputStream = new FileInputStream("src\\main\\resources\\txts\\file2.txt");
            OutputStream outputStream = new FileOutputStream("src\\main\\resources\\txts\\file3.txt",true);

            byte[] buf = new byte[3];
            int len;
            while ((len =inputStream.read(buf))  != -1){
                System.out.println("扔进去的字符："+ buf);
                /*
                * 解释：
                * 这里的.write方法 虽然一直在被while调用 但是经过第一次调用 写指针已经被挪动了
                * 这里的off是指 比如总体我想写100个字符进去 但是我规定了off为10 那也就是该输入源从0-9这10个位置的信息不输出到目标文件中
                * len是指buffer里面的字符数 如果buffer长度为100（就比如说我这个byte（100）也就是里面有100个字符，别看里面就36个实体字符，实际上剩余64个都默认为空）
                * 这点非常值得注意
                * */
                outputStream.write(buf,0,len);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //对象输出流
    public static void Function3() throws IOException {

        FileOutputStream fos = new FileOutputStream("src\\main\\resources\\txts\\file4.txt");


        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(new User("liupeng",1,2));
        os.close();
        fos.close();


    }


    //对象输入流
    public static void Function4() throws IOException, ClassNotFoundException {
        //怼了一个string
        InputStream is = new FileInputStream("src\\main\\resources\\txts\\file4.txt");
        ObjectInputStream oi  = new ObjectInputStream(is);
        User user = (User)(oi.readObject());
        System.out.println(user.getName());
        is.close();
        oi.close();
    }

}
