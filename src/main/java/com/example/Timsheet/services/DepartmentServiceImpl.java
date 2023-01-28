package com.example.Timsheet.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Timsheet.DTO.DepartmentDTO;
import com.example.Timsheet.models.Department;
import com.example.Timsheet.repositories.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Integer id) {
        return departmentRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Department tidak ditemukan"));
    }

    @Override
    public boolean save(Department department) {
        departmentRepository.save(department);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        departmentRepository.deleteById(id);
        return !departmentRepository.findById(id).isPresent();
    }

    @Override
    public List<DepartmentDTO> getAllDepartmentDTO() {
        List<Department> department = departmentRepository.getAllDepartment();
        return department.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public DepartmentDTO convertToDto(Department department){
        return new DepartmentDTO(department.getId(),
            department.getName());
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.getAllDepartment();
    }
    
}
