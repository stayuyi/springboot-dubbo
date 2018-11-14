package com.yy.provider1.service;

import com.yy.provider1.model.TaskModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TaskService {
    List<TaskModel> findAll();

    TaskModel findTaskModelBybyId(Long id);

    Page<TaskModel> findAllByCreatedBy(String createdBy,int page, int size);

    void deleteOneById(Long id);

    void deleteById(Long id);

    void updateTaskModelName(Long id,String name);

}
