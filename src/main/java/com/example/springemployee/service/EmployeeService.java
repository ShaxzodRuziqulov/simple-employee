package com.example.springemployee.service;

import com.example.springemployee.domain.Employee;
import com.example.springemployee.domain.request.ReqEmployee;
import com.example.springemployee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String createEmployee(ReqEmployee reqEmployee) {
        try {
            Employee employee = new Employee();
            employee.setFirstName(reqEmployee.getFirstName());
            employee.setLastName(reqEmployee.getLastName());
            employee.setPosition(reqEmployee.getPosition());
            employee.setWorkSchedule(reqEmployee.getWorkSchedule());
            employee.setGraduatedUniversity(reqEmployee.getGraduatedUniversity());
            employee.setYearOfBirth(reqEmployee.getYearOfBirth());
            employeeRepository.save(employee);
            return "Muvaffaqqiyatli saqlandi";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public String updateEmployee(ReqEmployee reqEmployee) {
        try {
            Employee employee = new Employee();
            employee.setId(reqEmployee.getId());
            employee.setFirstName(reqEmployee.getFirstName());
            employee.setLastName(reqEmployee.getLastName());
            employee.setPosition(reqEmployee.getPosition());
            employee.setWorkSchedule(reqEmployee.getWorkSchedule());
            employee.setGraduatedUniversity(reqEmployee.getGraduatedUniversity());
            employee.setYearOfBirth(reqEmployee.getYearOfBirth());
            employeeRepository.save(employee);
            return "Muvaffaqqiyatli yangilandi";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public List<Employee> allEmployee() {
        return employeeRepository.findAll();
    }

    public Employee findByEmployeeId(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee employee1 = employee.get();
            return employee1;
        } else {
            return new Employee();
        }
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.getReferenceById(id);
        employeeRepository.delete(employee);
    }
}
