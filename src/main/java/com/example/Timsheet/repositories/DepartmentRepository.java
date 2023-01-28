package com.example.Timsheet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Timsheet.DTO.DepartmentDTO;
import com.example.Timsheet.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    
//      @Query("select new com.example.Timsheet.models.Department(u.id, u.name, u.division_id) from tbl_m_department u")
//    public List<Department> getAllDepartment();

    @Query(value = "SELECT * FROM tbl_m_department", nativeQuery = true)
    public List<Department> getAllDepartment();

    @Query(value = "SELECT * FROM tbl_m_department", nativeQuery = true)
    public List<DepartmentDTO> getAllDepartmentDTO();

 
}
