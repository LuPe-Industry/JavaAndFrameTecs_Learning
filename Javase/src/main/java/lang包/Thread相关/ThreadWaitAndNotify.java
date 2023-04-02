package lang包.Thread相关;


public class ThreadWaitAndNotify {

    /*
    * 总结：
    * 1.wait会释放锁资源
    * 2.在wait的过程（已经进入临界区后）中如果对象锁被其他线程占用，那么醒来后需要等待别人释放锁
    * 下面逻辑有点点混乱。。。。感觉不对 但是我调试过程中总结出了这个 直接记住就好了
    *
    * */

    // 创建一个将被两个线程同时访问的共享对象
    public static Object object = new Object();

    // Thread0线程，执行wait()方法
    static class Thread0 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "初次获得对象锁，执行中，调用共享对象的wait()方法...");
                try {
                    // 共享对象wait方法，会让线程释放锁。
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //睡眠5秒
                try {
                    System.out.println("Thread0 睡眠5秒");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "再次获得对象锁，执行结束");
            }
        }

    }

    // Thread1线程，执行notify()方法
    static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                // 线程共享对象，通过notify()方法，释放锁并通知其他线程可以得到锁
                object.notify();
                System.out.println(Thread.currentThread().getName() + "获得对象锁，执行中，调用了共享对象的notify()方法");
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                try {
                    System.out.println("此时Thread0正在睡眠，直接抢夺object，本Thread2直接睡10秒");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "在Thread0 sleep时获得 对象锁 提示！！！");
            }
        }
    }

    // 主线程

    public static void main(String[] args) {
        Thread0 thread0 = new Thread0();
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread0.start();
        try {
            // 保证线程Thread0中的wait()方法优先执行，再执线程Thread1的notify()方法
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        thread1.start();

    }





}