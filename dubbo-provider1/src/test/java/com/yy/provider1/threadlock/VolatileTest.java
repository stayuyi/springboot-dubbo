package com.yy.provider1.threadlock;

import com.yy.provider1.bean.CustomerInfo;
import com.yy.provider1.rabbitMQ.Customer;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO 2019/5/20
 *
 * @author yuyi
 */

public class VolatileTest {
	private volatile CustomerInfo customerInfo;
	private ThreadPoolExecutor pool=new ThreadPoolExecutor(30,30,60,
			TimeUnit.SECONDS,new LinkedBlockingQueue<>(),new ThreadPoolExecutor.AbortPolicy());


	@Test
	public void test1(){
		customerInfo=new CustomerInfo("A",1);




	}

}
