package com.example.Timsheet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Timsheet.DTO.EmployeeTimesheetDTO;
import com.example.Timsheet.models.EmployeeTimesheet;


@Repository
public interface EmployeeTimesheetRepository extends JpaRepository<EmployeeTimesheet, Integer> {
    @Query(value = "SELECT * FROM db_timesheet.tbl_tr_employee_timesheet;", nativeQuery = true)
    public List<EmployeeTimesheet> getEmployeeTimesheet();
    
    @Query(value = "SELECT * FROM db_timesheet.tbl_tr_employee_timesheet;", nativeQuery = true)
    public List<EmployeeTimesheetDTO> getEmployeeTimesheetDTO();
}
