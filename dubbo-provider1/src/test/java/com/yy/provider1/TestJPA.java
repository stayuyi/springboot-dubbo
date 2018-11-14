package com.yy.provider1;

import com.yy.provider1.model.TaskModel;
import com.yy.provider1.repository.TaskRepository;
import com.yy.provider1.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DubboProvider1Application.class)
public class TestJPA {
    @Autowired
    private TaskService taskService;
    @Autowired
    TaskRepository taskRepository;

    @Test
    public void testDelete() {
        //这两个删除方法,第一个是jpa里的deleteById()方法,一个是原生的sql语句(delete from...这里不用*号)删除,
        //第一个没有用@Transactional没有报错,而且能正常删除数据,第二个不加会报错
        //第一个要删除的 id 不存在是,会报错  No class com.yy.provider1.model.TaskModel entity with id 7 exists!
        //第二个要删除的 id 不存在时,不会报错
        //jpa是操作的实体类, 发送原生的sql是操作的数据库
      taskService.deleteById(7L);
      taskService.deleteOneById(8L);
      taskService.updateTaskModelName(10L,"更新逾期信息更新逾期信息更新逾期信息");

      taskRepository.save(new TaskModel(3L,"abc",new Timestamp(1312132131321L),"bbc",new Timestamp(1312132131321L),"ccc","dddd"));

      //不管是不是继承至Repository里的方法最好还是 增删改都加上 @Transactional注解

    }



}
