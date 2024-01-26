package com.example.springemployee.service;

import com.example.springemployee.domain.EmployeeCompany;
import com.example.springemployee.domain.request.ReqEmployeeCompany;
import com.example.springemployee.repository.CompanyRepository;
import com.example.springemployee.repository.EmployeeCompanyRepository;
import com.example.springemployee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeCompanyService {
    private final EmployeeCompanyRepository employeeCompanyRepository;
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeCompanyService(EmployeeCompanyRepository employeeCompanyRepository, CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
        this.employeeCompanyRepository = employeeCompanyRepository;
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    public String create(ReqEmployeeCompany reqEmployeeCompany) {
        try {
            EmployeeCompany employeeCompany = new EmployeeCompany();
            employeeCompany.setCompanyId(companyRepository.getReferenceById(reqEmployeeCompany.getCompanyId()));
            employeeCompany.setEmployeeId(employeeRepository.getReferenceById(reqEmployeeCompany.getEmployeeId()));
            employeeCompanyRepository.save(employeeCompany);
            return "Muvofaqqiyatli saqlandi";
        }catch (Exception e){
            e.printStackTrace();
            return "Xatolik";
        }
    }
    public String update(ReqEmployeeCompany reqEmployeeCompany){
        try {
            EmployeeCompany employeeCompany = new EmployeeCompany();
            employeeCompany.setCompanyId(companyRepository.getReferenceById(reqEmployeeCompany.getCompanyId()));
            employeeCompany.setEmployeeId(employeeRepository.getReferenceById(reqEmployeeCompany.getEmployeeId()));
            employeeCompanyRepository.save(employeeCompany);
            return "Muvofaqqiyatli uzgartirildi";
        }catch (Exception e){
            e.printStackTrace();
            return "Xatolik";
        }
    }
    public List<EmployeeCompany> all(){
        return employeeCompanyRepository.findAll();
    }
    public EmployeeCompany byID(Long id){
        Optional<EmployeeCompany> byId = employeeCompanyRepository.findById(id);
        return byId.orElseGet(EmployeeCompany ::new);
    }
    public void delete(Long id){
        EmployeeCompany employeeCompany =employeeCompanyRepository.getReferenceById(id);
        employeeCompanyRepository.delete(employeeCompany);
    }


}
