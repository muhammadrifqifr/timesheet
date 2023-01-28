package com.example.Timsheet.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Timsheet.services.EmployeeTimesheetService;
import com.example.Timsheet.DTO.EmployeeTimesheetDTO;
import com.example.Timsheet.models.EmployeeTimesheet;

@RestController
@RequestMapping("/api/emptime")
public class EmployeeTimesheetRestController {

    @Autowired
    private EmployeeTimesheetService employeeTimesheetService;

    @GetMapping
    public List<EmployeeTimesheet> getAll(){
        return employeeTimesheetService.getAll();
    }

    @PostMapping("/insert")
    public Boolean submitRegisterasi(@RequestBody EmployeeTimesheetDTO dto){
        Boolean result;
            result = employeeTimesheetService.save(dto);
        return result;
    }


}
