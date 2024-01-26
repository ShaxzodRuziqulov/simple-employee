package com.example.springemployee.web.rest;

import com.example.springemployee.domain.TaskEmployee;
import com.example.springemployee.domain.request.ReqTaskEmployee;
import com.example.springemployee.service.TaskEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-employee")
public class TaskEmployeeResource {
    private final TaskEmployeeService taskEmployeeService;

    public TaskEmployeeResource(TaskEmployeeService taskEmployeeService) {
        this.taskEmployeeService = taskEmployeeService;
    }
    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody ReqTaskEmployee reqTaskEmployee){
        String response = taskEmployeeService.create(reqTaskEmployee);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/update")
    private ResponseEntity<?> update(@RequestBody ReqTaskEmployee reqTaskEmployee){
        String response = taskEmployeeService.create(reqTaskEmployee);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    private ResponseEntity<?> all(){
        List<TaskEmployee> allTaskEmploye= taskEmployeeService.all();
        return ResponseEntity.ok(allTaskEmploye);
    }
    @GetMapping("/byId/{id}")
    private ResponseEntity<?> by_id(@PathVariable Long id){
        TaskEmployee findByTaskEmployeId = taskEmployeeService.byId(id);
        return ResponseEntity.ok(findByTaskEmployeId);
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id){
        taskEmployeeService.delete(id);
        return ResponseEntity.ok("O'chirildi");
    }
}
