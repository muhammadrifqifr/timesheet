package com.example.Timsheet.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Timsheet.DTO.EmployeeDTO;
import com.example.Timsheet.models.Employee;
import com.example.Timsheet.services.EmployeeService;


@RestController
@RequestMapping("/api/employee")
public class EmployeeRestontroller {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestontroller(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/coba")
    public List<Employee> getAll(){
        return employeeService.getEmployeeJoinDesignation();
    }

    @GetMapping("/dto")
    public List<EmployeeDTO> getAllDTO(){
        return employeeService.getEmployeeJoinDesignationDTO();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable (required = true) Integer id) {
    return employeeService.getById(id);
    }

    @PostMapping("/insert")
    public Boolean insert(@RequestBody Employee employee) {
        Boolean result = employeeService.save(employee);
        return result;
    }

    @PutMapping("/update/{id}")
    public Boolean update(@PathVariable(required = true) Integer id, @RequestBody Employee employee) {
        employee.setId(id);
        Boolean result = employeeService.save(employee);
        return result;
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable(required = true) Integer id) {
        Boolean result = employeeService.delete(id);
        return result;
    }
    
}
