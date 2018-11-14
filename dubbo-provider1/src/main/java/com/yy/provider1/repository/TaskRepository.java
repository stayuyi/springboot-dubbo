package com.yy.provider1.repository;

import com.yy.provider1.model.TaskModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TaskRepository extends JpaRepository<TaskModel,Long> {
    TaskModel findTaskModelById(Long id);

    Page<TaskModel> findAllByCreatedBy(String createdBy, Pageable pageable);

    @Modifying
    @Query(value = "delete  from task where id= ?1",nativeQuery = true)
    void deleteOneById(Long id);

    @Modifying
    @Query("update TaskModel taskModel set taskModel.name =:name where taskModel.id =:id")
    void updateTaskModelName(@Param("id") Long id, @Param("name") String name);







}
