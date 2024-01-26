package com.example.springemployee.web.rest;

import com.example.springemployee.domain.EmployeeCompany;
import com.example.springemployee.domain.request.ReqEmployeeCompany;
import com.example.springemployee.service.EmployeeCompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employeecompany")
public class EmployeeCompanyResource {
    private final EmployeeCompanyService employeeCompanyService;

    public EmployeeCompanyResource(EmployeeCompanyService employeeCompanyService) {
        this.employeeCompanyService = employeeCompanyService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqEmployeeCompany reqEmployeeCompany){
        String response = employeeCompanyService.create(reqEmployeeCompany);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqEmployeeCompany reqEmployeeCompany){
        String response = employeeCompanyService.create(reqEmployeeCompany);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<EmployeeCompany> all = employeeCompanyService.all();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/byId/{id}")
    public ResponseEntity<?> byId(@PathVariable Long id){
        EmployeeCompany employeeCompany = employeeCompanyService.byID(id);
        return ResponseEntity.ok(employeeCompany);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        employeeCompanyService.delete(id);
        return ResponseEntity.ok("O'chirild");
    }

}
