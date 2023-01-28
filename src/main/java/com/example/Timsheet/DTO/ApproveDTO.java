package com.example.Timsheet.DTO;

import java.util.Date;

public class ApproveDTO {
    private String Name;
    private Date Date;
    private Integer Employee;
    private Integer Timesheet;
    private Integer Status;
    private Integer Role;

    public String getName(){
        return Name;
    }
    public void setName(String name){
        Name = name;
    }

    public Date getDate(){
        return Date;
    }
    public void setDate(Date date){
        Date = date;
    }

    public Integer getEmployee(){
        return Employee;
    }
    public void setEmployee(Integer employee){
        Employee = employee;
    }

    public Integer getStatus(){
        return Status;
    }
    public void setStatus(Integer status){
        Status = status;
    }

    public Integer getTimesheet() {
        return Timesheet;
    }
    public void setTimesheet(Integer timesheet) {
        Timesheet = timesheet;
    }

     public Integer getRole() {
        return Role;
    }
    public void setRole(Integer role) {
        Role = role;
    }
    
}
