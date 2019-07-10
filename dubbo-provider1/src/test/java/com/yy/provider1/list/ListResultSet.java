package com.yy.provider1.list;

import com.yy.provider1.bean.CustomerInfo;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * TODO 2019/5/15
 *
 * @author yuyi
 */

public class ListResultSet {
	private List<CustomerInfo> list1= Lists.newArrayList();
	private List<CustomerInfo> list2=Lists.newArrayList();

	@Before
	public void init() {
		CustomerInfo c1 = new CustomerInfo("aa", 1);
		CustomerInfo c2 = new CustomerInfo("bb", 2);
		CustomerInfo c3 = new CustomerInfo("cc", 3);
		list1.add(c1);
		list1.add(c3);
		list1.add(c2);
		list2.add(c3);
		list2.add(c1);
		list2.add(c2);
	}

	//TODO 比较2个list相等
	@Test
	public void test1() {
		boolean b = list1.containsAll(list2) && list2.containsAll(list1);
		boolean b1 = list1.containsAll(list2) && list1.size() == list2.size();
		System.out.println(b);
		System.out.println(b1);
		CustomerInfo c4 = new CustomerInfo("dd", 4);
		list2.add(c4);
	}

	//TODO 去重   基本数据类型无序
	@Test
	public void test2() {
		//基本类型
		List<Integer> list=Lists.newArrayList();
		list.addAll(Arrays.asList(2,1,3,2,4,3,6,4,5,5));
		System.out.println(list);
		Set<Integer> set= new HashSet<>(list);
		list.clear();
		list.addAll(set);
		System.out.println(list);

		//引用类型
		list1.add(new CustomerInfo("cc", 3));
		System.out.println(list1);
		Set<CustomerInfo> beanSet=new HashSet<>(list1);
		list1.clear();
		list1.addAll(beanSet);
		System.out.println(list1);

		//java8  list遍历移除元素
		list.removeIf(c->c==1);
		System.out.println(list);
	}

	//TODO listToMap  Map Remove element
	@Test
	public void test3(){
		Map<String, CustomerInfo> map = list1.stream().collect(
				Collectors.toMap(CustomerInfo::getName, Function.identity(), (v1, v2) -> v1));
		System.out.println(map);
		map.entrySet().removeIf(entry->entry.getValue().getAge()>1);
		System.out.println(map);
	}



}
