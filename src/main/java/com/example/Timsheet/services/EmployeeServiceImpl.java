package com.example.Timsheet.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Timsheet.DTO.EmployeeDTO;
import com.example.Timsheet.models.Employee;
import com.example.Timsheet.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        return employeeRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Employee tidak ditemukan"));
    }

    @Override
    public boolean save(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        employeeRepository.deleteById(id);
        return !employeeRepository.findById(id).isPresent();
    }

    @Override
    public List<Employee> getEmployeeJoinDesignation() {
        return employeeRepository.getEmployeeJoinDesignation();
    }

    @Override
    public List<EmployeeDTO> getEmployeeJoinDesignationDTO() {
        List<Employee> employee = employeeRepository.getEmployeeJoinDesignation();
        return employee.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public EmployeeDTO convertToDto(Employee employee){
        return new EmployeeDTO(employee.getId(),
            employee.getName(),
            employee.getEmail(),
            employee.getNik(),
            employee.getDesignation().getId(),
            employee.getDesignation().getName(),
            employee.getDesignation().getDepartment().getId(),
            employee.getDesignation().getDepartment().getName(),
            employee.getDesignation().getDepartment().getDivision().getId(), 
            employee.getDesignation().getDepartment().getDivision().getName());
    }
    
}
