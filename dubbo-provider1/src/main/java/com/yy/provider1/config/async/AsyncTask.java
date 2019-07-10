package com.yy.provider1.config.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * TODO 2019/4/1
 *
 * @author yuyi
 */

@Service
public class AsyncTask {
	@Async
	public void printA() throws InterruptedException {
		while (true) {
			Thread.sleep(1000);
			System.out.println("AAAAA");
		}
	}

	@Async
	public void printB() throws InterruptedException {
		while (true) {
			Thread.sleep(1000);
			System.out.println("BBBBB");
		}
	}
}
