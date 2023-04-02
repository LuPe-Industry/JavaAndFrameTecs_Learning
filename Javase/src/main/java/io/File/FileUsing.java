package io.File;

import java.io.File;
import java.io.FilenameFilter;

public class FileUsing {

    public static void main(String[] args) {


    }

    public void  relativePath(){
        //通过相对路径定位文件
        File file1 = new File("src\\main\\resources\\txts\\file1.txt");
        System.out.println(file1.exists());//true
    }



    //过滤器的使用
    public void filter(){
        //指定一个文件目录
        File directory1 = new File("src\\main\\resources\\pictures");

        //用上新学的接口式函数整个过滤器
        File[] fileArray1 = directory1.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //true表示我要了 false的过滤掉
                return name.contains(".jpg") & dir.isDirectory();
            }
        });
        for(File file : fileArray1){
            System.out.println(file.getName());
        }
    }

}
