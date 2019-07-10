package com.yy.provider1;

import com.yy.provider1.model.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class streamTest3 {

	/*
	TODO 并行求和  parallelStream 获得一个并行流   mapTOInt 返回一个intStream;
	TODO i->i的意思是定义一个变量i(前面的),让迭代出来的每个元素i(后面的) 赋值给(前面的) i,然后放到intStream里
	TODO sum 是intStream里的求和方法
	 */
	private final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

	@Test
	public void test1() {
		int sum = list.parallelStream().mapToInt(i -> i).sum();
		//result = 15
		System.out.println(sum);
	}

	/*
	TODO 验证lambda并行
	 */
	@Test
	public void test2() {
		list.parallelStream().forEach(System.out::print);
		System.out.println();
		list.forEach(System.out::print);
	}

}
