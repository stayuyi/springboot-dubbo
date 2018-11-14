package com.yy.provider1.controller;

import com.yy.provider1.model.CalendarDateModel;
import com.yy.provider1.model.TaskModel;
import com.yy.provider1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TaskModelController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/task/findAll")
    public List<TaskModel> findAll(){
        List<TaskModel> findAll = taskService.findAll();
        System.out.println(findAll.size());
        return findAll;
    }


    @RequestMapping("/task/findTaskModelBybyId/{id}")
    public TaskModel findTaskModelBybyId(@PathVariable("id") Long id){
        return  taskService.findTaskModelBybyId(id);
    }

    @RequestMapping("/task/findAllByCreatedBy/{createdBy}/{page}/{size}")
    public Page<TaskModel> findAllByCreatedBy(@PathVariable("createdBy") String createdBy,@PathVariable("page") int page,@PathVariable("size") int size){
        return  taskService.findAllByCreatedBy(createdBy,page,size);




    }
}
