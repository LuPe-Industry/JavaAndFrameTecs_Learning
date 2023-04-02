package lang包.Thread相关;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutor {


    /*
    * 注意：我在FramesWithSpring中有测试 那边是第一步我的第一次尝试高并发的东西
    *
    * */

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(100));
    public static void main(String[] args) {

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("liu先生您好");
            }
        });
    }

}
