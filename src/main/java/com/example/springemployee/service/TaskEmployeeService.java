package com.example.springemployee.service;

import com.example.springemployee.domain.EmployeeCompany;
import com.example.springemployee.domain.TaskEmployee;
import com.example.springemployee.domain.request.ReqTaskEmployee;
import com.example.springemployee.repository.EmployeeRepository;
import com.example.springemployee.repository.TaskEmployeeRepository;
import com.example.springemployee.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TaskEmployeeService {
    private final TaskEmployeeRepository taskEmployeeRepository;
    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;

    public TaskEmployeeService(TaskEmployeeRepository taskEmployeeRepository, TaskRepository taskRepository, EmployeeRepository employeeRepository) {
        this.taskEmployeeRepository = taskEmployeeRepository;
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
    }

    public String create(ReqTaskEmployee reqTaskEmployee) {
        try {
            TaskEmployee taskEmployee = new TaskEmployee();
            taskEmployee.setId(reqTaskEmployee.getId());
            taskEmployee.setTask(taskRepository.getReferenceById(reqTaskEmployee.getTaskId()));
            taskEmployee.setEmployee(employeeRepository.getReferenceById(reqTaskEmployee.getEmployeId()));
            taskEmployeeRepository.save(taskEmployee);
            return "Muvaffaqqiyatli saqlandi";
        } catch (Exception e) {
            e.printStackTrace();
            return "xatolik";
        }
    }

    public String update(ReqTaskEmployee reqTaskEmployee) {
        try {
            TaskEmployee taskEmployee = new TaskEmployee();
            taskEmployee.setId(reqTaskEmployee.getId());
            taskEmployee.setTask(taskRepository.getReferenceById(reqTaskEmployee.getTaskId()));
            taskEmployee.setEmployee(employeeRepository.getReferenceById(reqTaskEmployee.getEmployeId()));
            taskEmployeeRepository.save(taskEmployee);
            return "Muvaffaqqiyatli uzgartirildi";
        } catch (Exception e) {
            e.printStackTrace();
            return "xatolik";
        }
    }

    public List<TaskEmployee> all() {
        return taskEmployeeRepository.findAll();
    }
    public TaskEmployee byId(Long id){
        Optional<TaskEmployee> by_Id = taskEmployeeRepository.findById(id);
        return by_Id.orElseGet(TaskEmployee :: new);
    }
    public void delete(Long id){
        TaskEmployee taskEmployee = taskEmployeeRepository.getReferenceById(id);
        taskEmployeeRepository.delete(taskEmployee);
    }

}
