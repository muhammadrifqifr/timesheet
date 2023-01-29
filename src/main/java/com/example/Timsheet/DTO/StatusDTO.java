package com.example.Timsheet.DTO;

import java.util.Date;

public class StatusDTO {
    public StatusDTO(Integer id, String name, Date date, Integer employee_id, Integer timesheet_id) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.employee_id = employee_id;
        this.timesheet_id = timesheet_id;
    }
        
    private Integer id;
    private String name;
    private Date date;
    private Integer employee_id;
    private Integer timesheet_id;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Integer getEmployee_id() {
        return employee_id;
    }
    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }
    public Integer getTimesheet_id() {
        return timesheet_id;
    }
    public void setTimesheet_id(Integer timesheet_id) {
        this.timesheet_id = timesheet_id;
    }

   
}
