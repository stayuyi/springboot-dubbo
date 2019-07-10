package com.yy.provider1.error;

import org.junit.Test;

/**
 * TODO 2019/6/21
 *
 * @author yuyi
 */

public class TryCatchTest {
	@Test
	public void test(){
		try {
			System.out.println("try---1");
			try {
				System.out.println("try--2");
				System.out.println(1/0);
			}catch (Exception e){
				System.out.println("error--2");
				return;
			}
			System.out.println("try---1,after return");
		}catch (Exception e){
			System.out.println("error---1");
		}finally {
			System.out.println("finally");
		}



	}

}
