package com.example.springemployee.web.rest;

import com.example.springemployee.domain.Employee;
import com.example.springemployee.domain.request.ReqEmployee;
import com.example.springemployee.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqEmployee reqEmployee){
        String response = employeeService.createEmployee(reqEmployee);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqEmployee reqEmployee){
        String response = employeeService.updateEmployee(reqEmployee);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<Employee> all = employeeService.allEmployee();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/byId/{id}")
    public ResponseEntity<?> EmployeeId(@PathVariable Long id){
        Employee employee = employeeService.findByEmployeeId(id);
        return ResponseEntity.ok(employee);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("O'chirildi");
    }
    
}
