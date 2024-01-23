package com.example.springemployee.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_company")
public class EmployeeCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id" , referencedColumnName = "id")
    private Employee employeeId;
    @ManyToOne
    @JoinColumn(name = "company_id" , referencedColumnName = "id")
    private Company companyId;

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
