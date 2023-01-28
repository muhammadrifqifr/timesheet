package com.example.Timsheet.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Timsheet.DTO.EmployeeTimesheetDTO;
import com.example.Timsheet.models.Employee;
import com.example.Timsheet.models.EmployeeTimesheet;
import com.example.Timsheet.models.Timesheet;
import com.example.Timsheet.repositories.EmployeeTimesheetRepository;

@Service
public class EmployeeTimesheetServiceImpl implements EmployeeTimesheetService{
    
    @Autowired
    private EmployeeTimesheetRepository employeeTimesheetRepository;
    @Autowired
    private TimesheetService timesheetService;


    @Override
    public List<EmployeeTimesheet> getAll() {
        return employeeTimesheetRepository.findAll();
    }

    @Override
    public EmployeeTimesheet getById(Integer id) {
        return employeeTimesheetRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Employee_Timesheet tidak ditemukan"));
    }

    @Override
    public boolean save(EmployeeTimesheetDTO dto) {
        Timesheet timesheet = new Timesheet();
        Employee employee = new Employee();
        EmployeeTimesheet employeeTimesheet = new EmployeeTimesheet();

        employeeTimesheet.setWork_Date(dto.getWork_Date());
        employeeTimesheet.setActivity(dto.getActivity());
        employeeTimesheet.setStart_Hour(dto.getStart_Hour());
        employeeTimesheet.setEnd_Hour(dto.getEnd_Hour());
        employeeTimesheet.setPresents(dto.getPresents());
        employee.setId(dto.getEmployee());
        employeeTimesheet.setEmployee(employee);
        timesheet.setId(timesheetService.getByIdTs());
        employeeTimesheet.setTimesheet(timesheet);
        employeeTimesheetRepository.save(employeeTimesheet);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        employeeTimesheetRepository.deleteById(id);
        return !employeeTimesheetRepository.findById(id).isPresent();
    }
}
