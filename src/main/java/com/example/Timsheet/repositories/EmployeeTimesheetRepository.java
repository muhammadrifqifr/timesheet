package com.example.Timsheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Timsheet.models.EmployeeTimesheet;

@Repository
public interface EmployeeTimesheetRepository extends JpaRepository<EmployeeTimesheet, Integer> {
    
}
