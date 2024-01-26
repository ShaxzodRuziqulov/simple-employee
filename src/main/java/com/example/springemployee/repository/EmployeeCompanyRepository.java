package com.example.springemployee.repository;

import com.example.springemployee.domain.EmployeeCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCompanyRepository extends JpaRepository<EmployeeCompany,Long> {
}
