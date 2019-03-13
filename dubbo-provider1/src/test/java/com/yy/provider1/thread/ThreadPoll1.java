package com.yy.provider1.thread;

import com.alibaba.dubbo.common.threadpool.support.cached.CachedThreadPool;

import java.util.concurrent.*;

/**
 * Created by yuyi on 2019/3/6.
 */

public class ThreadPoll1 {
    private static ThreadPoolExecutor pool=new ThreadPoolExecutor(5,5,60L,
            TimeUnit.SECONDS,new LinkedBlockingQueue<>(5),new ThreadPoolExecutor.AbortPolicy());

    private void test(){

    }

    public static void main(String[] args) {
        int size=10000;
        for (int i=0;i<size;i++) {
            try {
                long start=System.currentTimeMillis();
                pool.execute(() -> System.out.println("线程执行:"));
                long end= System.currentTimeMillis();
                System.out.println(i+":"+(end-start));
            }catch (RejectedExecutionException e){
                System.out.println("拒绝策略,抛错{}"+Thread.currentThread().getId());
            }
        }

    }




}
