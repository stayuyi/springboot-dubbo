package com.yy.provider1.stringformat;

import org.junit.Test;

import javax.persistence.Convert;
import java.util.Date;

/**
 * TODO 2019/3/22
 *
 * @author yuyi
 */

public class StringFormatTest {

	/*
	TODO int转String且位数补齐
	 */
	@Test
	public void test1(){
		String format = String.format("%09d", 11);
		System.out.println(format);


	}

}
