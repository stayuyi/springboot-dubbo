package com.yy.provider1.config.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO 2019/4/1
 *
 * @author yuyi
 */

public class AsyncTest {
	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AsyncConfig.class);
		AsyncTask asyncTask =context.getBean(AsyncTask.class);
		asyncTask.printA();
		asyncTask.printB();
		System.out.println("spring异步");
	}
}
