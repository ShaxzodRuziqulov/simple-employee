package com.example.springemployee.web.rest;

import com.example.springemployee.domain.Company;
import com.example.springemployee.domain.request.ReqCompany;
import com.example.springemployee.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyResource {
    private final CompanyService companyService;

    public CompanyResource(CompanyService companyService) {
        this.companyService = companyService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> createCompany(@RequestBody ReqCompany reqCompany){
        String response = companyService.createCompany(reqCompany);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable ReqCompany reqCompany){
        String response = companyService.updateCompany(reqCompany);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    public ResponseEntity<?> allCompany(){
        List<Company> all = companyService.companyAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/byId/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Company company = companyService.findByCompanyId(id);
        return ResponseEntity.ok(company);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        companyService.delete(id);
        System.out.println("test");
        return ResponseEntity.ok("O'chirildi");
    }
}
