package com.yy.provider1.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "task", schema = "pandora_dev", catalog = "")
public class TaskModel {
    private long id;
    private String createdBy;
    private Timestamp createdTime;
    private String updatedBy;
    private Timestamp updatedTime;
    private String name;
    private String task;

    public TaskModel(long id, String createdBy, Timestamp createdTime, String updatedBy, Timestamp updatedTime, String name, String task) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.name = name;
        this.task = task;
    }

    public TaskModel() {
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "created_time")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "updated_by")
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Basic
    @Column(name = "updated_time")
    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "task")
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskModel taskModel = (TaskModel) o;
        return id == taskModel.id &&
                Objects.equals(createdBy, taskModel.createdBy) &&
                Objects.equals(createdTime, taskModel.createdTime) &&
                Objects.equals(updatedBy, taskModel.updatedBy) &&
                Objects.equals(updatedTime, taskModel.updatedTime) &&
                Objects.equals(name, taskModel.name) &&
                Objects.equals(task, taskModel.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdBy, createdTime, updatedBy, updatedTime, name, task);
    }
}
