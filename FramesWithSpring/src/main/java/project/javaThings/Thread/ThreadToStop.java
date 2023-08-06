package project.javaThings.Thread;

import project.projectDomains.Person;
import project.projectDomains.Pig;

public class ThreadToStop {
    /*
    *
    * 线程停止运行的几种方式 并且区分
    * */
    public static void main(String[] args) {
        //方式一 sleep（） 通过Thread常量
        Thread thread1 = new Thread(() -> {
            try {
                //主动睡眠1秒 (进入阻塞态)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //方式二 join（） thread2调用thread1的join方法
        Thread thread2 = new Thread(()->{
            try {
                //让thread1执行，thread2即本线程（进入阻塞），直到thread1执行结束
                thread1.join();
                //thread2   do。。。。。
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //方式三 yield（） 当前线程放弃cpu调用 等价于让cpu知晓已经完成了调用 （进入就绪态）
        Thread thread3 = new Thread(()->{
            Thread.currentThread().yield();
        });

        //方式四 wait() 和 notify()  属于Object类 只能在synchronized方法快中调用 因为只有在synchronized中才占有锁才有锁可以释放  上面三种属于Thread类
        Person person = new Person();
        Pig pig = new Pig();

        Thread thread4 = new Thread(()->{
            synchronized (person){
                try {
                    person.wait();//调用wait自我阻塞 然后释放person资源 直到被唤醒 重新占有person锁
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
            //自处线程5调用person资源，如果thread4没有释放，那么将不可以使用
        Thread thread5 = new Thread(()->{
            String name = person.getName();
            System.out.println(name);
            person.notify();//注意：这里唤醒 随机一个调用了person.wait();的线程
        });


    }




}
