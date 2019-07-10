package com.yy.provider1.springasync;

import com.yy.provider1.DubboProvider1Application;
import com.yy.provider1.config.async.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO 2019/4/1
 *
 * @author yuyi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest({"DubboProvider1Application.class"})
public class SpringAsyncTest {
	@Autowired
	private AsyncTask asyncTask;


	@Test
	public void testAsyncTask() throws InterruptedException {
		asyncTask.printB();
		asyncTask.printA();

	}



}
