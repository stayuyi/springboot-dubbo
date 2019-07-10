package com.yy.provider1.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO 2019/4/26
 *
 * @author yuyi
 */

public class InnerClassImpRunnable {
	private ThreadPoolExecutor pool=new ThreadPoolExecutor(30,30,
			60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.AbortPolicy());



	class run implements Runnable{

		@Override
		public void run() {
			System.out.println();
		}
	}





}
