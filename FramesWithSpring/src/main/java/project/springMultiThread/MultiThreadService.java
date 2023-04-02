package project.springMultiThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class MultiThreadService {


    @Resource
    private Executor myAppThreadPool;

    @Resource
    private ThreadPoolTaskExecutor springPool;

    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 16, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));

    public void useSpringItselfPool() {
        springPool.execute(() -> {
            System.out.println("SpringItselfPool线程名为：" + Thread.currentThread().getName());
        });
    }

    public void useMyPool() {
        myAppThreadPool.execute(() -> {
            System.out.println("MyPool线程名为：" + Thread.currentThread().getName());
        });
    }

    public void useJavaPool() {
        threadPool.execute(() -> {
            System.out.println("JavaPool线程名为：" + Thread.currentThread().getName());
        });
    }


}
