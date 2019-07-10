package com.yy.provider1;

import com.yy.provider1.model.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * TODO 2019/5/6
 *
 * @author yuyi
 */

public class streamToMap {

	public static void main(String[] args) {

		User user1=new User("1",111);
		User user2=new User("1",11123);
		User user3=new User("1",111234);
		User user4=new User("2",222);
		User user5=new User("3",333);
		User user6=new User("4",444);
		List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);


		//tomap方法 key不能重复(throw duplicate key)  value不能为null(throw NPE)
		Map<String, User> collect = users.stream().collect(Collectors.toMap(User::getNO,Function.identity(),(v1,v2)->{
			if (v1.getCost()==11){
				return v1;
			}else {
				return v2;
			}
		}));
		System.out.println(collect);

		System.out.println("**************************************");

		HashMap<User, List<User>> collect1 = users.stream().collect(Collectors.groupingBy(
				Function.identity(), HashMap::new, Collectors.toList()));
		System.out.println(collect1);

		System.out.println("**************************************");

		Map<String, List<User>> collect2 = users.stream().collect(Collectors.groupingBy(User::getNO));
		System.out.println(collect2);
	}


}
