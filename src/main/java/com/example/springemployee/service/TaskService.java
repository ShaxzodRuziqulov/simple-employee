package com.example.springemployee.service;

import com.example.springemployee.domain.Task;
import com.example.springemployee.domain.request.ReqTask;
import com.example.springemployee.repository.CompanyRepository;
import com.example.springemployee.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final CompanyRepository companyRepository;

    public TaskService(TaskRepository taskRepository, CompanyRepository companyRepository) {
        this.taskRepository = taskRepository;
        this.companyRepository = companyRepository;
    }


    public String createTask(ReqTask reqTask) {
        try {
            Task task = new Task();
            task.setId(reqTask.getId());
            task.setName(reqTask.getName());
            task.setCompany(companyRepository.getReferenceById(reqTask.getCompany()));
            taskRepository.save(task);
            return "Muvaffaqqiyatli saqlandi";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public String updateTask(ReqTask reqTask) {
        try {
            Task task = new Task();
            task.setId(reqTask.getId());
            task.setName(reqTask.getName());
            taskRepository.save(task);
            return "Muvaffaqqiyatli yangilandi";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task byId(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseGet(Task::new);
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.getReferenceById(id);
        taskRepository.delete(task);
    }
}
