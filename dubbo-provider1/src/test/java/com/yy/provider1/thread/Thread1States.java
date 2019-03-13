package com.yy.provider1.thread;


import org.junit.Test;

/**
 * Created by yuyi on 2019/1/12.
 */

public class Thread1States {

    class Thread1 implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("线程111111111");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Thread2 implements Runnable {
        @Override
         public synchronized void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2222222执行,并进入等待状态");
                try {
                    wait();//进入等待状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test1() {
        //1.创建,即实例化线程
        Thread t1 = new Thread(new Thread1());//创建线程,并制定线程运行的方法
        //2.就绪
        t1.start();

        //3.获取到cpu资源,运行中
        while (true) {
            System.out.println("主线程");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        Thread2 n = new Thread2();
        Thread t2 = new Thread(n);
        t2.start();

        while (true) {
            synchronized (n) {
                System.out.println("主线程");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n.notify();//唤醒线程,n必须被同步,notify通知的对象必须被同步
            }
        }

    }
}