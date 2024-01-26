package com.example.springemployee.web.rest;

import com.example.springemployee.domain.Task;
import com.example.springemployee.domain.request.ReqTask;
import com.example.springemployee.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskResource {
    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqTask reqTask){
        String response = taskService.createTask(reqTask);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqTask reqTask){
        String response = taskService.updateTask(reqTask);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    public ResponseEntity<?> allTask(){
        List<Task> task = taskService.findAll();
        return ResponseEntity.ok(task);
    }
    @GetMapping("/byId/{id}")
    public ResponseEntity<?> byId(@PathVariable Long id){
        Task task = taskService.byId(id);
        return ResponseEntity.ok(task);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("O'chirildi");
    }

}
