package com.yy.provider1.threadlock;

import com.google.common.collect.Maps;
import com.yy.provider1.bean.CustomerInfo;
import com.yy.provider1.error.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * TODO 2019/3/21
 *
 * @author yuyi
 */
@Slf4j
public class LockTest {
	private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private static ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 8, 60,
			TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024), new ThreadPoolExecutor.CallerRunsPolicy());

	private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
	private static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
	private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	private static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);

	/*
	TODO 主线程获取了2次锁,只释放了一次锁,导致出现死锁;一个线程获取多少次锁，就必须释放多少次锁   print:  main thread execute
	 */
	@Test
	public void test1() {
		Thread thread = new Thread(() -> {
			readWriteLock.writeLock().lock();
			System.out.println("Thread real execute");
			readWriteLock.writeLock().unlock();
		});

		readWriteLock.writeLock().lock();
		readWriteLock.writeLock().lock();
		thread.start();
		System.out.println("main thread execute");
		readWriteLock.writeLock().unlock();
	}

	/*
	TODO ReetrantReadWriteLock 不支持锁升级,即同一线程 读锁 未释放去申请 写锁,会造成死锁   print: get read lock
	 */
	@Test
	public void test2() {
		readWriteLock.readLock().lock();
		System.out.println("get read lock");
		readWriteLock.writeLock().lock();
		System.out.println("get write lock");

		List list=new ArrayList();
	}

	/*
	TODO ReetrantReadWriteLock 支持锁降级,即同一线程中 写锁 未释放去申请 读锁  print: get write lock      get read lock
	 */
	@Test
	public void test3() {
		readWriteLock.writeLock().lock();
		System.out.println("get write lock");
		readWriteLock.readLock().lock();
		System.out.println("get read lock");
	}

	@Test
	public void test4() {
		String str = null;
		Assert.assertNotNull("error parameter", str);
		System.out.println("str==>>:" + str);

	}

	@Test
	public void test5() {
		String str = null;
		if (StringUtils.isBlank(str)) {
			throw new BaseException("E10001", "error parameter");
		}
		System.out.println("str==>>:" + str);
	}

	/*
	TODO 测试 readLock  和  WriteLock保证线程安全
	 */
	@Test
	public void test6() {
		CustomerInfo c1 = new CustomerInfo("a", 1);
		CustomerInfo c2 = new CustomerInfo("b", 2);
		CustomerInfo c3 = new CustomerInfo("b", 3);
		List<CustomerInfo> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		new Thread(() -> {
			while (true) {
				readWriteLock.readLock().lock();
				System.out.println("读:" + System.currentTimeMillis() + ":" + list);
				readWriteLock.readLock().unlock();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		pool.execute(() -> {
			int i = 0;
			while (i < 10) {
				readWriteLock.writeLock().lock();
				c1.setAge(new Random().nextInt(10));
				System.out.println("写:" + System.currentTimeMillis() + ":" + list);
				readWriteLock.writeLock().unlock();
				i++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		while (true) {
			System.out.println("主:" + System.currentTimeMillis() + ":" + list);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	TODO  ScheduledPoolExecutor 测试,Callable 和 Runnable
	 */
	@Test
	public void test7() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		System.out.println("开启线程：" + sdf.format(new Date()));
		scheduledThreadPool.schedule(() -> {
			System.out.println("延迟5秒执行" + sdf.format(new Date()));
		}, 5, TimeUnit.SECONDS);

		ScheduledFuture<String> scheduleCallableResult = scheduledThreadPool.schedule(() -> {
			return "延迟5秒执行" + sdf.format(new Date());
		}, 5, TimeUnit.SECONDS);

		try {
			System.out.println("获取callable result...");
			String s = scheduleCallableResult.get();
			System.out.println("CallableResult" + s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}


		for (int i = 1; i <= 12; i++) {
			System.out.println("主线程等待中..." + i);
			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("主线程结束");
	}

	/*
	TODO Runable Callable
	 */
	@Test
	public void test8() throws ExecutionException, InterruptedException, TimeoutException {
		Callable callable=new Callable() {
			@Override
			public Object call() throws Exception {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("callable--->>"+System.currentTimeMillis());
				return "callable"+System.currentTimeMillis();
			}
		};

		Runnable runnable=new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("runnable===>>"+System.currentTimeMillis());
			}
		};
		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("add task"+System.currentTimeMillis());
		Future submit = pool.submit(callable);
		pool.execute(runnable);
		boolean cancel = submit.cancel(true);
		System.out.println("cancel:"+cancel);
//		Object result = submit.get();

		boolean cancelled = submit.isCancelled();
		boolean done = submit.isDone();
		System.out.println("cancelled:"+cancelled);
		System.out.println("done:"+done);

		Object result = submit.get(2, TimeUnit.SECONDS);


		System.out.println("callable===>>"+String.valueOf(submit.get(2, TimeUnit.SECONDS)));
		System.out.println("main thread terminate"+System.currentTimeMillis());
	}

	/*
	TODO 线程池定时任务 scheduleThreadPool
	 */
	@Test
	public void test(){
		Runnable runnable= () -> System.out.println(System.currentTimeMillis()+"task");
//		scheduledThreadPool.schedule(runnable,2,TimeUnit.SECONDS);

		//固定延迟时间的 定时任务,任务执行时间必须小于间隔时间
		scheduledThreadPool.scheduleAtFixedRate(runnable,1,2, TimeUnit.SECONDS);

		//不固定延时时间   上一次任务执行完毕后才开始计算间隔时间
		scheduledThreadPool.scheduleWithFixedDelay(runnable,1,2,TimeUnit.SECONDS);

		for (int i=0;i<10;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(System.currentTimeMillis()+"main");
		}
	}

}
