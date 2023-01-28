package com.example.Timsheet.services;

import java.util.List;

import com.example.Timsheet.DTO.DepartmentDTO;
import com.example.Timsheet.models.Department;

public interface DepartmentService {
    public List<Department> getAll();
    public List<Department> getAllDepartment();
    public List<DepartmentDTO> getAllDepartmentDTO();
    public Department getById(Integer id);
    public boolean save(Department department);
    public boolean delete(Integer id);
}
