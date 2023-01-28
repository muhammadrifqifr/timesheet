package com.example.Timsheet.services;

import java.util.List;
import com.example.Timsheet.DTO.EmployeeTimesheetDTO;
import com.example.Timsheet.models.EmployeeTimesheet;

public interface EmployeeTimesheetService {
    public List<EmployeeTimesheet> getAll();
    public List<EmployeeTimesheet> getEmployeeTimesheet();
    public List<EmployeeTimesheetDTO> getEmployeeTimesheetDTO();
    public EmployeeTimesheet getById(Integer id);
    public boolean save(EmployeeTimesheetDTO dto);
    public boolean delete(Integer id);
}
