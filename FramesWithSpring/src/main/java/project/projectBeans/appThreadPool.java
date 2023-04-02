package project.projectBeans;

import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Component
@Configuration
public class appThreadPool{
    /*
    *
    * 本项目中唯一的线程池
    * 目前我用的13400 6大4小 总计16线
    *
    * */

    @Bean("myAppThreadPool")
    public Executor ThreadPoolInApp(){

        ThreadPoolTaskExecutor appThreadPool = new ThreadPoolTaskExecutor();
        appThreadPool.setCorePoolSize(2);
        appThreadPool.setMaxPoolSize(16);
        appThreadPool.setQueueCapacity(32);
        appThreadPool.setThreadNamePrefix("appThread（notSpring）-->");
        //设置线程拒绝策略：当线程池满了 等待队列也满了 如何拒绝创建线程
        appThreadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        appThreadPool.initialize();
        return appThreadPool;

    }





}
