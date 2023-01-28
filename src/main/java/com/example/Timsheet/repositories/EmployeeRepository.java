package com.example.Timsheet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Timsheet.DTO.EmployeeDTO;
import com.example.Timsheet.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    @Query(value = "SELECT MAX(t.id) FROM tbl_m_timesheet t", nativeQuery = true)
    int findAdminId();

    @Query(value = "SELECT e.*, d.* FROM tbl_m_employee e JOIN tbl_m_designation d ON e.id = d.id", nativeQuery = true)
    public List<Employee> getEmployeeJoinDesignation();

    @Query(value = "SELECT e.*, d.*, dp.*, dv.* FROM tbl_m_employee e JOIN tbl_m_designation d ON e.id = d.id JOIN tbl_m_department dp ON dp.id = d.department_id JOIN tbl_m_division dv ON dv.id = dp.division_id;")
    public List<EmployeeDTO> getEmployeeJoinDesignationDTO();
}
