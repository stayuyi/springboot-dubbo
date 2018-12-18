package com.yy.provider1;

import com.yy.provider1.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * 流不会改变元数据,不存储数据,延迟性
 */
public class streamTest2 {
    private List<Student> stuList = null;

    @Before
    public void init() {
        Random random = new Random();
        stuList = new ArrayList<Student>() {
            {
                for (int i = 0; i < 10; i++) {
                    add(new Student("student" + i, random.nextInt(50) + 50));
                }
            }
        };
    }


    @Test
    public void test1() {
        System.out.println(stuList);
        //过滤分数低于85的
        List<Student> collect = stuList.stream().filter(x -> x.getScore() >= 85).collect(Collectors.toList());
        System.out.println("collect:" + collect);

        //分数>=85分的总分
        int sum = stuList.stream().filter(x -> x.getScore() >= 85).mapToInt(x -> x.getScore()).sum();
        System.out.println("sum:" + sum);

        //分数>85分的student,升序,并按分数排序
        List<Student> collect1 = stuList.stream().filter(x -> x.getScore() >= 85).sorted(Comparator.comparingInt(Student::getScore)).collect(Collectors.toList());
        System.out.println(collect1);

        ////分数>85分的名字,降序,并按分数排序
        List<String> collect2 = stuList.stream().filter(x -> x.getScore() >= 85).sorted(Comparator.comparingInt(Student::getScore).reversed()).map(Student::getName).collect(Collectors.toList());
        System.out.println(collect2);

    }

    public boolean filter(Student s) {
        System.out.println("begin compare");
        return s.getScore() > 85;
    }

    /**
     * 流的延迟性测试
     */
    @Test
    public void test2() {
        Stream<Student> stream = stuList.stream().filter(this::filter);
        System.out.println("split-------------------------------------");
        //在执行collect方法的时候才运行了filter行代码
        List<Student> studentList = stream.collect(Collectors.toList());

    }

    /**
     * 生成Stream
     */
    @Test
    public void test3() {
        int[] arr = new int[]{1, 22, 333, 123};
        Student[] studentArr = new Student[]{new Student("s1", 99), new Student("s2", 98)};

        IntStream stream1 = Arrays.stream(arr);
        Stream<int[]> arr1 = Stream.of(arr);
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<String> aaa = Stream.of("aaa", "bbb", "ccc");

        Stream<Student> stream2 = Arrays.stream(studentArr);
        Stream<Student> stream3 = Stream.of(studentArr);
    }

    /* 创建无限流*/
    @Test
    public void test4() {
// limit  截断流的长度 不超过 5
        Stream.generate(() -> "number" + new Random().nextInt()).limit(5).forEach(System.out::println);
        Stream.generate(() -> new Student("name", new Random().nextInt(10))).limit(3).forEach(System.out::println);
        //产生规律的数据
        Stream.iterate(0, x -> x + 1).limit(5).forEach(System.out::println);
        Stream.iterate(0, x->x ).limit(5).forEach(System.out::println);


        //UnaryOperator.identity() 一元运算，接受一个T类型参数，输出一个与入参一模一样的值
        Stream.iterate(0, UnaryOperator.identity()).limit(5).forEach(System.out::println);
    }

    @Test
    public void test5() {
    }

    @Test
    public void test6() {
    }

    @Test
    public void test7() {
    }

    @Test
    public void test8() {
    }

    @Test
    public void test9() {
    }


}
