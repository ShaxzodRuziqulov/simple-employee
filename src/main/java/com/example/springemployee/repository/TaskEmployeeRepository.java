package com.example.springemployee.repository;

import com.example.springemployee.domain.TaskEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskEmployeeRepository extends JpaRepository<TaskEmployee,Long> {
}
