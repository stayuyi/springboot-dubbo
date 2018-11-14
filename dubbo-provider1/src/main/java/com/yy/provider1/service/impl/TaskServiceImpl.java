package com.yy.provider1.service.impl;

import com.yy.provider1.model.TaskModel;
import com.yy.provider1.repository.TaskRepository;
import com.yy.provider1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<TaskModel> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public TaskModel findTaskModelBybyId(Long id) {
        return taskRepository.findTaskModelById(id);
    }

    @Override
    public Page<TaskModel> findAllByCreatedBy(String createdBy, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC,"id");
        //最后的sql 相当于  select * from table_name where created_by=? order by id limit page,size
              return taskRepository.findAllByCreatedBy(createdBy,pageable);
    }

    @Override
    @Transactional
    public void deleteOneById(Long id) {
        taskRepository.deleteOneById(id);
    }

    @Override

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateTaskModelName(Long id, String name) {
        taskRepository.updateTaskModelName(id,name);
    }
}
