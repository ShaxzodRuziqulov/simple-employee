package com.example.springemployee.domain.request;

public class ReqTaskEmployee {
    private Long id;
    private Long taskId;
    private Long EmployeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getEmployeId() {
        return EmployeId;
    }

    public void setEmployeId(Long employeId) {
        EmployeId = employeId;
    }
}
