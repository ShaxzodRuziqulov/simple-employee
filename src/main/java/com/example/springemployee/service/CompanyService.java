package com.example.springemployee.service;

import com.example.springemployee.domain.Company;
import com.example.springemployee.domain.request.ReqCompany;
import com.example.springemployee.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    public String createCompany(ReqCompany reqCompany){
        try {
            Company company = new Company();
            company.setId(reqCompany.getId());
            company.setName(reqCompany.getName());
            company.setAddress(reqCompany.getAddress());
            companyRepository.save(company);
            return "Muvaffaqiyatli saqlandi";
        }catch (Exception e){
            e.printStackTrace();
            return "Xatolik";
        }
    }
    public String updateCompany(ReqCompany reqCompany){
        try {
            Company company = new Company();
            company.setId(reqCompany.getId());
            company.setName(reqCompany.getName());
            company.setAddress(reqCompany.getAddress());
            companyRepository.save(company);
            return "Muvaffaqiyatli yangilandi";
        }catch (Exception e){
            e.printStackTrace();
            return "Xatolik";
        }
    }
    public List<Company> companyAll(){
        return companyRepository.findAll();
    }
    public Company findByCompanyId(Long id){
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()){
            Company company1 = company.get();
            return company1;
        }else {
            return new Company();
        }
    }
    public void delete(Long id){
        Company company = companyRepository.getReferenceById(id);
        companyRepository.delete(company);
    }
}
