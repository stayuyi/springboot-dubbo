package com.yy.provider1;

import com.yy.provider1.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestStreamExample {
    private List stuList=null;
    @Before
    public void init() {
     Random random = new Random();
       stuList = new ArrayList<Student>() {
            {
                for (int i = 0; i < 100; i++) {
                    add(new Student("student" + i, random.nextInt(50) + 50));
                }
            }
        };
    }


    //1列出班上超过85分的学生姓名，并按照分数降序输出用户名字
    @Test
    public void test1() {
    /*    List<String> studentList = stuList.stream()
                .filter(x->x.getScore()>85)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(studentList);
*/




    }
}
