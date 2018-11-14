package com.yy.provider1.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "task_entry", schema = "pandora_dev", catalog = "")
public class TaskEntryModel {
    private long id;
    private String createdBy;
    private Timestamp createdTime;
    private String updatedBy;
    private Timestamp updatedTime;
    private Long tenantId;
    private String argument;
    private String component;
    private String dependencyTask;
    private Integer execRate;
    private String execTime;
    private String task;
    private String taskType;

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
    @Column(name = "tenant_id")
    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    @Basic
    @Column(name = "argument")
    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    @Basic
    @Column(name = "component")
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @Basic
    @Column(name = "dependency_task")
    public String getDependencyTask() {
        return dependencyTask;
    }

    public void setDependencyTask(String dependencyTask) {
        this.dependencyTask = dependencyTask;
    }

    @Basic
    @Column(name = "exec_rate")
    public Integer getExecRate() {
        return execRate;
    }

    public void setExecRate(Integer execRate) {
        this.execRate = execRate;
    }

    @Basic
    @Column(name = "exec_time")
    public String getExecTime() {
        return execTime;
    }

    public void setExecTime(String execTime) {
        this.execTime = execTime;
    }

    @Basic
    @Column(name = "task")
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Basic
    @Column(name = "task_type")
    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntryModel that = (TaskEntryModel) o;
        return id == that.id &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedBy, that.updatedBy) &&
                Objects.equals(updatedTime, that.updatedTime) &&
                Objects.equals(tenantId, that.tenantId) &&
                Objects.equals(argument, that.argument) &&
                Objects.equals(component, that.component) &&
                Objects.equals(dependencyTask, that.dependencyTask) &&
                Objects.equals(execRate, that.execRate) &&
                Objects.equals(execTime, that.execTime) &&
                Objects.equals(task, that.task) &&
                Objects.equals(taskType, that.taskType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdBy, createdTime, updatedBy, updatedTime, tenantId, argument, component, dependencyTask, execRate, execTime, task, taskType);
    }
}
